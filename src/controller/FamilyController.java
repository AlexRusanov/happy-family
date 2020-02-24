package controller;

import model.human.Family;
import model.human.Human;
import model.pet.Pet;
import service.FamilyService;

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
        return familyService.bornChild(family, mansName, womansName);
    }

    public Family adoptChild(Family family, Human child) {
        return familyService.adoptChild(family, child);
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
}
