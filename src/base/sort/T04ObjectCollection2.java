package base.sort;

import java.util.Arrays;
import java.util.Comparator;

public class T04ObjectCollection2 {

	public static void main(String[] args) {
		
		Fruit[] fruits = new Fruit[4];
		
		fruits[0] = new Fruit("Pineapple", 70);
		fruits[1] = new Fruit("Apple", 50);
		fruits[2] = new Fruit("Orange", 60);
		fruits[3] = new Fruit("Banana", 30);
		
		for(Fruit fruit : fruits) {
			System.out.print(fruit.name);
			System.out.println(", " + fruit.quantity);
		}		
		
		System.out.println("-----------------");
		
		// Collections ����
//		Arrays.sort(fruits, nameComparator);
//		Arrays.sort(fruits, quantComparator);
		
		for(Fruit fruit : fruits) {
			System.out.print(fruit.name);
			System.out.println(", " + fruit.quantity);
		}
		
	}
	
}

class Fruit2 implements Comparable<Fruit>{
	public String name;
	public int quantity;
	
	public Fruit2(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public int compareTo(Fruit fruit) {
		return name.compareTo(fruit.name);
	}
	
	public static Comparator<Fruit2> nameComparator = new Comparator<Fruit2>(){
		public int compare(Fruit2 fruit1, Fruit2 fruit2) {
			return fruit1.name.compareTo(fruit2.name);
		}
	};
	
	public static Comparator<Fruit2> quantComparator = new Comparator<Fruit2>(){
		public int compare(Fruit2 fruit1, Fruit2 fruit2) {
			return fruit1.quantity - fruit2.quantity;
		}
	};	
}