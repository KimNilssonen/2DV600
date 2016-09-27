package kn222gp;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import graphs.*;

public class MyNode<E> extends Node<E>{
	private Set<Node<E>> _preds = new TreeSet<>();
	private Set<Node<E>> _succs = new TreeSet<>();
	
	protected MyNode(E item) {
		super(item);
		
	}

	@Override
	public boolean hasSucc(Node<E> node) {
		return _succs.contains(node);
	}

	@Override
	public int outDegree() {
		return _succs.size();
	}

	@Override
	public Iterator<Node<E>> succsOf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasPred(Node<E> node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int inDegree() {
		return _preds.size();
	}

	@Override
	public Iterator<Node<E>> predsOf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void addSucc(Node<E> succ) {
		_succs.add(succ);
	}

	@Override
	protected void removeSucc(Node<E> succ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addPred(Node<E> pred) {
		_preds.add(pred);		
	}

	@Override
	protected void removePred(Node<E> pred) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void disconnect() {
		// TODO Auto-generated method stub
		
	}

}
