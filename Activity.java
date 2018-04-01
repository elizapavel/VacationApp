
/**
 * 
 * @author Pavel Eliza
 *
 *         It's a representation of an activity, which has a name and a place
 *         in which is the cheapest to do this activity.
 */

public class Activity {
	private String name;
	private Place cheapestPlace;

	public Activity(String name) {
		this.name = name;
		HierarchyObjects.activities.put(name, this);
	}

	public String getName() {
		return name;
	}

	public void updatePlace(Place place) {
		this.cheapestPlace = place;
	}

	public Place getPlace() {
		return cheapestPlace;
	}
}
