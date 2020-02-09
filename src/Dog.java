public class Dog extends Pet implements PetInterface{
    public Dog() {
        super.setSpecies(Species.DOG);
    }

    public Dog(String nickname) {
        super(nickname);
        super.setSpecies(Species.DOG);
    }

    public Dog(String nickname, int age, byte trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.DOG);
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
