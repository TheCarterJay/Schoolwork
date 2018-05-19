package a02;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Client program that takes a command-line integer k. Reads in a 
 * sequence of strings from standard input using StdIn.readString() and prints 
 * out exactly k of them, uniformly at random. Each item from the sequence can 
 * be printed out at most once.
 * 
 * @author Christopher Bordoy and Carter Timpson
 *
 */

public class Subset {

	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		RandomizedQueue<String> queue = new RandomizedQueue<>();

        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }
        
        for (int i = 0; i < k; i++) {
        	StdOut.println(queue.dequeue());
        }
	}

}
