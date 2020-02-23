package model.human;

import model.pet.Pet;

import java.time.LocalDateTime;
import java.util.Random;

public final class Woman extends Human implements HumanCreator {

    public static final String[] WOMANNAMES = {"Mara", "Leia", "Padmé", "Shmi", "Rey"};

    public Woman() {
    }

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, byte iq) {
        super(name, surname, year, iq);
    }

    @Override
    public void greetPets() {
        if(super.getFamily().getPets() != null) {
            for(Pet pet: super.getFamily().getPets()) {
                System.out.println("Привет лучший друг женщины, " + pet.getNickname());
            }
        } else {
            System.out.println("У нас нет питомца");
        }
    }

    public void makeup() {
        System.out.println("Какой у меня макияж!");
    }

    @Override
    public Human bornChild() {
        Human child;

        Random random = new Random();

        Human dad = this.getFamily().getFather();

        if (random.nextBoolean()) {
            child = new Man(Man.MANNAMES[random.nextInt(5) - 1], dad.getSurname(), LocalDateTime.now().getYear(), (byte)((dad.getIq() + this.getIq())/2));
        } else {
            child = new Woman(Woman.WOMANNAMES[random.nextInt(5) - 1], dad.getSurname(), LocalDateTime.now().getYear(), (byte)((dad.getIq() + this.getIq())/2));
        }

        this.getFamily().addChild(child);

        return child;
    }
}
