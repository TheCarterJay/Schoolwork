package inheritanceA03;

/*
 * A03 - Inheritance
 * CSIS 1410
 * Carter Timpson
 */

/**
 * A class for testing the Rectangle, Square, IsoscelesRightTriangle, and Circle
 * along with all of their methods and parent/subclasses.
 * @author Carter
 *
 */
public class InheritanceApp {

	public static void main(String[] args) {
		Rectangle myRectangle = new Rectangle(5, 4);
		
		System.out.print(myRectangle.toString());
		System.out.printf("Length: %d%n", myRectangle.length);
		System.out.printf("Width: %d%n", myRectangle.width);
		
		Square mySquare = new Square(4);
		
		System.out.print("\n" + mySquare.toString());
		System.out.printf("Side: %d%n", mySquare.getSide());
		
		IsoscelesRightTriangle myIsoscelesRightTriangle = new IsoscelesRightTriangle(5);
		
		System.out.print("\n" + myIsoscelesRightTriangle.toString());
		System.out.printf("Leg: %d%n", myIsoscelesRightTriangle.getLeg());
		System.out.printf("Hypotenuse: %.1f%n", myIsoscelesRightTriangle.hypotenuse());
		
		Circle myCircle = new Circle(4);
		
		System.out.print("\n" + myCircle.toString());
		System.out.printf("Diameter: %d%n", myCircle.diameter());
		System.out.printf("Circumference: %.1f%n", myCircle.circumference());
		System.out.printf("Radius: %d%n", myCircle.getRadius());
		
		Rectangle rectangle2 = mySquare;
		
		System.out.println("\nrectangle2:\n" + "-----------");
		System.out.print(rectangle2.toString());
		System.out.printf("Length: %d%n", rectangle2.length);
		System.out.printf("Width: %d%n", rectangle2.width);

		Rectangle[] rectangles = {rectangle2, mySquare, myRectangle};
		System.out.println("\nRectangle Array:\n" + "-----------");
		
		for (Rectangle el : rectangles) {
			System.out.print("\n" + el.toString());
			System.out.printf("Length: %d%n", el.length);
			System.out.printf("Width: %d%n", el.width);
		}
	}

}
