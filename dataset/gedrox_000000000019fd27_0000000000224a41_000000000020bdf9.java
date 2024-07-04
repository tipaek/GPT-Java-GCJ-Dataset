import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        nextCase:
        for (int i = 0; i < t; i++) {

            int n = sc.nextInt();
            char[] c = new char[n];
            int w = 0;

            int[][] x = new int[2 * n][];
            for (int i1 = 0; i1 < n; i1++) {
                x[2 * i1] = new int[] {sc.nextInt(), 1, i1};
                x[2 * i1 + 1] = new int[] {sc.nextInt(), -1, i1};
            }

            Arrays.sort(x, Comparator.<int[], Integer>comparing(v -> v[0]).thenComparing(v -> v[1]));

            for (int[] y : x) {
                if (y[1] == 1) {
                    if ((w & 1) == 0) {
                        c[y[2]] = 'C';
                        w |= 1;
                    } else if ((w & 2) == 0) {
                        c[y[2]] = 'J';
                        w |= 2;
                    } else {
                        System.out.println(String.format("Case #%d: IMPOSSIBLE", i + 1));
                        continue nextCase;
                    }
                } else {
                    if (c[y[2]] == 'C') {
                        w &= 2;
                    } else {
                        w &= 1;
                    }
                }
            }

            System.out.println(String.format("Case #%d: %s", i + 1, new String(c)));
        }
    }
}
