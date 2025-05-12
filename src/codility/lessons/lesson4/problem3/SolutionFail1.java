package codility.lessons.lesson4.problem3;

import java.util.*;

public class SolutionFail1 {
    public int[] solution(int N, int[] A) {
        // Implement your solution here
        int[] result = new int[N];
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            int X = A[i];
            if (X >= 1 && X < N) {
                result[X - 1] += 1;
                if (max < result[X - 1]) {
                    max = result[X - 1];
                }
                System.out.print(max);
            }
            if (X == N + 1) {
                for (int j = 0; j < result.length; j++) {
                    result[j] = max;
                }
            }
            System.out.println(Arrays.toString(result));
        }
        return result;
    }
}
