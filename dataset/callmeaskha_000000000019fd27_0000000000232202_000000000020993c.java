import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[][] mass = new int[N][N];

            int k = 0;
            int r = 0;
            int c = 0;

            for (int i = 0; i < N; i++) {
                String[] rowArray = br.readLine().split(" ");
                int curTrace = Integer.parseInt(rowArray[i]);
                k += curTrace;

                for (int j = 0; j < rowArray.length; j++) {
                    int cur = Integer.parseInt(rowArray[j]);
                    mass[i][j] = cur;
                }
            }
            
            for (int i = 0; i < N; i++) {
                Set<Integer> row = new HashSet<Integer>();
                Set<Integer> column = new HashSet<Integer>();
                for (int j = 0; j < N; j++) {
                    row.add(mass[i][j]);
                    column.add(mass[j][i]);
                }
                if (row.size() != N) {
                    r += 1;
                }
                if (column.size() != N) {
                    c += 1;
                }
            }

            System.out.println("Case #" + (testCase + 1) + ": " + k + " " + r + " " + c);

        }
    }
}
