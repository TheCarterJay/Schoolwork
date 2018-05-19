package labRegex;

import java.util.Scanner;

public class LabRegex {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String myRegex1 = "CS\\d{4}";
		
		String myRegex2 = "A\\w+";
		
		String myRegex3 = "[A|E|I|O|U]\\w+";
		
		String myRegex4 = "[A|E|I|O|U]\\w{1,}";
		
		String myRegex5 = "^([0-9]( |-)?)?(\\(?[0-9]{3}\\)?|[0-9]{3})( |-)?([0-9]{3}( |-)?[0-9]{4}|[a-zA-Z0-9]{7})$";
		
		String myRegex6 = "^[A-Za-z0-9](([_\\.\\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\\.\\-]?[a-zA-Z0-9]+)*)\\.([A-Za-z]{2,})$";
		test(myRegex2);
	}

	@SuppressWarnings("resource")
	private static void test(String regex) {
		String word;
		Scanner input = new Scanner(System.in);

		System.out.printf("Enter words to match the expression %s%n", regex);
		System.out.println("Enter DONE when you are finished");
		System.out.print("Word: ");
		word = input.nextLine();
		while (!word.equalsIgnoreCase("done")) 
		{
			System.out.printf("%s %s%n", word, word.matches(regex) ? "matches" 
					: "does not match");
			System.out.print("Word: ");
			word = input.nextLine();
		}
	}
}
