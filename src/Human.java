import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private byte iq;
    private String[][] schedule;
    private Family family;

    static {
        System.out.println("Loading class: " + Human.class);
    }

    {
        System.out.println("Creating new instance of type " + this.getClass());
    }

    public Human() {
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, byte iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq > 0 && iq <101 ? iq: 50;
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

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=" + Arrays.deepToString(schedule) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year &&
                iq == human.iq &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname) &&
                Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, family);
    }

    public void greetPet(){
        System.out.println("Привет, " + family.getPet().getNickname());
    }

    public void describePet(){
        System.out.println("У меня есть " + family.getPet().getSpecies() + ", ему " + family.getPet().getAge() + " лет, он " + (family.getPet().getTrickLevel() > 50 ? "очень хитрый": "почти не хитрый"));
    }

    public boolean feedPet(boolean isItFeedingTime){
        if (isItFeedingTime){
            System.out.println("Хм... покормлю ка я " + family.getPet().getNickname());
            return true;
        } else {
            Random random = new Random();
            byte trick = (byte) random.nextInt(100);
            if (family.getPet().getTrickLevel() > trick) {
                System.out.println("Хм... покормлю ка я " + family.getPet().getNickname());
                return true;
            }
            return false;
        }
    }

    public void createFamily() {
        int currYear = LocalDate.now().getYear();
        if (currYear - year > 21) {

        }
    }
}
