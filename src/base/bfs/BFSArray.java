package base.bfs;

import java.util.LinkedList;
import java.util.Queue;


/*
------------------
 0
/
1 -- 3    7
│  / │ \ /
│ /  │  5
2 -- 4   \
          6 - 8
------------------
출력
------------------
BFS(0) - 인접행렬 / 큐로 구현
0 1 2 3 4 5 6 7 8 
------------------
*/
public class BFSArray {
	public static void main(String[] args) {
		
		int n = 9; // 정점의 개수
		int v = 0; // 탐색을 시작할 정점의 번호
		
		boolean visited[] = new boolean[n]; // 방문 여부를 검사할 배열		
		
		// 관계를 표현할 인접 행렬
		// 간선 추가
		// 인덱스와 값이 같다고 가정
		int[][] adjArray = {
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
		
		System.out.println("BFS("+v+") - 인접행렬 / 큐로 구현");
		bfsArray(v, adjArray, visited);
	}
	
	// BFS - 인접행렬 / 큐로 구현
	public static void bfsArray(int v, int[][] adjArray, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(v);
		visited[v] = true; // 정점 방문 표시
		
		while(!queue.isEmpty()) {
			int w = queue.poll(); // 큐에서 정점을 하나 꺼냄
			for(int i = 0; i < adjArray.length; i++) { // 꺼낸 정점과 인접한 정점 찾기
				if(adjArray[w][i] == 1 && visited[i] == false) { // 방문하지 않은 정점이라면
					visited[i] = true; // 방문 표시
					queue.offer(i); // 큐에 추가
				}
			}
			System.out.print(w + " "); // 정점 출력
		}
	}
}
