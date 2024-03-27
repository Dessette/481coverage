import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;
  MessageQueue mq;

  @Test
  public void example() {
    mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }

  @Test
  public void testCountNumberOfOccurrences() {
        mq = mock(MessageQueue.class);
        c = new Compute(mq);
        String element = "test";
        int expectedOccurrences = 5;

        when(mq.size()).thenReturn(expectedOccurrences);
        when(mq.contains(element)).thenReturn(true);
        when(mq.getAt(anyInt())).thenReturn(element);

        int actualOccurrences = c.countNumberOfOccurrences(element);

        assertEquals(expectedOccurrences, actualOccurrences);

        verify(mq,times(expectedOccurrences + 2)).size();
        verify(mq).contains(element);
        verify(mq, times(expectedOccurrences)).getAt(anyInt());
  }

  @Test
  public void testCountNumberOfOccurrencesWithEmptyQueue() {
        mq = mock(MessageQueue.class);
        c = new Compute(mq);
        String element = "test";

        when(mq.size()).thenReturn(0);

        int actualOccurrences = c.countNumberOfOccurrences(element);

        assertEquals(-1, actualOccurrences);

        verify(mq).size();
        verify(mq,times(0)).contains(element);
  }

  @Test
  public void testCountNumberOfOccurrencesWithElementNotInQueue() {
        mq = mock(MessageQueue.class);
        c = new Compute(mq);
        String element = "test";

        when(mq.size()).thenReturn(3);
        when(mq.contains(any())).thenReturn(false);

        int actualOccurrences = c.countNumberOfOccurrences(element);

        assertEquals(0, actualOccurrences);

        verify(mq).size();
        verify(mq).contains(element);
    }
}