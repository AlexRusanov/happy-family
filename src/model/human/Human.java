package model.human;

import model.enums.DayOfWeek;
import model.pet.Pet;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private byte iq;
    private SortedMap<Integer, String> schedule;
    private Family family;
    private final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Human() {
    }

    public Human(String name, String surname, long birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = 50;
        initSchedule();
    }

    public Human(String name, String surname, long birthDate, byte iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq > 0 && iq <101 ? iq: 50;
        initSchedule();
    }

    //FOR ADOPTED CHILDREN
    public Human(String name, String surname, String birthDate, byte iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDate.parse(birthDate, DATE_FORMATTER).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        this.iq = iq;
        initSchedule();
    }

    public long getBirthDate() {
        return birthDate;
    }

    public byte getIq() {
        return iq;
    }

    public void setIq(byte iq) {
        if (iq > -1 && iq <101){
            this.iq = iq;
        } else {
            System.out.println("It's can't be true");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Map<Integer, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(SortedMap<Integer, String> schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth date=" + formatBirthDate() +
                ", iq=" + iq +
                ", schedule=[" + prepareScheduleForPrint() +
                "]}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate &&
                iq == human.iq &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname) &&
                Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iq, family);
    }

    public void greetPets(){
        if(family.getPets() != null) {
            for(Pet pet: family.getPets()){
                System.out.println("Привет, " + pet.getNickname());
            }
        } else {
            System.out.println("У нас нет питомца");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this);
    }

    public void describePets(){
        if(family.getPets() != null) {
            for(Pet pet: family.getPets()) {
                System.out.println("У меня есть " + pet.getSpecies() + ", ему " + pet.getAge() + " лет, он " + (pet.getTrickLevel() > 50 ? "очень хитрый": "почти не хитрый"));
            }
        } else {
            System.out.println("У нас нет питомца");
        }
    }

    public boolean feedPets(boolean isItFeedingTime){
        if(family.getPets() != null) {
            if (isItFeedingTime){
                for(Pet pet: family.getPets()){
                    System.out.println("Хм... покормлю ка я " + pet.getNickname());
                }
                return true;
            } else {
                Random random = new Random();
                byte trick = (byte) random.nextInt(100);
                int petsFeeded = 0;
                for(Pet pet: family.getPets()){
                    if (pet.getTrickLevel() > trick) {
                        System.out.println("Хм... покормлю ка я " + pet.getNickname());
                        petsFeeded++;
                    }
                }
                return petsFeeded == family.getPets().size();
            }
        } else {
            System.out.println("У нас нет питомца");
            return false;
        }
    }

    private void initSchedule() {
        this.schedule = new TreeMap<>();
        this.schedule.put(DayOfWeek.MONDAY.ordinal(), "");
        this.schedule.put(DayOfWeek.TUESDAY.ordinal(), "");
        this.schedule.put(DayOfWeek.WEDNESDAY.ordinal(), "");
        this.schedule.put(DayOfWeek.THURSDAY.ordinal(), "");
        this.schedule.put(DayOfWeek.FRIDAY.ordinal(), "");
        this.schedule.put(DayOfWeek.SATURDAY.ordinal(), "");
        this.schedule.put(DayOfWeek.SUNDAY.ordinal(), "");
    }

    public String prepareScheduleForPrint() {
        int i = 0;
        StringBuilder result = new StringBuilder();
        for(Map.Entry<Integer, String> entry : this.schedule.entrySet()) {
            result.append("[").append(DayOfWeek.values()[i]).append(", ").append(entry.getValue()).append("], ");
            i++;
        }

        result.setLength(result.length() - 2);

        return String.valueOf(result);
    }

    public String describeAge() {
        Period age = Period.between(Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
        return this.name + " на текущий момент прожила " + age.getYears() + " лет " + age.getMonths() + " месяцев " + age.getDays() + " дней";
    }

    public String formatBirthDate() {
        return Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate().format(DATE_FORMATTER);
    }
}
