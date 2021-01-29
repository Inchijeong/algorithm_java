package base.probability;

import java.util.Arrays;

public class CaseOfNumber3 {
    static int[] data = { 1,2,3,4 };
    static int[] res;
    static boolean[] visit;
    static int cnt;

    public static void main(String[] args) {
        int N = 4, R = 2;
        res = new int[R];
        visit = new boolean[N];

        cnt = 0;
        solve1(N, R, 0);
        System.out.println(cnt);

        cnt = 0;
        solve2(N, R, 0);
        System.out.println(cnt);

        cnt = 0;
        solve3(N, R, 0, 0);
        System.out.println(cnt);

        cnt = 0;
        solve4(N, R, 0, 0);
        System.out.println(cnt);
    }

    //중복순열: 순서가 중요하고(123!=321), 중복을 허용하는 경우
    private static void solve1(int n, int r, int depth) {
        if (depth == r) {
            System.out.println(Arrays.toString(res));
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            res[depth] = data[i];
            solve1(n, r, depth + 1);
        }
    }

    //순열: 순서가 중요하고(123!=321), 중복을 허용하지 않는 경우
    private static void solve2(int n, int r, int depth) {
        if (depth == r) {
            System.out.println(Arrays.toString(res));
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                res[depth] = data[i];
                solve2(n, r, depth + 1);
                visit[i] = false;
            }
        }
    }

    //중복조합: 순서가 중요하지 않고(123==321), 중복을 허용하는 경우
    private static void solve3(int n, int r, int depth, int start) {
        if (depth == r) {
            System.out.println(Arrays.toString(res));
            cnt++;
            return;
        }

        for (int i = start; i < n; i++) {
            res[depth] = data[i];
            solve3(n, r, depth + 1, i);
        }
    }

    //조합: 순서가 중요하지 않고(123==321), 중복을 허용하지 않는 경우
    private static void solve4(int n, int r, int depth, int start) {
        if (depth == r) {
            System.out.println(Arrays.toString(res));
            cnt++;
            return;
        }

        for (int i = start; i < n; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                res[depth] = data[i];
                solve4(n, r, depth + 1, i);
                visit[i] = false;
            }
        }
    }

}
