package a01;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Percolation sets up a 2D grid, converts to a 1D grid
 * for use with indices and use of WeightedQuickUnionUF methods
 * Percolation determines whether the grid percolates
 * based on the position of the open sites
 * @author shenandoahStubbs
 * @author carterTimpson
 *
 */
public class Percolation {
	private int n;
	private int virtualTop;
	private int virtualBottom;
	private WeightedQuickUnionUF sites;
	private WeightedQuickUnionUF checkBackwash;
	private boolean[][] grid;
	private int index = 0;
	private int openSites = 0;

	/**
	 * create N-by-N grid, with all sites blocked
	 */
	public Percolation(int n) {
		this.n = n;
		virtualTop = n * n;
		virtualBottom = n * n + 1;
		if (n <= 0)
			throw new IllegalArgumentException("n must be greater than 0");
		grid = new boolean[n][n];
		sites = new WeightedQuickUnionUF(n * n + 2); // will assign the boolean grid to sites that are closed by default
		topToBottom(); 

	}

	/**
	 * Open site (row i, column j) if it is not open already
	 * has a condition to check to ensure the open sites are
	 * not out of bounds
	 */
	public void open(int i, int j) {

		if (i < 0 || i >= n || j < 0 || j >= n)
			throw new IndexOutOfBoundsException(
					"row and column indices " + i + "and " + j + " must be between 0 and " + (n - 1));
		grid[i][j] = true; 
		if (j > 0 && (grid[i][j - 1] == true))
			sites.union(indexConvert(i, j), indexConvert(i, j - 1));
		if (j < n - 1 && (grid[i][j + 1] == true))
			sites.union(indexConvert(i, j), indexConvert(i, j + 1));
		if (i > 0 && (grid[i - 1][j] == true))
			sites.union(indexConvert(i, j), indexConvert(i - 1, j));
		if (i < n - 1 && (grid[i + 1][j] == true))
			sites.union(indexConvert(i, j), indexConvert(i + 1, j));
		//openSites++;
	}

	/**
	 * checks whether the i site (row i, column j) open?
	 */
	public boolean isOpen(int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= n)
			throw new IndexOutOfBoundsException(
					"row and column indices " + i + "and " + j + " must be between 0 and " + (n - 1));
		return grid[i][j];
	}

	/**
	 * checks whether the site (row i, column j) is full?
	 */
	public boolean isFull(int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= n)
			throw new IndexOutOfBoundsException(
					"row and column indices " + i + "and " + j + " must be between 0 and " + (n - 1));
		return (isOpen(i, j) && sites.connected(virtualTop, indexConvert(i, j)));

	}

	/**
	 * checks whether the system percolates
	 */
	public boolean percolates() {

		return sites.connected(virtualTop, virtualBottom);
	}

	/**
	 * Converts the index of the 2D array to 1D This makes it so you can implement
	 * the WeightedQuickUnionUF
	 * @param i
	 * @param j
	 * @return converted index for a 1D array from a 2D array
	 */
	private int indexConvert(int i, int j) {
		int index = ((i * n) + j);
		return index;
	}

	/**
	 * Connects the virtual top to the virtual bottom so that you can check for
	 * percolation
	 */
	private void topToBottom() {
		for (int i = 0; i < n; i++) {
			sites.union(virtualTop, indexConvert(0, i));
			sites.union(virtualBottom, indexConvert(n - 1, i));
		}
	}

	/**
	 * used to implement the main method from the Percolation Visualizer
	 * 
	 * @return
	 *//*
	public int numberOfOpenSites() {
		return openSites;
	}*/

}