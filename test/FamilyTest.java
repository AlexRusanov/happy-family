import model.enums.DayOfWeek;
import model.human.Family;
import model.human.Human;
import model.human.Man;
import model.human.Woman;
import org.junit.Assert;
import org.junit.Test;
import model.pet.Pet;
import model.pet.RoboCat;

import java.util.*;

public class FamilyTest {
    @Test
    public void toStringReturnsFamily() throws Exception {
        SortedMap<Integer, String> schedule = new TreeMap<>();
        schedule.put(DayOfWeek.MONDAY.ordinal(), "diplomatic mission");
        schedule.put(DayOfWeek.TUESDAY.ordinal(), "To be captured by Darth Vader");
        schedule.put(DayOfWeek.WEDNESDAY.ordinal(), "To be rescued");
        schedule.put(DayOfWeek.THURSDAY.ordinal(), "Fight with Empire");
        schedule.put(DayOfWeek.FRIDAY.ordinal(), "Fall in love with Solo");
        schedule.put(DayOfWeek.SATURDAY.ordinal(), "plan an attack on the death star");
        schedule.put(DayOfWeek.SUNDAY.ordinal(), "celebrate victory");

        Human mum = new Woman("Leia", "Organa", 1977, (byte) 99);
        mum.setSchedule(schedule);
        Human dad = new Man("Han", "Solo", 1977);
        Family family = new Family(mum, dad);
        Set<String> habbits = new HashSet<>();
        habbits.add("hack computer systems");
        habbits.add("repair starships");
        Set<Pet> pets = new HashSet<>();
        pets.add(new RoboCat("R2D2", 20, (byte) 99, habbits));
        SortedMap<Integer, String> schedule1 = new TreeMap<>();
        schedule1.put(DayOfWeek.MONDAY.ordinal(), "Сonquer the galaxy");
        schedule1.put(DayOfWeek.TUESDAY.ordinal(), "Fight jedi");
        schedule1.put(DayOfWeek.WEDNESDAY.ordinal(), "Kill the dark lord");
        schedule1.put(DayOfWeek.THURSDAY.ordinal(), "Fight with Rey");
        schedule1.put(DayOfWeek.FRIDAY.ordinal(), "Fall in love with Rey");
        schedule1.put(DayOfWeek.SATURDAY.ordinal(), "Choose the light side");
        schedule1.put(DayOfWeek.SUNDAY.ordinal(), "Tragically die");
        Human son = new Human("Ben", "Solo", 2007, (byte) 99);
        son.setSchedule(schedule1);
        family.addChild(son);
        family.setPets(pets);
        Assert.assertEquals("model.human.Family{mother=model.human.Human{name='Leia', surname='Organa', year=1977, iq=99, schedule=[[MONDAY, diplomatic mission], [TUESDAY, To be captured by Darth Vader], [WEDNESDAY, To be rescued], [THURSDAY, Fight with Empire], [FRIDAY, Fall in love with Solo], [SATURDAY, plan an attack on the death star], [SUNDAY, celebrate victory]]}, father=model.human.Human{name='Han', surname='Solo', year=1977, iq=50, schedule=[[MONDAY, ], [TUESDAY, ], [WEDNESDAY, ], [THURSDAY, ], [FRIDAY, ], [SATURDAY, ], [SUNDAY, ]]}, children=[model.human.Human{name='Ben', surname='Solo', year=2007, iq=99, schedule=[[MONDAY, Сonquer the galaxy], [TUESDAY, Fight jedi], [WEDNESDAY, Kill the dark lord], [THURSDAY, Fight with Rey], [FRIDAY, Fall in love with Rey], [SATURDAY, Choose the light side], [SUNDAY, Tragically die]]}], model.pet=[ROBOCAT{nickname='R2D2', age=20, trickLevel=99, habits=[repair starships, hack computer systems]}]}", family.toString());
    }

    @Test
    public void addChildAddsChildToChildrenList() throws Exception {
        SortedMap<Integer, String> schedule = new TreeMap<>();
        schedule.put(DayOfWeek.MONDAY.ordinal(), "diplomatic mission");
        schedule.put(DayOfWeek.TUESDAY.ordinal(), "To be captured by Darth Vader");
        schedule.put(DayOfWeek.WEDNESDAY.ordinal(), "To be rescued");
        schedule.put(DayOfWeek.THURSDAY.ordinal(), "Fight with Empire");
        schedule.put(DayOfWeek.FRIDAY.ordinal(), "Fall in love with Solo");
        schedule.put(DayOfWeek.SATURDAY.ordinal(), "plan an attack on the death star");
        schedule.put(DayOfWeek.SUNDAY.ordinal(), "celebrate victory");
        Human mum = new Human("Leia", "Organa", 1977, (byte) 99);
        mum.setSchedule(schedule);
        Human dad = new Human("Han", "Solo", 1977);
        Family family = new Family(mum, dad);
        schedule.put(DayOfWeek.MONDAY.ordinal(), "Сonquer the galaxy");
        schedule.put(DayOfWeek.TUESDAY.ordinal(), "Fight jedi");
        schedule.put(DayOfWeek.WEDNESDAY.ordinal(), "Kill the dark lord");
        schedule.put(DayOfWeek.THURSDAY.ordinal(), "Fight with Rey");
        schedule.put(DayOfWeek.FRIDAY.ordinal(), "Fall in love with Rey");
        schedule.put(DayOfWeek.SATURDAY.ordinal(), "Choose the light side");
        schedule.put(DayOfWeek.SUNDAY.ordinal(), "Tragically die");
        Human son = new Human("Ben", "Solo", 2007, (byte) 99);
        son.setSchedule(schedule);
        family.addChild(son);
        Assert.assertEquals("Is children length extends by 1", 1, family.getChildren().size());
    }

