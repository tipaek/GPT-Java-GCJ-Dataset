import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        int T = input.nextInt(); 
        for (int i = 0; i < T; i++) {
            int size = input.nextInt(); 
            int[][] matrix = new int[size][size]; 
            for (int k = 0; k < size; k++) {
                for (int j = 0; j < size; j++) {
                    matrix[k][j] = input.nextInt(); 
                }
            }
            String s = String.format("Case #%d: ", i+1); 
            System.out.println(s + trace(s)); 
        }
    }
    
    public static String trace(int[][] matrix) {
        int trace = 0;
        int rowsRepeated = 0; 
        int colsRepeated = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
            Set<Integer> row = new HashSet<>(Arrays.asList(matrix[i]));
            Set<Integer> col = new HashSet<>(); 
            for (int j = 0; j < matrix.length; j++) {
                col.add(matrix[j][i]);
            }
            if (row.size() < matrix.length) {
                rowsRepeated += 1; 
            }
            if (col.size() < matrix.length) {
                colsRepeated += 1; 
            }
        }
        return Integer.toString(trace) + " " + Integer.toString(rowsRepeated)
         + " " + Integer.toString(colsRepeated); 
    }
}