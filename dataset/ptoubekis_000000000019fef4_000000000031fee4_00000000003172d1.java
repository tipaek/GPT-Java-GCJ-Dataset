import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            int n = in.nextInt();
            int d = in.nextInt();
            long[] list = new long[n];
            for (int j = 0; j < n; j++) {
                list[j] = in.nextLong();
            }
            System.out.println("Case #" + i + ": " + foo(n, d, list));
        }
    }

    private static int foo(int n, int d, long[] list) {
        if (d == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (list[i] == list[j]) {
                        return 0;
                    }
                }
            }
            return 1;
        }
        if (d == 3) {
            int best = 2;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (list[i] == list[j]) {
                        for (int k = j + 1; k < n; k++) {
                            if (list[j] == list[k]) {
                                return 0;
                            }
                        }
                        if (j != n - 1 || i != n - 2) {
                            best = 1;
                        }
                    }
                    long min, max;
                    if (list[i] < list[j]) {
                        min = list[i];
                        max = list[j];
                    } else {
                        min = list[j];
                        max = list[i];
                    }
                    if (min * 2 == max) {
                        best = 1;
                    }
                }
                return best;
            }
        }
        return 0;
    }
}
