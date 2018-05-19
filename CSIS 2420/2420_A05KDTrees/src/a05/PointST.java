package a05;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.Stack;
/**
 * 
 * @author Arturo Lara-Coronado
 * @author Carter Timpson 
 *
 * @param <Value>
 */
public class PointST<Value> {
    private RedBlackBST<Point2D, Value> bst;
    /**
     * construct an empty symbol table of points
     */
    public PointST() {
        bst = new RedBlackBST<>();
    }
    /**
     * is the symbol table empty?
     * 
     * @return
     */
    public boolean isEmpty() {
        return bst.size() == 0;
    }
    /**
     * number of points
     * 
     * @return
     */
    public int size() {
        return bst.size();
    }
    /**
     * associate the value val with point p
     * 
     * @param p
     * @param val
     */
    public void put(Point2D p, Value val) {
        if (p == null || val == null) {
            throw new NullPointerException("Method cannot be called with a "
                    + "'null' point or value.");
        }
        bst.put(p, val);
    }
    /**
     * value associated with point p
     * 
     * @param p
     * @return
     */
    public Value get(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Method cannot be called with a null point.");
        }
        return bst.get(p);
    }
    /**
     * does the symbol table contain point p?
     * 
     * @param p
     * @return
     */
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Method cannot be called with a null point.");
        }
        return bst.contains(p);
    }
    /**
     * all points in the symbol table
     * 
     * @return
     */
    public Iterable<Point2D> points() {
        return bst.keys();
    }
    /**
     * all points that are inside the rectangle
     * 
     * @param rect
     * @return
     */
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new NullPointerException("Method cannot be called with a null rectangle.");
        }
        
        Stack<Point2D> points = new Stack<>();
        
        for (Point2D p : bst.keys()) {
            if (rect.contains(p)) {
                points.push(p);
            }
        }
        return points;
    }
    /**
     * a nearest neighbor to point p; null if the symbol table is empty
     * 
     * @param p
     * @return
     */
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Method cannot be called with a null point.");
        }
        Point2D near = bst.max();
        
        for (Point2D point : bst.keys()) {
            if (p.distanceSquaredTo(point) < p.distanceSquaredTo(near)) {
                near = p;
            }
        }
        return near;
    }
    /**
     * unit testing of the methods (not graded)
     * 
     * @param args
     */
    public static void main(String[] args) {
        // TODO
    }
}
