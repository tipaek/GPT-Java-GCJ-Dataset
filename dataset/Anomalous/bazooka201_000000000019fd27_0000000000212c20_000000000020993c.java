import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int runs = Integer.parseInt(console.nextLine());
        
        for (int run = 1; run <= runs; run++) {
            int size = Integer.parseInt(console.nextLine());
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                String[] line = console.nextLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            
            int total = 0;
            for (int i = 0; i < size; i++) {
                total += matrix[i][i];
            }
            System.out.print("Case #" + run + ": " + total + " ");
            
            int rows = 0;
            for (int i = 0; i < size; i++) {
                if (hasDuplicate(matrix[i])) {
                    rows++;
                }
            }
            System.out.print(rows + " ");
            
            int columns = 0;
            for (int i = 0; i < size; i++) {
                int[] column = new int[size];
                for (int j = 0; j < size; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasDuplicate(column)) {
                    columns++;
                }
            }
            System.out.println(columns);
        }
    }
    
    private static boolean hasDuplicate(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                return true;
            }
        }
        return false;
    }
}