import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    private static class E {
        public int start;
        public int end;

        public E(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static String solve3(Scanner s) {
        int n = s.nextInt();
        E[] a = new E[n];
        for (int i = 0; i < n; i++) {
            int st = s.nextInt();
            int end = s.nextInt();
            a[i] = new E(st, end);
        }
        Arrays.sort(a, new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return o1.start - o2.start;
            }
        });
        String ans = "";
        int cEnd = -1;
        int jEnd = -1;
        for (int i = 0; i < n; i++) {
            if (cEnd <= a[i].start) {
                ans += "C";
                cEnd = a[i].end;
            } else if (jEnd <= a[i].start) {
                ans += "J";
                jEnd = a[i].end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            System.out.println("Case #" + t + ": " + solve3(s));
        }
    }
}
