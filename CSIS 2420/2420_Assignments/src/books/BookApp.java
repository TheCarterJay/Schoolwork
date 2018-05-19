package books;

import java.util.Collections;
import java.util.List;

public class BookApp {

	public static void main(String[] args) {
		
		List<Book> books = Book.getList("src/books/books.csv");
		
		System.out.println("Number of books: " + books.size());
		
		System.out.println("\nSorted book list:");
		Collections.sort(books);
		
		for (Book book : books) {
			System.out.println(book.toString());
		}
		
		System.out.println("\nReverse Order:");
		
		Collections.reverse(books);
		
		for (Book book : books) {
			System.out.println(book.toString());
		}
	
	}
}
