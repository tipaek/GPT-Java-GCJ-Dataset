
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String... args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = input.nextInt();
        
        for (int i = 1; i <= cases; i++) { 
            // for every test cases
            
            int size = input.nextInt();
            int repeatedC = 0;
            int repeatedR = 0;
            int vestigium = 0;
            int [][] matrix = new int[size][size];
            
            // put everything into a 2d array
            for (int j = 0; j < size; j++) {
                // for every row
                Set<Integer> row = new HashSet<>();
                for (int k = 0; k < size; k++) {
                    // for every columns
                    matrix[k][j] = input.nextInt();
                    if (j == k) {
                        vestigium += matrix[k][j];
                    }
                    row.add(matrix[k][j]);
                }
                // test row
                if (row.size() < size) {
                    repeatedR++;
                }
            }
            
            // test columns
            for (int j = 0; j < size; j++) {
                Set<Integer> column = new HashSet<Integer>();
                for (Integer k : matrix[j]) {
                    column.add(k);
                }
                if (column.size() < size)
                    repeatedC++;
            }
            
            System.out.println("Case #" + i + ": " + vestigium + " " + repeatedR + " " + repeatedC); 
        }
        
        input.close();
    }
}
