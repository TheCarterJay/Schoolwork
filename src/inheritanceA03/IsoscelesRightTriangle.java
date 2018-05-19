package inheritanceA03;

/*
 * A03 - Inheritance
 * CSIS 1410
 * Carter Timpson
 */

/**
 * A class that creates an Isosceles Right Triangle based on the side length given.
 * @author Carter
 *
 */
public class IsoscelesRightTriangle {
	private final int leg;
	
	/**
	 * Constructs an IsoscelesRightTriangle based on the side length given.
	 * @param leg the side length for the leg
	 */
	public IsoscelesRightTriangle (int leg) {
		this.leg = leg;
	}
	
	/**
	 * Gets the length of the leg
	 * @return an int for the length of the leg
	 */
	public int getLeg() {
		return leg;
	}
	
	/**
	 * Calculates the length of the hypotenuse of the IsoscelesRightTriangle.
	 * @return a double for the length of the hypotenuse
	 */
	public double hypotenuse() {
		return Math.sqrt(Math.pow(leg, 2) + Math.pow(leg, 2));
	}

	/**
	 * Gives a formatted String with the leg length of the IsoscelesRightTriangle.
	 * @return a String for the leg length of the IsoscelesRightTriangle
	 */
	@Override
	public String toString() {
		return "IsoscelesRightTriangle(" + leg + ")\n";
	}
}
