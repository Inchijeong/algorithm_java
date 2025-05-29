package codility.lessons.lesson4.problem3;

// import java.util.*;

public class Solution {
    public int[] solution(int N, int[] A) {
        // Implement your solution here
        int[] result = new int[N];
        int currentMax = 0;
        int lastMax = 0;

        for (int i = 0; i < A.length; i++) {
            int x = A[i];
            if (x >= 1 && x <= N) {
                int n = result[x - 1];
                if (n < lastMax) {
                    result[x - 1] = lastMax + 1;
                } else {
                    result[x - 1]++;
                }
                if (result[x - 1] > currentMax) {
                    currentMax = result[x - 1];
                }
            }
            if (x == N + 1) {
                lastMax = currentMax;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] < lastMax) {
                result[i] = lastMax;
            }
        }
        return result;
    }
}
