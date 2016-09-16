package kn222gp_assign2.exercise3;

import kn222gp_assign2.ArrayIntList;
import kn222gp_assign2.ArrayIntStack;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.internal.runners.TestMethod;

public class CollectionTest {
	private static int _testNumber;

	@Before
	public void start() {
		_testNumber++;
		System.out.println("Test number: " + _testNumber + "\n--------------------\n");
	}

	@After
	public void end() {
		System.out.println("--------------------\nTest " + _testNumber + " complete!\n\n");
	}

	/*
	 * Tests for ArrayIntList
	 */
	
	@Test
	/*
	 * Test 1
	 */
	public void testAdd() {
		// Creating lists with different sizes.
		ArrayIntList list = buildIntList(20);
		ArrayIntList list2 = buildIntList(10000);

		// Testing the list sizes.
		assertEquals(list.size(), 20);
		assertEquals(list2.size(), 10000);

		// Adding the value 25 at the end of each list.
		list.add(25);
		list2.add(25);

		// Testing the list sizes after add.
		assertEquals(list.size(), 21);
		assertEquals(list2.size(), 10001);

		// Testing if empty.
		assertFalse(list.isEmpty());
	}

	@Test
	/*
	 * Test 2
	 */
	public void testAddAt() {
		// Creating a list with a size of 10.
		ArrayIntList list = buildIntList(10);
		ArrayIntList list2 = buildIntList(10000);
		ArrayIntList list3 = buildIntList(0);

		// Adding a value of 5 at index 8.
		list.addAt(5, 8);
		assertEquals(11, list.size());

		// Adding a value of 40 at index 9800.
		list2.addAt(40, 9800);
		assertEquals(10001, list2.size());

		// Adding a value of 2 at index 5 on an empty list. Should fail.
		try {
			list3.addAt(2, 5);
		}
		catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	@Test
	/*
	 * Test 3
	 */
	public void testRemove() {
		ArrayIntList list = buildIntList(10);
		ArrayIntList list2 = buildIntList(10000);
		
		// Removing index 5 from list.
		list.remove(5);
		assertEquals(9, list.size());
		
		// Removing index 20 from list. Should fail.
		try{
			list.remove(20);
		}
		catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
		
		// Removing index 9999 from list2.
		list2.remove(200);
		assertEquals(9999, list2.size());
	}
	
	@Test
	/*
	 * Test 4
	 */
	public void testGet() {
		ArrayIntList list = buildIntList(10);
		ArrayIntList list2 = buildIntList(10000);
		
		// Get index 2 from list.
		list.get(2);
		assertTrue(list.get(2) == 2);
		
		// Get index 9000 from list.
		list2.get(9000);
		assertTrue(list2.get(9000) == 9000);
		
		try {
			list.get(-1);
		}
		catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	@Test
	/*
	 * Test 5
	 */
	public void testIndexOf() {
		ArrayIntList list = buildIntList(10);
		ArrayIntList list2 = buildIntList(10000);
		
		// Checking if index of 6's value is equals to 6.
		assertEquals(6, list.indexOf(6));
		
		// Checking if index of 5454's value is equals to 5454.
		assertEquals(5454, list2.indexOf(5454));
		
		// Expect to get response of -1 since there is not value of 25 in the list.
		assertEquals(-1, list.indexOf(25));		
	}
	
	/*
	 * Used to create lists to make the test procedure easier and less monotonously.
	 */
	public ArrayIntList buildIntList(int n) {
		ArrayIntList list = new ArrayIntList();

		for(int i = 0; i < n; i++) {
			list.add(i);
		}

		return list;
	}

	
	/*
	 * Tests for ArrayIntStack
	 */
	
	@Test
	/*
	 * Test 6
	 */
	public void testPush() {
		
	}
	
	/*
	 * Used to create lists to make the test procedure easier and less monotonously.
	 */
	public ArrayIntStack buildIntStack(int n) {
		ArrayIntStack stack = new ArrayIntStack();

		for(int i = 0; i < n; i++) {
			stack.push(i);
		}

		return stack;
	}
	
}
