package base;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
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
8 10 0
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
0 1 2 3 4 5 6 8 7
------------------
*/

public class DFSList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 정점의 개수
		int m = sc.nextInt(); // 간선의 개수
		int v = sc.nextInt(); // 탐색을 시작할 정점의 번호
		
		boolean visited[] = new boolean[n+1]; // 방문 여부를 검사할 배열
		
		LinkedList<Integer>[] adjList = new LinkedList[n+1];
		
		for(int i = 0; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		// 두 정점 사이에 여러 개의 간선이 있을 수 있다.
		// 입력으로 주어지는 간선은 양방향이다.
		for(int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		
		for(int i = 1; i <= n; i++) {
			Collections.sort(adjList[i]);
		}
		
		System.out.println("DFS - 인접리스트");
		dfsListIter(v, adjList, visited);
//		dfsListFor(v, adjList, visited);
	}
	
	// DFS - 인접리스트 - 재귀로 구현 - Iterator 이용
	public static void dfsListIter(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		visited[v] = true; // 정점 방문 표시
		System.out.print(v + " "); // 정점 출력
		
		Iterator<Integer> iter = adjList[v].listIterator(); // 정점 인접리스트 순회
		while(iter.hasNext()) {
			int w = iter.next();
			if(!visited[w]) { // 방문하지 않은 점점이라면
				dfsListIter(w, adjList, visited); // 다시 DFS
			}
		}
	}
	
	// DFS - 인접리스트 - 재귀로 구현 - For문 이용
	public static void dfsListFor(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		visited[v] = true; // 정점 방문 표시
		System.out.print(v + " "); // 정점 출력
		
		for(int w : adjList[v]) { // 정점 인접리스트 순회
			if(!visited[w]) { // 방문하지 않은 점점이라면
				dfsListFor(w, adjList, visited); // 다시 DFS
			}
		}		
	}
	
}
