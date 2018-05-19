package books;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable<Book> {

	private String title;
	private String author;
	private int year;

	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return title + " by " + author + " (" + year + ")";
	}

	@Override
	public int compareTo(Book o) {
		return this.getTitle().compareTo(o.getTitle());
	}

	public static List<Book> getList(String file) {

		List<Book> books = new ArrayList<Book>();
		String item = "";

		try (BufferedReader bookReader = new BufferedReader(new FileReader(file))) {

			while ((item = bookReader.readLine()) != null) {
				String[] newBook = item.split(",");
				try {
					books.add(new Book(newBook[0], newBook[1], Integer.parseInt(newBook[2])));
				} catch (Exception e) {
					System.err.println("Problem reading in \"" + item + "\"");
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("The file could not be found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("The file could not be read.");
			e.printStackTrace();
		}

		return books;

	}

}
