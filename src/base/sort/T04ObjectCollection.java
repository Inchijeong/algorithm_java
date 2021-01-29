package base.sort;

import java.util.Arrays;

public class T04ObjectCollection {

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
		Arrays.sort(fruits);
		
		for(Fruit fruit : fruits) {
			System.out.print(fruit.name);
			System.out.println(", " + fruit.quantity);
		}
		
	}
	
}

class Fruit implements Comparable<Fruit>{
	public String name;
	public int quantity;
	
	public Fruit(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	// A.compareTo(B)
	// �� ���ڿ��� ���ϰ� int�� ���� ��ȯ�ϴ� �޼ҵ�
	// A �� B�� ������ 0�� ��ȯ
	// A�� ũ�� ���
	// B�� ũ�� ����
	
//	public int compareTo(Fruit fruit) {
//		return name.compareTo(fruit.name);
//	}
	
	// ��������
	// this �� > other �� = 1 �ڸ��ٲ� 
//	public int compareTo(Fruit fruit) {
//		if(this.quantity > fruit.quantity) {
//			return 1;
//		}else if(this.quantity < fruit.quantity) {
//			return -1;
//		}else {
//			return 0;
//		}
//	}
	
	// ��������
	// other �� > this ��  = 1 �ڸ��ٲ� 
	public int compareTo(Fruit fruit) {
		if(this.quantity > fruit.quantity) {
			return 1;
		}else if(this.quantity < fruit.quantity) {
			return -1;
		}else {
			return 0;
		}
	}
	
}