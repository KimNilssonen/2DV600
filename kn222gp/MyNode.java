package kn222gp;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import graphs.*;

public class MyNode<E> extends Node<E>{
	private Set<Node<E>> _preds = new HashSet<>();
	private Set<Node<E>> _succs = new HashSet<>();
	
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
		return _succs.iterator();
	}

	@Override
	public boolean hasPred(Node<E> node) {
		return _preds.contains(node);
	}

	@Override
	public int inDegree() {
		return _preds.size();
	}

	@Override
	public Iterator<Node<E>> predsOf() {
		return _preds.iterator();
	}

	@Override
	protected void addSucc(Node<E> succ) {
		_succs.add(succ);
	}

	@Override
	protected void removeSucc(Node<E> succ) {
		_succs.remove(succ);
	}

	@Override
	protected void addPred(Node<E> pred) {
		_preds.add(pred);		
	}

	@Override
	protected void removePred(Node<E> pred) {
		_preds.remove(pred);
	}

	@Override
	protected void disconnect() {	
		_succs.clear();
		_preds.clear();
	}
}
