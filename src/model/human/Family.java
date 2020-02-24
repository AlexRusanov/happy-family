package model.human;

import model.pet.Pet;

import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    static {
        System.out.println("Loading class:" + Family.class);
    }

    {
        System.out.println("Creating new instance of type " + this.getClass().getName());
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        mother.setFamily(this);
        father.setFamily(this);
        this.pets = new HashSet<>();
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pet) {
        this.pets = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                children.equals(family.children) &&
                pets.equals(family.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pets);
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + children.toString() +
                ", model.pet=" + pets +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this);
    }

    public void addChild(Human child) {
        this.children.add(child);
        child.setFamily(this);
    }

    public boolean deleteChild(Human child) {
        boolean isRemoved = this.children.removeIf(ch -> ch.equals(child));

        if(isRemoved) {
            child.setFamily(null);
        }

        return isRemoved;
    }

    public int countFamily() {
        return 2 + children.size();
    }
}
