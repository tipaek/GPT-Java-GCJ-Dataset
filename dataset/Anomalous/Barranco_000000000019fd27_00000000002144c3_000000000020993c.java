import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int cases = sc.nextInt();
        for (int cnumber = 1; cnumber <= cases; cnumber++) {
            int size = sc.nextInt();
            int repeatRows = 0;
            int repeatCols = 0;
            int diagonalSum = 0;
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    int number = sc.nextInt();
                    matrix[i][j] = number;
                    rowSet.add(number);
                    if (i == j) {
                        diagonalSum += number;
                    }
                }
                if (rowSet.size() != size) {
                    repeatRows++;
                }
            }
            
            for (int j = 0; j < size; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != size) {
                    repeatCols++;
                }
            }
            
            System.out.println("Case #" + cnumber + ": " + diagonalSum + " " + repeatRows + " " + repeatCols);
        }
        
        sc.close();
    }
}