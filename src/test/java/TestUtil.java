import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.RandomAccessFile;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void testComputeSingleArgument() {
     assertFalse(c.compute(6));
  }

  @Test
  public void testComputeEvenNumberOfArguments() {
     assertFalse(c.compute(2,3,4,5));
  }

  @Test(expected = RuntimeException.class)
  public void testComputeZeroArgument() {
      c.compute(0,1,2);

  }

  @Test
  public void testCompute() {
     assertTrue(c.compute(1,2,3));
  }

  @Test
  public void testComputeDivisableLastArgument() {
     assertTrue(c.compute(7,4,3));
  }

  @Test
  public void testComputeNoDivisable() {
     assertFalse(c.compute(7,6,3));
  }
}