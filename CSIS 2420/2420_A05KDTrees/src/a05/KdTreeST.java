package a05;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;


public class KdTreeST<Value> {
	private Node root;
	private int size;

	
	private class Node {
		   private Point2D p;      // the point
		   private Value value;    // the symbol table maps the point to this value
		   private RectHV rect;    // the axis-aligned rectangle corresponding to this node
		   private Node lb;        // the left/bottom subtree
		   private Node rt;        // the right/top subtree
		   public Node(Point2D p, Value value, RectHV rect) {
			   this.p = p;
			   this.value = value;
			   this.rect = rect;
		   }
	}
	/**
	 * Constructs an empty symbol table of points
	 */
	public KdTreeST() {
	}

	/**
	 * is the symbol table empty?
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * number of points
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * associate the value val with point p
	 * 
	 * @param p
	 * @param val
	 */
	public void put(Point2D p, Value val) {
		if (p == null || val == null) throw new NullPointerException();
		double negInf = Double.NEGATIVE_INFINITY;
		double posInf = Double.POSITIVE_INFINITY;
		root = put(root, p, val, new RectHV(negInf, negInf, posInf, posInf), 1);
	}
	
	private Node put(Node x, Point2D p, Value val, RectHV rect, int level) {
		if (x == null) {
			size++;
			return new Node(p, val, rect);
		}
		
		// Use level to determine which coordinate to use to compare points
		boolean isVertical = false;
		int cmp;
		
		if (level % 2 == 1) { // vertical
			cmp = Double.compare(p.x(), x.p.x());
			isVertical = true;
		}
		else { // horizontal
			cmp = Double.compare(p.y(), x.p.y());
			isVertical = false;
		}
		
		RectHV newRect;
		if (x.p.equals(p))
			x.value = val;
		
		else if (cmp < 0) {
			newRect = getLeftRect(x, rect, isVertical);
			x.lb = put(x.lb, p, val, newRect, ++level); // assign left node
		}
		else { // (cmp >= 0)
			newRect = getRightRect(x, rect, isVertical);
			x.rt = put(x.rt, p, val, newRect, ++level); // assign right node
		}
		return x;
	}

	private RectHV getRightRect(Node x, RectHV rect, boolean isVertical) {
		RectHV newRect;
		if (isVertical)
			newRect = new RectHV(x.p.x(), rect.xmin(), rect.xmax(), rect.ymax());
		else
			newRect = new RectHV(rect.xmin(), x.p.y(), rect.xmax(), rect.ymax());
		return newRect;
	}

	private RectHV getLeftRect(Node x, RectHV rect, boolean isVertical) {
		RectHV newRect;
		if (isVertical)
			newRect = new RectHV(rect.xmin(), rect.ymin(), x.p.x(), rect.ymax());
		else
			newRect = new RectHV(rect.xmin(), rect.ymin(), rect.xmax(), x.p.y());
		return newRect;
	}

	/**
	 * value associated with point p
	 * 
	 * @param p
	 * @return
	 */
	public Value get(Point2D p) {
		return get(p, root, 1);
	}
	
	private Value get(Point2D p, Node x, int level) {
		if (x == null) return null;
		
		// use level to determine which coordinate to use to compare points
		int cmp;
		if (level % 2 == 1)
			cmp = Double.compare(p.x(), x.p.x());
		else 
			cmp = Double.compare(p.y(), x.p.y());
	
		if 		(cmp < 0) 	return get(p, x.lb, ++level); // go to the left side, increment level
		else if (cmp > 0) 	return get(p, x.rt, ++level); // go to the right side, increment level
		else { // check to see if points are equal. Otherwise, continue recursion to the right side
			if (x.p.equals(p)) 	return x.value;
			else				return get(p, x.rt, ++level);
		}
	}

	/**
	 * does the symbol table contain point p?
	 * 
	 * @param p
	 * @return
	 */
	public boolean contains(Point2D p) {
		if (p == null) throw new NullPointerException("argument to contains() is null");
		return get(p) != null;
	}

	/**
	 * all points in the symbol table
	 * 
	 * @return
	 */
	public Iterable<Point2D> points() {
		Queue<Point2D> points = new Queue<>();
		Queue<Node> queue = new Queue<>();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			Node x = queue.dequeue();
			if (x == null) continue;
			points.enqueue(x.p);
			queue.enqueue(x.lb);
			queue.enqueue(x.rt);
		}
		return points;
	}
	

	/**
	 * all points that are inside the rectangle
	 * 
	 * @param rect
	 * @return
	 */
	public Iterable<Point2D> range(RectHV rect) {
		if (rect == null) {
			throw new NullPointerException("Cannot call the range method with a null rectangle.");
		}
		
		Queue<Point2D> rangePoints = new Queue<>();
		
		range(rect, rangePoints, root);
		return rangePoints;
	}
	
	private void range(RectHV rect, Queue<Point2D> rectPoints, Node node) {
		if (node == null) {
			return;
		}
		if (!rect.intersects(node.rect)) {
			return;
		}
		if (rect.contains(node.p)) {
			rectPoints.enqueue(node.p);
		}
		
		range(rect, rectPoints, node.lb);
		range(rect, rectPoints, node.rt);
	}
	
	

	/**
	 * a nearest neighbor to point p; null if the symbol table is empty
	 * 
	 * @param p
	 * @return
	 */
	public Point2D nearest(Point2D p) {
		if (p == null) {
			throw new NullPointerException("Cannot call the nearest method with a null argument.");
		}
		return nearest(p, root, root.p);
	}

	private Point2D nearest(Point2D p, Node node, Point2D nearestPoint) {
		if (node == null) {
			return nearestPoint;
		}
		
		if(node.rect.distanceSquaredTo(p) > nearestPoint.distanceSquaredTo(p)) {
			return nearestPoint;
		}
		
		if (p.distanceSquaredTo(node.p) < p.distanceSquaredTo(nearestPoint)) {
			nearestPoint = node.p;
		}
		
		if (node.lb != null && node.lb.rect.contains(p)) {
			nearestPoint = nearest(p, node.lb, nearestPoint);
			nearestPoint = nearest(p, node.rt, nearestPoint);
		} else {
			nearestPoint = nearest(p, node.rt, nearestPoint);
			nearestPoint = nearest(p, node.lb, nearestPoint);
		}
		return nearestPoint;
	}


	/**
	 * unit testing of the methods (not graded)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		KdTreeST<String> kdTree = new KdTreeST<>();
		kdTree.put(new Point2D(2,3), "test");
		kdTree.put(new Point2D(4,2), "test2");
		kdTree.put(new Point2D(4,5), "test3");
		kdTree.put(new Point2D(3,3), "test4");
		kdTree.put(new Point2D(1,5), "test5");
		kdTree.put(new Point2D(4,4), "test6");
		System.out.println("get(2,3): " + kdTree.get(new Point2D(2,3)));
		System.out.println("get(4,4): " + kdTree.get(new Point2D(4,4)));
		System.out.println(kdTree.size());
		System.out.println(kdTree.contains(new Point2D(4,4)));
		
		Iterable<Point2D> points = kdTree.points();
		
		for (Point2D p : points)
			System.out.println(p + " " + kdTree.get(p));
		System.out.println();
		
		Iterable<Point2D> range = kdTree.range(new RectHV(1.5, 2.5, 3.5, 3.5));
		for (Point2D p : range) 
			System.out.println(p + " " + kdTree.get(p));
		
		Point2D nearest = kdTree.nearest(new Point2D(0.0, 0.0));
		System.out.println(nearest);
	}
}
