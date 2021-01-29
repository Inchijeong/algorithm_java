package base.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T03Collection {
	public static void main(String[] args) {
		
		List<String> data = new ArrayList<String>();
		
		data.add("Pineapple");
		data.add("Apple");
		data.add("Orange");
		data.add("Banana");
		
		Collections.sort(data);
		
		for(String val: data) {
			System.out.println(val);
		}
		
	}
}
