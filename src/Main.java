public class Main {
    public static void main(String[] args) {
        Human grandma = new Human("Padmé", "Amidala", 1952);
        Human grandpa = new Human("Anakin", "Skywalker", 1957);
        Family grandFamily = new Family(grandma, grandpa);
        Human mum = new Human("Leia", "Organa", 1977, (byte) 99, new String[][]{{"Monday", "diplomatic mission"}, {"Tuesday", "To be captured by Darth Vader"}, {"Wednesday", "To be rescued"}, {"Thursday", "Fight with Empire"}, {"Friday", "Fall in love with Solo"}, {"Saturday", "plan an attack on the death star"}, {"Sunday", "celebrate victory"}});
        Human uncle = new Human("Luke", "Skywalker", 1977, (byte) 99, new String[][]{{"Monday", "buy R2D2"}, {"Tuesday", "start learning force"}, {"Wednesday", "get on the millennium falcon"}, {"Thursday", "to rescue Leia"}, {"Friday", "Find Yoda"}, {"Saturday", "plan an attack on the death star"}, {"Sunday", "blow up the death star"}});
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
        Pet r2d2 = new Pet("robot", "R2D2", 20, (byte) 99, new String[]{"hack computer systems", "repair starships"});
        Human son = new Human("Ben", "Solo", 2007, (byte) 99, new String[][]{{"Monday", "Сonquer the galaxy"}, {"Tuesday", "Fight jedi"}, {"Wednesday", "Kill the dark lord"}, {"Thursday", "Fight with Rey"}, {"Friday", "Fall in love with Rey"}, {"Saturday", "Choose the light side"}, {"Sunday", "Tragically die"}});

        family.addChild(son);
        family.setPet(r2d2);

        System.out.println(family);
        System.out.print("\n");

        Pet rancor = new Pet("Rancor", "Beast");

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
