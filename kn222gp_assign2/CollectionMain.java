package kn222gp_assign2;

public class CollectionMain {

	public static void main(String[] args) {

		try {
			// Testing ArrayIntList
			System.out.println("Testing ArrayIntList\n");
			ArrayIntList list = new ArrayIntList();
			
			// add
			System.out.println("Adding values...");
			for(int i = 0; i < 10; i++) {
				list.add(i);
			}
			
			// size
			System.out.println("Size: " + list.size());
			System.out.println("Whole list: " + list.toString());
			System.out.println("Add 10 at index 2: ");

			// addAt
			list.addAt(10, 2);
			System.out.println("Whole list: " + list.toString());
			System.out.println("Add 5 at index 1: ");
			list.addAt(5, 1);
			System.out.println("Whole list: " + list.toString());

			// remove
			System.out.println("Removing at index 3: ");
			list.remove(3);
			
			// get
			System.out.println("\nList index 0: " + list.get(0));
			System.out.println("List index 1: " + list.get(1));
			System.out.println("List index 2: " + list.get(2));

			System.out.println("\nWhole list: " + list.toString());


			// Testing ArrayIntStack
			System.out.println("\n-----------------------------------------\nTesting ArrayIntStack\n");
			ArrayIntStack stack = new ArrayIntStack();

			// push
			System.out.println("Adding values...");
			for(int i = 0; i < 5; i++) {
				stack.push(i);
			}
			System.out.println("Whole stack: " + stack.toString());
			
			// peek
			System.out.println("Peeking at top: " + stack.peek());
			
			// size
			System.out.println("Size: " + stack.size());
			
			// pop
			System.out.println("Popping...");
			stack.pop();
			System.out.println("Whole stack: " + stack.toString());
			System.out.println("Peeking at top: " + stack.peek());
			System.out.println("Size: " + stack.size());
		}
		catch(IndexOutOfBoundsException e) {
			e.getMessage();
			System.out.println("Index is out of bounds!");
		}
	}

}
