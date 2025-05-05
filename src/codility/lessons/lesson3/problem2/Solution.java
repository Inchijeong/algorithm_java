package codility.lessons.lesson3.problem2;

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        if (A.length == 0) {
            return 1;
        }
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A[A.length - 1] + 1;
    }
}

