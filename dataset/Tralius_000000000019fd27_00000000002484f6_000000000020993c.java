import java.util.*;
import java.io.*;

public class Solution {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();
            for(int i = 1; i <= t; i++){
                int n = in.nextInt();
                int[][] matrix = new int[n][n];
                int trace = 0, row = 0, column = 0;
                for(int line = 0; line < n; line++){
                    for(int pos = 0; pos < n; pos++){
                        matrix[line][pos] = in.nextInt();
                    }
                }
                trace = getTrace(matrix);
                row = getRepRow(matrix);
                column = getRepColumn(matrix);
                System.out.println("Case #" + i + ": " + trace + " " + row + " " + column);
            }
        }

        private static int getTrace(int[][] matrix){
            int trace = 0;
            for(int i = 0; i < matrix.length; i++){
                trace += matrix[i][i];
            }
            return trace;
        }

        private static int getRepRow(int[][] matrix){
            int row = 0;
            for(int i = 0; i < matrix.length; i++){
                ArrayList<Integer> rowArray = new ArrayList<>();
                boolean found = false;
                for (int j = 0; j< matrix.length && found == false; j++){
                    if(rowArray.contains((matrix[i][j]))){
                        row++;
                        found = true;
                    }
                    rowArray.add(matrix[i][j]);
                }
            }
            return row;
        }

        private static int getRepColumn(int[][] matrix){
            int column = 0;
            for(int i = 0; i < matrix.length; i++){
                ArrayList<Integer> columnArray = new ArrayList<>();
                boolean found = false;
                for (int j = 0; j< matrix.length && found == false; j++){
                    if(columnArray.contains((matrix[j][i]))){
                        column++;
                        found = true;
                    }
                    columnArray.add(matrix[j][i]);
                }
            }
            return column;
        }
}
