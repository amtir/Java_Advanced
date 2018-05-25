package module6;

public class BKMenuItem {
	
	protected String name;
	protected String price;
	protected String description;
	protected String calories;
	
	@Override
	public String toString() {
		return "BKMenuItem [name=" + name + ", price=" + price + ", descriptor=" + description + ", calories=" + calories
				+ "]";
	}

}
