package interfaceA04;

/**
 * A class that creates a Rectangle based on the given length and width. 
 * @author Carter
 *
 */
public class Rectangle implements Shape {
	protected int length;
	protected int width;

	/**
	 * Constructs a rectangle from the given length and width.
	 * @param length the length of the Rectangle
	 * @param width the width of the Rectangle
	 */
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	/**
	 * Gets the length of the Rectangle.
	 * @return an int for the length of the Rectangle
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Gets the widthh of the Rectangle.
	 * @return an int for the width of the Rectangle
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Gives a formatted String with the length and width of the Rectangle.
	 * @return a String for the length and width of the Rectangle.
	 */
	@Override
	public String toString() {
		return "Rectangle(" + length + "x" + width + ")\n";
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

}
