package inheritanceA03;

/*
 * A03 - Inheritance
 * CSIS 1410
 * Carter Timpson
 */

/**
 * A class that creates a Circle with the radius given.
 * @author Carter
 *
 */
public class Circle {
	private final int radius;
	
	/**
	 * Constructs a Circle based off the given radius.
	 * @param radius an int for the radius of the Circle
	 */
	public Circle(int radius) {
		this.radius = radius;
	}
	
	/**
	 * Gets the radius of the Circle.
	 * @return an int for the radius
	 */
	public int getRadius() {
		return radius;
	}
	
	/**
	 * Calculates the diameter of the Circle based on the radius.
	 * @return an int for the diameter of the Circle
	 */
	public int diameter() {
		return (radius * 2);
	}
	
	/**
	 * Calculates the circumference of the Circle based on the radius.
	 * @return an int for the circumference of the Circle
	 */
	public double circumference() {
		return ((radius * Math.PI) * 2);
	}
	
	/**
	 * Gives a formatted String with the radius of the Circle.
	 * @return a String for the radius of the Circle.
	 */
	@Override
	public String toString() {
		return "Circle(" + radius + ")\n";
	}

}
