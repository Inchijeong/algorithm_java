package programmers.kit.binary_search.q2_stepping_stone;

import java.util.Arrays;

public class SteppingStone {

	public static void main(String[] args) {
		
		int distance = 25;
		int[] rocks = {2, 14, 11, 21, 17};
		int n = 2;
		
		System.out.println("answer: " + solution(distance, rocks, n));
	}
	
	public static int solution(int distance, int[] rocks, int n) {
		int answer = 0;
		int start = 0;
		int end = distance;
		// 빼낸돌 개수 기준
		int mid = 0;
		
		Arrays.sort(rocks);
		System.out.println(Arrays.toString(rocks));
		
		int p = 0;
		
//		while(p < 4) {
		while(start <= end) {
			// 뺄수있는 돌의 개수
			int cnt = 0;
			// 이전 돌
			int prev = 0;
			mid = (start + end) / 2;
			System.out.println("mid:" +  mid);
			
			// mid 보다 작은 거리 개수 찾기
			for(int i = 0; i < rocks.length; i++) {
				if(rocks[i] - prev < mid) { // mid 보다 작은 거리를 가짐
					cnt++;
				}else { // mid 보다 큰 거리를 가짐, 현재 돌로 초기화
					prev = rocks[i];
				}
			}
			
			// 마지막이랑 도착점 거리
			if(distance - prev < mid) {
				cnt++;
			}
			
			if(cnt <= n) { // n개 보다 작거나 같은 돌을 빼서 만들수 있음 
				if(mid > answer) {
					answer = mid;
				}
				start = mid + 1;
			}else { // 더 많은 돌을 뺌
				end = mid - 1;
			}
			
			p++;
		}
		
		return answer;
	}
}
