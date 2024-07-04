import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner in = new Scanner(
//                "3\n" +
//                        "4\n" +
//                        "1 2 3 4\n" +
//                        "2 1 4 3\n" +
//                        "3 4 1 2\n" +
//                        "4 3 2 1\n" +
//                        "4\n" +
//                        "2 2 2 2\n" +
//                        "2 3 2 3\n" +
//                        "2 2 2 3\n" +
//                        "2 2 2 2\n" +
//                        "3\n" +
//                        "2 1 3\n" +
//                        "1 3 2\n" +
//                        "1 2 3"
// );

        int t = in.nextInt();
        for (int c = 1; c <= t; ++c) {
            int w = in.nextInt();
            int trace = 0;

            HashSet<Integer> dupRows = new HashSet<>();
            HashSet<Integer> dupCols = new HashSet<>();
            boolean rows[][] = new boolean[w][w];
            boolean cols[][] = new boolean[w][w];

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < w; j++) {
                    int n = in.nextInt();
                    if (i == j) {
                        trace += n;
                    }
                    if (rows[i][n-1]) {
                        dupRows.add(i);
                    } else {
                        rows[i][n-1] = true;
                    }
                    if (cols[j][n-1]) {
                        dupCols.add(j);
                    } else {
                        cols[j][n-1] = true;
                    }
                }
            }
            System.out.println("Case #" + c + ": " + trace + " " + dupRows.size() + " " + dupCols.size());
        }
    }
}
