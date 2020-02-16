import enums.DayOfWeek;
import human.Human;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class HumanTest {
    @Test
    public void toStringReturnsHuman() throws Exception {
        Human human = new Human("Leia", "Organa", 1977, (byte) 99);
        SortedMap<Integer, String> schedule = new TreeMap<>();
        schedule.put(DayOfWeek.MONDAY.ordinal(), "diplomatic mission");
        schedule.put(DayOfWeek.TUESDAY.ordinal(), "To be captured by Darth Vader");
        schedule.put(DayOfWeek.WEDNESDAY.ordinal(), "To be rescued");
        schedule.put(DayOfWeek.THURSDAY.ordinal(), "Fight with Empire");
        schedule.put(DayOfWeek.FRIDAY.ordinal(), "Fall in love with Solo");
        schedule.put(DayOfWeek.SATURDAY.ordinal(), "plan an attack on the death star");
        schedule.put(DayOfWeek.SUNDAY.ordinal(), "celebrate victory");
        human.setSchedule(schedule);
        Assert.assertEquals("human.Human{name='Leia', surname='Organa', year=1977, iq=99, schedule=[[MONDAY, diplomatic mission], [TUESDAY, To be captured by Darth Vader], [WEDNESDAY, To be rescued], [THURSDAY, Fight with Empire], [FRIDAY, Fall in love with Solo], [SATURDAY, plan an attack on the death star], [SUNDAY, celebrate victory]]}", human.toString());
    }
}