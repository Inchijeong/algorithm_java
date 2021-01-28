package programmers.kit.dynamic_programming.q3_back_road;

public class BackRoad {

	public static void main(String[] args) {
		
		int m = 4;
		int n = 3;
		int[][] puddles = {{2, 2}};
		
		System.out.println(solution(m, n, puddles));
		
	}
	
	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		
		int h = 1;
		int v = 1;
		
		getWayCount(h, v, m, n, puddles);
		
		return answer;
	}
	
	// 현재 좌표를 받기
	public static int getWayCount(int h, int v, int m, int n, int[][] puddles) {
		
		// 처음 좌표보다 작으면 종료
		if(h == 1 && v == 1) {
			return 0;
		}
		
		// 현재 위치가 웅덩이인지 확인
		for(int i = 0; i < puddles.length; i++) {
			if(puddles[i][0] == m - 1 && puddles[i][1] == n -1) {
				return 0;
			}
		}
		
		// 웅덩이가 아니라면 왼쪽과 위쪽으로 이동
		int right = getWayCount(h + 1, v, m, n, puddles);
		int bottom = getWayCount(h, v + 1, m, n, puddles);				
		
		return right + bottom + 1;
	}
}
