package pl.edu.agh.kis.datastructures;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyListTest {
    @Test
    public void interateOverEmptyList() {
        MyList list = MyList.fromList();
        for (Object e : list) {
            fail("there should be no elements within list");
        }
    }

    @Test
    public void iterateOverListWithOnlyOneElement() {
      //setup:
        MyList list = MyList.fromList("str");
        int numberOfIterations = 0;

      //expect:
        for (Object e : list) {
            assertEquals("str",e.toString());
            numberOfIterations++;
        }
        assertEquals(1,numberOfIterations);
    }

    @Test void iterateOverListWithSeveralDifferentElements() {
        //setup:
        Object[] elements = new Object[] {"str","obj","wuk"};
        MyList list = MyList.fromList(elements);
        int numberOfIterations = 0;

      //expect:
        for (Object e : list) {
            assertEquals(elements[numberOfIterations],e.toString());
            numberOfIterations++;
        }
        assertEquals(3,numberOfIterations);
    }
}