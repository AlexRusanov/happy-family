public class DomesticCat extends Pet implements PetInterface{

    public DomesticCat() {
        super.setSpecies(Species.DOMESTICCAT);
    }

    public DomesticCat(String nickname) {
        super(nickname);
        super.setSpecies(Species.DOMESTICCAT);
    }

    public DomesticCat(String nickname, int age, byte trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.DOMESTICCAT);
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
