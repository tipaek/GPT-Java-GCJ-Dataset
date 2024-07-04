import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tt = 0; tt < t; tt++) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];

            int k = 0;
            int r = 0;
            int c = 0;

            Map<Integer ,Integer> mapr = new HashMap<>();
            Map<Integer ,Integer> mapc = new HashMap<>();

//            System.out.println("Case #" + (tt + 1) + ": ");
            for (int i = 0; i < n; i++) {
                boolean checkr = true;
                for (int j = 0; j < n; j++) {
                    int m = in.nextInt();
                    arr[i][j] = m;
//                    System.out.print(arr[i][j] + " ");

                    if (checkr && mapr.get(m) != null) {
                        checkr = false;
                        r ++;
                    }
                    if (checkr) {
                        mapr.put(m, m);
                    }
                }
//                System.out.println();
                mapr = new HashMap<>();
                k += arr[i][i];
            }

            for (int i = 0; i < n; i++) {
                boolean checkc = true;
                for (int j = 0; j < n; j++) {
                    int m = arr[j][i];
                    if (checkc && mapc.get(m) != null) {
                        checkc = false;
                        c ++;
                    }
                    if (checkc) {
                        mapc.put(m, m);
                    }
                }
                mapc = new HashMap<>();
            }

            System.out.println("Case #" + (tt + 1) + ": " + k + " " + r + " " + c);
        }
    }
}
