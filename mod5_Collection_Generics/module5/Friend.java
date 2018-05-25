package module5;

public class Friend implements Comparable<Friend>{
	private String name;
	private Integer age;
	private String location;
	public Friend(String name, Integer age, String location) {
		this.name = name;
		this.age = age;
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Friend [name=" + name + ", age=" + age + ", location=" + location + "]";
	}
// 	Integer and String implement both the comparable interface.
	public  <T extends String, S extends Integer> boolean friendFinder(T t, S s){
		if ( (t.equals(this.getName()) && s == this.getAge())    )
			return true;
		else 
			return false;
	}
	
	public  <T extends String, S extends String> boolean friendFinder(T t, S s){
		if ( (t.equals(this.getName()) && s.equals(this.getLocation() )    ) )
			return true;
		else 
			return false;
	}

@Override
public int compareTo(Friend fr) {
	// If friend object are equal they should have the same name, age and location
	if ( (fr.getName().equals(this.getName()) && fr.getAge() == this.getAge()  &&  fr.getLocation() == this.getLocation() )    )
		return 0;
	else if ( this.getAge() > fr.getAge()   ) // compare age to sort
		return 1;
	else
		return -1;
}
	

}
