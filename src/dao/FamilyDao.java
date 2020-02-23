package dao;

import model.human.Family;

import java.util.List;

public interface FamilyDao {
    List<Family> getAllFamilies();

    Family getFamilyByIndex(int index);

    boolean deleteFamily(int index);

    boolean deleteFamily(Family family);

    boolean saveFamily(Family family);
    
    boolean updateFamily(int familyIndex, Family family);
}
