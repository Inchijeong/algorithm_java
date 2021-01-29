package programmers.kit.graph.q1_farthest_node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FarthestNode {

	public static void main(String[] args) {
		
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		
		System.out.println("answer: " + solution(n, edge));
	}
	
	public static int solution(int n, int[][] edge) {
		int answer = 0;
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		visited[0] = true;
		int level = 1;
		
		while(!queue.isEmpty()) {
			System.out.println("level: "+level);
			int cnt = 0;
			int v = queue.poll();
			
			for(int i = 0; i < edge.length; i++) {
				int cv = edge[i][1];
				if(visited[cv-1] == false && edge[i][0] == v) {
					visited[cv-1] = true;
					queue.offer(cv);
					cnt++;
					System.out.println(cv);
				}
				int cv2 = edge[i][0];
				if(visited[cv2-1] == false && edge[i][1] == v) {
					visited[cv2-1] = true;
					queue.offer(cv2);
					cnt++;
					System.out.println(cv2);
				}
			}
			level++;
			System.out.println("cnt: "+cnt);
			System.out.println();
//			System.out.println("v: "+v);
		}
		return answer;
	}
}
