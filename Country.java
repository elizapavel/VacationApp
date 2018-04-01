import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author Pavel Eliza
 * 
 *         Class for describing a country, which has: a name, the name of the
 *         planet it belongs to, a list of districts that can be found in the
 *         district and the medium price, as the medium of every district's price.
 *
 */

public class Country implements BasicDetails{
	private String name;
	private String planetName;
	private ArrayList<String> districts;
	private double mediumPriceSum = 0;
	
	public Country(String name, String planetName) {
		this.name = name;
		this.planetName = planetName;
		HierarchyObjects.countries.put(name, this);
		HierarchyObjects.planets.get(planetName).addObjectInside(name);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public ArrayList<String> getInsideNames() {
		return districts;
	}

	@Override
	public void addObjectInside(String name) {
		if (districts == null) {
			districts = new ArrayList<>();
		}
		
		districts.add(name);
	}

	@Override
	public String getUpperName() {
		return planetName;
	}
	
	public double getMediumPrice() {
		if (districts == null) {
			return 0;
		}
		
		mediumPriceSum = 0;
		District d;
		int nr = 0;
		for (String name : districts) {
			d = HierarchyObjects.districts.get(name);
			if (d.getMediumPrice() > 0) {
				nr++;
				mediumPriceSum += d.getMediumPrice();
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
				District a = HierarchyObjects.districts.get(aStr);
				District b = HierarchyObjects.districts.get(bStr);
				return (int)(b.getMediumPrice() - a.getMediumPrice());
			}
		};
		
		districts.sort(c);
	}
}
