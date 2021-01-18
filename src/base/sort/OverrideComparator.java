package base.sort;

import java.util.Arrays;
import java.util.Comparator;

public class OverrideComparator {
	public static void main(String[] args) {
		
//		Integer[] arr = new Integer[5];
//		
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = i;
//		}
		
		Integer[] arr = {2, 1, 3, 5, 6};
		
        Arrays.sort(arr, new Comparator<Integer>() {
        	@Override
        	public int compare(Integer i1, Integer i2) {
        		
        		int res = 0;
        		
        		// 오름차순
        		if(i1 > i2) {
        			res = 1;
        		}else if(i1 < i2) {
        			res = -1;
        		}
        		
        		return res;
        	}
        });
        
        System.out.println(Arrays.toString(arr));
        
	}
}
