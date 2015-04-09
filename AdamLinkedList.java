import java.util.List;

//should use all the methods in the List interface
//good example on how to implement an interface
//list interface: https://docs.oracle.com/javase/7/docs/api/java/util/List.html
public class AdamLinkedList<E> implements List<T> {
	
	private Node<E> head;	//first
	private Node<E> tail; 	//last
	private int size;

	public AdamLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setData(T data) {
			this.data = data;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
	}

	public int size() {
		return this.size;
	}

	public isEmpty() {
		return this.size() == 0;
	}

	public boolean add(E e) {
		if(this.isEmpty()) {
			head = new Node(e, null);
			tail = head;
		} else {
			tail.setNext(new Node(e, null));
			tail = getNext;
		}
		size++;
		return true;
	}

	public void add(int index, E element) {
		if(index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		} 

		if(index == size()) {
			this.add(element);
			return;
		}

		if(index == 0) {
			head = new Node(e, head);
		} else {
			//iterate to the index we want to add the element
			Node<E> current = head;
			for(int j = 0; j < i-1; j++) {
				current = current.getNext();
			}

			//current is now the node before the index
			current.setNext(new Node(e, current.getNext()));
		}

		size++;
	}

	public void clear() {
		//this works because the objects that are not referenced
		//will be deleted by the garbage collector
		head = null;
		tail = null;
		size = 0;
	}

	public E get(int i) {
		if(i < 0 || i >= size()) {
			throw new IndexOutOfBoundsException();
		}

		if(i < size() - 1 ) {
			Node<E> current = head;
			for(int j = 0; j < i; j++) {
				current = current.getNext();
			}
			return current.getData();
		}

		return tail.getData();
	}

	//Interface: http://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html
	//iterators allow the : method
	class LinkedListIterator<E> implements Iterator<E> {
		private Node<E> current;
		private Node<E> previous;
		private Node<E> previous2;

		public LinkedListIterator() {
			current = head;
			previous = null;
			previous2 = null;
		}

		public boolean hasNext() {
			return current != null;
		}

		public E next() {
			if(current == null) {
				throw new NoSuchElementException();
			}
			E temp = current.getData();
			previous2 = previous;
			previous = current;
			current = current.getNext();
			return temp;
		}

		//remove the last element returned by the iterator
		public void remove() {
			//next has never been called
			if(previous == null) {
				throw new IllegalStateException();
			}

			if(previous2 = null) {
				head = current;
			} else {
				previous2.setNext(current);
			}
			size--;
		}
	}
}