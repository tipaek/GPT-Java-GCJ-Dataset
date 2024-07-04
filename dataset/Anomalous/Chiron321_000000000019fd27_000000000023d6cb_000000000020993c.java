import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;
            int rowDuplicates = 0;
            
            for (int i = 0; i < size; i++) {
                boolean rowHasDuplicate = false;
                for (int j = 0; j < size; j++) {
                    int value = sc.nextInt();
                    if (!rowHasDuplicate && contains(matrix[i], value)) {
                        rowDuplicates++;
                        rowHasDuplicate = true;
                    }
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                }
            }
            
            int columnDuplicates = 0;
            
            for (int j = 0; j < size; j++) {
                int[] column = new int[size];
                for (int i = 0; i < size; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    columnDuplicates++;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
            caseNumber++;
        }
        
        sc.close();
    }

    private static boolean contains(int[] arr, int value) {
        for (int element : arr) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDuplicates(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}