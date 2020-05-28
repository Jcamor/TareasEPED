package es.uned.lsi.eped.EvalJun2020;

public class Deque<E> extends SequenceDL<E> implements DequeIF<E> {

	private NodeSequence lastNode;

	public E getFront() {

		return this.firstNode.getValue();
	}

	public E getBack() {
		return this.lastNode.getValue();
	}

	public void insertFront(E e) {
		NodeSequence newNode = new NodeSequence(e);
		NodeSequence auxNode = new NodeSequence(e);

		if (firstNode == null) {
			this.firstNode = newNode;
		} else {
			auxNode = firstNode;
			this.firstNode = newNode;
			this.firstNode.setNext(auxNode);
		}

		this.size++;
	}

	public void insertBack(E e) {
		NodeSequence newNode = new NodeSequence(e);
		NodeSequence auxNode = new NodeSequence();

		if (isEmpty()) {
			this.firstNode = newNode;
		} else {
			auxNode = this.lastNode;
			this.lastNode = newNode;
			auxNode.setNext(lastNode);
			this.lastNode.setPre(auxNode);
		}
		this.lastNode = newNode;
		this.size++;

	}

	public void removeFront() {
		this.firstNode = this.firstNode.getNext();
		this.size--;
		if (this.size == 0) {
			this.lastNode = null;
		}
	}

	public void removeBack() {
		NodeSequence auxNode = new NodeSequence();

		auxNode = this.lastNode.getPre();
		auxNode.setNext(null);
		this.lastNode = auxNode;

		this.size--;
		if (this.size == 0) {
			this.lastNode = null;
		}
	}

}
