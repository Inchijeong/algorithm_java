package base.sort;

import java.util.Arrays;

public class T01Primitive {
	public static void main(String[] args) {
		
		int[] data = new int[5];
		
		data[0] = 3;
		data[1] = 4;
		data[2] = 5;
		data[3] = 1;
		data[4] = 2;
		
		Arrays.sort(data);
		
		System.out.println(Arrays.toString(data));
		
	}
}
