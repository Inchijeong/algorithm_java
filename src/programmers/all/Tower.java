package programmers.all;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 탑
public class Tower {
    public int[] solution(int[] heights) {
        int len = heights.length;
        int[] answer = new int[len];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = len-1; i >= 0 ; i--){
            int send = heights[i];
            // System.out.println("send " + send);
            for(int j = i-1; j >= 0; j--){
                if(heights[j] > heights[i]){
                    stack.push(j+1);
                    // System.out.println("heights[j] " + heights[j]);
                    // System.out.println("j + 1 " + (j + 1));
                    break;
                }
                if(j == 0){
                    System.out.println("j " + 0);
                    stack.push(0);
                }
            }
        }
        stack.push(0);
        // System.out.println(stack.empty());
        
        for(int k = 0; k < len; k++){
            // System.out.println(stack.pop());
            answer[k] = stack.pop();
        }
        
        return answer;
    }
}
