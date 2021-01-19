package programmers.kit.bfs_dfs.travelRoute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
	static boolean[] visited;
	static ArrayList<String> answers;
	
	public static void main(String[] args) {
		
		String[][] tickets = {{"ICN", "JFK"}, {"HND, IAD"}, {"JFK, HND"}};
		
		System.out.println("answer: " + Arrays.toString(solution(tickets)));
	}
	
	public static String[] solution(String[][] tickets) {
		visited = new boolean[tickets.length];
		answers = new ArrayList<String>();
		int count = 0;
		dfs(count, "ICN", "ICN", tickets);
		Collections.sort(answers);
		String[] answer = answers.get(0).split(" ");
		
		return answer;
	}
	
	public static void dfs(int count, String present, String answer, String[][] tickets) {
		if(count == tickets.length) {
			answers.add(answer);
			return;
		}
		for(int i = 0; i < tickets.length; i++) {
			if(!visited[i] && tickets[i][0].equals(present)) {
				System.out.println(answer);
				visited[i] = true;
				dfs(count+1, tickets[i][1], answer+" "+tickets[i][1], tickets);
				visited[i] = false;
			}
		}
		return;
	}
}
