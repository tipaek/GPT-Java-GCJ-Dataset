import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Vestigium {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tt = 0; tt < t; tt++) {
            int n = Integer.parseInt(br.readLine());
            int trace = 0, rows = 0;
            HashSet<Integer> colSet = new HashSet<>();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                boolean rowDuplicate = false;
                int[] rowCount = new int[n];
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    int val = Integer.parseInt(st.nextToken()) - 1;

                    if (i == j) {
                        trace += val + 1;
                    }

                    matrix[val][j]++;
                    if (matrix[val][j] > 1) {
                        colSet.add(j);
                    }

                    rowCount[val]++;
                    if (rowCount[val] > 1) {
                        rowDuplicate = true;
                    }
                }

                if (rowDuplicate) {
                    rows++;
                }
            }

            System.out.println(trace + " " + rows + " " + colSet.size());
        }
    }
}