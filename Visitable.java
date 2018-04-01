
public interface Visitable {
	public void accept(Visitor v);
}

interface Visitor {
	public void visit(Place p);
	public void visit(City c);
	public void visit(District d);
	public void visit(Country c);
	public void visit(Planet p);
}