package programmers.kit.heap.q3_dual_priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DualPriorityQueue {

	public static void main(String[] args) {
		
//		String[] operations = {"I 16", "D 1"};
		String[] operations = {"I 7", "I 5", "I -5", "D -1"};
		
		int[] ans = solution(operations);
		
		for(int num : ans) {
			System.out.println(num);
		}
	}
	
    public static int[] solution(String[] operations) {

        DoubleEndedPriorityQueue doubleEndedPriorityQueue = new DoubleEndedPriorityQueue();
        
        for(int i = 0; i < operations.length; i++) {
        	String[] oper = operations[i].split(" ");
        	
        	if("I".equals(oper[0])) {
        		System.out.println("삽입");
        		doubleEndedPriorityQueue.offer(Integer.parseInt(oper[1]));
        	}else {
        		if("1".equals(oper[1])) {
        			System.out.println("최댓값 제거");
        			doubleEndedPriorityQueue.removeMax();
        		}else {
        			System.out.println("최솟값 제거");
        			doubleEndedPriorityQueue.removeMin();
        		}
        	}        	
        }
        
        int[] answer = {doubleEndedPriorityQueue.getMax(), doubleEndedPriorityQueue.getMin()};
        
        return answer;
    }
}

class DoubleEndedPriorityQueue {
	
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());    
    
    public void offer(Integer n){
    	minHeap.offer(n);
    	maxHeap.offer(n);
    }
    
    public Integer getMax() {
    	Integer max = 0;
    	if(!maxHeap.isEmpty()) {
    		max = maxHeap.peek();
    	}
    	return max;
    }
    
    public Integer getMin() {
    	Integer min = 0;
    	if(!minHeap.isEmpty()) {
    		min = minHeap.peek();
    	}
    	return min;
    }
    
    public void removeMax() {
    	if(!maxHeap.isEmpty()) {
    		minHeap.remove(maxHeap.poll());    		
    	}
    }
    
    public void removeMin() {
    	if(!minHeap.isEmpty()) {
    		maxHeap.remove(minHeap.poll());    		
    	}
    }
}
