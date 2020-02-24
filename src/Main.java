import controller.FamilyController;
import dao.CollectionFamilyDao;
import model.human.Human;
import model.human.Man;
import model.human.Woman;
import service.FamilyService;

public class Main {
    public static void main(String[] args) {
        FamilyController familyController = new FamilyController(new FamilyService(new CollectionFamilyDao()));

        Human grandma = new Woman("Padmé", "Amidala", 34758483355L, (byte) 99);

        System.out.println(grandma.describeAge());
        System.out.print("\n");
        System.out.print("\n");

        Human grandpa = new Man("Anakin", "Skywalker", 37778593355L, (byte) 99);
        familyController.createNewFamily(grandma, grandpa);

        familyController.bornChild(familyController.getFamilyById(0), "Luke", "Leia");

        Human mum = new Woman("Leia", "Organa", 666666666L, (byte) 99);
        Human dad = new Man("Han", "Solo", 666666666L, (byte) 99);
        familyController.createNewFamily(mum, dad);

        System.out.print("\n");
        System.out.println("getFamiliesBiggerThan 2 -> " + familyController.getFamiliesBiggerThan(2));
        System.out.print("\n");

        Human rey = new Woman("Rey", "Palpatine", "09/09/2001", (byte) 99);
        familyController.adoptChild(familyController.getFamilyById(1), rey);

        System.out.print("\n");
        System.out.println("getFamiliesLessThan 4 -> " + familyController.getFamiliesLessThan(4));
        System.out.print("\n");

        System.out.print("\n");
        System.out.println("countFamiliesWithMemberNumber 3 -> " + familyController.countFamiliesWithMemberNumber(3));
        System.out.print("\n");

        familyController.displayAllFamilies();

        familyController.deleteAllChildrenOlderThen(15);
        System.out.print("\n");
        System.out.println("deleteAllChildrenOlderThen 15 -> " + familyController.getAllFamilies());

        System.out.print("\n");

        System.out.println("deleteFamilyByIndex 1 -> " + familyController.deleteFamilyByIndex(1));

        System.out.print("\n");

        System.out.println("count Families -> " + familyController.count());

        System.out.print("\n");

        familyController.displayAllFamilies();

        System.out.print("\n");

//        model.human.Human grandma = new model.human.Human("Padmé", "Amidala", 1952);
//        model.human.Human grandpa = new model.human.Human("Anakin", "Skywalker", 1957);
//        model.human.Family grandFamily = new model.human.Family(grandma, grandpa);
//        Woman mum = new Woman("Leia", "Organa", 1977, (byte) 99);
//        model.human.Human uncle = new model.human.Human("Luke", "Skywalker", 1977, (byte) 99, new String[][]{{model.enums.DayOfWeek.MONDAY.name(), "buy R2D2"}, {model.enums.DayOfWeek.TUESDAY.name(), "start learning force"}, {model.enums.DayOfWeek.WEDNESDAY.name(), "get on the millennium falcon"}, {model.enums.DayOfWeek.THURSDAY.name(), "to rescue Leia"}, {model.enums.DayOfWeek.FRIDAY.name(), "Find Yoda"}, {model.enums.DayOfWeek.SATURDAY.name(), "plan an attack on the death star"}, {model.enums.DayOfWeek.SUNDAY.name(), "blow up the death star"}});
//        grandFamily.addChild(mum);
//        grandFamily.addChild(uncle);
//
//        System.out.println("Grand model.human.Family counts" + grandFamily.countFamily() + " --->" + grandFamily);
//        System.out.print("\n");
//
//        grandFamily.deleteChild(mum);
//        grandFamily.deleteChild(uncle);
//
//        System.out.println("Grand model.human.Family counts" + grandFamily.countFamily() + " --->" + grandFamily);
//        System.out.print("\n");

//        Man dad = new Man("Han", "Solo", 1977, (byte) 99);
//
//        Family family = new Family(mum, dad);
//        Set<String> habbits = new HashSet<>();
//        habbits.add("hack computer systems");
//        habbits.add("repair starships");
//        Set<Pet> pets = new HashSet<>();
//        pets.add(new RoboCat("R2D2", 20, (byte) 99, habbits));
//        Human child = mum.bornChild();
//
//        family.setPets(pets);
//
//        System.out.println(family);
//        System.out.print("\n");
//
//        Pet rancor = new Dog("Beast");
//
//        System.out.println(mum);
//        System.out.print("\n");
//
//        System.out.println(dad);
//        System.out.print("\n");
//
//        System.out.println(child);
//        System.out.print("\n");
//
//        System.out.println(pets);
//        System.out.print("\n");
//
//        System.out.println(rancor);
//        System.out.print("\n");
//
//        System.out.println("########################");
//        System.out.println(child.toString());
//        System.out.print("\n");
//        child.greetPets();
//        System.out.print("\n");
//        child.describePets();
//        System.out.print("\n");
//        child.feedPets(false);
//        System.out.println("########################");
//        System.out.print("\n");
//
//        rancor.eat();
//        System.out.print("\n");
//        pets.forEach(Pet::respond);
    }
}
