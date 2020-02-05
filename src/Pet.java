import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private Species species;
    private String nickname;
    private int age;
    private byte trickLevel;
    private String[] habits;

    static {
        System.out.println("Loading class:" + Pet.class);
    }

    {
        System.out.println("Creating new instance of type " + this.getClass());
    }

    public Pet() {
    }

    public Pet(Species species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(Species species, String nickname, int age, byte trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age > 0 && age <101 ? age: 0;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Species getSpecies() {
        return species;
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

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    @Override
    public String toString() {
        return  species + "{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + (habits != null ? Arrays.toString(habits) : "No data") +
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

    public void respond(){
        System.out.println("Привет, хозяин. Я - " + nickname + ". Я соскучился!");
    }

    public void foul(){
        System.out.println("Нужно хорошо замести следы...");
    }
}
