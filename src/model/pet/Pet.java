package model.pet;

import model.enums.Species;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

abstract public class Pet implements Serializable{
    private Species species;
    private String nickname;
    private int age;
    private byte trickLevel;
    private Set<String> habits;

    public Pet() {
    }

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet(String nickname, int age, byte trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age > 0 && age <101 ? age: 0;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Species getSpecies() {
        return species;
    }

    void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public byte getTrickLevel() {
        return trickLevel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > -1 && age <101){
            this.age = age;
        } else {
            System.out.println("Unfortunately no one lives so long");
        }
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    @Override
    public String toString() {
        return  species + "{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + (habits != null ? habits : "No data") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age &&
                trickLevel == pet.trickLevel &&
                Objects.equals(species, pet.species) &&
                Objects.equals(nickname, pet.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this);
    }

    public void eat(){
        System.out.println("Я кушаю!");
    }

    abstract public void respond();

    public String prettyFormat() {
        return "\t\t{species=" + this.getClass().getSimpleName().toUpperCase() + ", nickname='" + this.getNickname() + "', age=" + this.getAge() + ", trickLevel=" + this.getTrickLevel() + ", habits=" + this.getHabits() + "}\n";
    }
}
