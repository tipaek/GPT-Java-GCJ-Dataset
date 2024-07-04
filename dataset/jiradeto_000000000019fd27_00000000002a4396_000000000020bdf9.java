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

    private static void solve(int idx, int[][] time) {
        StringBuilder sb = new StringBuilder();
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        for (int[] t : time) {
            if (isOk(a, t[0], t[1])) {
                a.add(t);
                sb.append("J");
            } else if (isOk(b, t[0], t[1])) {
                b.add(t);
                sb.append("C");
            } else {
                System.out.println("Case #" + idx + ": " + "IMPOSSIBLE");
                return;
            }
        }
        System.out.println("Case #" + idx + ": " + sb.toString());
    }

    private static boolean isOk(List<int[]> a, int start, int end) {
        for (int[] time : a) {
            if (time[0] < end && time[1] > start) 
                return false;
        }
        return true;
    }

}

