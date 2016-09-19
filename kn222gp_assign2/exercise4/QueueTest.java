package kn222gp_assign2.exercise4;

import static org.junit.Assert.*;

import javax.lang.model.element.Element;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {
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
	
	@Test
	/* 
	 * Test 1
	 */
	public void testEnqueue() {
		Queue queue = buildQueue(10);
		Queue queue2 = buildQueue(100000);
		
		// Testing if queue is empty.
		assertFalse(queue.isEmpty());
		assertFalse(queue2.isEmpty());
	}
	
	@Test
	/*
	 * Test 2
	 */
	public void testDequeue() {
		Queue queue = buildQueue(10);
		Queue queue2 = buildQueue(100000);
		
		// Testing if queue is equal to 10,
		 // and queue2 is equal to 100000.
		assertEquals(10, queue.size());
		assertEquals(100000, queue2.size());
		
		// Dequeuing
		assertEquals(queue.first(), queue.dequeue());
		assertEquals(queue2.first(), queue2.dequeue());
		
		// Testing if queue is equal to 9 after dequeue.
		assertEquals(9, queue.size());
		assertEquals(99999, queue2.size());
		
		// Dequeue big queue.
		for(int i = 0; i < 99999; i++) {
			queue2.dequeue();
		}
		assertTrue(queue2.isEmpty());
		
		// Testing to dequeue an empty queue. Expect IndexOutOfBounds.
		try {
			Queue emptyQueue = buildQueue(0);
			emptyQueue.dequeue();
		}
		catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	@Test
	/*
	 * Test 3
	 */
	public void testFirst() {
		
		// Testing first on empty queue. Expect IndexOutOfBounds.
		try {
			Queue queue = buildQueue(0);
			queue.first();
		}
		catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
		
		// Testing first on queue of five integers. Expect 0.
		Queue queue = buildQueue(5);
		assertEquals(queue.first(), queue.dequeue());
		
		// Testing first on a big queue. Expect 0.
		Queue queue2 = buildQueue(100000);
		assertEquals(queue2.first(), queue2.dequeue());
		
		// Testing first on a big queue after the queue has been emptied. Expect IndexOutOfBounds.
		try {
			for(int i = 0; i < 99999; i++) {
				queue2.dequeue();
			}
			queue2.first();
		} 
		catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	@Test
	/*
	 * Test 4
	 */
	public void testLast() {
		Queue queue = buildQueue(10);
		Queue queue2 = buildQueue(100000);
		Queue emptyQueue = buildQueue(0);
		
		// Testing last() on queue. Expect 9.
		assertEquals(queue.size()-1, queue.last());
		
		// Testing last() on queue2. Expect 99999.
		assertEquals(queue2.size()-1, queue2.last());
		
		// Testing last() on emptyQueue. Expect IndexOutOfBounds.
		try {
			emptyQueue.last();
		}
		catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	@Test
	/*
	 * Test 5
	 */
	public void testSize() {
		Queue queue = buildQueue(5);
		Queue queue2 = buildQueue(100000);
		Queue negativeQueue = buildQueue(-1);
		
		// Testing size() on queue. Expect 5.
		assertEquals(5, queue.size());
		
		// Testing size() on queue2. Expect 100000.
		assertEquals(100000, queue2.size());
		
		// Testing size() on negativeQueue. Expect 0.
		assertEquals(0, negativeQueue.size());
		
	}
	
	@Test
	/*
	 * Test 6
	 */
	public void testIsEmpty() {
		Queue queue = buildQueue(5);
		Queue queue2 = buildQueue(100000);
		Queue emptyQueue = buildQueue(0);
		
		// Testing isEmpty() on queue. Expect false.
		assertFalse(queue.isEmpty());
		
		// Testing isEmpty() on queue2. Expect false.
		assertFalse(queue2.isEmpty());
		
		// Testing isEmpty() on emptyQueue. Expect true.
		assertTrue(emptyQueue.isEmpty());
		
	}
	
	public Queue buildQueue(int size) {
		Queue queue = new Queue<>();
		for(int i = 0; i < size; i++) {
			queue.enqueue(i);
		}
		return queue;
	}
}
