import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int x = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[x][x];

            for (int i = 0; i < x; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for (int j = 0; j < x; j++) {
                    arr[i][j] = Integer.parseInt(str.nextToken());
                }
            }

            int trace = 0;
            int rowRepeated = 0;
            int colRepeated = 0;

            for (int i = 0; i < x; i++) {
                trace += arr[i][i];
                boolean[] rowCheck = new boolean[101];
                boolean[] colCheck = new boolean[101];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < x; j++) {
                    if (rowCheck[arr[i][j]]) {
                        rowHasDuplicate = true;
                    }
                    rowCheck[arr[i][j]] = true;

                    if (colCheck[arr[j][i]]) {
                        colHasDuplicate = true;
                    }
                    colCheck[arr[j][i]] = true;
                }

                if (rowHasDuplicate) {
                    rowRepeated++;
                }
                if (colHasDuplicate) {
                    colRepeated++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeated + " " + colRepeated);
            caseNumber++;
        }
    }
}