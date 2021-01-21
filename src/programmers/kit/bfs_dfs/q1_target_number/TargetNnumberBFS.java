package programmers.kit.bfs_dfs.q1_target_number;

import java.util.LinkedList;
import java.util.Queue;

// BFS 풀이
public class TargetNnumberBFS {

	public static void main(String[] args) {
		
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		
		System.out.println("answer: " + solution(numbers, target));
	}
	
	public static int solution(int[] numbers, int target) {
		int answer = 0;
		
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(new Pair(numbers[0], 0));
		queue.offer(new Pair(-numbers[0], 0));
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			if(p.index == numbers.length -1) {
				if(p.cur == target) {
					answer += 1;
				}
				continue;
			}
			int c1 = p.cur + numbers[p.index+1];
			int c2 = p.cur - numbers[p.index+1];
			
			queue.add(new Pair(c1, p.index+1));
			queue.add(new Pair(c2, p.index+1));
		}		
		
		return answer;
	}
	
	static class Pair {
		int cur;
		int index;
		
		Pair(int cur, int index) {
			this.cur = cur;
			this.index = index;
		}
	}
}
