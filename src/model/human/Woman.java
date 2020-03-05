package model.human;

import model.pet.Pet;

public final class Woman extends Human {

//    public static final String[] WOMANNAMES = {"Mara", "Leia", "Padmé", "Shmi", "Rey"};

    public Woman() {
    }

    public Woman(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    public Woman(String name, String surname, long birthDate, byte iq) {
        super(name, surname, birthDate, iq);
    }

    public Woman(String name, String surname, String birthDate, byte iq) {
        super(name, surname, birthDate, iq);
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

//    @Override
//    public Human bornChild() {
//        Human child;
//
//        Random random = new Random();
//
//        Human dad = this.getFamily().getFather();
//
//        if (random.nextBoolean()) {
//            child = new Man(Man.MANNAMES[random.nextInt(5) - 1], dad.getSurname(), LocalDateTime.now().getYear(), (byte)((dad.getIq() + this.getIq())/2));
//        } else {
//            child = new Woman(Woman.WOMANNAMES[random.nextInt(5) - 1], dad.getSurname(), LocalDateTime.now().getYear(), (byte)((dad.getIq() + this.getIq())/2));
//        }
//
//        this.getFamily().addChild(child);
//
//        return child;
//    }
}
