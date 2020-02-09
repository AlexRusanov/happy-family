import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FamilyTest {
    @Test
    public void toStringReturnsFamily() throws Exception {
        Human mum = new Human("Leia", "Organa", 1977, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "diplomatic mission"}, {DayOfWeek.TUESDAY.name(), "To be captured by Darth Vader"}, {DayOfWeek.WEDNESDAY.name(), "To be rescued"}, {DayOfWeek.THURSDAY.name(), "Fight with Empire"}, {DayOfWeek.FRIDAY.name(), "Fall in love with Solo"}, {DayOfWeek.SATURDAY.name(), "plan an attack on the death star"}, {DayOfWeek.SUNDAY.name(), "celebrate victory"}});
        Human dad = new Human("Han", "Solo", 1977);
        Family family = new Family(mum, dad);
        RoboCat r2d2 = new RoboCat("R2D2", 20, (byte) 99, new String[]{"hack computer systems", "repair starships"});
        Human son = new Human("Ben", "Solo", 2007, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "Сonquer the galaxy"}, {DayOfWeek.TUESDAY.name(), "Fight jedi"}, {DayOfWeek.WEDNESDAY.name(), "Kill the dark lord"}, {DayOfWeek.THURSDAY.name(), "Fight with Rey"}, {DayOfWeek.FRIDAY.name(), "Fall in love with Rey"}, {DayOfWeek.SATURDAY.name(), "Choose the light side"}, {DayOfWeek.SUNDAY.name(), "Tragically die"}});
        family.addChild(son);
        family.setPet(r2d2);
        Assert.assertEquals("Family{mother=Human{name='Leia', surname='Organa', year=1977, iq=99, schedule=[[MONDAY, diplomatic mission], [TUESDAY, To be captured by Darth Vader], [WEDNESDAY, To be rescued], [THURSDAY, Fight with Empire], [FRIDAY, Fall in love with Solo], [SATURDAY, plan an attack on the death star], [SUNDAY, celebrate victory]]}, father=Human{name='Han', surname='Solo', year=1977, iq=0, schedule=null}, children=[Human{name='Ben', surname='Solo', year=2007, iq=99, schedule=[[MONDAY, Сonquer the galaxy], [TUESDAY, Fight jedi], [WEDNESDAY, Kill the dark lord], [THURSDAY, Fight with Rey], [FRIDAY, Fall in love with Rey], [SATURDAY, Choose the light side], [SUNDAY, Tragically die]]}], pet=ROBOCAT{nickname='R2D2', age=20, trickLevel=99, habits=[hack computer systems, repair starships]}}", family.toString());
    }

    @Test
    public void addChildReturnsArrayWithAddedChild() throws Exception {
        Human mum = new Human("Leia", "Organa", 1977, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "diplomatic mission"}, {DayOfWeek.TUESDAY.name(), "To be captured by Darth Vader"}, {DayOfWeek.WEDNESDAY.name(), "To be rescued"}, {DayOfWeek.THURSDAY.name(), "Fight with Empire"}, {DayOfWeek.FRIDAY.name(), "Fall in love with Solo"}, {DayOfWeek.SATURDAY.name(), "plan an attack on the death star"}, {DayOfWeek.SUNDAY.name(), "celebrate victory"}});
        Human dad = new Human("Han", "Solo", 1977);
        Family family = new Family(mum, dad);
        Human son = new Human("Ben", "Solo", 2007, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "Сonquer the galaxy"}, {DayOfWeek.TUESDAY.name(), "Fight jedi"}, {DayOfWeek.WEDNESDAY.name(), "Kill the dark lord"}, {DayOfWeek.THURSDAY.name(), "Fight with Rey"}, {DayOfWeek.FRIDAY.name(), "Fall in love with Rey"}, {DayOfWeek.SATURDAY.name(), "Choose the light side"}, {DayOfWeek.SUNDAY.name(), "Tragically die"}});
        family.addChild(son);
        Assert.assertEquals("Is children length extends by 1", 1, family.getChildren().length );
        Assert.assertArrayEquals(new Human[]{son}, family.getChildren());
    }

    @Test
    public void deleteChildFromFamilyReturnsTrue() throws Exception {
        Human mum = new Human("Leia", "Organa", 1977, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "diplomatic mission"}, {DayOfWeek.TUESDAY.name(), "To be captured by Darth Vader"}, {DayOfWeek.WEDNESDAY.name(), "To be rescued"}, {DayOfWeek.THURSDAY.name(), "Fight with Empire"}, {DayOfWeek.FRIDAY.name(), "Fall in love with Solo"}, {DayOfWeek.SATURDAY.name(), "plan an attack on the death star"}, {DayOfWeek.SUNDAY.name(), "celebrate victory"}});
        Human dad = new Human("Han", "Solo", 1977);
        Family family = new Family(mum, dad);
        Human son = new Human("Ben", "Solo", 2007, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "Сonquer the galaxy"}, {DayOfWeek.TUESDAY.name(), "Fight jedi"}, {DayOfWeek.WEDNESDAY.name(), "Kill the dark lord"}, {DayOfWeek.THURSDAY.name(), "Fight with Rey"}, {DayOfWeek.FRIDAY.name(), "Fall in love with Rey"}, {DayOfWeek.SATURDAY.name(), "Choose the light side"}, {DayOfWeek.SUNDAY.name(), "Tragically die"}});
        family.addChild(son);
        Assert.assertTrue(family.deleteChild(son));
    }

    @Test
    public void deleteNotChildFromFamilyReturnsFalse() throws Exception {
        Human mum = new Human("Leia", "Organa", 1977, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "diplomatic mission"}, {DayOfWeek.TUESDAY.name(), "To be captured by Darth Vader"}, {DayOfWeek.WEDNESDAY.name(), "To be rescued"}, {DayOfWeek.THURSDAY.name(), "Fight with Empire"}, {DayOfWeek.FRIDAY.name(), "Fall in love with Solo"}, {DayOfWeek.SATURDAY.name(), "plan an attack on the death star"}, {DayOfWeek.SUNDAY.name(), "celebrate victory"}});
        Human dad = new Human("Han", "Solo", 1977);
        Family family = new Family(mum, dad);
        Human uncle = new Human("Luke", "Skywalker", 1977, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "buy R2D2"}, {DayOfWeek.TUESDAY.name(), "start learning force"}, {DayOfWeek.WEDNESDAY.name(), "get on the millennium falcon"}, {DayOfWeek.THURSDAY.name(), "to rescue Leia"}, {DayOfWeek.FRIDAY.name(), "Find Yoda"}, {DayOfWeek.SATURDAY.name(), "plan an attack on the death star"}, {DayOfWeek.SUNDAY.name(), "blow up the death star"}});
        Assert.assertFalse(family.deleteChild(uncle));
    }

    @Test
    public void countFamilyReturnsCountOfFamilyMembers() throws Exception {
        Human mum = new Human("Leia", "Organa", 1977, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "diplomatic mission"}, {DayOfWeek.TUESDAY.name(), "To be captured by Darth Vader"}, {DayOfWeek.WEDNESDAY.name(), "To be rescued"}, {DayOfWeek.THURSDAY.name(), "Fight with Empire"}, {DayOfWeek.FRIDAY.name(), "Fall in love with Solo"}, {DayOfWeek.SATURDAY.name(), "plan an attack on the death star"}, {DayOfWeek.SUNDAY.name(), "celebrate victory"}});
        Human dad = new Human("Han", "Solo", 1977);
        Family family = new Family(mum, dad);
        Human son = new Human("Ben", "Solo", 2007, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "Сonquer the galaxy"}, {DayOfWeek.TUESDAY.name(), "Fight jedi"}, {DayOfWeek.WEDNESDAY.name(), "Kill the dark lord"}, {DayOfWeek.THURSDAY.name(), "Fight with Rey"}, {DayOfWeek.FRIDAY.name(), "Fall in love with Rey"}, {DayOfWeek.SATURDAY.name(), "Choose the light side"}, {DayOfWeek.SUNDAY.name(), "Tragically die"}});
        family.addChild(son);
        Assert.assertEquals(3, family.countFamily());
    }

}