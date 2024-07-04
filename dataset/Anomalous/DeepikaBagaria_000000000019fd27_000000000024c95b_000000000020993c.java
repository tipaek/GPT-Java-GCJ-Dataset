import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tt = 0; tt < t; tt++) {
            int n = Integer.parseInt(br.readLine());
            int trace = 0;
            int duplicateRows = 0;
            HashSet<Integer> duplicateCols = new HashSet<>();
            int[][] matrix = new int[n][n];
            int[] rowChecker = new int[n];

            for (int i = 0; i < n; i++) {
                rowChecker = new int[n];
                boolean rowHasDuplicates = false;
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    int val = Integer.parseInt(st.nextToken()) - 1;

                    if (i == j) {
                        trace += val;
                    }

                    matrix[val][j]++;
                    if (matrix[val][j] > 1) {
                        duplicateCols.add(j);
                    }

                    if (!rowHasDuplicates) {
                        rowChecker[val]++;
                        if (rowChecker[val] > 1) {
                            rowHasDuplicates = true;
                        }
                    }
                }

                if (rowHasDuplicates) {
                    duplicateRows++;
                }
            }

            trace += n;
            System.out.println(trace + " " + duplicateRows + " " + duplicateCols.size());
        }

        System.exit(0);
    }
}