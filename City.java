import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author Pavel Eliza
 * 
 *         Class for describing a city, which has: a name, the name of the
 *         district it belongs to, a list of places that can be found in the
 *         city and the medium price, as the medium of every place's price.
 *
 */

public class City implements BasicDetails {
	private String name;
	private String districtName;
	private ArrayList<String> places;
	private double mediumPriceSum = 0;

	public City(String name, String districtName) {
		this.name = name;
		this.districtName = districtName;
		HierarchyObjects.cities.put(name, this);
		HierarchyObjects.districts.get(districtName).addObjectInside(name);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ArrayList<String> getInsideNames() {
		return places;
	}

	@Override
	public void addObjectInside(String name) {
		if (places == null) {
			places = new ArrayList<>();
		}

		places.add(name);
	}

	@Override
	public String getUpperName() {
		return districtName;
	}

	public double getMediumPrice() {
		if (places == null) {
			return 0;
		}

		mediumPriceSum = 0;
		Place p;
		int nr = 0;
		for (String name : places) {
			p = HierarchyObjects.places.get(name);
			if (p.getMediumPrice() > 0) {
				nr++;
				mediumPriceSum += p.getMediumPrice();
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
				Place a = HierarchyObjects.places.get(aStr);
				Place b = HierarchyObjects.places.get(bStr);
				return (int) (b.getMediumPrice() - a.getMediumPrice());
			}
		};

		places.sort(c);
	}
}
