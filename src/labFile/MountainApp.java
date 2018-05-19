package labFile;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MountainApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		List<Mountain> mountainList = new LinkedList<>();
		try {
			Scanner mountainScanner = new Scanner(MountainApp.class.getResourceAsStream("Mountains.csv"));

			while (mountainScanner.hasNextLine()) {
				Mountain newMountain = getMountain(mountainScanner.nextLine());

				if (newMountain != null) {
					mountainList.add(newMountain);
				}

			}
		} finally {
			for (Mountain mountain : mountainList) {
				System.out.println(mountain.toString());
			}
		}

	}

	private static Mountain getMountain(String nextLine) {
		try {
			String[] items = nextLine.split(",");
			return new Mountain(items[0], Integer.parseInt(items[1]), Boolean.parseBoolean(items[2]));
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.err.print(nextLine + ".. could not be read in as mountain.\n");
			return null;
		}

	}

}
