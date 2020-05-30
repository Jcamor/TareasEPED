package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.QueueIF;

public class QueueDeque<E> implements QueueIF<E> {
	private DequeIF<E> bicola = new Deque<E>();

	public QueueDeque() {
		super();
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

	/* Vacía la cola */
	public void clear() {
		bicola.clear();
	}


	/* Devuelve el primer elemento de la cola */
	public E getFirst() {
		return bicola.getFront();
	}

	/* Añade un nuevo elemento al final de la cola */
	public void enqueue(E elem) {
		bicola.insertBack(elem);
	}

	/* Elimina el primer elemento de la cola */
	public void dequeue() {
		bicola.removeFront();

	}

}
