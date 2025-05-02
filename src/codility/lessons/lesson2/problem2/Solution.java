package codility.lessons.lesson2.problem2;
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        if (A.length == 1) {
            return A[0];
        }

        Set<Integer> aSet = new HashSet<>();
        for (int a : A) {
            if (aSet.contains(a)) {
                aSet.remove(a);
            } else {
                aSet.add(a);
            }
        }
        return aSet.iterator().next();
    }
}
