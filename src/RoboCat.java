public class RoboCat extends Pet implements PetInterface{
    public RoboCat() {
        super.setSpecies(Species.ROBOCAT);
    }

    public RoboCat(String nickname) {
        super(nickname);
        super.setSpecies(Species.ROBOCAT);
    }

    public RoboCat(String nickname, int age, byte trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.ROBOCAT);
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
