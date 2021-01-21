package programmers.kit.bfs_dfs.q3_word_conversion;

import java.util.LinkedList;
import java.util.Queue;

// BFS - 타겟에 도달하면 멈추기 위함
public class WordConversion {

	static class Word {
		int idx;
		int cnt; // 변경한 횟수
		
		Word(int idx, int cnt){
			this.idx = idx;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) {
		
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
//		String target = "hak";
//		String[] words = {"hot", "hat", "hak"};
		
		System.out.println("answer: " + solution(begin, target, words));
	}
	
	public static int solution(String begin, String target, String[] words) {
		
		int answer = 0;		
		int n = words.length + 1;
		int m = begin.length();
		int[][] adjArray = new int[n][n];
		String[] wds = new String[n];
		boolean visited[] = new boolean[n];
		
		// begin 포함
		wds[0] = begin;
		for(int i = 1; i < n; i++) {
			wds[i] = words[i-1];
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				
				// 한글자씩 다르면 인접
				int sameCnt = 0;
				for(int k = 0; k < m; k++) {
					if(wds[i].charAt(k) == wds[j].charAt(k)) {
						sameCnt++;
					}
				}
				if(sameCnt == m-1) {
					adjArray[i][j] = 1;
				}
			}
		}
		
//		for(String wd : wds) {
//			System.out.println(wd);
//		}
//
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(adjArray[i][j]);
//			}
//			System.out.println();
//		}
		
		answer = bfs(0, adjArray, visited, wds, target);
		
		return answer;
	}
	
	public static int bfs(int v, int[][] adjArray, boolean[] visited, String[] wds, String target) {
		Queue<Word> queue = new LinkedList<Word>();
		queue.offer(new Word(v, 0));
		visited[v] = true;
				
		while(!queue.isEmpty()) {
			Word currentWord = queue.poll(); 
			int w = currentWord.idx;
			int cnt = currentWord.cnt;
			if(wds[w].equals(target)) {
				return cnt;
			}
			for(int i = 0; i < adjArray.length; i++) {
				if(adjArray[w][i] == 1 & visited[i] == false) {
					visited[i] = true;
					queue.offer(new Word(i, cnt + 1));
				}
			}
		}
		return 0;
	}
}
