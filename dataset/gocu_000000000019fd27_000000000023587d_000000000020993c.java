
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int numTestCases = Integer.parseInt(bi.readLine());

        for (int j = 0; j < numTestCases; j++) {
            int n = Integer.parseInt(bi.readLine()); // input
            int[][] arr = new int[n][n];

            int trace = 0; // output
            int numOfColumns = 0; // output
            int numOfRows = 0; // output


            for (int k = 0; k < n; k++) {
                String line = bi.readLine();
                String[] strs = line.split("\\s");
                int[] uniqueArr = new int[n+1];
                boolean rowUnique = true;
                for (int l = 0; l < n; l++) {
                    int element = Integer.parseInt(strs[l]);
                    if (uniqueArr[element] == 1) {
                        rowUnique = false;
                    } else {
                        uniqueArr[element] = 1;
                    }
                    arr[k][l] = element;
                }
                if (!rowUnique) {
                    numOfRows++;
                }

                trace = trace + arr[k][k];
            }

            for (int col = 0; col < n; col++) {
                int[] uniqueArr = new int[n+1];
                boolean rowUnique = true;

                for (int row = 0; row < n; row++) {
                    int element = arr[row][col];
                    if (uniqueArr[element] == 1) {
                        rowUnique = false;
                    } else {
                        uniqueArr[element] = 1;
                    }
                }
                if (!rowUnique) {
                    numOfColumns++;
                }
            }
            System.out.println("Case #" + (j+1) + ": " + trace + " " + numOfRows + " " + numOfColumns);
        }
    }


}
