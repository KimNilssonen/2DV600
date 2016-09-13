package kn222gp_assign2;

import da1031.AbstractIntCollection;
import da1031.IntStack;

public class ArrayIntStack extends AbstractIntCollection implements IntStack{

	@Override
	public void push(int n) {
		if(size() == values.length) {
			resize();
		}
		int temp;
		int valueToBeChanged = values[0];
		values[0] = n;

		if(size() == values.length) {
			resize();
		}

		for(int i = 0; i < size(); i++) {
			temp = values[0+1];
			values[0+1] = valueToBeChanged;
			valueToBeChanged = temp;
		}
		size++;
	}

	@Override
	public int pop() throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return 0;
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
