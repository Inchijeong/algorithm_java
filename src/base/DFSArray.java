package base;

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
public class DFSArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 정점의 개수
		int m = sc.nextInt(); // 간선의 개수
		int v = sc.nextInt(); // 탐색을 시작할 정점의 번호
		
		boolean visited[] = new boolean[n+1]; // 방문 여부를 검사할 배열
		
		int[][] adjArray = new int[n+1][n+1];
		
		// 두 정점 사이에 여러 개의 간선이 있을 수 있다.
		// 입력으로 주어지는 간선은 양방향이다.
		for(int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjArray[v1][v2] = 1;
			adjArray[v2][v1] = 1;
		}
		
		System.out.println("DFS - 인접행렬 / 재귀로 구현");
		dfsArrayRecursion(v, adjArray, visited);
		Arrays.fill(visited, false);
		
		System.out.println();
		System.out.println("DFS - 인접행렬 / 스택으로 구현");
		dfsArrayStack(v, adjArray, visited, true);
	}
	
	// DFS - 인접행렬 / 재귀로 구현
	public static void dfsArrayRecursion(int v, int[][] adjArray, boolean[] visited) {
		int l = adjArray.length-1;
		visited[v] = true;
		System.out.print(v + " ");

		for(int i = 1; i <= l; i++) {
			if(adjArray[v][i] == 1 && !visited[i]) {
				dfsArrayRecursion(i, adjArray, visited);
			}
		}
	}
	
	// DFS - 인접행렬 / 스택으로 구현
	public static void dfsArrayStack(int v, int[][] adjArray, boolean[] visited, boolean flag) {
		int l = adjArray.length-1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(v);
		visited[v] = true;
		System.out.print(v + " ");
		
		while(!stack.isEmpty()) {
			int w = stack.peek();
			flag = false;
			
			for(int i = 1; i <= l; i++) {
				if(adjArray[w][i] == 1 && !visited[i]) {
					stack.push(i);
					System.out.print(i + " ");
					visited[i] = true;
					flag = true;
					break;
				}
			}
			if(!flag) {
				stack.pop();
			}			
		}		
	}
}
