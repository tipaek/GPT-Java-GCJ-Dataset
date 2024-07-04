import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = in.nextInt();
        for (int testCase = 1; testCase <= numberOfCases; testCase++) {
            int n = in.nextInt();
            int m[][] = new int[n][n];

            int trace = 0;
            int rowsRepeat = 0;
            int colsRepeat = 0;

            boolean repeated = false;
            HashSet<Integer> uniqueElements = new HashSet<Integer>();

            for (int i = 0; i < n; i++) {
                repeated = false;
                uniqueElements.clear();

                for (int j = 0; j < n; j++) {
                    m[i][j] = in.nextInt();

                    if (!repeated) {
                        if (uniqueElements.contains(m[i][j])) {
                            repeated = true;
                            rowsRepeat++;
                        } else {
                            uniqueElements.add(m[i][j]);
                        }
                    }

                    if (i==j) {
                        trace += m[i][j];
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                repeated = false;
                uniqueElements.clear();

                for (int i = 0; i < n; i++) {

                    if (!repeated) {
                        if (uniqueElements.contains(m[i][j])) {
                            repeated = true;
                            colsRepeat++;
                            break;
                        } else {
                            uniqueElements.add(m[i][j]);
                        }
                    }
                }
            }

            System.out.format("Case #{%d}: %d %d %d%n", testCase, trace, rowsRepeat, colsRepeat);
        }
    }
}