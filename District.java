import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author Pavel Eliza
 * 
 *         Class for describing a district, which has: a name, the name of the
 *         country it belongs to, a list of cities that can be found in the
 *         district and the medium price, as the medium of every city's price.
 *
 */

public class District implements BasicDetails {
	private String name;
	private String countryName;
	private ArrayList<String> cities;
	private double mediumPriceSum = 0;
	
	public District(String name, String countryName) {
		this.name = name;
		this.countryName = countryName;
		HierarchyObjects.districts.put(name, this);
		HierarchyObjects.countries.get(countryName).addObjectInside(name);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public ArrayList<String> getInsideNames() {
		return cities;
	}

	@Override
	public void addObjectInside(String name) {
		if (cities == null) {
			cities = new ArrayList<>();
		}
		
		cities.add(name);
	}

	@Override
	public String getUpperName() {
		return countryName;
	}
	
	public double getMediumPrice() {
		if (cities == null) {
			return 0;
		}
		
		mediumPriceSum = 0;
		City c;
		int nr = 0;
		for (String name : cities) {
			c = HierarchyObjects.cities.get(name);
			if (c.getMediumPrice() > 0) {
				nr++;
				mediumPriceSum += c.getMediumPrice();
			}
		}
		
		if (nr == 0) {
			return 0;
		}
		
		return mediumPriceSum/nr;
	}

	public void sort() {
		Comparator<String> c = new Comparator<String>() {
			public int compare(String aStr, String bStr) {
				City a = HierarchyObjects.cities.get(aStr);
				City b = HierarchyObjects.cities.get(bStr);
				return (int)(b.getMediumPrice() - a.getMediumPrice());
			}
		};
		
		cities.sort(c);
	}

}
