package a01;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * PercolationStats determines the mean,
 * standard deviation, low end point, and
 * high end point from a grid that percolates
 * @author shenandoahStubbs
 * @author carterTimpson
 *
 */

public class PercolationStats {
    private double[] percolationData;
    

    /**
     * performs T independent experiments on an N-by-N grid
     */
    public PercolationStats(int N, int T) {
        
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("The constructor values must be greater than zero.");
        }
        
        percolationData = runTests(N, T);
    }

    private double[] runTests(int N, int T) {
        
        double[] opened = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation p = new Percolation(N);
            int count = 0;
            while (!p.percolates()) {
                int j = StdRandom.uniform(N);
                int k = StdRandom.uniform(N);
                if (!p.isOpen(j, k)) {
                    p.open(j, k);
                    count++;
                }
            }
            opened[i] = ((double) count) / (N * N);
        }
        return opened;
    }

    /**
     * sample mean of percolation threshold
     */
    public double mean() {
        return StdStats.mean(percolationData);
    }

    /**
     * sample standard deviation of percolation threshold
     */
    public double stddev() {
        return StdStats.stddev(percolationData);
    }

    /**
     * low end-point of 95% confidence interval
     */
    public double confidenceLow() {
        return mean() - StdStats.stddev(percolationData);
    }

    /**
     * high end-point of 95% confidence interval
     */
    public double confidenceHigh() {
        return mean() + StdStats.stddev(percolationData);
    }
    
    public static void main(String[] args) {
        PercolationStats p1 = new PercolationStats(200, 100);
        
        StdOut.print("Example values after creating PercolationStats(200,100): \n");
        StdOut.printf("mean()          = %f%n", p1.mean());
        StdOut.printf("stddev()        = %f%n", p1.stddev());
        StdOut.printf("confidenceLow() = %f%n", p1.confidenceLow());
        StdOut.printf("confidenceHigh()= %f%n", p1.confidenceHigh());
        StdOut.println("\n");
        
PercolationStats p2 = new PercolationStats(200, 100000);
        
        StdOut.print("Example values after creating PercolationStats(200,100000): \n");
        StdOut.printf("mean()          = %f%n", p2.mean());
        StdOut.printf("stddev()        = %f%n", p2.stddev());
        StdOut.printf("confidenceLow() = %f%n", p2.confidenceLow());
        StdOut.printf("confidenceHigh()= %f%n", p2.confidenceHigh());
    }
}
