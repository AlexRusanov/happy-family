package pet;

import enums.Species;

import java.util.Set;

public class Fish extends Pet{

    public Fish() {
    }

    public Fish(String nickname) {
        super(nickname);
    }

    public Fish(String nickname, int age, byte trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Привет, хозяин. Я - " + super.getNickname() + ". Я соскучился!");
    }
}
