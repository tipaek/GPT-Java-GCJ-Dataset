package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution  {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());

        for (int tesCase = 1; tesCase <= num; tesCase++) {

            int n = Integer.parseInt(bufferedReader.readLine());
            int sum = 0;

            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++)
                matrix[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int i = 0; i < n; i++)
                sum += matrix[i][i];

            Set<String> set = new HashSet<>();
            Set<Integer> dupRow = new HashSet<>();
            Set<Integer> dupCol = new HashSet<>();
            int rowCount = 0, colCount = 0;
            for(int i = 0; i < n; i ++) {

                for (int j = 0; j < n; j++) {

                    if(!set.add(matrix[i][j] + " in row " + i) && !dupRow.contains(i)) {
                        rowCount++;
                        dupRow.add(i);
                    }


                    if(!set.add(matrix[i][j] + " in col " + j)  && !dupCol.contains(j)) {
                        colCount++;
                        dupCol.add(j);
                    }
                }
            }
            System.out.println("Case #" + tesCase + ": " + sum + " " + rowCount + " " + colCount);
        }
    }

}
