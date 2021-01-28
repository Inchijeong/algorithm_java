package programmers.all;

import java.util.LinkedList;
import java.util.List;

// 숫자 야구
public class NumberBaseball {
	
	public static void main(String[] args) {
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		
		System.out.println(solution(baseball));
	}
	
    public static int solution(int[][] baseball) {
		
        List<String> list = new LinkedList<String>();

        // 후보들 생성
        for(int i = 1; i <= 9; i++) {
        	for(int j = 1; j <= 9; j++) {
        		if(j != i) {
        			for(int k = 1; k <= 9; k++) {
        				if(k != i && k != j) {
        					int num = i * 100 + j * 10 + k;
        					list.add(String.valueOf(num));        
//        					System.out.println(num);
        				}
        			}
        		}
        	}        	
        }
        
        // 시도한 baseball 순회
        for(int i = 0; i < baseball.length; i++) {
        	String tryNum = String.valueOf(baseball[i][0]);
        	
        	// 후보 순회 
        	for(int j = 0; j < list.size(); j++) {
        		String candidate = list.get(j);        		
        		int strike = 0;
        		int ball = 0;
        		
        		// 스크라이크 체크
        		for(int k = 0; k <= 2; k++) {
        			if(tryNum.charAt(k) == candidate.charAt(k)) {
        				strike++;
        			}
        		}
        		        		
        		// 볼 체크
        		for(int k = 0; k <= 2; k++) {
            		for(int l = 0; l <= 2; l++) {
                		if(candidate.equals("137")) {
                			System.out.println("tryNum.charAt(l) : " + tryNum.charAt(l));
                			System.out.println("candidate.charAt(k) :" + candidate.charAt(k));
                		}
            			if(tryNum.charAt(l) == candidate.charAt(k)) {
            				ball++;
            			}
            		}
            		if(candidate.equals("137")) {
            			System.out.println("===");            			
            		}
        		}
        		
        		ball -= strike;
        		
        		if(candidate.equals("137")) {
        			System.out.println("strike : " + strike);
        			System.out.println("ball :" + ball);
        		}
        		
        		// 틀린 후보 제거
        		if(baseball[i][1] != strike || baseball[i][2] != ball) {
            		if(candidate.equals("137")) {
            			System.out.println("제거");
            		}
        			list.remove(j);
        		}
        	}
        }
        
        for(String num : list) {
//        	System.out.println(num);
        }
                
        return list.size();
    }
}
