package module6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class SerializationDemo {

	public static void store(List<Person> list, String filename) throws FileNotFoundException, IOException {
		try (ObjectOutputStream outstream = new ObjectOutputStream(new FileOutputStream(filename));) {
			outstream.writeObject(list);
		}
	}

	public static List<Person> load(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectInputStream instream = new ObjectInputStream(new FileInputStream(filename));) {
			return (List<Person>) instream.readObject();
		}
	}

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Usage: Java module Serialization file_name mode (store or load) ");
			System.exit(-1);
		}

		Person p1 = new Person("Karl Pearson", new Integer(36), "UK");
		Person p2 = new Person("John Tukez", new Integer(45), "USA");
		Person p3 = new Person("Akram MTir", new Integer(45), "TN");
		Person p4 = new Person("David Smith", new Integer(35), "FR");

		Vector<Person> inList = new Vector<Person>();
		inList.add(p1);
		inList.add(p2);
		inList.add(p3);
		inList.add(p4);

		try {
			if ("store".equalsIgnoreCase(args[1])) {
				SerializationDemo.store(inList, args[0]);
				System.out.println("Objects stored.");
			} else if ("load".equalsIgnoreCase(args[1])) {
				List<Person> outList = SerializationDemo.load(args[0]);

				for (Person p : outList)
					System.out.println(p.toString());
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class Person implements Serializable {

	private static final long serialVersionUID = -4756619175145079158L;

	protected String name = null;
	protected Integer age = null;

	protected transient String location = null;

	public Person() {
	}

	public Person(String name, Integer age, String location) {
		this.name = name;
		this.age = age;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", location=" + location + "]";
	}

}
