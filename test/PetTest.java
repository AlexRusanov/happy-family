import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PetTest {
    @Test
    public void toStringReturnsPet() throws Exception {
        RoboCat r2d2 = new RoboCat("R2D2", 20, (byte) 99, new String[]{"hack computer systems", "repair starships"});
        Assert.assertEquals("ROBOCAT{nickname='R2D2', age=20, trickLevel=99, habits=[hack computer systems, repair starships]}", r2d2.toString());
    }

}