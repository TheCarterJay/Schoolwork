package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Similar to a stack or a queue, except that the item removed is chosen
 * uniformly at random from items in the data structure.
 * 
 * @author Christopher Bordoy and Carter Timpson
 *
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] randomTypeArray;
	private static int sizeOfQueue;
	private int first = 0;
	private int last = 0;

	/**
	 * Constructs an empty randomized queue.
	 */
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		sizeOfQueue = 0;
		randomTypeArray = (Item[]) new Object[1];
	}

	/**
	 * Checks to see if the queue is empty.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return sizeOfQueue == 0;
	}

	/**
	 * Returns the number of items in the queue.
	 * 
	 * @return
	 */
	public int size() {
		return sizeOfQueue;
	}

	private void resizeArray(int changeValue) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[changeValue];
		for (int i = 0; i < sizeOfQueue; i++) {
			temp[i] = randomTypeArray[i];
		}
		randomTypeArray = temp;
		first = 0;
		last = sizeOfQueue;
	}

	/**
	 * Adds the item to the queue. 
	 * Resizes the array to twice it's size once full.
	 * 
	 * @param item
	 */
	public void enqueue(Item item) {
		if (item == null) {
			throw new NullPointerException("Item cannot be null!");
		}

		if (randomTypeArray.length == sizeOfQueue) {
			resizeArray(randomTypeArray.length * 2);
		}

		randomTypeArray[last++] = item;

		if (last == randomTypeArray.length) {
			last = 0;
		}

		sizeOfQueue++;
	}

	/**
	 * Deletes and returns a random item in the queue. 
	 * Resizes the array to half it's size once
	 * the array is one-fourth full.
	 * 
	 * @return
	 */
	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty!");
		}

		int itemIndex = StdRandom.uniform(sizeOfQueue);

		Item item = randomTypeArray[itemIndex];
		randomTypeArray[itemIndex] = randomTypeArray[--sizeOfQueue];
		randomTypeArray[sizeOfQueue] = null;

		if (sizeOfQueue > 0 && sizeOfQueue == randomTypeArray.length / 4) {
			resizeArray(randomTypeArray.length / 2);
		}

		return item;
	}

	/**
	 * Returns (but does not delete) a random item in the queue.
	 * 
	 * @return
	 */
	public Item sample() {
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty!");
		}

		return randomTypeArray[StdRandom.uniform(sizeOfQueue)];
	}

	/**
	 * Returns an independent iterator over items in random order.
	 */
	public Iterator<Item> iterator() {
		return new RandomizedQueueIterator();
	}

	private class RandomizedQueueIterator implements Iterator<Item> {
		private int iteratorSize = sizeOfQueue;
		private Item[] shuffleArray;

		@SuppressWarnings("unchecked")
		public RandomizedQueueIterator() {
			shuffleArray = (Item[]) new Object[sizeOfQueue];
			System.arraycopy(randomTypeArray, first, shuffleArray, 0, sizeOfQueue);
			StdRandom.shuffle(shuffleArray);
		}

		@Override
		public boolean hasNext() {
			return iteratorSize > 0;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException("There are no more elements in the iterator.");
			}

			return shuffleArray[--iteratorSize];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove is not a supported method");
		}
	}

	public static void main(String[] args) {
		RandomizedQueue<String> words = new RandomizedQueue<>();

		StdOut.println("Is the queue empty: " + words.isEmpty()
				+ ". Size of queue: " + words.size());
		
		StdOut.println("\nAdding items to the queue... ");
		words.enqueue("Cat") ;
		words.enqueue("Dog");
		words.enqueue("Horse");
		words.enqueue("Pig");
		words.enqueue("Fly");
		words.enqueue("Buffalo");
		words.enqueue("Chicken");
		words.enqueue("Squirell");
		StdOut.println("\nIs the queue empty: " + words.isEmpty() 
				+ ". Size of queue: " + words.size());

		StdOut.println("\nSampling items from the queue:");
		StdOut.println(words.sample()); // WORKS FINE
		StdOut.println(words.sample());
		StdOut.println(words.sample());
		StdOut.println();
		
		StdOut.println("All items in the queue dequed:");
		StdOut.println(words.dequeue());
		StdOut.println(words.dequeue());
		StdOut.println(words.dequeue());
		StdOut.println(words.dequeue());
		StdOut.println(words.dequeue());
		StdOut.println(words.dequeue());
		StdOut.println(words.dequeue());
		StdOut.println(words.dequeue());
		
		StdOut.println("\nIs the queue empty: " + words.isEmpty() 
				+ ". Size of queue: " + words.size());

		StdOut.println("\nAdding more items to the queue...");
		
		words.enqueue("Frog");
		words.enqueue("Flea");
		words.enqueue("Goat");
		words.enqueue("Giraffe");
		StdOut.println();

		Iterator<String> iterator = words.iterator();// WORKS GREAT

		StdOut.println("Printing the items in the queue using an iterator:");
		while (iterator.hasNext()) {
			StdOut.println(iterator.next());
		}
	}
}