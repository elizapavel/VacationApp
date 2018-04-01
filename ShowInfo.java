
/**
 * 
 * @author Pavel Eliza
 *
 *         Shows details about an object
 */

public class ShowInfo implements Visitor {

	@Override
	public void visit(Place p) {
		System.out.println("Name: " + p.getName() + " from: " + p.getUpperName());
		System.out.println("Medium price: " + p.getMediumPrice());
		System.out.print("Activities: ");
		for (String activityName : p.getInsideNames()) {
			System.out.print(activityName + " ");
		}
		System.out.print("\nAvailable dates: ");
		for (DateInterval date : p.getDates()) {
			System.out.print("[" + date.getStart() + " " + date.getEnd() + "] ");
		}
		System.out.println();
	}

	@Override
	public void visit(City c) {
		System.out.println("Name: " + c.getName() + " from: " + c.getUpperName());
		System.out.println("Medium price: " + c.getMediumPrice());
		System.out.print("Places: ");
		for (String placeName : c.getInsideNames()) {
			System.out.print(placeName + " ");
		}
		System.out.println();
	}

	@Override
	public void visit(District d) {
		System.out.println("Name: " + d.getName() + " from: " + d.getUpperName());
		System.out.println("Medium price: " + d.getMediumPrice());
		System.out.print("Cities: ");
		for (String cityName : d.getInsideNames()) {
			System.out.print(cityName + " ");
		}
		System.out.println();
	}

	@Override
	public void visit(Country c) {
		System.out.println("Name: " + c.getName() + " from: " + c.getUpperName());
		System.out.println("Medium price: " + c.getMediumPrice());
		System.out.print("Districts: ");
		for (String districtName : c.getInsideNames()) {
			System.out.print(districtName + " ");
		}
		System.out.println();
	}

	@Override
	public void visit(Planet p) {
		System.out.println("Name: " + p.getName());
		System.out.println("Medium price: " + p.getMediumPrice());
		System.out.print("Countries: ");
		for (String countryName : p.getInsideNames()) {
			System.out.print(countryName + " ");
		}
		System.out.println();
	}

}
