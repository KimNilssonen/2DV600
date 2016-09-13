package kn222gp_assign2;

import da1031.AbstractIntCollection;
import da1031.IntList;

public class ArrayIntList extends AbstractIntCollection implements IntList {

	@Override
	public void add(int n) {
		if(size() == values.length) {
			resize();
		}
		values[size()] = n;
		size++;
	}

	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if(checkIndex(index, size())) {
			// Using temporary files to iterate through the array.
			int temp;
			int valueToBeChanged = values[index];
			values[index] = n;

			if(size() == values.length) {
				resize();
			}

			for(int i = 0; i < size(); i++) {
				temp = values[index+1];
				values[index+1] = valueToBeChanged;
				valueToBeChanged = temp;
			}
			size++;
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		if(checkIndex(index, size())) {
			for(int i = 0; i < index; i++) {
				values[index] = values[index+1];
			}
			size--;
		}
		else {
			throw new IndexOutOfBoundsException();
		}

	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();		
		}
		return values[index];
	}

	@Override
	public int indexOf(int n) {
		for(int i = 0; i < size(); i++) {
			if(values[i] == n){
				return i;
			}
		}
		return -1;
	}

}
