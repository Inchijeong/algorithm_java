package base.bfs.scanner;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
입력
------------------
9 10 0
0 1
1 2
1 3
2 4
2 3
3 4
3 5
5 6
5 7
6 8
------------------
출력
------------------
BFS(0) - 인접리스트 / 큐로 구현
0 1 2 3 4 5 6 7 8 
------------------
*/

public class BFSListScanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 정점의 개수
		int m = sc.nextInt(); // 간선의 개수
		int v = sc.nextInt(); // 탐색을 시작할 정점의 번호
		
		boolean visited[] = new boolean[n]; // 방문 여부를 검사할 배열
		LinkedList<Integer>[] adjList = new LinkedList[n]; // 관계를 표현할 인접리스트
		
		// 인접리스트 정점의 개수만큼 생성
		for(int i = 0; i < n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		// 간선 추가
		// 인덱스와 값이 같다고 가정
		for(int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjList[v1].add(v2);
		}
		
		System.out.println("BFS("+v+") - 인접리스트 / 큐로 구현");
		bfsList(v, adjList, visited);
		
		sc.close();
	}	
	
	// DFS - 인접리스트 - 큐로 구현
	public static void bfsList(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(v);
		visited[v] = true; // 정점 방문 표시
		
		while(!queue.isEmpty()) {
			int w = queue.poll(); // 큐에서 정점을 하나 꺼냄
			for(int adv : adjList[w]) { // 꺼낸 정점과 인접한 정점 찾기
				if(visited[adv] == false) { // 방문하지 않은 정점이라면
					visited[adv] = true; // 방문 표시
					queue.offer(adv); // 큐에 추가
				}
			}
			System.out.print(w + " "); // 정점 출력
		}
	}
}
