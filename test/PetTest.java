import org.junit.Assert;
import org.junit.Test;
import pet.RoboCat;

import java.util.HashSet;
import java.util.Set;

public class PetTest {
    @Test
    public void toStringReturnsPet() throws Exception {
        Set<String> habbits = new HashSet<>();
        habbits.add("repair starships");
        habbits.add("hack computer systems");
        RoboCat r2d2 = new RoboCat("R2D2", 20, (byte) 99, habbits);
        Assert.assertEquals("ROBOCAT{nickname='R2D2', age=20, trickLevel=99, habits=[repair starships, hack computer systems]}", r2d2.toString());
    }

}