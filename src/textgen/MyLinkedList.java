package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	private int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		size = 0;
		head = new LLNode<>(null);
		tail = new LLNode<>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		add(size, element);
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (index > size - 1 || index < 0) {
			throw new IndexOutOfBoundsException("Wrong index");
		}
		LLNode<E> outNode = head;
		/*if (index < size / 2) {
			out = head;
			for (int i = 0; i <= index; i++) {
				out = out.next;
			}
		} else {
			out = tail;
			for (int i = 0; i <= size - index; i++) {
				out = out.prev;
			}
		}*/
		for (int i = 0; i <= index; i++) {
			outNode = outNode.next;
		}
		return outNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if (element == null) {
			throw new NullPointerException("Null elements are forbidden");
		}
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Wrong index");
		}
		LLNode<E> newNode = new LLNode<>(element);
		if (size == 0) {
			size++;
			head.next = newNode;
			tail.prev = newNode;
			newNode.prev = head;
			newNode.next = tail;
		} else if (index == size) {
			size++;
			LLNode<E> prevNode = tail.prev;
			prevNode.next = newNode;
			newNode.prev = prevNode;
			newNode.next = tail;
			tail.prev = newNode;
		} else {
			size++;
			LLNode<E> prevNode = head;
			for (int i = 0; i < index; i++) {
				prevNode = prevNode.next;
			}
			newNode.next = prevNode.next;
			prevNode.next.prev = newNode;
			newNode.prev = prevNode;
			prevNode.next = newNode;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Wrong index");
		}
		LLNode<E> nodeToDelete = head;
		for (int i = 0; i <= index; i++) {
			nodeToDelete = nodeToDelete.next;
		}
		LLNode<E> prevNode = nodeToDelete.prev;
		LLNode<E> nextNode = nodeToDelete.next;
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		size--;
		return nodeToDelete.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if (index > size - 1 || index < 0) {
			throw new IndexOutOfBoundsException("Wrong index");
		}
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> node = head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		E prevElement = node.data;
		node.data = element;
		return prevElement;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public String toString() {
		return (String) data;
	}

}
