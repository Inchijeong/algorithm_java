package programmers.kit.brute_force_search.q2_find_prime_numbers;

import java.util.HashSet;

public class FindPrimeNumbers {
	
	public static void main(String[] args) {
		
		String numbers = "117";
		
		int answer = solution(numbers);
		
		System.out.println(answer);
	}
	
    public static int solution(String numbers) {
        int answer = 0;
        int len = numbers.length();
        int n = len;
        
        String[] strArr = numbers.split("");
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i = 1; i <= len; i++) {
        	permutation(strArr, 0, n, i, set);
        }
        
        // 0, 1 제거
        set.remove(0);
        set.remove(1);
        
        for(int num : set) {
        	System.out.println(num);
        	boolean isPrime = false;
        	
        	for(int i = 2; i < num; i++) {
        		// 소수가 아니라면
        		if(num % i == 0) {
        			isPrime = true;
        			break;
        		}
        	}
        	if(!isPrime) {
        		answer++;
        	}        	
        }
        
        return answer;
    }
    
    static void permutation(String[] arr, int depth, int n, int r, HashSet<Integer> set) {
        if (depth == r) {
//            print(arr, r);
            String str = "";
            for (int i = 0; i < r; i++) {
            	str += arr[i];
            }            
            int num = Integer.parseInt(str);
//            System.out.println(num);
            set.add(num);
            
            return;
        }
     
        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r, set);
            swap(arr, depth, i);
        }
    }
     
    static void swap(String[] arr, int depth, int i) {
    	String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    
    static void print(String[] arr, int r) {
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
