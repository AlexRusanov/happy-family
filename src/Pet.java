import java.util.Arrays;

public class Pet {
    private String species;
    private String nickname;
    private int age;
    private byte trickLevel;
    private String[] habits;

    public Pet() {
    }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, byte trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age > 0 && age <101 ? age: 0;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public String getSpecies() {
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
