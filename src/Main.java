public class Main {
    public static void main(String[] args) {
        Human grandma = new Human("Padmé", "Amidala", 1952);
        Human grandpa = new Human("Anakin", "Skywalker", 1957);
        Family grandFamily = new Family(grandma, grandpa);
        Human mum = new Human("Leia", "Organa", 1977, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "diplomatic mission"}, {DayOfWeek.TUESDAY.name(), "To be captured by Darth Vader"}, {DayOfWeek.WEDNESDAY.name(), "To be rescued"}, {DayOfWeek.THURSDAY.name(), "Fight with Empire"}, {DayOfWeek.FRIDAY.name(), "Fall in love with Solo"}, {DayOfWeek.SATURDAY.name(), "plan an attack on the death star"}, {DayOfWeek.SUNDAY.name(), "celebrate victory"}});
        Human uncle = new Human("Luke", "Skywalker", 1977, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "buy R2D2"}, {DayOfWeek.TUESDAY.name(), "start learning force"}, {DayOfWeek.WEDNESDAY.name(), "get on the millennium falcon"}, {DayOfWeek.THURSDAY.name(), "to rescue Leia"}, {DayOfWeek.FRIDAY.name(), "Find Yoda"}, {DayOfWeek.SATURDAY.name(), "plan an attack on the death star"}, {DayOfWeek.SUNDAY.name(), "blow up the death star"}});
        grandFamily.addChild(mum);
        grandFamily.addChild(uncle);

        System.out.println("Grand Family counts" + grandFamily.countFamily() + " --->" + grandFamily);
        System.out.print("\n");

        grandFamily.deleteChild(mum);
        grandFamily.deleteChild(uncle);

        System.out.println("Grand Family counts" + grandFamily.countFamily() + " --->" + grandFamily);
        System.out.print("\n");

        Human dad = new Human("Han", "Solo", 1977);

        Family family = new Family(mum, dad);
        Pet r2d2 = new Pet(Species.ROBOT, "R2D2", 20, (byte) 99, new String[]{"hack computer systems", "repair starships"});
        Human son = new Human("Ben", "Solo", 2007, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "Сonquer the galaxy"}, {DayOfWeek.TUESDAY.name(), "Fight jedi"}, {DayOfWeek.WEDNESDAY.name(), "Kill the dark lord"}, {DayOfWeek.THURSDAY.name(), "Fight with Rey"}, {DayOfWeek.FRIDAY.name(), "Fall in love with Rey"}, {DayOfWeek.SATURDAY.name(), "Choose the light side"}, {DayOfWeek.SUNDAY.name(), "Tragically die"}});

        family.addChild(son);
        family.setPet(r2d2);

        System.out.println(family);
        System.out.print("\n");

        Pet rancor = new Pet(Species.RANCOR, "Beast");

        System.out.println(mum);
        System.out.print("\n");

        System.out.println(dad);
        System.out.print("\n");

        System.out.println(son);
        System.out.print("\n");

        System.out.println(r2d2);
        System.out.print("\n");

        System.out.println(rancor);
        System.out.print("\n");

        System.out.println("########################");
        System.out.println(son.toString());
        System.out.print("\n");
        son.greetPet();
        System.out.print("\n");
        son.describePet();
        System.out.print("\n");
        son.feedPet(false);
        System.out.println("########################");
        System.out.print("\n");

        rancor.eat();
        System.out.print("\n");
        r2d2.respond();
        System.out.print("\n");
        r2d2.foul();
    }
}
