package pl.edu.agh.kis.datastructures;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class Array2dTest {

	@Test
	public void singletonArrayIteratedRowLike() {
		// setup:
		Array2d m = Array2d.fromList(Arrays.asList("singleton"), 1, 1);
		int numberOfIterations = 0;

		// expect:
		for (Object o : m.rowLike()) {
			assertEquals("singleton", o.toString());
			numberOfIterations++;
		}
		assertEquals(1, numberOfIterations);
	}

	@Test
	public void singletonArrayIteratedColumnLike() {
		// setup:
		Array2d m = Array2d.fromList(Arrays.asList("singleton"), 1, 1);
		int numberOfIterations = 0;

		// expect:
		for (Object o : m.columnLike()) {
			assertEquals("singleton", o.toString());
			numberOfIterations++;
		}
		assertEquals(1, numberOfIterations);
	}

	@Test
	public void size2x3ArrayIteratedRowLike() {
		// setup:
		Object[] elements = new Object[] { 1, 2, 3, 4, 5, 6 };
		Array2d m = Array2d.fromList(Arrays.asList(elements), 2, 3);
		int numberOfIterations = 0;

		// expect:
		for (Object o : m.rowLike()) {
			assertEquals(elements[numberOfIterations], o);
			numberOfIterations++;
		}
		assertEquals(6, numberOfIterations);
	}

	@Test
	public void size2x3ArrayIteratedColumnLike() {
		// setup:
		Object[] elements = new Object[] { 1, 3, 5, 2, 4, 6 };
		Array2d m = Array2d.fromList(Arrays.asList(1, 2, 3, 4, 5, 6), 2, 3);
		int numberOfIterations = 0;

		// expect:
		for (Object o : m.columnLike()) {
			assertEquals(elements[numberOfIterations], o);
			numberOfIterations++;
		}
		assertEquals(6, numberOfIterations);
	}
}
