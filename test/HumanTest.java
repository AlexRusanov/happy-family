import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HumanTest {
    @Test
    public void toStringReturnsHuman() throws Exception {
        Human human = new Human("Leia", "Organa", 1977, (byte) 99, new String[][]{{DayOfWeek.MONDAY.name(), "diplomatic mission"}, {DayOfWeek.TUESDAY.name(), "To be captured by Darth Vader"}, {DayOfWeek.WEDNESDAY.name(), "To be rescued"}, {DayOfWeek.THURSDAY.name(), "Fight with Empire"}, {DayOfWeek.FRIDAY.name(), "Fall in love with Solo"}, {DayOfWeek.SATURDAY.name(), "plan an attack on the death star"}, {DayOfWeek.SUNDAY.name(), "celebrate victory"}});
        Assert.assertEquals("Human{name='Leia', surname='Organa', year=1977, iq=99, schedule=[[MONDAY, diplomatic mission], [TUESDAY, To be captured by Darth Vader], [WEDNESDAY, To be rescued], [THURSDAY, Fight with Empire], [FRIDAY, Fall in love with Solo], [SATURDAY, plan an attack on the death star], [SUNDAY, celebrate victory]]}", human.toString());
    }
}