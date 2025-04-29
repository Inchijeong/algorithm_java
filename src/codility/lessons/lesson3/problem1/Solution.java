package codility.lessons.lesson3.problem1;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int Y, int D) {
        // Implement your solution here
        int n = (Y - X) / D;
        if ((Y - X) % D != 0) {
            n += 1;
        }
        return n;
        // return (Y - X) % D == 0 ? (Y - X) / D : (Y - X) / D + 1;
    }
}
