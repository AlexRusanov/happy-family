public class Main {
    public static void main(String[] args) {
        Human mum = new Human("Leia", "Organa", 1977, new Human("Anakin", "Skywalker", 1957), new Human("Padmé", "Amidala", 1952));
        Human dad = new Human("Han", "Solo", 1977);
        Pet r2d2 = new Pet("robot", "R2D2", 20, (byte) 99, new String[]{"hack computer systems", "repair starships"});
        Human son = new Human("Ben", "Solo", 2007, (byte) 99, r2d2, mum, dad, new String[][]{{"Monday", "Сonquer the galaxy"}, {"Tuesday", "Fight jedi"}, {"Wednesday", "Kill the dark lord"}, {"Thursday", "Fight with Rey"}, {"Friday", "Fall in love with Rey"}, {"Saturday", "Choose the light side"}, {"Sunday", "Tragically die"}});
        Pet rancor = new Pet("Rancor", "Beast");

        System.out.println(mum);
        System.out.println(dad);
        System.out.println(son);
        System.out.println(r2d2);
        System.out.println(rancor);

        System.out.println("########################");
        System.out.println(son.toString());
        son.greetPet();
        son.describePet();
        son.feedPet(false);
        System.out.println("########################");

        rancor.eat();
        r2d2.respond();
        r2d2.foul();
    }
}
