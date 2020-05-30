package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.StackIF;

public class StackDeque<E> implements StackIF<E> {
	private DequeIF<E> bicola = new Deque<E>();
	
	public StackDeque() {
		super();
//		DequeIF<E> bicola = new Deque<E>();
	}

	public IteratorIF<E> iterator() {
	
		return bicola.iterator();
	}


	public int size() {
	
		return bicola.size();
	}

	
	public boolean isEmpty() {
	
		return bicola.isEmpty();
	}

	
	public boolean contains(E e) {
		
		return bicola.contains(e);
	}

	
	public void clear() {
	
		bicola.clear();
	}

	/* Devuelve el elemento en la cima de la pila */
	public E getTop() {
		
		return bicola.getFront();
	}

	/* Añade un nuevo elemento a la cima de la pila */
	public void push(E elem) {
		bicola.insertFront(elem);

	}

	/* Elimina el elemento situado en la cima de la pila */
	public void pop() {
		bicola.removeFront();

	}

}
