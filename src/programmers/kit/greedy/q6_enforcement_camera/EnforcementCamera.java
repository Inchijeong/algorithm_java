package programmers.kit.greedy.q6_enforcement_camera;

public class EnforcementCamera {

	public static void main(String[] args) {
		int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
		
		System.out.println(solution(routes));
	}
	
	public static int solution(int[][] routes) {
		int answer = 0;
		int len = routes.length;
		int start = routes[0][0];
		int end = routes[0][1];
		
		for(int i = 0; i < len; i++) {
			if(routes[i][0] >= start) {
				start = routes[i][0];
			}
			if(routes[i][1] <= end) {
				end = routes[i][1];
			}
		}
		
		System.out.println("start : " + start);
		System.out.println("end : " + end);
		
		return answer;
	}
}
