package a05;

import static org.junit.Assert.*;

import java.util.Iterator;

import a05.PointST;

import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.algs4.Point2D;

public class KdTreeSTTest {
	private KdTreeST<String> tree;
	private KdTreeST<String> emptyTree;
	
	private final Point2D[] points = {new Point2D(0.7, 0.2), 
			new Point2D(0.5, 0.4), new Point2D(0.2, 0.3),
			new Point2D(0.4, 0.7), new Point2D(0.9, 0.6)};
	
	private final Point2D[] pointsInLevelOrder = {new Point2D(0.7, 0.2), 
			new Point2D(0.5, 0.4), new Point2D(0.9, 0.6),
			new Point2D(0.2, 0.3), new Point2D(0.4, 0.7)};	
	
	@Before
	public void setUp() throws Exception {
		emptyTree = new KdTreeST<>();
		
		tree = new KdTreeST<>();
		for (Point2D point : points) 
			tree.put(point, point.toString());
	}
	
	@Test
	public void testPointST() {
		PointST<Integer> newTree = new PointST<>();
		assertEquals(0, newTree.size());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(emptyTree.isEmpty());
		assertFalse(tree.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, emptyTree.size());
		assertEquals(5, tree.size());
	}

	@Test
	public void testPutInsert() {
		Point2D p = new Point2D(5,5);
		tree.put(p, "(5,5)");
		assertEquals(6, tree.size());
		assertEquals("(5,5)", tree.get(p)); 
	}
	
	@Test
	public void testPutUpdate() {
		Point2D p = new Point2D(0.2, 0.3);
		tree.put(p, "somethingDifferent");
		assertEquals(5, tree.size());
		assertEquals("somethingDifferent", tree.get(p)); 
	}
	
	@Test (expected = NullPointerException.class)
	public void testPutNullNull() {
		tree.put(null, null);
	}
	
	@Test (expected = NullPointerException.class)
	public void testPutNullSomething() {
		tree.put(null, "something");
	}
	
	@Test (expected = NullPointerException.class)
	public void testPutSomethingNull() {
		tree.put(new Point2D(1, 1), null);
	}

	@Test
	public void testGetFirstPoint() {
		Point2D p = new Point2D(0.7, 0.2);		
		assertEquals("(0.7, 0.2)", tree.get(p));
	}

	@Test
	public void testGetLastPoint() {
		Point2D p = new Point2D(0.9, 0.6);		
		assertEquals("(0.9, 0.6)", tree.get(p));
	}
	
	@Test
	public void testGetNonExistingPoint() {
		Point2D p = new Point2D(0.2, 0.3);		
		assertEquals(null, emptyTree.get(p));
	}
	
	@Test (expected = NullPointerException.class)
	public void testGetNull() {
		tree.get(null);
	}

	@Test
	public void testContainsFirstPoint() {
		Point2D p = new Point2D(0.7, 0.2);		
		assertTrue(tree.contains(p));
	}

	@Test
	public void testContainsLastPoint() {
		Point2D p = new Point2D(0.9, 0.6);		
		assertTrue( tree.contains(p));
	}
	
	@Test
	public void testContainsNonExistingPoint() {
		Point2D p = new Point2D(0.9, 0.6);		
		assertFalse( emptyTree.contains(p));
	}
	
	@Test (expected = NullPointerException.class)
	public void testContainsNull() {
		tree.contains(null);
	}
	
	@Test
	public void testPoints() {
		Iterable<Point2D> treePoints = tree.points();
		Iterator<Point2D> it = treePoints.iterator();

		int count = 0;
		while (it.hasNext()) {
			it.next();
			count++;
		}

		assertEquals(points.length, count);
	}
	
	@Test
	public void testPointsOrder() {
		Iterable<Point2D> treePoints = tree.points();

		int i = 0;
		for (Point2D p : treePoints) {
			assertEquals(p, pointsInLevelOrder[i++]);
		}
	}

	@Test (expected = NullPointerException.class)
	public void testRangeNull() {
		tree.range(null);
	}
	
	@Test (expected = NullPointerException.class)
	public void testNearestNull() {
		tree.nearest(null);
	}
	
	@Test
	public void testNearest() {
		assertEquals(new Point2D(0,0), tree.nearest(new Point2D(0,0)));
		assertEquals(new Point2D(0,0), tree.nearest(new Point2D(Double.MIN_VALUE, Double.MIN_VALUE)));
		assertEquals(new Point2D(2,2), tree.nearest(new Point2D(10000000, 10000000)));
		assertEquals(new Point2D(-2,-2), tree.nearest(new Point2D(-10000000, -10000000)));
		assertEquals(new Point2D(-2, 2), tree.nearest(new Point2D(-10000000, 10000000)));
		assertEquals(new Point2D(2, -2), tree.nearest(new Point2D(10000000, -10000000)));
		assertEquals(new Point2D(0,0), tree.nearest(new Point2D(0.4, 0.6)));
		assertEquals(new Point2D(1,1), tree.nearest(new Point2D(0.40000000001, 0.6)));
		assertEquals(new Point2D(1,1), tree.nearest(new Point2D(0.4, 0.60000000001)));
	}

	// This set of unit tests is not complete. 
	// I hope it is a helpful starting point and 
	// encourages you to add your own jUnit tests.
}