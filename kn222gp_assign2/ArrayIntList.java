package kn222gp_assign2;

import da1031.AbstractIntCollection;
import da1031.IntList;

public class ArrayIntList extends AbstractIntCollection implements IntList {

	// Adds a new integer at the end of the array. 
	@Override
	public void add(int n) {
		values[size()] = n;
		size++;
		if(size() == values.length) {
			resize();
		}
	}

	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if(checkIndex(index, size())) {
			if(size() == values.length) {
				resize();
			}
			// Using temporary files to iterate through the array.
			int startAt = values[index];
			values[index] = n;
			for(int i = index; i < size(); i++) {
				int temp = values[i+1];
				values[i+1] = startAt;
				startAt = temp;
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
			for(int i = index; i < size; i++) {
				values[i] = values[i+1];
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

	// Check if the value at position "i" equals the value "n". If it does, return i.
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
