import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for(int i = 1; i <= cases; i++) {
            int size = input.nextInt();
            int[][] matrix = createMatrix(size, input);
            int k = testingk(matrix, size);
            int r = testingr(matrix, size);
            int c = testingc(matrix, size);
            printing(i, k, r, c);
        }
    }
    
    public static int[][] createMatrix(int size, Scanner input) {
        int[][] matrix = new int[size][];
        for(int i = 0; i < size; i++) {
            matrix[i] = new int[size];
            for(int j = 0; j < size; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        return matrix;
    }
    
    public static int testingk(int[][] matrix, int size) {
        int k = 0;
        for(int i = 0; i < size; i++) {
            k += matrix[i][i];
        }
        return k;
    }
    
    public static int testingr(int[][] matrix, int size) {
        int look = 0;
        Set<Integer> factorial = new HashSet<>();
        for(int i = 1; i <= size; i++) {
            factorial.add(i);
        }
        Set<Integer> checker = new HashSet<>();
        for(int i = 0; i < matrix.length; i++) {    
            for(int j = 0; j < matrix.length; j++) {
                checker.add(matrix[i][j]);
            }
            if(!checker.equals(factorial)) {
                look++;
            }
            checker.clear();
        }
        return look;
    }
    
    public static int testingc(int[][] matrix, int size) {
        int look = 0;
        Set<Integer> factorial = new HashSet<>();
        for(int i = 1; i <= size; i++) {
            factorial.add(i);
        }
        Set<Integer> checker = new HashSet<>();
        for(int i = 0; i < matrix.length; i++) {    
            for(int j = 0; j < matrix.length; j++) {
                checker.add(matrix[j][i]);
            }
            if(!checker.equals(factorial)) {
                look++;
            }
            checker.clear();
        }
        return look;
    }
    
    public static void printing(int i, int k, int r, int c) {
        System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
    }
}
