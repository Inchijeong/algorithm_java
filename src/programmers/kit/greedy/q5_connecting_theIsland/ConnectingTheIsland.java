package programmers.kit.greedy.q5_connecting_theIsland;

import java.util.Arrays;

public class ConnectingTheIsland {

	public static void main(String[] args) {
	
		int n = 4;
		int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
		
		System.out.println(solution(n, costs));
		
	}
	
	public static int solution(int n, int[][] costs) {
		int answer = 0;
		
		Arrays.sort(costs, (o1, o2) -> {
			return Integer.compare(o1[2], o2[2]);
		});
		
		// for(int[] c : costs) {
		// 	System.out.println(c[2]);
		// }
		
		return answer;
	}
}
