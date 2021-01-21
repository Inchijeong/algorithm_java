package programmers.kit.bfs_dfs.travel_route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// DFS
public class TravelRouteDFS {
	static boolean[] visited;
	static ArrayList<String> answers = new ArrayList<>();
	
	public static void main(String[] args) {
		
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		
		System.out.println("answer: " + Arrays.toString(solution(tickets)));
	}
	
	public static String[] solution(String[][] tickets) {		
		// 방문 체크
		visited = new boolean[tickets.length];
		// 시작 공항
		String origin = "ICN";
		// 전체 티켓 수
		int n = tickets.length;
		// 사용한 티켓의 수
		int count = 0;
		
		dfs(tickets, origin, count, n, origin);
		// 알파벳 순서로 뽑기 위해 정렬
		Collections.sort(answers);
		// 가장 먼저인 경로를 배열로 변환
		String[] answer = answers.get(0).split(" ");
		
		return answer;
	}
	
	public static void dfs(String[][] tickets, String origin, int count, int n, String ans) {

		System.out.println(origin);
		if(count == n) {
			System.out.println("모든 티켓 사용");
			System.out.println(ans);
			answers.add(ans);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i] && tickets[i][0].equals(origin)) {
				String dest = tickets[i][1];
				visited[i] = true;
				dfs(tickets, dest, count+1, n, ans + " " + dest);
				visited[i] = false; // 다른 티켓을 찾을때 방문을 초기화하기 위함
			}
		}
	}
}
