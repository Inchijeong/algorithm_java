package codility.lessons.lesson2.problem1;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int K) {
        // Implement your solution here
        if (A.length == 0 || K % A.length == 0 || K == 0) {
            return A;
        }
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[(i + K) % A.length] = A[i];
        }
        return result;
    }
}
