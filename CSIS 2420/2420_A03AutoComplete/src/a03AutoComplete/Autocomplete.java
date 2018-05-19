package a03AutoComplete;

import java.util.Arrays;

import edu.princeton.cs.algs4.Quick3way;
import edu.princeton.cs.algs4.StdOut;

/**
 * Provides the autocomplete functionality for the provided array of terms.
 * Supports the ability to sort the terms in lexicographic order, use binary
 * search to find the set of terms that start with a given prefix, and sort the
 * matching terms in descending order by weight.
 * 
 * @author Carter TEimpson and Marcell Romero
 *
 */
public class Autocomplete {
	private final Term[] finalTerms;

	/**
	 * Initialize the data structure from the given array of terms.
	 * 
	 * @param terms
	 */
	public Autocomplete(Term[] terms) {
		if (terms == null) {
			throw new NullPointerException();
		}

		finalTerms = terms;

		Quick3way.sort(finalTerms);
	}

	/**
	 * Return all terms that start with the given prefix, in descending order of
	 * weight.
	 * 
	 * @param prefix
	 * @return
	 */
	public Term[] allMatches(String prefix) {
		if (prefix == null) {
			throw new NullPointerException();
		}

		int firstIndex = BinarySearchDeluxe.firstIndexOf(finalTerms, new Term(prefix, 0),
				Term.byPrefixOrder(prefix.length()));

		if (firstIndex == -1) {
			return new Term[0];
		}

		int lastIndex = BinarySearchDeluxe.lastIndexOf(finalTerms, new Term(prefix, 0),
				Term.byPrefixOrder(prefix.length()));

		Term[] matchingTerms = new Term[1 + lastIndex - firstIndex];

		for (int i = 0; i < matchingTerms.length; i++) {
			matchingTerms[i] = finalTerms[firstIndex++];
		}

		Arrays.sort(matchingTerms, Term.byReverseWeightOrder());

		return matchingTerms;
	}

	/**
	 * Return the number of terms that start with the given prefix.
	 * 
	 * @param prefix
	 * @return
	 */
	public int numberOfMatches(String prefix) {
		if (prefix == null) {
			throw new NullPointerException();
		}

		return 1 + BinarySearchDeluxe.lastIndexOf(finalTerms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()))
				- BinarySearchDeluxe.firstIndexOf(finalTerms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
	}

	public static void main(String[] args) {
		Term[] terms = { new Term("Apple", 1), new Term("Orange", 2), new Term("Pear", 3), new Term("Dragonfuit", 4),
				new Term("Kiwi", 0), new Term("Strawberry", 1), new Term("Blackberry", 2), new Term("Banana", 3),
				new Term("Plum", 4), new Term("Tomato", 0), new Term("Grape", 1), new Term("Watermelon", 2),
				new Term("Mango", 3), new Term("Pineapple", 4), new Term("Cantelope", 0), new Term("Ape", 6),
				new Term("Agent", 4), new Term("Angle", 7.5), new Term("Ancient", 2.6), new Term("Blue", 1),
				new Term("Balloon", 1), new Term("Bear", 1), new Term("Crab", 1), };

		Autocomplete autocomplete = new Autocomplete(terms);

		Term[] matches = autocomplete.allMatches("A");

		StdOut.println("Terms that match \"A\": ");
		for (Term term : matches) {
			StdOut.println(term.toString());
		}

		StdOut.println();

		StdOut.print("Number of Terms that match \"B\": " + autocomplete.numberOfMatches("B"));
	}
}