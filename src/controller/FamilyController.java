package controller;

import exceptions.FamilyOverflowException;
import model.human.Family;
import model.human.Human;
import model.pet.Pet;
import service.FamilyService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyController {
    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int familyMembersCount) {
        return familyService.getFamiliesBiggerThan(familyMembersCount);
    }

    public List<Family> getFamiliesLessThan(int familyMembersCount) {
        return familyService.getFamiliesLessThan(familyMembersCount);
    }

    public int countFamiliesWithMemberNumber(int familyMembersCount) {
        return familyService.countFamiliesWithMemberNumber(familyMembersCount);
    }

    public boolean createNewFamily(Human mother, Human father) {
        return familyService.createNewFamily(mother, father);
    }

    public boolean deleteFamilyByIndex(int familyIndex) {
        return familyService.deleteFamilyByIndex(familyIndex);
    }

    public Family bornChild(Family family, String mansName, String womansName) {
        Family result = family;

        try {
            result = familyService.bornChild(family, mansName, womansName);
        } catch (FamilyOverflowException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNumber());
        }

        return result;
    }

    public Family adoptChild(Family family, Human child) {
        Family result = family;

        try {
            result = familyService.adoptChild(family, child);
        } catch (FamilyOverflowException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNumber());
        }

        return result;
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int familyIndex) {
        return familyService.getFamilyById(familyIndex);
    }

    public boolean addPet(int familyIndex, Pet pet) {
        return familyService.addPet(familyIndex, pet);
    }

    public void initTestRepo() {
        familyService.initTestRepo();
    }

    public boolean loadData() {
        List<Family> families = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream("families.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            families = (List<Family>) objectInputStream.readObject();
        } catch (ClassNotFoundException | ClassCastException | IOException e) {
            e.printStackTrace();
        }

        return families.size() > 0 && familyService.loadData(families);
    }

    public void writeDataToFile() {
        List<Family> families = familyService.getAllFamilies();
        try(FileOutputStream fileOutputStream = new FileOutputStream("families.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(families);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
