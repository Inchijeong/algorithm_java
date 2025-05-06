// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        if (A.length <= 1) {
            return 0;
        }
        if (A.length == 2) {
            return Math.abs(A[1] - A[0]);
        }
        int total = 0;
        for (int n : A) {
            total += n;
        }
        int preSum = A[0];
        int proSum = total - A[0];
        int result = Math.abs(preSum - proSum);
        for (int i = 1; i < A.length - 1; i++) {
            preSum += A[i];
            proSum -= A[i];
            int newVal = Math.abs(preSum - proSum);
            if (newVal < result) {
                result = newVal;
            }
        }
        return result;
    }
}
