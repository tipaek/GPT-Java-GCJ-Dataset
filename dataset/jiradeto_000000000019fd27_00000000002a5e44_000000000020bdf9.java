import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        for (int i = 1; i <= n; i++) {
            int t = reader.nextInt();
            int[][] inp = new int[t][2];
            for (int j = 0; j < t; j++) {
                int start = reader.nextInt();
                int end = reader.nextInt();
                inp[j] = new int[]{start, end};
            }
            solve(i, inp);
        }

    }

    private static void explore(int j, int[][] time, List<String> ans, List<int[]> a, List<int[]> b, String str) {
        if (j == time.length) {
            ans.add(str);
            return;
        }

        if (j < time.length) {
            int i = j;
            int[] t = time[i];
            if (isOk(a, t[0], t[1])) {
                List<int[]> clone = new ArrayList<>(a);
                clone.add(t);
                explore(i + 1, time, ans, clone, b, str + "J");
            }
            if (isOk(b, t[0], t[1])) {
                List<int[]> clone = new ArrayList<>(b);
                clone.add(t);
                explore(i + 1, time, ans, a, clone, str + "C");
            }
        }
    }

    private static void solve(int idx, int[][] time) {
        List<String> ans = new ArrayList<>();
        explore(0, time, ans, new ArrayList<>(), new ArrayList<>(), "");
        int x = 3;
        if (ans.size() == 0) {
            System.out.println("Case #" + idx + ": " + "IMPOSSIBLE");
        }else {
            System.out.println("Case #" + idx + ": " + ans.get(0));
        }
    }

    private static boolean isOk(List<int[]> a, int start, int end) {
        for (int[] time : a) {
            if (time[0] < end && start < time[1]) return false;
        }
        return true;
    }

}

