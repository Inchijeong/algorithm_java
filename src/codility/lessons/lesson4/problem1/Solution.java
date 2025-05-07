// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {
        // Implement your solution here
        int result = -1;
        int[] river = new int[X];
        for (int i = 0; i < river.length; i++) {
            river[i] = -1;    
        }
        for (int i = 0; i < A.length; i++) {
            int position = A[i];
            if (position < X + 1 && river[position - 1] == -1) {
                // System.out.println("i: " + i);
                // System.out.println("position: " + position);
                river[position - 1] = i;
            }
        }
        // for (int k : river) {
        //     System.out.println("k: " + k);
        // }
        for (int j = 0; j < river.length; j++) {
            System.out.println("river[j]: " + river[j]);
            if (river[j] == -1) {
                // System.out.println("-1");
                return -1;
            }
            if (result < river[j]) {
                result = river[j];
            }
        }
        // System.out.println("result:" + result);
        return result;
    }
}
