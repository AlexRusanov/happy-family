package model.pet;

import java.util.Set;

public class RoboCat extends Pet implements FoulingPet {
    public RoboCat() {
    }

    public RoboCat(String nickname) {
        super(nickname);
    }

    public RoboCat(String nickname, int age, byte trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Привет, хозяин. Я - " + super.getNickname() + ". Я соскучился!");
    }

    @Override
    public void foul() {
        System.out.println("Нужно хорошо замести следы...");
    }
}
