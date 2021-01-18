package base.dfs.scanner;

import java.util.Arrays;
import java.util.Scanner;
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
DFSR(0) - 인접행렬 / 재귀로 구현
0 1 2 3 4 5 6 8 7 
DFS(0) - 인접행렬 / 스택으로 구현
0 1 3 5 7 6 8 4 2 
------------------
*/
public class DFSArrayScanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 정점의 개수
		int m = sc.nextInt(); // 간선의 개수
		int v = sc.nextInt(); // 탐색을 시작할 정점의 번호
		
		boolean visited[] = new boolean[n]; // 방문 여부를 검사할 배열		
		int[][] adjArray = new int[n][n]; // 관계를 표현할 인접 행렬
		
		// 간선 추가
		// 인덱스와 값이 같다고 가정
		for(int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjArray[v1][v2] = 1;
			adjArray[v2][v1] = 1;
		}
		
		System.out.println("DFSR("+v+") - 인접행렬 / 재귀로 구현");
		dfsArrayRecursion(v, adjArray, visited);
		
		// 방문 배열 초기화
		Arrays.fill(visited, false);
		
		System.out.println();
		System.out.println("DFS("+v+") - 인접행렬 / 스택으로 구현");
		dfsArrayStack(v, adjArray, visited);
		
		sc.close();
	}
	
	// DFS - 인접행렬 / 재귀로 구현
	public static void dfsArrayRecursion(int v, int[][] adjArray, boolean[] visited) {
		visited[v] = true; // 정점 방문 표시
		System.out.print(v + " "); // 정점 출력
		
		for(int i = 0; i < adjArray.length; i++) { // 꺼낸 정점과 인접한 정점 찾기
			if(adjArray[v][i] == 1 && visited[i] == false) { // 방문하지 않은 정점이라면
				dfsArrayRecursion(i, adjArray, visited); // 다시 DFS
			}
		}
	}
	
	// DFS - 인접행렬 / 스택으로 구현
	public static void dfsArrayStack(int v, int[][] adjArray, boolean[] visited) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(v);
		visited[v] = true; // 정점 방문 표시
		
		while(!stack.isEmpty()) {
			int w = stack.pop(); // 스택에서 정점을 하나 꺼냄
			for(int i = 0; i < adjArray.length; i++) { // 꺼낸 정점과 인접한 정점 찾기
				if(adjArray[w][i] == 1 && visited[i] == false) { // 방문하지 않은 정점이라면
					visited[i] = true; // 방문 표시
					stack.push(i); // 스택에 추가
				}
			}
			System.out.print(w + " "); // 정점 출력
		}
	}
}
