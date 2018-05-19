package a03AutoComplete;

import java.util.Comparator;

/**
 * Represents and autocomplete term using both a string for the query and a
 * double for the related weight. Supports comparing the terms by lexicographic
 * order by query string(natural order), in descending order by weight, and
 * lexicographic order by query string using only the first n characters.
 * 
 * @author Carter Timpson and Marcell Romero
 *
 */
public class Term implements Comparable<Term> {
	private String query;
	private double weight;

	/**
	 * Initialize a term with the given query string and weight.
	 * 
	 * @param query
	 * @param weight
	 */
	public Term(String query, double weight) {
		if (query == null) {
			throw new NullPointerException();
		}

		if (weight < 0) {
			throw new IllegalArgumentException();
		}

		this.query = query;
		this.weight = weight;
	}

	/**
	 * Compare the terms in descending order by weight.
	 * 
	 * @return
	 */
	public static Comparator<Term> byReverseWeightOrder() {
		return new Comparator<Term>() {
			@Override
			public int compare(Term t1, Term t2) {
				if (t1.weight > t2.weight) {
					return -1;
				} else if (t1.weight == t2.weight) {
					return 0;
				} else {
					return 1;
				}
			}
		};
	}

	/**
	 * Compare the terms in lexicographic order but using only the first r
	 * characters of each query.
	 * 
	 * @param r
	 * @return
	 */
	public static Comparator<Term> byPrefixOrder(int r) {
		if (r < 0) {
			throw new IllegalArgumentException();
		}

		final int rFinal = r;
		return new Comparator<Term>() {
			@Override
			public int compare(Term t1, Term t2) {
				String query1 = t1.query;
				String query2 = t2.query;
				int minLength = query1.length() < query2.length() ? query1.length() : query2.length();

				if (minLength >= rFinal) {
					return query1.substring(0, rFinal).compareTo(query2.substring(0, rFinal));
				} else if (query1.substring(0, minLength).compareTo(query2.substring(0, minLength)) == 0) {
					if (query1.length() == minLength) {
						return -1;
					} else {
						return 1;
					}
				} else {
					return query1.substring(0, minLength).compareTo(query2.substring(0, minLength));
				}
			}
		};
	}

	/**
	 * Compare the terms in lexicographic order by query.
	 */
	public int compareTo(Term that) {
		String query1 = this.query;
		String query2 = that.query;
		return query1.compareTo(query2);
	}

	/**
	 * Return a string representation of the term in the following format: the
	 * weight, followed by a tab, followed by the query.
	 */
	@Override
	public String toString() {
		return weight + "\t" + query;
	}
}