package programmers.kit.heap.q2_disk_controller;

import java.util.PriorityQueue;

public class DiskController {

	
	public static void main(String[] args) {
		
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		
		System.out.println(solution(jobs));		
	}	
	
    public static int solution(int[][] jobs) {
        int answer = 0;
        int len = jobs.length;
        int[] waitTime = new int[len];
        
        PriorityQueue<Integer> waitQueue = new PriorityQueue<Integer>();
        
        int process = 0;        
        int time = 0;
        
        for(int i = 0; i < len; i++) {
        	waitTime[i] = 0;
        }
        
        // 0초에 들어온 모든 요청 대기큐에 삽입
    	for(int i = 0; i < len; i++) {
    		if(time == jobs[i][0]) {
    			waitQueue.offer(jobs[i][1]);
    		}
    	}
    	
        while(time == 0) {
        	
        	time++;
        	process--;
        	
        	// 해당 초에 모든 요청 대기큐에 삽입
        	for(int i = 0; i < len; i++) {
        		if(time == jobs[i][0]) {
        			waitQueue.offer(jobs[i][1]);
        		}
        	}
        	
        	process = waitQueue.poll();
        	
        	// 빼기        	
        	if(waitQueue.poll() != null) {
        		
        	}else {
        		
        	}
        	
        	time++;
        }
        
        return answer;
    }
}
