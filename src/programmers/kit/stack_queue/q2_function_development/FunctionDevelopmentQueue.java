package programmers.kit.stack_queue.q2_function_development;

import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelopmentQueue {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int day = 1;
        int j = 0;        
        
        Queue<Integer> prgQueue = new LinkedList<Integer>();
        Queue<Integer> spdQueue = new LinkedList<Integer>();
        Queue<Integer> resultQueue = new LinkedList<Integer>();        
        
        for(int i = 0; i < len; i++){
            prgQueue.offer(progresses[i]);
            spdQueue.offer(speeds[i]);
        }
        
        while(!prgQueue.isEmpty()){
            int cnt = 0;
            int i = 0;
            while(!prgQueue.isEmpty()){
                // System.out.println(prgQueue.peek() + spdQueue.peek() * day);
                // System.out.println("prgQueue.size() " + prgQueue.size());
                if(prgQueue.peek() + spdQueue.peek() * day >= 100){
                    prgQueue.poll();
                    spdQueue.poll();                
                    cnt++;
                }else{
                    break;
                }            
                i++;
            }
            if(cnt > 0){
                resultQueue.offer(cnt);                
            }
            day++;
            // System.out.println("cnt " + cnt);
            // System.out.println("===========================");
        }        
        
        int queueSize = resultQueue.size();
        int[] answer = new int[queueSize];        
        
        // System.out.println(queueSize);
        
        for(int i = 0; i < queueSize; i++){
            // System.out.println(queue.poll());
            answer[i] = resultQueue.poll();
        }
        
        return answer;
    }
}
