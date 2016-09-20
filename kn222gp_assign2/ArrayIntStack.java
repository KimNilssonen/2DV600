package kn222gp_assign2;

import da1031.AbstractIntCollection;
import da1031.IntStack;

public class ArrayIntStack extends AbstractIntCollection implements IntStack{

	@Override
	public void push(int n) {
		if(size() == values.length) {
			resize();
		}
		values[size++] = n;
	}

	@Override
	public int pop() throws IndexOutOfBoundsException {
		return values[--size];
	}

	@Override
	public int peek() throws IndexOutOfBoundsException {
		if(size() != 0) {
			return values[size-1];
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}

}
