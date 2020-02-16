import human.Family;
import human.Human;
import human.Man;
import human.Woman;
import pet.Dog;
import pet.Pet;
import pet.RoboCat;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        human.Human grandma = new human.Human("Padmé", "Amidala", 1952);
//        human.Human grandpa = new human.Human("Anakin", "Skywalker", 1957);
//        human.Family grandFamily = new human.Family(grandma, grandpa);
        Woman mum = new Woman("Leia", "Organa", 1977, (byte) 99);
//        human.Human uncle = new human.Human("Luke", "Skywalker", 1977, (byte) 99, new String[][]{{enums.DayOfWeek.MONDAY.name(), "buy R2D2"}, {enums.DayOfWeek.TUESDAY.name(), "start learning force"}, {enums.DayOfWeek.WEDNESDAY.name(), "get on the millennium falcon"}, {enums.DayOfWeek.THURSDAY.name(), "to rescue Leia"}, {enums.DayOfWeek.FRIDAY.name(), "Find Yoda"}, {enums.DayOfWeek.SATURDAY.name(), "plan an attack on the death star"}, {enums.DayOfWeek.SUNDAY.name(), "blow up the death star"}});
//        grandFamily.addChild(mum);
//        grandFamily.addChild(uncle);
//
//        System.out.println("Grand human.Family counts" + grandFamily.countFamily() + " --->" + grandFamily);
//        System.out.print("\n");
//
//        grandFamily.deleteChild(mum);
//        grandFamily.deleteChild(uncle);
//
//        System.out.println("Grand human.Family counts" + grandFamily.countFamily() + " --->" + grandFamily);
//        System.out.print("\n");

        Man dad = new Man("Han", "Solo", 1977, (byte) 99);

        Family family = new Family(mum, dad);
        Set<String> habbits = new HashSet<>();
        habbits.add("hack computer systems");
        habbits.add("repair starships");
        Set<Pet> pets = new HashSet<>();
        pets.add(new RoboCat("R2D2", 20, (byte) 99, habbits));
        Human child = mum.bornChild();

        family.setPets(pets);

        System.out.println(family);
        System.out.print("\n");

        Pet rancor = new Dog("Beast");

        System.out.println(mum);
        System.out.print("\n");

        System.out.println(dad);
        System.out.print("\n");

        System.out.println(child);
        System.out.print("\n");

        System.out.println(pets);
        System.out.print("\n");

        System.out.println(rancor);
        System.out.print("\n");

        System.out.println("########################");
        System.out.println(child.toString());
        System.out.print("\n");
        child.greetPets();
        System.out.print("\n");
        child.describePets();
        System.out.print("\n");
        child.feedPets(false);
        System.out.println("########################");
        System.out.print("\n");

        rancor.eat();
        System.out.print("\n");
        pets.forEach(Pet::respond);
    }
}
