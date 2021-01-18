package base.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

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
DFSR(0) - 인접리스트 / 재귀로 구현
0 1 2 4 3 5 6 8 7 
DFS(0) - 인접리스트 / 스택으로 구현
0 1 3 5 7 6 8 4 2
------------------
*/

public class DFSList {
	public static void main(String[] args) {
		
		int n = 9; // 정점의 개수
		int v = 0; // 탐색을 시작할 정점의 번호
		
		boolean visited[] = new boolean[n]; // 방문 여부를 검사할 배열
		LinkedList<Integer>[] adjList = new LinkedList[n]; // 관계를 표현할 인접리스트
		
		// 인접리스트 정점의 개수만큼 생성
		for(int i = 0; i < n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		// 간선 추가
		// 인덱스와 값이 같다고 가정
		adjList[0].add(1);
		adjList[1].add(2);
		adjList[1].add(3);
		adjList[2].add(4);
		adjList[2].add(3);
		adjList[3].add(4);
		adjList[3].add(5);
		adjList[5].add(6);
		adjList[5].add(7);
		adjList[6].add(8);
		
		System.out.println("DFSR("+v+") - 인접리스트 / 재귀로 구현");
		dfsListRecursion(0, adjList, visited);
		
		// 방문 배열 초기화
		Arrays.fill(visited, false);
		
		System.out.println();
		System.out.println("DFS("+v+") - 인접리스트 / 스택으로 구현");
		dfsListStack(0, adjList, visited);
	}	
	
	// DFS - 인접리스트 - 재귀로 구현
	public static void dfsListRecursion(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		visited[v] = true; // 정점 방문 표시
		System.out.print(v + " "); // 정점 출력
		
		for(int w : adjList[v]) { // 꺼낸 정점과 인접한 정점 찾기
			if(visited[w] == false) { // 방문하지 않은 정점이라면
				dfsListRecursion(w, adjList, visited); // 다시 DFS
			}
		}
	}
	
	// DFS - 인접리스트 - 스택으로 구현
	public static void dfsListStack(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(v);
		visited[v] = true; // 정점 방문 표시
		
		while(!stack.isEmpty()) {
			int w = stack.pop(); // 스택에서 정점을 하나 꺼냄
			for(int adv : adjList[w]) { // 꺼낸 정점과 인접한 정점 찾기
				if(visited[adv] == false) { // 방문하지 않은 정점이라면
					visited[adv] = true; // 방문 표시
					stack.push(adv); // 스택에 추가
				}
			}
			System.out.print(w + " "); // 정점 출력
		}
	}
}
