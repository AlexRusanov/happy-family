package service;

import dao.FamilyDao;
import exceptions.FamilyOverflowException;
import model.human.Family;
import model.human.Human;
import model.human.Man;
import model.human.Woman;
import model.pet.Dog;
import model.pet.Pet;
import model.pet.RoboCat;

import java.time.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        IntStream.range(0, familyDao.getAllFamilies().size())
                .mapToObj(i -> (i + 1) + ". " + familyDao.getAllFamilies().get(i))
                .forEach(System.out::println);


    }

    public List<Family> getFamiliesBiggerThan(int familyMembersCount) {
        return familyDao.getAllFamilies().stream()
            .filter(family -> family.countFamily() > familyMembersCount)
            .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int familyMembersCount) {
        return familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() < familyMembersCount)
                .collect(Collectors.toList());
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
        if (family.countFamily() > 3) {
            throw new FamilyOverflowException("Размер семьи не позволяет вам иметь больше детей", 4);
        }

        Human child;

        Random random = new Random();

        Human dad = family.getFather();
        Human mum = family.getMother();

        if (random.nextBoolean()) {
            child = new Man(mansName, dad.getSurname(), Instant.now().toEpochMilli(), (byte)((dad.getIq() + mum.getIq())/2));
        } else {
            child = new Woman(womansName, dad.getSurname(), Instant.now().toEpochMilli(), (byte)((dad.getIq() + mum.getIq())/2));
        }

        family.addChild(child);

        return updateFamilyByValue(family) ? family : null;
    }

    public Family adoptChild(Family family, Human child) {
        if (family.countFamily() > 3) {
            throw new FamilyOverflowException("Размер семьи не позволяет вам иметь больше детей", 4);
        }

        family.addChild(child);

        updateFamilyByValue(family);

        return updateFamilyByValue(family) ? family : null;
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyDao.getAllFamilies().forEach(family -> {
            List<Human> childrenList = family.getChildren().stream()
                    .filter(child -> Period.between(Instant.ofEpochMilli(child.getBirthDate()).atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears() < age)
                    .collect(Collectors.toList());

            family.setChildren(childrenList);
        });
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

    public void initTestRepo() {
        Human grandma = new Woman("Padmé", "Amidala", 34758483355L, (byte) 99);

        Human grandpa = new Man("Anakin", "Skywalker", 37778593355L, (byte) 99);
        createNewFamily(grandma, grandpa);

        bornChild(getFamilyById(0), "Luke", "Leia");
        bornChild(getFamilyById(0), "John", "Luna");

        Set<String> habbits = new HashSet<>();
        habbits.add("hack computer systems");
        habbits.add("repair starships");
        Set<Pet> pets = new HashSet<>();
        pets.add(new RoboCat("R2D2", 20, (byte) 99, habbits));
        pets.add(new Dog("Шарик", 7, (byte) 50, null));

        getFamilyById(0).setPets(pets);

        Woman mum = new Woman("Leia", "Organa", 1977, (byte) 99);
        Man dad = new Man("Han", "Solo", 1977, (byte) 99);
        createNewFamily(mum, dad);
    }

    public boolean loadData(List<Family> families) {
        return familyDao.saveFamilies(families);
    }
}
