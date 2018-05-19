package a03AutoComplete;

import java.util.Comparator;

/**
 * Binary searches a sorted array, while supporting the ability to find the
 * index of either the first or last occurrence of the provided key.
 * 
 * @author Carter Timpson and Marcell Romero
 *
 */
public class BinarySearchDeluxe {

	/**
	 * Return the index of the first key in a[] that equals the search key, or -1 if
	 * no such key.
	 * 
	 * @param a
	 * @param key
	 * @param comparator
	 * @return
	 */
	public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		if (a == null || key == null || comparator == null) {
			throw new NullPointerException();
		}

		if (a.length == 0) {
			return -1;
		}

		int start = 0;
		int end = a.length - 1;

		while (start + 1 < end) {
			int middle = start + (end - start) / 2;
			if (comparator.compare(key, a[middle]) <= 0) {
				end = middle;
			} else {
				start = middle;
			}
		}
		if (comparator.compare(key, a[start]) == 0) {
			return start;
		}
		if (comparator.compare(key, a[end]) == 0) {
			return end;
		}

		return -1;
	}

	/**
	 * Return the index of the last key in a[] that equals the search key, or -1 if
	 * no such key.
	 * 
	 * @param a
	 * @param key
	 * @param comparator
	 * @return
	 */
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
		if (a == null || key == null || comparator == null) {
			throw new NullPointerException();
		}

		if (a == null || a.length == 0) {
			return -1;
		}

		int start = 0;
		int end = a.length - 1;

		while (start + 1 < end) {
			int middle = start + (end - start) / 2;
			if (comparator.compare(key, a[middle]) < 0) {
				end = middle;
			} else {
				start = middle;
			}
		}
		if (comparator.compare(key, a[end]) == 0) {
			return end;
		}

		if (comparator.compare(key, a[start]) == 0) {
			return start;
		}

		return -1;
	}
}