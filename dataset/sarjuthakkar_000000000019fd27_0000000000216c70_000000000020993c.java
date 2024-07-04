import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(
                new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int size = in.nextInt();
            int diagonal = 0;
            int[][] matrix = new int[size][size];
            for(int j = 0; j < size; j++){
                for(int k = 0; k < size; k++){
                    int importNum = in.nextInt();
                    matrix[j][k] = importNum;
                    if(j == k){
                        diagonal += importNum;
                    }
                }
            }
            int rowsCorrupt = 0;
            for(int row = 0; row < size; row++){
                boolean duplicateInRow = false;
                for(int j = 0; j < size - 1; j++){
                    for(int k = 1; k < size; k++){
                        duplicateInRow = (matrix[row][j] == matrix[row][k]);
                        if(duplicateInRow) {
                            break;
                        }
                    }
                    if(duplicateInRow) {
                            break;
                        }
                }
                if(duplicateInRow) {
                    rowsCorrupt++;
                    if(row == size - 1){
                        break;
                    }
                }
            }
            int columnsCorrupt = 0;
            for(int column = 0; column < size; column++){
                boolean duplicateInColumn = false;
                for(int j = 0; j < size - 1; j++){
                    for(int k = 1; k < size; k++){
                        duplicateInColumn = (matrix[j][column] == matrix[k][column]);
                        if(duplicateInColumn) {
                            break;
                        }
                    }
                    if(duplicateInColumn) {
                            break;
                        }
                }
                if(duplicateInColumn) {
                    columnsCorrupt++;
                    if(column == size - 1){
                        break;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + diagonal + " " + rowsCorrupt + " " + columnsCorrupt);
        }
    }
}