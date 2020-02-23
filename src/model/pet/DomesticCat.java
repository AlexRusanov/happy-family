package model.pet;

import java.util.Set;

public class DomesticCat extends Pet implements FoulingPet {

    public DomesticCat() {
    }

    public DomesticCat(String nickname) {
        super(nickname);
    }

    public DomesticCat(String nickname, int age, byte trickLevel, Set<String> habits) {
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
