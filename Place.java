import java.util.ArrayList;

/**
 * 
 * @author Pavel Eliza
 * 
 *         It's an object that describes a place, which has: a name, the name of
 *         the city it belongs to, a medium price per day, a list of available
 *         activities and a list of dates intervals in which the place is
 *         available.
 *
 */

public class Place implements BasicDetails, Visitable {
	private String name;
	private String cityName;
	private double mediumPrice;
	private ArrayList<String> activities;
	private ArrayList<DateInterval> dates;

	public Place(String name, String cityName, double mediumPrice) {
		this.name = name;
		this.cityName = cityName;
		this.mediumPrice = mediumPrice;
		HierarchyObjects.places.put(name, this);
		HierarchyObjects.cities.get(cityName).addObjectInside(name);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ArrayList<String> getInsideNames() {
		return activities;
	}

	@Override
	public void addObjectInside(String name) {
		if (activities == null) {
			activities = new ArrayList<>();
		}

		activities.add(name);
		updateActivity(name);
	}
	
	public void updateActivity(String name) {
		Activity a = HierarchyObjects.activities.get(name);
		
		if (a.getPlace() == null) {
			a.updatePlace(this);
		} else if (a.getPlace().getMediumPrice() > mediumPrice) {
			a.updatePlace(this);
		}		
	}

	@Override
	public String getUpperName() {
		return cityName;
	}

	public void addDate(DateInterval date) {
		if (dates == null) {
			dates = new ArrayList<>();
		}
		
		dates.add(date);
	}
	
	public ArrayList<DateInterval> getDates() {
		return dates;
	}

	public double getMediumPrice() {
		return mediumPrice;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
