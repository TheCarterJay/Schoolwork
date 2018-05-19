package labQuadrotors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrotorApp {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		List<Quadrotor> rotors = new ArrayList(Arrays.asList( 
				new Quadrotor(2, 4, 2), new Quadrotor(3, 4, 4), new Quadrotor(4, 4, 6), 
				new Quadrotor(5, 4, 2), new Quadrotor(6, 4, 4), new Quadrotor(7, 4, 6)));
		
		System.out.println(rotors.toString());
		
		changeOrientation(rotors);
		
		System.out.println(rotors.toString());
		
		Quadrotor searchItem = new Quadrotor(4, 6, 4);
		
		if (rotors.contains(searchItem) == true) {
			System.out.println("rotors does contain " + searchItem);
		} else {
			System.out.println("rotors does not contain " + searchItem);
		}
		
		rotors.remove(searchItem);
		
		System.out.println(rotors.toString());
		
		rotors.remove(0);
		
		System.out.println(rotors.toString());
	}
	
	private static void changeOrientation(List<Quadrotor> quadrotors) {
		int tempX;
		int tempY;
		for (Quadrotor el : quadrotors) {
			tempX = el.getY();
			tempY = el.getX();
			
			el.setX(tempX);
			el.setY(tempY);
		}
	}

}
