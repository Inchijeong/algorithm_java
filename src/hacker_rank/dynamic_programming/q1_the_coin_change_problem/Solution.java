package hacker_rank.dynamic_programming.q1_the_coin_change_problem;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		List<Long> c = new ArrayList<>();
		
//		c.add(1L);
//		c.add(2L);
//		c.add(3L);
//		int n = 4;
		
		c.add(2L);
		c.add(5L);
		c.add(3L);
		c.add(6L);
		int n = 10;
		
		System.out.println("되는 경우 " + coinChange(0, n, c, ""));
	}
	
    public static long coinChange(int ci, long remaining, List<Long> currencies, String paid){
    	
    	if(remaining == 0) {
    		System.out.println(paid);
    		return 1;
    	}
    	if(remaining < 0) {
    		return 0;
    	}
    	
    	int res = 0;
    	for(int i = ci; i < currencies.size(); i++) {
    		
    		res += coinChange(i, remaining - currencies.get(i), currencies,
    				paid + Long.toString(currencies.get(i)) + ",");
    	}
    	return res;
    }
}
