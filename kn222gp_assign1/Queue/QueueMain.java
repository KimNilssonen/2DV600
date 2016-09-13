package kn222gp_assign1.Queue;

import java.util.Iterator;

public class QueueMain {

	public static void main(String[] args) {
		Queue queue = new Queue();
		int amountOfElements = 10;
		int testValue1 = 6;
		int testValue2 = 0;

		for(int i = 0; i < amountOfElements; i++) {
			queue.enqueue(i);
		}
		System.out.println("----------Queue----------\n");

		Iterator<Object> iterator = queue.iterator();
		System.out.println("\nValues in queue: ");
		while(iterator.hasNext()){
			System.out.print(iterator.next() + ", ");
		}
		System.out.println("\n--------------------");

		// Size
		System.out.println("\nSize of queue: " + queue.size());
		System.out.println("--------------------");

		// First
		try {
			System.out.println("\nFirst value in queue: " + queue.first());
			System.out.println("--------------------");
		}
		catch(Exception e){
			System.out.println("Error, Out of bounds! Exception was probably cast since queue is empty: " + e.getMessage());
		}

		// Last
		try {
			System.out.println("\nLast value in queue: " + queue.last());
			System.out.println("--------------------");
		}
		catch(Exception e){
			System.out.println("Error, Out of bounds! Exception was probably cast since queue is empty: " + e.getMessage());
		}

		// Dequeue
		try {
			System.out.println("\nTesting \"dequeue\"... \nResponse value: " + queue.dequeue());
			System.out.println("\nFirst value is now: " + queue.first());
			System.out.println("\nLast value is now: " + queue.last());
			System.out.println("--------------------");
		}
		catch(Exception e){
			System.out.println("Error, Out of bounds! Exception was probably cast since queue is empty: " + e.getMessage());
		}


		// Contains
		System.out.println("\nTesting \"contains\"... \n...with the value of '4' - Found object: " + queue.contains(testValue1));
		System.out.println("\n...with the value of '0' -  Found object: " + queue.contains(testValue2));
		System.out.println("--------------------");

		// Dequeue until empty queue
		System.out.println("\nTrying to \"dequeue\" until empty\n");
		while(!queue.isEmpty()){
			System.out.println("\nDequeue response (value): " + queue.dequeue());
			System.out.println("Queue size after dequeue: " + queue.size() );
		}

		// IsEmpty
		System.out.println("\nTesting \"isEmpty\"...\nAnswer (True/False): " + queue.isEmpty());
		
	}
}
