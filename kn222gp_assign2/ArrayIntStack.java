package kn222gp_assign2;

import da1031.AbstractIntCollection;
import da1031.IntStack;

public class ArrayIntStack extends AbstractIntCollection implements IntStack{

	@Override
	public void push(int n) {
		if(size() == values.length) {
			resize();
		}
		int startAt = values[0];
		values[0] = n;
		for(int i = 0; i < size(); i++) {
			int temp = values[i+1];
			values[i+1] = startAt;
			startAt = temp;
		}
		size++;
	}

	@Override
	public int pop() throws IndexOutOfBoundsException {
		int toBeReturned = values[0];
		for(int i = 0; i < size(); i++) {
			values[i] = values[i+1];
		}
		size--;
		return toBeReturned;
	}

	@Override
	public int peek() throws IndexOutOfBoundsException {
		if(size() != 0) {
			return values[0];
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}

}
