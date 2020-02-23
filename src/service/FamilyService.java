package service;

import dao.FamilyDao;
import model.human.Family;
import model.human.Human;
import model.human.Man;
import model.human.Woman;
import model.pet.Pet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class FamilyService {
    private final FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public FamilyDao getFamilyDao() {
        return familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        System.out.println(familyDao.getAllFamilies());
    }

    public void getFamiliesBiggerThan(int familyMembersCount) {
        familyDao.getAllFamilies().stream()
            .filter(family -> family.countFamily() > familyMembersCount)
            .forEach(System.out::println);
    }

    public void getFamiliesLessThan(int familyMembersCount) {
        familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() < familyMembersCount)
                .forEach(System.out::println);
    }

    public int countFamiliesWithMemberNumber(int familyMembersCount) {
        return (int) familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() == familyMembersCount)
                .count();
    }

    public boolean createNewFamily(Human mother, Human father) {
        return familyDao.saveFamily(new Family(mother, father));
    }

    public boolean deleteFamilyByIndex(int familyIndex) {
        return familyDao.deleteFamily(familyIndex);
    }

    public boolean updateFamilyByValue(Family family) {
        int familyIndex = familyDao.getAllFamilies().indexOf(family);

        if(familyIndex > -1) {
            return familyDao.updateFamily(familyIndex, family);
        } else {
            return familyDao.saveFamily(family);
        }
    }

    public Family bornChild(Family family, String mansName, String womansName) {
        Human child;

        Random random = new Random();

        Human dad = family.getFather();
        Human mum = family.getMother();

        if (random.nextBoolean()) {
            child = new Man(mansName, dad.getSurname(), LocalDateTime.now().getYear(), (byte)((dad.getIq() + mum.getIq())/2));
        } else {
            child = new Woman(womansName, dad.getSurname(), LocalDateTime.now().getYear(), (byte)((dad.getIq() + mum.getIq())/2));
        }

        family.addChild(child);

        return updateFamilyByValue(family) ? family : null;
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);

        updateFamilyByValue(family);

        return updateFamilyByValue(family) ? family : null;
    }

    public void deleteAllChildrenOlderThen(int age) {
        List<Family> families = familyDao.getAllFamilies();
        for (Family family: families) {
            List<Human> childs = family.getChildren();
            Human[] chs = new Human[(int) childs.stream().filter(ch -> LocalDate.now().getYear() - ch.getYear() < age).count()];
            int i = 0;
            for (Human child : childs) {
                if(LocalDate.now().getYear() - child.getYear() < age){
                    chs[i] = child;
                    i++;
                }
            }
            family.setChildren(Arrays.asList(chs));
        }
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int familyIndex) {
        return familyDao.getFamilyByIndex(familyIndex);
    }

    public Set<Pet> getPets(int familyIndex) {
        return familyDao.getFamilyByIndex(familyIndex) != null ? familyDao.getFamilyByIndex(familyIndex).getPets() : null;
    }

    public boolean addPet(int familyIndex, Pet pet) {
        Set<Pet> pets = getPets(familyIndex);

        if(pets == null) {
            pets = new HashSet<>();
            return pets.add(pet);
        } else {
            return pets.add(pet);
        }
    }
}
