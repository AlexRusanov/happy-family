public final class Man extends Human {

    public static final String[] MANNAMES = {"Ben", "Kol", "Nat", "Cade", "Luke", "Anakin"};

    public Man() {
    }

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, byte iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        if(super.getFamily().getPet() != null) {
            System.out.println("Привет лучший друг мужчины, " + super.getFamily().getPet().getNickname());
        } else {
            System.out.println("У нас нет питомца");
        }
    }

    public void repairCar() {
        System.out.println("Я чиню машину");
    }
}
