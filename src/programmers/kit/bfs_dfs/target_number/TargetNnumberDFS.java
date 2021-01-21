package programmers.kit.bfs_dfs.target_number;

//DFS Recursion 풀이
public class TargetNnumberDFS {

	public static void main(String[] args) {
		
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		
		System.out.println("answer: " + solution(numbers, target));
	}
	
	public static int solution(int[] numbers, int target) {
		int answer = 0;		
		answer = dfs(numbers, -1, 0, target);
		
		return answer;
	}
	
	public static int dfs(int[] numbers, int idx, int sum, int target) {
		int length = numbers.length;
		idx++;
		
		int ans = 0;
		if(idx < length) {
			ans += dfs(numbers, idx, sum + numbers[idx], target);
			ans += dfs(numbers, idx, sum - numbers[idx], target);
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
