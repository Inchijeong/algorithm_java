package codility.lessons.lesson3.problem3;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class SolutionFail1 {
    public int solution(int[] A) {
        // Implement your solution here
        if(A.length <= 1) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int p = 1; p < A.length; p++) {
            int preSum = 0;
            for (int i = 0; i < p; i++) {
                preSum += A[i];
            }
            int proSum = 0;
            for (int j = p; j < A.length; j++) {
                proSum += A[j];
            }
            int diff = Math.abs(preSum - proSum);
            if (diff < result) {
                result = diff;
            }
        }
        return result;
    }
}
