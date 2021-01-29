package base.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T05Comparator {

	public static void main(String[] args) {
		
		class nameLengthCompare implements Comparator<Person>{
			
			@Override
			public int compare(Person p1, Person p2) {
				
				return p1.name.length() > p2.name.length() ? 1
						: p1.name.length() < p2.name.length() ? -1 : 0;
			}
			
		}
		
		List<Person> nameList = new ArrayList<>();
		
		nameList.add(new Person("Hwang", 28));
		nameList.add(new Person("Lee", 24));
		nameList.add(new Person("Choi", 26));
		
		for(Person person : nameList) {
			System.out.print(person.name);
			System.out.println(", " + person.age);
		}
		
		System.out.println("-----------------");
		
		Collections.sort(nameList, new nameLengthCompare());

		for(Person person : nameList) {
			System.out.print(person.name);
			System.out.println(", " + person.age);
		}
		
	}
	
}

class Person {
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
