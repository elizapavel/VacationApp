import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 
 * @author Pavel Eliza
 * 
 *         Class for testing the solution.
 *
 */

public class Main {

	public static void main(String[] args) {

		readFile("src/firstTest.in");
		showHierarchy();
		
		Activity a = HierarchyObjects.activities.get("Activity 1");
		System.out.println(a.getPlace().getName() + " " + a.getPlace().getMediumPrice());

	}

	
	/**
	 * Displays all the elements in the hierarchy
	 */
	public static void showHierarchy() {
		for (Entry<String, Planet> p : HierarchyObjects.planets.entrySet()) {
			System.out.print(p.getKey() + " ");
		}
		System.out.println();

		for (Entry<String, Country> p : HierarchyObjects.countries.entrySet()) {
			System.out.print(p.getKey() + " ");
		}
		System.out.println();

		for (Entry<String, District> p : HierarchyObjects.districts.entrySet()) {
			System.out.print(p.getKey() + " ");
		}
		System.out.println();

		for (Entry<String, City> p : HierarchyObjects.cities.entrySet()) {
			System.out.print(p.getKey() + " ");
		}
		System.out.println();

		for (Entry<String, Place> p : HierarchyObjects.places.entrySet()) {
			System.out.print(p.getKey() + " ");
		}
		System.out.println();
		
		for (Entry<String, Activity> a : HierarchyObjects.activities.entrySet()) {
			System.out.print(a.getKey() + " ");
		}
		System.out.println();
	}

	/**
	 * Reads a file and creates all the objects.
	 */
	public static void readFile(String filename) {
		try {
			Scanner sc = new Scanner(new FileReader(filename));
			String[] parts = sc.nextLine().split(",");

			for (int i = 0; i < Integer.parseInt(parts[0]); i++) {
				String line = sc.nextLine();
				HierarchyObjects.planets.put(line, new Planet(line));
			}

			for (int i = 0; i < Integer.parseInt(parts[1]); i++) {
				String line = sc.nextLine();
				String[] info = line.split(",");
				HierarchyObjects.countries.put(info[0], new Country(info[0], info[1]));
			}

			for (int i = 0; i < Integer.parseInt(parts[2]); i++) {
				String line = sc.nextLine();
				String[] info = line.split(",");
				HierarchyObjects.districts.put(info[0], new District(info[0], info[1]));
			}

			for (int i = 0; i < Integer.parseInt(parts[3]); i++) {
				String line = sc.nextLine();
				String[] info = line.split(",");
				HierarchyObjects.cities.put(info[0], new City(info[0], info[1]));
			}

			for (int i = 0; i < Integer.parseInt(parts[4]); i++) {
				String line = sc.nextLine();
				String[] info = line.split(",");
				HierarchyObjects.places.put(info[0], new Place(info[0], info[1], Double.parseDouble(info[2])));
				Place p = HierarchyObjects.places.get(info[0]);
				for (int j = 2; j < info.length; j++) {
					String[] piece = info[3].split(" ");
					DateInterval date = new DateInterval(
							Integer.parseInt(piece[0]), Integer.parseInt(piece[1]),
							Integer.parseInt(piece[2]), Integer.parseInt(piece[3]),
							Integer.parseInt(piece[4]), Integer.parseInt(piece[5]));
					p.addDate(date);
				}
			}

			for (int i = 0; i < Integer.parseInt(parts[5]); i++) {
				String line = sc.nextLine();
				String[] info = line.split(",");
				HierarchyObjects.activities.put(info[0], new Activity(info[0]));
				for (int j = 1; j < info.length; j++) {
					Place p = HierarchyObjects.places.get(info[j]);
					p.addObjectInside(info[0]);
				}
			}

			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
