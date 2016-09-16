package kn222gp_assign2.exercise3;

import kn222gp_assign2.ArrayIntList;
import kn222gp_assign2.ArrayIntStack;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class CollectionTest {
	private static int _testNumber;
	
	@Before
	public void start() {
		_testNumber++;
		System.out.println("Test number: " + _testNumber);
	}
	
	@After
	public void end() {
		System.out.println("Test " + _testNumber + " complete!");
	}
	
	@Test
	public void testAdd() {
		// Creating a list with 20 slots
		ArrayIntList list = buildList(20);
		
		// Testing to add the value 25 at the end of the list.
		list.add(25);
		assertTrue(condition);
	}
	
	public ArrayIntList buildList(int n) {
		ArrayIntList list = new ArrayIntList();
		
		for(int i = 0; i < n; i++) {
			list.add(i);
		}
		
		return list;
	}

}
