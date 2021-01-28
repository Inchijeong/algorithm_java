package programmers.kit.sort.q2_largest_number;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	
	public static void main(String[] args) {
		
		int[] numbers = {6, 10, 2};
//		int[] numbers = {3, 30, 34, 5, 9};
		
		System.out.println(solution(numbers));
		
	}
	
    public static String solution(int[] numbers) {
        String answer = "";      
        int len = numbers.length;        
        Integer[] WrapperNumbers = new Integer[numbers.length]; 
        boolean zero = true;
        
        for(int i = 0; i < len; i++) {
        	int num = numbers[i];
        	WrapperNumbers[i] = num;
        	if(num > 0) {
        		zero = false;
        	}
        }
        
        if(zero) {
        	return "0";
        }
        
        Arrays.sort(WrapperNumbers, new Comparator<Integer>() {
        	@Override
        	public int compare(Integer i1, Integer i2) {
        		int num1 = Integer.parseInt(""+i1+i2);
        		int num2 = Integer.parseInt(""+i2+i1);
        		int res = 0;
        		if(num2 > num1) {
        			res = 1;
        		}else if(num1 > num2) {
        			res = -1;
        		}
        		return res;
        	}
        });
        
        for(int i = 0; i < len; i++) {
        	answer += WrapperNumbers[i];
        }
        
        return answer;
    }
}
