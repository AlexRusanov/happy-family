import java.util.Arrays;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private byte iq;
    private Pet pet;
    private Human mother;
    private Human father;
    private String[][] schedule;

    public Human() {
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int year, byte iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq > 0 && iq <101 ? iq: 50;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
    }

    public int getYear() {
        return year;
    }

    public byte getIq() {
        return iq;
    }

    public void setIq(byte iq) {
        if (iq > -1 && iq <101){
            this.iq = iq;
        } else {
            System.out.println("It's can't be true");
        }
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", mother=" + (mother != null ? mother.getName() + " " + mother.getSurname() : "No data") +
                ", father=" + (father != null ? father.getName() + " " + father.getSurname() : "No data") +
                ", pet=" + (pet != null ? pet : "No data") +
                '}';
    }

    public void greetPet(){
        System.out.println("Привет, " + pet.getNickname());
    }

    public void describePet(){
        System.out.println("У меня есть " + pet.getSpecies() + ", ему " + pet.getAge() + " лет, он " + (pet.getTrickLevel() > 50 ? "очень хитрый": "почти не хитрый"));
    }

    public boolean feedPet(boolean isItFeedingTime){
        if (isItFeedingTime){
            System.out.println("Хм... покормлю ка я " + pet.getNickname());
            return true;
        } else {
            Random random = new Random();
            byte trick = (byte) random.nextInt(100);
            if (pet.getTrickLevel() > trick) {
                System.out.println("Хм... покормлю ка я " + pet.getNickname());
                return true;
            }
            return false;
        }
    }
}
