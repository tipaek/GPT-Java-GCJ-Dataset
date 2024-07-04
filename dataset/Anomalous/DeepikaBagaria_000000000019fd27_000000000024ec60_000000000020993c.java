import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int trace = 0;
            int rowCount = 0;
            HashSet<Integer> colSet = new HashSet<>();
            int[][] matrix = new int[n][n];
            int[] rowTracker = new int[n];

            for (int i = 0; i < n; i++) {
                rowTracker = new int[n];
                boolean rowHasDuplicate = false;
                StringTokenizer tokenizer = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(tokenizer.nextToken()) - 1;

                    if (i == j) {
                        trace += value;
                    }

                    matrix[value][j]++;
                    if (matrix[value][j] > 1) {
                        colSet.add(j);
                    }

                    if (!rowHasDuplicate) {
                        rowTracker[value]++;
                        if (rowTracker[value] > 1) {
                            rowHasDuplicate = true;
                        }
                    }
                }

                if (rowHasDuplicate) {
                    rowCount++;
                }
            }

            trace += n;
            System.out.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + colSet.size());
        }
    }
}