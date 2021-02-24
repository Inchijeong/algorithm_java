package programmers.kit.graph.q1_farthest_node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FarthestNode3 {

	public static void main(String[] args) {
		
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		
		System.out.println("answer: " + solution(n, edge));
	}
	
	// 인덱스와 정점의 번호를 같게함
	public static int solution(int n, int[][] edge) {
		int answer = 0;
		// 방문 및 레벨 체크
		int[] visited = new int[n+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		visited[1] = 1;
		int max = 0;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
//			System.out.println("v: "+v);
//			System.out.println("max: "+max);
//			System.out.println("visited[v]: "+visited[v]);
			if(visited[v] > max) {
				max = visited[v]; 
			}else if(visited[v] == max){
//				answer++;
			}
			
			for(int i = 0; i < edge.length; i++) {
				int cv = edge[i][1];
				if(visited[cv] == 0 && edge[i][0] == v) {
					visited[cv] = visited[v] + 1;
					queue.offer(cv);
//					System.out.println(cv);
				}
				int cv2 = edge[i][0];
				if(visited[cv2] == 0 && edge[i][1] == v) {
					visited[cv2] = visited[v] + 1;
					queue.offer(cv2);
//					System.out.println(cv2);
				}
			}
		}
//		System.out.println(Arrays.toString(visited));
//		System.out.println(max);
		
		for(int i = 0; i < visited.length; i++) {
			if(visited[visited.length-i-1] == max) {
				answer++;
			}
		}
		
		return answer;
	}
}
