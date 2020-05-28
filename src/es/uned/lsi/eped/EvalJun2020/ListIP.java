package es.uned.lsi.eped.EvalJun2020;

public class ListIP<E> extends SequenceDL<E> implements ListIPIF<E> {

	private int posicion=1;

	/* Constructor por defecto: crea una lista vacía */
	public ListIP() {
		super();
		new NodeSequence();
	}

	/*
	 * Constructor por copia: delega en el constructor por copia * de la secuencia
	 */
	public ListIP(ListIP<E> s) {
		super(s);
	}

	/* Devuelve la posición actual del puntero entre 1 y size()+1 */
	public int getPointer() {
	
		return posicion;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	/*
	 * Mueve el puntero a la siguiente posición de la lista
	 * 
	 * @Pre: 1 <= getPointer() <= size()
	 * 
	 * @Post: 1 < getPointer() <= size()+1
	 */
	public void moveNext() {
		if (1 <= getPointer() && getPointer() <= size()) {
			posicion = posicion + 1;
		}

	}

	/*
	 * Mueve el puntero a la posición anterior de la lista
	 * 
	 * @Pre: 1 < getPointer() <= size()+1
	 * 
	 * @Post: 1 <= getPointer() < size()
	 */
	public void movePrev() {
		if (1 < getPointer() && getPointer() <= (size() + 1)) {
			posicion = posicion - 1;
		}
	}

	/*
	 * Mueve el puntero a una posición determinada
	 * 
	 * @param posición a la que se mueve el puntero
	 * 
	 * @Pre: 1 <= pos <= size()+1
	 * 
	 * @Post: getPointer() = pos
	 */
	public void moveTo(int pos) {
		if (1 <= pos && pos <= (size() + 1)) {
			posicion = pos;
		}

	}

	/*
	 * Inserta un elemento en la posición actual del puntero
	 * 
	 * @param elem Elemento a añadir
	 * 
	 * @Pre: 1 <= getPointer() <= size()+1
	 * 
	 * @Post: getElem() = elem
	 */
	public void insert(E elem) {
		if (1 <= getPointer() && getPointer() <= (size() + 1)) {
			NodeSequence newNode = new NodeSequence(elem);
			if (getPointer() == 1) {
				newNode.setNext(this.firstNode);
				this.firstNode = newNode;
			} else {
				NodeSequence previousNode = getNode(getPointer() - 1);
				NodeSequence nextNode = previousNode.getNext();
				newNode.setPre(previousNode);
				previousNode.setNext(newNode);
				newNode.setNext(nextNode);
			}
			this.size++;
		}

	}

	/*
	 * Elimina el elemento de la posición actual del puntero
	 * 
	 * @Pre 1 <= getPointer() <= size()
	 */
	public void remove() {
		if (1 <= getPointer() && getPointer() <= size()) {

			if (getPointer() == 1) {
				this.firstNode = this.firstNode.getNext();
			} else {
				NodeSequence previousNode = getNode(getPointer() - 1);
				NodeSequence nextNode = previousNode.getNext().getNext();
				previousNode.setNext(nextNode);
				previousNode.setPre(getNode(getPointer() - 1));
			}
			this.size--;

		}
	}

	/*
	 * Devuelve el valor del elemento en la posición del puntero
	 * 
	 * @Pre: 1 <= getPointer() <= size()
	 */
	public E getElem() {
		NodeSequence node = getNode(getPointer());
		return node.getValue();
	}

	/*
	 * Modifica el valor del elemento que está en la posición actual del puntero
	 * 
	 * @param elem el valor que debe adoptar el elemento de la posicion del puntero
	 * 
	 * @Pre: 1 <= getPointer() <= size()
	 * 
	 * @Post: getElem() = elem
	 */
	public void setElem(E elem) {
		if (1 <= getPointer() && getPointer() <= size()) {
			NodeSequence node = getNode(getPointer());
			node.setValue(elem);
		}
	}

}
