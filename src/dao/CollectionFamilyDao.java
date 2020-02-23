package dao;

import model.human.Family;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao{
    private final List<Family> families;

    public CollectionFamilyDao() {
        this.families = new ArrayList<>();
    }

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return index < families.size() ? families.get(index) : null;
    }

    @Override
    public boolean deleteFamily(int index) {
        return index < families.size() && families.remove(families.get(index));
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.indexOf(family) > -1 && families.remove(family);
    }

    @Override
    public boolean saveFamily(Family family) {
        return !families.contains(family) && families.add(family);
    }

    @Override
    public boolean updateFamily(int familyIndex, Family family) {
        families.remove(familyIndex);
        families.add(familyIndex, family);
        return families.contains(family);
    }
}
