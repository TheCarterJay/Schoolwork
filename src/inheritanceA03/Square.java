package inheritanceA03;

/*
 * A03 - Inheritance
 * CSIS 1410
 * Carter Timpson
 */

/**
 * A class that creates a Square based on the given side length.
 * Inherits Rectangle.
 * 
 * @author Carter
 *
 */
public class Square extends Rectangle {

	/**
	 * Constructs a square based on the given side length.
	 * @param side an int for the side length
	 */
	public Square(int side) {
		super(side, side);
	}

	/**
	 * Gets the side length of the Square.
	 * @return the side length of the Square
	 */
	public int getSide() {
		return length;
	}

	/**
	 * Gives a formatted String with the side length of the Square.
	 * 
	 * @return a String for the side length of the Square
	 */
	@Override
	public String toString() {
		return "Square(" + length + ")\n";
	}

}
