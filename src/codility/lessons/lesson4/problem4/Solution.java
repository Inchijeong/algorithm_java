package codility.lessons.lesson4.problem4;

public class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        boolean[] arr = new boolean[A.length + 2];
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && A[i] < A.length + 2)
            arr[A[i]] = true;
        }
        for (int j = 1; j < arr.length; j++) {
            if (! arr[j]) {
                return j;
            }
        }
        return 1;
    }
}
