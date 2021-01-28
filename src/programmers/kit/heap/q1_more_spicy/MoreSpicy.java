package programmers.kit.heap.q1_more_spicy;

import java.util.PriorityQueue;

public class MoreSpicy {
	
	public static void main(String[] args) {
		
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		
		System.out.println(solution(scoville, K));
	}
	
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        int len = scoville.length;
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(); 
        
        for(int i = 0; i < len; i++) {
        	queue.offer(scoville[i]);        	
        }
        
    	// 기준 스코빌 지수가 0
    	if(K == 0) return answer;
        
        while(queue.size() > 1) {
        	
        	// 첫 번째로 안매운 음식
        	int first = queue.poll();
        	// 두 번째로 안매운 음식
        	int second = queue.poll();        
        	
        	// 모든 음식이 0
        	if(first == 0 && second == 0) {
        		answer = -1;
        		break;
        	};
        	
        	// 모든 음식이 스코빌 지수 보다 크면 종료
        	if(first >= K && second >= K) break;
        	
        	// 섞은 음식
        	int mix = first + second * 2;
        	
        	queue.offer(mix);        	
        	
        	answer++;
        	
        }
        
        // 다 섞었는데 스코빌 지수보다 낮을 경우
        if(queue.size() == 1 && queue.peek() < K) {
        	answer = -1;
        }
        
        return answer;
    }
}
