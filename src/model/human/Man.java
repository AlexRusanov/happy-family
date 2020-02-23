package model.human;

import model.pet.Pet;

public final class Man extends Human {

    public static final String[] MANNAMES = {"Ben", "Kol", "Nat", "Cade", "Luke", "Anakin"};

    public Man() {
    }

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, byte iq) {
        super(name, surname, year, iq);
    }

    @Override
    public void greetPets() {
        if(super.getFamily().getPets() != null) {
            for(Pet pet: super.getFamily().getPets()) {
                System.out.println("Привет лучший друг мужчины, " + pet.getNickname());
            }
        } else {
            System.out.println("У нас нет питомца");
        }
    }

    public void repairCar() {
        System.out.println("Я чиню машину");
    }
}
