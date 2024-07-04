import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int loop = 1; loop <= t; loop++) {
            int size = in.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            
            // Loop through each row
            int r = 0;
            for (int j = 0; j < size; j++) {
                if (hasDuplicates(matrix[j])) {
                    r++;
                }
            }
            
            // Loop through each column
            int c = 0;
            for (int j = 0; j < size; j++) {
                int[] temp = new int[size];
                for (int k = 0; k < size; k++) {
                    temp[k] = matrix[k][j];
                }
                if (hasDuplicates(temp)) {
                    c++;
                }
            }
            
            // Compute trace
            int trace = 0;
            for (int x = 0; x < size; x++) {
                trace += matrix[x][x];
            }
            
            // Print desired results
            System.out.println("Case #" + loop + ": " + trace + " " + r + " " + c);
        }
    }
    
    public static boolean hasDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}