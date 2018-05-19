package labSerialization.Desktop;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LabSerialization {
    public static void main(String[] args) {
        ListVsSetDemo demo = new ListVsSetDemo(
                new ColoredSquare(4, Color.RED),
                new ColoredSquare(6, Color.BLUE),
                new ColoredSquare(4, Color.RED),
                new ColoredSquare(8, Color.YELLOW));

        testDemo(demo);
        
        serialize(demo, "src/labSerialization/Demo.ser");
        System.out.println("Serialization complete.\n");
        
        ListVsSetDemo newDemo = deserialize("src/labSerialization/Demo.ser");
        testDemo(newDemo);
    };

    private static void testDemo(ListVsSetDemo demo) {
        System.out.println("List:");
        System.out.println(demo.getListElements());
        System.out.println("Set:");
        System.out.println(demo.getSetElements());
    }
    
    private static void serialize(ListVsSetDemo demo, String fileName) {
    			try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
    				out.writeObject(demo);
    			} catch (IOException ex) {
    				System.out.println("An error occured during serialization.");
    				System.out.println(ex.getMessage());
    			}
    }
    
    private static ListVsSetDemo deserialize(String fileName) {
    	ListVsSetDemo squareList = null;
    	try ( ObjectInputStream in = new ObjectInputStream (new FileInputStream(fileName))) {
    		squareList = (ListVsSetDemo) in.readObject();
    	} catch (IOException | ClassNotFoundException ex) {
    		System.out.printf("An error occured during deserialization %s%n", fileName);
    		System.out.println(ex.getMessage());
    	}
    	return squareList;
    }
}
