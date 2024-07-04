
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        for (int i = 1; i <= tests; i++) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            for (int j = 0; j < n; j++) {
                start[j] = sc.nextInt();
                end[j] = sc.nextInt();
            }
            check(i, n, start, end);
        }
    }

    private static void check(int i, int n, int[] start, int[] end) {
        System.out.print("Case #" + i + ": ");
        int c = 0;
        int j = -1;
        StringBuilder sb = new StringBuilder("C");
        for (int k = 1; k < n; k++) {
            if (start[k] >= end[c] || end[k] <= start[c]) {
                sb.append("C");
                c = k;
            } else if (j < 0 || start[k] >= end[j] || end[k] <= start[j]) {
                sb.append("J");
                j = k;
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        System.out.println(sb.toString());
    }
}
