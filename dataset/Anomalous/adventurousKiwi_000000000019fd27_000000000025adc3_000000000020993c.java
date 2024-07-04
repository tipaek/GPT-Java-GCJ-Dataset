import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(sc.nextLine());
            BigInteger trace = BigInteger.ZERO;
            int duplicateRows = 0;
            int duplicateCols = 0;

            boolean[][] cols = new boolean[N][N];
            boolean[] colHasDuplicate = new boolean[N];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                boolean[] row = new boolean[N];
                boolean rowHasDuplicate = false;

                for (int k = 0; k < N; k++) {
                    int element = Integer.parseInt(st.nextToken());

                    if (j == k) {
                        trace = trace.add(BigInteger.valueOf(element));
                    }

                    if (row[element - 1]) {
                        if (!rowHasDuplicate) {
                            rowHasDuplicate = true;
                            duplicateRows++;
                        }
                    } else {
                        row[element - 1] = true;
                    }

                    if (cols[k][element - 1]) {
                        if (!colHasDuplicate[k]) {
                            colHasDuplicate[k] = true;
                            duplicateCols++;
                        }
                    } else {
                        cols[k][element - 1] = true;
                    }
                }
            }
            System.out.printf("Case #%d: %s %d %d%n", i + 1, trace, duplicateRows, duplicateCols);
        }
    }
}