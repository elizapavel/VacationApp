import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author Pavel Eliza
 * 
 *         Class for encapsulating all the other objects. It is used for keeping
 *         the hierarchy sorted.
 *
 */

public class Planet implements BasicDetails {
	private String name;
	private ArrayList<String> countries;
	private double mediumPriceSum = 0;

	public Planet(String name) {
		this.name = name;
		HierarchyObjects.planets.put(name, this);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ArrayList<String> getInsideNames() {
		return countries;
	}

	@Override
	public void addObjectInside(String name) {
		if (countries == null) {
			countries = new ArrayList<>();
		}

		countries.add(name);
	}

	@Override
	public String getUpperName() {
		return null;
	}

	public double getMediumPrice() {
		if (countries == null) {
			return 0;
		}

		mediumPriceSum = 0;
		Country c;
		int nr = 0;
		for (String name : countries) {
			c = HierarchyObjects.countries.get(name);
			if (c.getMediumPrice() > 0) {
				nr++;
				mediumPriceSum += c.getMediumPrice();
			}
		}

		if (nr == 0) {
			return 0;
		}

		return mediumPriceSum / nr;
	}

	public void sort() {
		Comparator<String> c = new Comparator<String>() {
			public int compare(String aStr, String bStr) {
				Country a = HierarchyObjects.countries.get(aStr);
				Country b = HierarchyObjects.countries.get(bStr);
				return (int) (b.getMediumPrice() - a.getMediumPrice());
			}
		};

		countries.sort(c);
	}
}
