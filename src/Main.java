public class Main {
    public static void main(String[] args) {
//        Human grandma = new Human("Padmé", "Amidala", 1952);
//        Human grandpa = new Human("Anakin", "Skywalker", 1957);
//        Family grandFamily = new Family(grandma, grandpa);
        Woman mum = new Woman("Leia", "Organa", 1977, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "diplomatic mission"}, {DayOfWeek.TUESDAY.name(), "To be captured by Darth Vader"}, {DayOfWeek.WEDNESDAY.name(), "To be rescued"}, {DayOfWeek.THURSDAY.name(), "Fight with Empire"}, {DayOfWeek.FRIDAY.name(), "Fall in love with Solo"}, {DayOfWeek.SATURDAY.name(), "plan an attack on the death star"}, {DayOfWeek.SUNDAY.name(), "celebrate victory"}});
//        Human uncle = new Human("Luke", "Skywalker", 1977, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "buy R2D2"}, {DayOfWeek.TUESDAY.name(), "start learning force"}, {DayOfWeek.WEDNESDAY.name(), "get on the millennium falcon"}, {DayOfWeek.THURSDAY.name(), "to rescue Leia"}, {DayOfWeek.FRIDAY.name(), "Find Yoda"}, {DayOfWeek.SATURDAY.name(), "plan an attack on the death star"}, {DayOfWeek.SUNDAY.name(), "blow up the death star"}});
//        grandFamily.addChild(mum);
//        grandFamily.addChild(uncle);
//
//        System.out.println("Grand Family counts" + grandFamily.countFamily() + " --->" + grandFamily);
//        System.out.print("\n");
//
//        grandFamily.deleteChild(mum);
//        grandFamily.deleteChild(uncle);
//
//        System.out.println("Grand Family counts" + grandFamily.countFamily() + " --->" + grandFamily);
//        System.out.print("\n");

        Man dad = new Man("Han", "Solo", 1977, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), ""}, {DayOfWeek.TUESDAY.name(), ""}, {DayOfWeek.WEDNESDAY.name(), ""}, {DayOfWeek.THURSDAY.name(), ""}, {DayOfWeek.FRIDAY.name(), ""}, {DayOfWeek.SATURDAY.name(), ""}, {DayOfWeek.SUNDAY.name(), ""}});

        Family family = new Family(mum, dad);
        RoboCat r2d2 = new RoboCat("R2D2", 20, (byte) 99, new String[]{"hack computer systems", "repair starships"});
        Human child = mum.bornChild();

        family.setPet(r2d2);

        System.out.println(family);
        System.out.print("\n");

        Pet rancor = new Dog("Beast");

        System.out.println(mum);
        System.out.print("\n");

        System.out.println(dad);
        System.out.print("\n");

        System.out.println(child);
        System.out.print("\n");

        System.out.println(r2d2);
        System.out.print("\n");

        System.out.println(rancor);
        System.out.print("\n");

        System.out.println("########################");
        System.out.println(child.toString());
        System.out.print("\n");
        child.greetPet();
        System.out.print("\n");
        child.describePet();
        System.out.print("\n");
        child.feedPet(false);
        System.out.println("########################");
        System.out.print("\n");

        rancor.eat();
        System.out.print("\n");
        r2d2.respond();
        System.out.print("\n");
        r2d2.foul();
    }
}
