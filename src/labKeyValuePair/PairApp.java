package labKeyValuePair;

public class PairApp {

	public static void main(String[] args) {
		KeyValuePair<String, Integer> p1 = new KeyValuePair<String, Integer>("SLC", 189899);
		KeyValuePair<String, Integer> p2 = new KeyValuePair<String, Integer>("NY", 8244910);

		System.out.println(p1);
		System.out.println(p2);
		
		System.out.printf("p1.equals(p2): %b%n%n",p1.equals(p2));
		
		p1 = p2;
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.printf("p1.equals(p2): %b%n",p1.equals(p2));
	}

}
