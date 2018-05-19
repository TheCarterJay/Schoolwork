package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;




/**
 * A generalization of a stack and a queue that supports inserting and removing 
 * items from either the front or the back of the data structure.
 * 
 * @author Christopher Bordoy and Carter Timpson
 *
 * @param <Item>
 */

public class Deque<Item> implements Iterable<Item> {
	private int itemsInDeque;
	private Node first;
	private Node last;
	
	/**
	 * Constructs an empty deque.
	 */
	public Deque() {
		itemsInDeque = 0;
		first = null;
		last = null;
	}
	
	/**
     * Node of Deque that stores the item and a
     * reference to the previous and next node.
     */
	 private class Node {
	        private Item item;
	        private Node previous;
	        private Node next;
	    }

	/**
	 * Checks to see if the deque is empty.
	 * @return
	 */
	public boolean isEmpty()    {
		return itemsInDeque == 0;
	}

	/**
	 * Returns the number of items in the deque.
	 * @return
	 */
	public int size()  {
		return itemsInDeque;
	}

	/**
	 * Inserts the item to the front of the deque.
	 * @param item
	 */
	public void addFirst(Item item)    {
		if(item == null) {
			throw new NullPointerException("You cannot add an item that is null");
		}
		
		Node newNode = new Node();
		newNode.item = item;
		
		if(isEmpty()) {
			first = newNode;
			last = newNode;
			first.next = null;
			first.previous = null;
			last.next = null;
			last.previous = null;
		} else {
			Node oldFirst = first;
			first = newNode;
			newNode.next = oldFirst;
			newNode.previous = null;
		}
		itemsInDeque++;
	}

	/**
	 * Inserts the item to the end of the deque.
	 * @param item
	 */
	public void addLast(Item item)  {
		if(item == null) {
			throw new NullPointerException("You cannot add an item that is null");
		}
		Node newNode = new Node();
		newNode.item = item;
		
		if(isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			Node oldLast = last;
			last = newNode;
			oldLast.next = last;
			last.next = null;
			last.previous = oldLast;
		}
		itemsInDeque++;
	}

	/**
	 * Deletes and returns the item at the front of the deque.
	 * @return
	 */
	public Item removeFirst()    {
		
		if(isEmpty()) {
			throw new NoSuchElementException("There are no items in the deque to remove");
		}
		
		Node tempNode = first;
		
		first = first.next;
		if (first != null) {
			first.previous = null;
		}
		itemsInDeque--;
		if (isEmpty()) last = null;
		
		return tempNode.item;
	}

	/**
	 * Deletes and returns the item at the end of the deque.
	 * @return
	 */
	public Item removeLast()   {
		
		if(isEmpty()) {
			throw new NoSuchElementException("There are no items in the deque to remove");
		}
		
		Node tempNode = last;
		
		if (last.previous != null) {
			last = last.previous;
		}
		
		if (last != null) {
			last.next = null;
		}
		
		itemsInDeque--;
		
		if (itemsInDeque == 1) {
			last = first;
		}
		
		if (isEmpty()) {
			first = null;
		}
			
		return tempNode.item;
	}

	/**
	 * Returns an iterator over items in order from front to end.
	 */
	@Override
	public Iterator<Item> iterator()    {
		return new DequeIterator();
	}
		
	private class DequeIterator implements Iterator<Item> {
		private Node current = first;
		
		/**
		 * Not supported.
		 * @throws java.lang.UsupportedOperationException.
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove is not a supported method");
		}

		/**
		 * Returns whether the iterator has another element.
		 * @return whether the iterator has another element.
		 */
		@Override
		public boolean hasNext() {
			return current != null;
		}

		/**
		 * Returns the next item in the iterator.
		 * @return the next item in the iterator.
		 */
		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException("There are no more elements in the iterator.");
			}
			
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args) {
		Deque<String> words = new Deque<>();
		
		StdOut.println("Is the deque empty: " + words.isEmpty()
				+ ". Size of deque: " + words.size());
	
		StdOut.println("\nAdding items to the deque... ");
		
		words.addFirst("Cat");
		words.addFirst("Dog");
		words.addLast("Horse");
		
		StdOut.println("\nIs the deque empty: " + words.isEmpty()
				+ ". Size of deque: " + words.size());
		
		StdOut.println("\nRemoving the items from the deque:");
		StdOut.println(words.removeFirst());
		StdOut.println(words.removeLast());
		StdOut.println(words.removeFirst() + "\n");
		
		StdOut.println("Is the deque empty: " + words.isEmpty()
				+ ". Size of deque: " + words.size());
		
		
		StdOut.println("\nAdding more items to the deque... ");
		words.addFirst("Fly");
		words.addLast("Pig");
		words.addLast("Lion");
		words.addFirst("Eel");

		StdOut.println("\nPrinting each item in the deque using a for-each loop:");
		for (String w : words) {
			StdOut.print(w + " ");
		}
		
		StdOut.println("\n\nRemoving the items from the deque while adding a couple more items"
				+ " inbetween removals:");
		StdOut.println(words.removeFirst());
		words.addFirst("Bear");
		StdOut.println(words.removeFirst());
		StdOut.println(words.removeLast());
		words.addLast("Beaver");
		StdOut.println(words.removeFirst());
		StdOut.println(words.removeFirst());
		StdOut.println(words.removeFirst());
		
		StdOut.println("\nIs the deque empty: " + words.isEmpty()
				+ ". Size of deque: " + words.size());
		
		StdOut.println("\nAdding more items to the deque...");
		words.addFirst("Box");
		words.addFirst("Circle");
		words.addLast("Square");
		words.addFirst("Rectangle");
		words.addFirst("Triangle");
		
		StdOut.println("\nPrinting each pairing of the items using "
				+ "nested for-each loops:");
		for (String w : words) {
			for (String w2 : words) {
				StdOut.println(w + " " + w2);
			}
		}
		
		Iterator<String> iterator = words.iterator();
		
		StdOut.println("\nPrinting each item using the iterator:");
		while (iterator.hasNext()) {
			StdOut.println(iterator.next());
		}
	}
}