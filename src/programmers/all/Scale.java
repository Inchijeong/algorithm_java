package programmers.all;

import java.util.Arrays;

// 저울
public class Scale {

	public static void main(String[] args) {
		int[] weight = {3, 1, 6, 2, 7, 30, 1};
		
		System.out.println(solution(weight));
	}
	
	public static int solution(int[] weight) {
		int answer = 0;
		int len = weight.length;
				
		Arrays.sort(weight);
		
//		for(int i = len - 1; i >= 0 ; i--) {
//			System.out.println(weight[i]);
//		}
		
		int obj = 1;
		boolean isCircuit = true;
		
		while(isCircuit) {
//			System.out.println(obj);
			
			int o = obj; 
			
			for(int i = len - 1; i >= 0 ; i--) {
				int w = weight[i];
				
//				System.out.println(w);
				
				// 가장 큰 추 부터 빼준다
				if(o >= w) {
					o -= w;
				}
				
				// 측정 할 수 있는 무게
				if(o == 0) {
					break;
				}
			}
			// 측정 할 수 없는 무게			
			if(o > 0) {
				isCircuit = false;
				answer = obj;
			}
			obj++;
		}
		
		return answer;
	}
}
