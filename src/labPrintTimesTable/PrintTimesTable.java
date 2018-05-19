package labPrintTimesTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintTimesTable {
	public static void main(String[] args) {
		PrintTimesTable();
	}

	public static void PrintTimesTable() {
		try {
			File file = new File("src/labPrintTimesTable/TimeTables.txt");
			PrintWriter myPrinter = new PrintWriter(file);
			
			for (int i = 1; i <= 10; i += 2) {
				for (int j = 1; j <= 10; j++) {
					System.out.printf("%2d * %-2d = %-2d", j, i, j * i);
					System.out.printf("%10d * %d = %d%n", j, i + 1, j * (i + 1));
					
					myPrinter.printf("%2d * %-2d = %-2d", j, i, j * i);
					myPrinter.printf("%10d * %d = %d%n", j, i + 1, j * (i + 1));
				}
				System.out.println();
				myPrinter.println();
			}
			myPrinter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
