package programmers.kit.stack_queue.q4_printer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class PrinterQueue {
	
	public static void main(String[] args) {
		
//		int[] priorities = {2, 1, 3, 2};
//		int location = 2;
		
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		
		System.out.println(solution(priorities, location));		
		
	}
	
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int len = priorities.length;

        Queue<Integer> IdxQueue = new LinkedList<Integer>();
        Queue<Integer> priQueue = new LinkedList<Integer>();
        
        for(int i = 0; i < len; i++) {
//        	System.out.println("priorities[i] " + priorities[i]);
        	priQueue.offer(priorities[i]);
        	IdxQueue.offer(i);
        }
        
        while(!priQueue.isEmpty()) {
        	
//        	printQueue(priQueue);
//        	printQueue(IdxQueue);
        	
        	if(priQueue.peek() >= Collections.max(priQueue) || priQueue.size() == 1) {
//        		System.out.println("�̱�");
        		answer++;
        		if(IdxQueue.peek() == location) {
        			break;
        		}
        		priQueue.poll();
        		IdxQueue.poll();
        	}else {
//        		System.out.println("����");
        		priQueue.offer(priQueue.poll());
        		IdxQueue.offer(IdxQueue.poll());
        	}
        	
//        	System.out.println("================");
        }
        
        return answer;
    }
    
    public static void printQueue(Queue<Integer> queue) {
    	System.out.print("[ ");
    	queue.forEach(que -> System.out.print(que + " "));
    	System.out.println("]");
    }

}
