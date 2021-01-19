package programmers.kit.bfs_dfs.network;

public class Solution {

	public static void main(String[] args) {
		
//		int n = 3;
//		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		//   1 2 3
		// 1 1 1 0
		// 2 1 1 0
		// 3 0 0 1
		
		int n = 9;
		int[][] computers = {
				{0, 1, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 1, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 1, 1, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 1},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		
		System.out.println("answer: " + solution(n, computers));
	}
	
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		
		boolean[] visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			if(visited[i] == false) {
				dfs(i, computers, visited);
				answer++;
			}
		}
		
		return answer;
	}
	
	public static void dfs(int v, int[][] computers, boolean[] visited) {	
		visited[v] = true;
//		System.out.println(v);
		
		for(int i = 0; i < computers.length; i++) {			
			if(computers[v][i] == 1 && visited[i] == false) {
				dfs(i, computers, visited);
			}
		}
	}
}
