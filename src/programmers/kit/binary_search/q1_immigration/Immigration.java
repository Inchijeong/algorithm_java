package programmers.kit.binary_search.q1_immigration;

import java.util.Arrays;

public class Immigration {

	public static void main(String[] args) {
		
		int n = 6;
		int[] times = {7, 10};
		
		System.out.println("answer: " + solution(n, times));
	}
	
	public static long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
		long start = 0;
		long end = 0;
		long mid = 0;
		
		// 최대 시간 - 가장 오래걸리는 심사대만 이용할 경우 
		for(int time : times) {
			if(time > end) {
				end = time;
			}
		}
		end *= n;
		
		while(start <= end) {
			// 판단이 대상이 될 시간
			mid = (start + end) / 2;
			
			long cnt = 0;
			for(int t : times) {				
				cnt += mid / t;
			}			
//			System.out.println("cnt: " + cnt);
			
			if(cnt < n) { // 해당 시간 안에 받을 수 있는 사람은 n명 보다 적다.
				start = mid + 1;
			}else { // 해당 시간 안에 받을 수 있는 사람은 n명 보다 많거나 같다.
				// 시간들중에 최소 시간 구하기
				if(mid < answer) {
//					System.out.println("mid: " + mid);
					answer = mid;
				}				
				end = mid - 1;				
			}
		}
		
		return answer;
	}
}
