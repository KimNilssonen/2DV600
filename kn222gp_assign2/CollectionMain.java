package kn222gp_assign2;

public class CollectionMain {

	public static void main(String[] args) {
		
		// Testing ArrayIntList
		ArrayIntList list = new ArrayIntList();
		
		list.add(1); // index 0
		list.add(2); // index 1
		list.add(3); // index 2
		System.out.println("Testing ArrayIntList\nSize: " + list.size());
		
		list.addAt(10, 2);
		System.out.println("Size: " + list.size());
		System.out.println("\nList index 0: " + list.get(0));
		System.out.println("List index 1: " + list.get(1));
		System.out.println("List index 2: " + list.get(2));
		System.out.println("List index 3: " + list.get(3));
		list.addAt(5, 1);
		System.out.println("\nList index 1: " + list.get(1));
		
		list.remove(2);
		System.out.println("\nList index 0: " + list.get(0));
		System.out.println("List index 1: " + list.get(1));
		System.out.println("List index 2: " + list.get(2));
		
		System.out.println("\nIndex of 1: : " + list.indexOf(1));
		

		// Testing ArrayIntStack
		ArrayIntStack stack = new ArrayIntStack();
		
		stack.push(5);
		System.out.println("\nPeeking at top: " + stack.peek());
		stack.push(4);		
		System.out.println("\nPeeking at top: " + stack.peek());
		System.out.println("\n-----------------------------------------\nTesting ArrayIntStack\nSize: " + stack.size());
		System.out.println(stack.toString());
		
	}

}
