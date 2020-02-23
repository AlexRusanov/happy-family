package service;

import dao.CollectionFamilyDao;
import model.human.Family;
import model.human.Human;
import model.human.Man;
import model.human.Woman;
import model.pet.Dog;
import model.pet.Pet;
import model.pet.RoboCat;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class FamilyServiceTest {
    @Test
    public void getAllFamiliesReturnsFamilyListWhenItPresent() throws Exception {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Human mum = new Woman("Leia", "Organa", 1977, (byte) 99);
        Human dad = new Man("Han", "Solo", 1977);
        familyService.createNewFamily(mum, dad);
        List<Family> exprctedFamilyList = new ArrayList<>();
        exprctedFamilyList.add(new Family(mum, dad));

        Assert.assertEquals(exprctedFamilyList, familyService.getAllFamilies());
    }

    @Test
    public void countFamiliesWithMemberNumberReturnsCountWhenFamiliesWithSuchCountOfMembersArePresent() throws Exception {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Human mum1 = new Woman("Mum", "1", 1977, (byte) 99);
        Human dad1 = new Man("Dad", "1", 1977);
        Human mum2 = new Woman("Mum", "2", 1977, (byte) 99);
        Human dad2 = new Man("Dad", "2", 1977);
        familyService.createNewFamily(mum1, dad1);
        familyService.createNewFamily(mum2, dad2);

        Assert.assertEquals(2, familyService.countFamiliesWithMemberNumber(2));
    }

    @Test
    public void createNewFamilyReturnsTrueWhenNewFamilyIsAdded() throws Exception {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Human mum = new Woman("Leia", "Organa", 1977, (byte) 99);
        Human dad = new Man("Han", "Solo", 1977);
        Assert.assertTrue(familyService.createNewFamily(mum, dad));
    }

    @Test
    public void deleteFamilyByIndexReturnsTrueWhenFamilyIsDeletedFromRepository() throws Exception {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Human mum = new Woman("Leia", "Organa", 1977, (byte) 99);
        Human dad = new Man("Han", "Solo", 1977);
        familyService.createNewFamily(mum, dad);
        Assert.assertTrue(familyService.deleteFamilyByIndex(0));
    }

    @Test
    public void updateFamilyByValueReturnsTrueWhenFamilyDoesNotExist() throws Exception {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Human mum = new Woman("Leia", "Organa", 1977, (byte) 99);
        Human dad = new Man("Han", "Solo", 1977);
        Assert.assertTrue(familyService.updateFamilyByValue(new Family(mum, dad)));
    }

    @Test
    public void updateFamilyByValueReturnsTrueWhenFamilyDoExist() throws Exception {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Human mum = new Woman("Leia", "Organa", 1977, (byte) 99);
        Human dad = new Man("Han", "Solo", 1977);
        familyService.createNewFamily(mum, dad);
        Assert.assertTrue(familyService.updateFamilyByValue(new Family(mum, dad)));
    }

    @Test
    public void bornChildReturnsFamilyWithChildrenListSizeOneWhenOneChildIsAdded() throws Exception {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Human mum = new Woman("Leia", "Organa", 1977, (byte) 99);
        Human dad = new Man("Han", "Solo", 1977, (byte) 99);
        familyService.createNewFamily(mum, dad);

        Assert.assertEquals(1, familyService.bornChild(familyService.getFamilyById(0), "Ben", "Star").getChildren().size());
    }

    @Test
    public void adoptChildReturnsFamilyWithAdoptedChildWhenChildIsAdopted() throws Exception {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Human mum = new Woman("Leia", "Organa", 1977, (byte) 99);
        Human dad = new Man("Han", "Solo", 1977, (byte) 99);
        familyService.createNewFamily(mum, dad);
        Human rey = new Man("Rey", "Palpatine", 2017, (byte) 99);
        Assert.assertEquals(rey, familyService.adoptChild(familyService.getFamilyById(0), rey).getChildren().get(0));
    }

    @Test
    public void deleteAllChildrenOlderThenDeletesAllChildrenFromAllFamiliesWhenThereAreChildrensOlderThanGivenAge() throws Exception {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Human mum1 = new Woman("Mum", "1", 1977, (byte) 99);
        Human dad1 = new Man("Dad", "1", 1977);
        Human mum2 = new Woman("Mum", "2", 1977, (byte) 99);
        Human dad2 = new Man("Dad", "2", 1977);
        Human child1 = new Woman("Mary", "family1", 1995, (byte) 99);
        Human child2 = new Man("John", "family1", 2015, (byte) 99);
        Human child3 = new Woman("Mary", "family2", 2017, (byte) 99);
        Human child4 = new Man("John", "family2", 1997, (byte) 99);
        familyService.createNewFamily(mum1, dad1);
        familyService.createNewFamily(mum2, dad2);
        familyService.adoptChild(familyService.getFamilyById(0), child1);
        familyService.adoptChild(familyService.getFamilyById(0), child2);
        familyService.adoptChild(familyService.getFamilyById(1), child3);
        familyService.adoptChild(familyService.getFamilyById(1), child4);
        familyService.deleteAllChildrenOlderThen(10);
        Assert.assertEquals(2, familyService.countFamiliesWithMemberNumber(3));
    }

    @Test
    public void countReturnsFamiliesCountWhenTheyExists() throws Exception {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Human mum1 = new Woman("Mum", "1", 1977, (byte) 99);
        Human dad1 = new Man("Dad", "1", 1977);
        Human mum2 = new Woman("Mum", "2", 1977, (byte) 99);
        Human dad2 = new Man("Dad", "2", 1977);
        familyService.createNewFamily(mum1, dad1);
        familyService.createNewFamily(mum2, dad2);
        Assert.assertEquals(2, familyService.count());
    }

    @Test
    public void getFamilyById() throws Exception {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Human mum1 = new Woman("Mum", "1", 1977, (byte) 99);
        Human dad1 = new Man("Dad", "1", 1977);
        Human mum2 = new Woman("Mum", "2", 1977, (byte) 99);
        Human dad2 = new Man("Dad", "2", 1977);
        familyService.createNewFamily(mum1, dad1);
        familyService.createNewFamily(mum2, dad2);
        Assert.assertEquals(new Family(mum2, dad2), familyService.getFamilyById(1));
    }

    @Test
    public void getPets() throws Exception {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Human mum = new Woman("Leia", "Organa", 1977, (byte) 99);
        Human dad = new Man("Han", "Solo", 1977);
        familyService.createNewFamily(mum, dad);
        Set<String> habbits = new HashSet<>();
        habbits.add("hack computer systems");
        habbits.add("repair starships");
        Set<Pet> pets = new HashSet<>();
        pets.add(new RoboCat("R2D2", 20, (byte) 99, habbits));
        pets.add(new Dog("Dog", 10, (byte) 40, new HashSet<>()));
        Set<Pet> expectedPets = new HashSet<>();
        expectedPets.add(new RoboCat("R2D2", 20, (byte) 99, habbits));
        expectedPets.add(new Dog("Dog", 10, (byte) 40, new HashSet<>()));

        familyService.getFamilyById(0).setPets(pets);
        Assert.assertEquals(expectedPets, familyService.getPets(0));
    }

    @Test
    public void addPet() throws Exception {
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        Human mum = new Woman("Leia", "Organa", 1977, (byte) 99);
        Human dad = new Man("Han", "Solo", 1977);
        familyService.createNewFamily(mum, dad);
        Assert.assertTrue(familyService.addPet(0, new RoboCat("R2D2", 20, (byte) 99, new HashSet<>())));
    }

}