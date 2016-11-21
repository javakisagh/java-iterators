package pl.edu.agh.kis.datastructures;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.google.common.collect.Iterables;

public class BinaryTreeTest {

	@Test
	public void emptyTreeDefaultIterator() {
		// setup:
		BinaryTree t = BinaryTree.fromList();

		// expect:
		for (Object o : t) {
			fail("there should be no elements to iterate in empty tree");
		}
	}

	@Test
	public void emptyTreePreOrderIterator() {
		// setup:
		BinaryTree t = BinaryTree.fromList();

		// expect:
		for (Object o : t.preOrder()) {
			fail("there should be no elements to iterate in empty tree");
		}
	}

	@Test
	public void emptyTreeInOrderIterator() {
		// setup:
		BinaryTree t = BinaryTree.fromList();

		// expect:
		for (Object o : t.inOrder()) {
			fail("there should be no elements to iterate in empty tree");
		}
	}

	@Test
	public void emptyTreePostOrderIterator() {
		// setup:
		BinaryTree t = BinaryTree.fromList();

		// expect:
		for (Object o : t.postOrder()) {
			fail("there should be no elements to iterate in empty tree");
		}
	}

	@Test
	public void singletonTreeDefaultIterator() {
		// setup:
		BinaryTree t = BinaryTree.fromList("singleton");
		int numberOfIterations = 0;

		// expect:
		for (Object o : t) {
			assertEquals("singleton", o.toString());
			numberOfIterations++;
		}
		assertEquals(1, numberOfIterations);
	}

	@Test
	public void singletonTreePreOrderIterator() {
		// setup:
		BinaryTree t = BinaryTree.fromList("singleton");
		int numberOfIterations = 0;

		// expect:
		for (Object o : t) {
			assertEquals("singleton", o.toString());
			numberOfIterations++;
		}
		assertEquals(1, numberOfIterations);
	}

	@Test
	public void singletonTreeInOrderIterator() {
		// setup:
		BinaryTree t = BinaryTree.fromList("singleton");
		int numberOfIterations = 0;

		// expect:
		for (Object o : t) {
			assertEquals("singleton", o.toString());
			numberOfIterations++;
		}
		assertEquals(1, numberOfIterations);
	}

	@Test
	public void singletonTreePostOrderIterator() {
		// setup:
		BinaryTree t = BinaryTree.fromList("singleton");
		int numberOfIterations = 0;

		// expect:
		for (Object o : t) {
			assertEquals("singleton", o.toString());
			numberOfIterations++;
		}
		assertEquals(1, numberOfIterations);
	}

	@Test
	public void balancedTreeWith3ElementsDefaultIterator() {
		// setup:
		Object[] elements = new Object[] { "first", "second", "third" };
		BinaryTree t = BinaryTree.fromList("first", "second", null, null, "third");

		// when:
		Object[] result = Iterables.toArray(t, Object.class);
		// then:
		assertArrayEquals(elements, result);
		assertEquals(elements.length, result.length);
	}

	@Test
	public void balancedTreeWith3ElementsPreOrderIterator() {
		// setup:
		Object[] elements = new Object[] { "second", "first", "third" };
		BinaryTree t = BinaryTree.fromList("first", "second", null, null, "third");

		// when:
		Object[] result = Iterables.toArray(t.preOrder(), Object.class);
		// then:
		assertArrayEquals(elements, result);
		assertEquals(elements.length, result.length);
	}

	@Test
	public void balancedTreeWith3ElementsInOrderIterator() {
		// setup:
		Object[] elements = new Object[] { "first", "second", "third" };
		BinaryTree t = BinaryTree.fromList("first", "second", null, null, "third");

		// when:
		Object[] result = Iterables.toArray(t.inOrder(), Object.class);
		// then:
		assertArrayEquals(elements, result);
		assertEquals(elements.length, result.length);
	}

	@Test
	public void balancedTreeWith3ElementsPostOrderIterator() {
		// setup:
		Object[] elements = new Object[] { "second", "third", "first" };
		BinaryTree t = BinaryTree.fromList("first", "second", null, null, "third");

		// when:
		Object[] result = Iterables.toArray(t.postOrder(), Object.class);
		// then:
		assertArrayEquals(elements, result);
		assertEquals(elements.length, result.length);
	}

	// the following 7 elements tree is tested:
	// l1.1
	// l2.1 l2.2
	// null l3.2 l3.3 l3.4
	// null null null l4.6 null null
	// null null
	@Test
	public void balancedTreeWith7ElementsDefaultIterator() {
		// setup:
		Object[] elements = new Object[] { "l1.1", "l2.1", "l3.2", "l2.2", "l3.3", "l4.6", "l3.4" };
		BinaryTree t = BinaryTree.fromList("l1.1", "l2.1", null, "l3.2", null, null, "l2.2", "l3.3", null, "l4.6", null,
				null, "l3.4");

		// when:
		Object[] result = Iterables.toArray(t, Object.class);
		// then:
		assertArrayEquals(elements, result);
		assertEquals(elements.length, result.length);
	}

	@Test
	public void balancedTreeWith7ElementsPreOrderIterator() {
		// setup:
		Object[] elements = new Object[] { "l2.1", "l3.2", "l1.1", "l3.3", "l4.6", "l2.2", "l3.4" };
		BinaryTree t = BinaryTree.fromList("l1.1", "l2.1", null, "l3.2", null, null, "l2.2", "l3.3", null, "l4.6", null,
				null, "l3.4");

		// when:
		Object[] result = Iterables.toArray(t.preOrder(), Object.class);
		// then:
		assertArrayEquals(elements, result);
		assertEquals(elements.length, result.length);
	}

	@Test
	public void balancedTreeWith7ElementsInOrderIterator() {
		// setup:
		Object[] elements = new Object[] { "l1.1", "l2.1", "l3.2", "l2.2", "l3.3", "l4.6", "l3.4" };
		BinaryTree t = BinaryTree.fromList("l1.1", "l2.1", null, "l3.2", null, null, "l2.2", "l3.3", null, "l4.6", null,
				null, "l3.4");

		// when:
		Object[] result = Iterables.toArray(t.inOrder(), Object.class);
		// then:
		assertArrayEquals(elements, result);
		assertEquals(elements.length, result.length);
	}

	@Test
	public void balancedTreeWith7ElementsPostOrderIterator() {
		// setup:
		Object[] elements = new Object[] { "l3.2", "l2.1", "l4.6", "l3.3", "l3.4", "l2.2", "l1.1" };
		BinaryTree t = BinaryTree.fromList("l1.1", "l2.1", null, "l3.2", null, null, "l2.2", "l3.3", null, "l4.6", null,
				null, "l3.4");

		// when:
		Object[] result = Iterables.toArray(t.postOrder(), Object.class);
		// then:
		assertArrayEquals(elements, result);
		assertEquals(elements.length, result.length);
	}
}
