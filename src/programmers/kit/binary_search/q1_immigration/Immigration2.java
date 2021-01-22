package programmers.kit.binary_search.q1_immigration;

import java.util.Arrays;

// 오답
// 사람마다 가장 빠른 심사대를 찾는다.
// 그리고 끝나는 시간을 반환한다.
public class Immigration2 {

	public static void main(String[] args) {
		
		int n = 6;
		int[] times = {7, 10};
		
		System.out.println("answer: " + solution(n, times));
	}
	
	public static int solution(int n, int[] times) {
		int answer = 0;
		int start = 0;
		int end = times.length - 1;
		int mid = (start + end) / 2;
		int[] remaining = new int[times.length];
		
		
		for(int i = 0; i < n; i++) {
			
			// 가장 빠른 심사대 인덱스
			int min = 0;
			
			// 가장 빨리 끝나는 시간 찾기			
			for(int j = 1; j < remaining.length; j++) {
				if(remaining[j] + times[j] < remaining[min] + times[min]) {
					min = j;
				}
			}
			remaining[min] += times[min];
			
//			System.out.println(remaining[min]);
			if(i == n-1) {
				answer = remaining[min]; 				
			}
		}
		
		return answer;
	}
}
