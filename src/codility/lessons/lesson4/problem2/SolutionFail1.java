package codility.lessons.lesson4.problem2;
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class SolutionFail1 {
    public int solution(int[] A) {
        // Implement your solution here
        int result = 1;
        Arrays.sort(A);
        int pre = A[0];
        for (int i = 1; i < A.length; i++) {
            if (pre + 1 != A[i]) {
                return 0;
            }
            pre++;
        }
        return result;
    }
}
