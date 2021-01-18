package programmers.kit.bfs_dfs.targetNumber;

//DFS Recursion 풀이 시도
public class Solution {

	public static void main(String[] args) {
		
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		
		System.out.println("answer: " + solution(numbers, target));
	}
	
	public static int solution(int[] numbers, int target) {
		int answer = 0;		
		answer = dfsR(numbers, -1, 0, target, 0);
		
		return answer;
	}
	
	public static int dfsR(int[] numbers, int idx, int sum, int target, int ans) {
		int length = numbers.length;
		idx++;
		if(idx < length) {
			ans += dfsR(numbers, idx, sum + numbers[idx], target, ans);
			ans += dfsR(numbers, idx, sum - numbers[idx], target, ans);
			System.out.println("idx: " + idx);
			System.out.println("cnt " + ans);
			return ans;
		}else { // 마지막
			System.out.println("sum: " + sum);
			if(target == sum) {
				return 1;
			}else {
				return 0;
			}			
		}
	}
}
