package module5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FriendshipCriteria {
	public static void main(String[] args) {
		// Criteria 
		String name = "Bob";
		Integer age = 25;
		String location = "Paris";
		Friend f = new Friend(name, age, location );
		// List of Friend Object
		List<Friend> list = new ArrayList<Friend>();
		list.add(new Friend("Bob", 25, "Paris"));
		list.add(new Friend("Tom", 35, "London"));
		list.add(new Friend("Alice", 45, "Madrid"));
		list.add(new Friend("Peter", 50, "Berlin"));
		list.add(new Friend("Bob", 25, "New York"));
		list.add(new Friend("Alex", 35, "London"));
		list.add(new Friend("David", 45, "Madrid"));
		list.add(new Friend("Bob", 55, "Paris"));
		list.add(new Friend("Sandy", 50, "Berlin"));
		// Printing the list of friends
		System.out.println("list of friend");
		for(Friend fr : list) {
			System.out.println("Another friend : " + fr);
		}
		// Sorting the list
		Collections.sort(list);
		// Printing the list sorted by age 
		System.out.println("");
		System.out.println("list of friend sorted by age: ");
		for(Friend fr : list) {
			System.out.println("Another friend : " + fr);
		}
		
		System.out.println("------");  System.out.println("Friends based on name and age: ");
		for(Friend fr : list) {
			
		if ( fr.friendFinder(name, age) ) // if ( fr.equals() ) 
				System.out.println("Found a friend for you : " + fr);
		}
		
		System.out.println("------");  System.out.println("Friends based on name and location: ");
		for(Friend fr : list) {
			
		if ( fr.friendFinder(name, location) ) // if ( fr.equals() ) 
				System.out.println("Found a friend for you : " + fr);
		}
		
	}
}
