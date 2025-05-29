package codility.lessons.lesson4.problem3;

// import java.util.*;

public class SolutionFail2 {
    public int[] solution(int N, int[] A) {
        // Implement your solution here
        int[] result = new int[N];
        int max = 0;
        boolean needsUpdate = false;

        for (int i = 0; i < A.length; i++) {
            int X = A[i];
            if (X >= 1 && X <= N) {
                if (needsUpdate) {
                    for (int j = 0; j < result.length; j++) {
                        result[j] = max;
                        needsUpdate = false;
                    }
                }
                result[X - 1] += 1;
                if (max < result[X - 1]) {
                    max = result[X - 1];
                }
                // System.out.print(max);
            }
            if (X == N + 1) {
                needsUpdate = true;
            }
            // System.out.println(Arrays.toString(result));
        }
        return result;
    }
}
