package normal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //PrintWriter pw = new PrintWriter("output.txt");

        int maxCaseNum = in.nextInt();

        for (int caseIdx = 1; caseIdx <= maxCaseNum; caseIdx++) {
            //String[] array = line.split(" ");
//            long n = in.nextLong();
            int n = in.nextInt();

            long[][]matrix = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Long.valueOf(in.next());
                }
            }

            //row
            long dupRow = 0;
            for (int i = 0; i < n; i++) {
                Set<Long> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!set.add(matrix[i][j])) {
                        dupRow++;
                        break;
                    }
                }
            }

            //col
            long dupCol = 0;
            for (int i = 0; i < n; i++) {
                Set<Long> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!set.add(matrix[j][i])) {
                        dupCol++;
                        break;
                    }
                }
            }



            String ans = "Case #" + caseIdx + ": " + diagonal(matrix,n) + " " + dupRow + " " + dupCol;
            System.out.println(ans);

        }

        in.close();

    }

    static long diagonal (long[][] matrix, int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }

}