    @Test
    public void deleteChildFromFamilyReturnsTrue() throws Exception {
        SortedMap<Integer, String> schedule = new TreeMap<>();
        schedule.put(DayOfWeek.MONDAY.ordinal(), "diplomatic mission");
        schedule.put(DayOfWeek.TUESDAY.ordinal(), "To be captured by Darth Vader");
        schedule.put(DayOfWeek.WEDNESDAY.ordinal(), "To be rescued");
        schedule.put(DayOfWeek.THURSDAY.ordinal(), "Fight with Empire");
        schedule.put(DayOfWeek.FRIDAY.ordinal(), "Fall in love with Solo");
        schedule.put(DayOfWeek.SATURDAY.ordinal(), "plan an attack on the death star");
        schedule.put(DayOfWeek.SUNDAY.ordinal(), "celebrate victory");
        Human mum = new Human("Leia", "Organa", 1977, (byte) 99);
        mum.setSchedule(schedule);
        Human dad = new Human("Han", "Solo", 1977);
        Family family = new Family(mum, dad);
        schedule.put(DayOfWeek.MONDAY.ordinal(), "Сonquer the galaxy");
        schedule.put(DayOfWeek.TUESDAY.ordinal(), "Fight jedi");
        schedule.put(DayOfWeek.WEDNESDAY.ordinal(), "Kill the dark lord");
        schedule.put(DayOfWeek.THURSDAY.ordinal(), "Fight with Rey");
        schedule.put(DayOfWeek.FRIDAY.ordinal(), "Fall in love with Rey");
        schedule.put(DayOfWeek.SATURDAY.ordinal(), "Choose the light side");
        schedule.put(DayOfWeek.SUNDAY.ordinal(), "Tragically die");
        Human son = new Human("Ben", "Solo", 2007, (byte) 99);
        son.setSchedule(schedule);
        family.addChild(son);
        Assert.assertTrue(family.deleteChild(son));
    }

    @Test
    public void deleteNotChildFromFamilyReturnsFalse() throws Exception {
        SortedMap<Integer, String> schedule = new TreeMap<>();
        schedule.put(DayOfWeek.MONDAY.ordinal(), "diplomatic mission");
        schedule.put(DayOfWeek.TUESDAY.ordinal(), "To be captured by Darth Vader");
        schedule.put(DayOfWeek.WEDNESDAY.ordinal(), "To be rescued");
        schedule.put(DayOfWeek.THURSDAY.ordinal(), "Fight with Empire");
        schedule.put(DayOfWeek.FRIDAY.ordinal(), "Fall in love with Solo");
        schedule.put(DayOfWeek.SATURDAY.ordinal(), "plan an attack on the death star");
        schedule.put(DayOfWeek.SUNDAY.ordinal(), "celebrate victory");
        Human mum = new Human("Leia", "Organa", 1977, (byte) 99);
        mum.setSchedule(schedule);
        Human dad = new Human("Han", "Solo", 1977);
        Family family = new Family(mum, dad);
        schedule.put(DayOfWeek.MONDAY.ordinal(), "buy R2D2");
        schedule.put(DayOfWeek.TUESDAY.ordinal(), "start learning force");
        schedule.put(DayOfWeek.WEDNESDAY.ordinal(), "get on the millennium falcon");
        schedule.put(DayOfWeek.THURSDAY.ordinal(), "to rescue Leia");
        schedule.put(DayOfWeek.FRIDAY.ordinal(), "Find Yoda");
        schedule.put(DayOfWeek.SATURDAY.ordinal(), "plan an attack on the death star");
        schedule.put(DayOfWeek.SUNDAY.ordinal(), "blow up the death star");
        Human uncle = new Human("Luke", "Skywalker", 1977, (byte) 99);
        uncle.setSchedule(schedule);
        Assert.assertFalse(family.deleteChild(uncle));
    }

    @Test
    public void countFamilyReturnsCountOfFamilyMembers() throws Exception {
        SortedMap<Integer, String> schedule = new TreeMap<>();
        schedule.put(DayOfWeek.MONDAY.ordinal(), "diplomatic mission");
        schedule.put(DayOfWeek.TUESDAY.ordinal(), "To be captured by Darth Vader");
        schedule.put(DayOfWeek.WEDNESDAY.ordinal(), "To be rescued");
        schedule.put(DayOfWeek.THURSDAY.ordinal(), "Fight with Empire");
        schedule.put(DayOfWeek.FRIDAY.ordinal(), "Fall in love with Solo");
        schedule.put(DayOfWeek.SATURDAY.ordinal(), "plan an attack on the death star");
        schedule.put(DayOfWeek.SUNDAY.ordinal(), "celebrate victory");
        Human mum = new Human("Leia", "Organa", 1977, (byte) 99);
        mum.setSchedule(schedule);
        Human dad = new Human("Han", "Solo", 1977);
        Family family = new Family(mum, dad);
        schedule.put(DayOfWeek.MONDAY.ordinal(), "Сonquer the galaxy");
        schedule.put(DayOfWeek.TUESDAY.ordinal(), "Fight jedi");
        schedule.put(DayOfWeek.WEDNESDAY.ordinal(), "Kill the dark lord");
        schedule.put(DayOfWeek.THURSDAY.ordinal(), "Fight with Rey");
        schedule.put(DayOfWeek.FRIDAY.ordinal(), "Fall in love with Rey");
        schedule.put(DayOfWeek.SATURDAY.ordinal(), "Choose the light side");
        schedule.put(DayOfWeek.SUNDAY.ordinal(), "Tragically die");
        Human son = new Human("Ben", "Solo", 2007, (byte) 99);
        son.setSchedule(schedule);
        family.addChild(son);
        Assert.assertEquals(3, family.countFamily());
    }

}