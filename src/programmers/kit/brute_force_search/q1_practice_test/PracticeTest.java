package programmers.kit.brute_force_search.q1_practice_test;

import java.util.ArrayList;
import java.util.List;

public class PracticeTest {

	public static void main(String[] args) {
		
//		int[] answers = {1, 2, 3, 4, 5, 6};
		int[] answers = {1, 3, 2, 4, 2};
		
		solution(answers);
		
	}
	
    public static int[] solution(int[] answers) {
        int len = answers.length;
        int first = 0;
        int[] firstdPick = {1, 2, 3, 4, 5};
        int second = 0;
        int[] secondPick = {2, 1, 2, 3, 2, 4, 2, 5};
        int third = 0;
        int[] thirdPick = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i = 0; i < len; i++) {
        	
        	int ans = answers[i];
        	
        	System.out.println("i번 문제 답 : " + ans);
        	
        	// 1번 수포자
//        	if(ans == i % 5 + 1) {
//        		System.out.println("1번 수포자 정답");
//        		first++;
//        	}
        	// 1번 수포자
        	if(ans == firstdPick[i % 5]) {
        		first++;
//        		System.out.println("2번 수포자 정답");
        	}
        	
        	// 2번 수포자
        	if(ans == secondPick[i % 8]) {
        		second++;
//        		System.out.println("2번 수포자 정답");
        	}
        	
        	// 3번 수포자
        	if(ans == thirdPick[i % 10]) {
        		third++;
//        		System.out.println("3번 수포자 정답");
        	}
        	
//        	System.out.println("=========================");
        }
        
        int[] cntArr = {first, second, third};
        
        int max = first;
        
        for(int cnt : cntArr) {
        	if(cnt > max) {
        		max = cnt;
        	}
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < cntArr.length; i++) {
        	if(max == cntArr[i]) {
        		list.add(i+1);
        	}
        }
        
        if(max == 0) {
        	return new int[0];
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}
