import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            int trace = findTrace(matrix);
            int r = rowRepeats(matrix);
            int c = colRepeats(matrix);
            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }
    
    public static int findTrace(int[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            result += matrix[i][i];
        }
        return result;
    }
    
    public static int rowRepeats(int[][] matrix) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (!map.containsKey(matrix[i][j])) {
                    map.put(matrix[i][j], 1);
                } else {
                    result++;
                    break;
                }
            }
            map.clear();
        }
        return result;
    }
    
    public static int colRepeats(int[][] matrix) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (!map.containsKey(matrix[i][j])) {
                    map.put(matrix[i][j], 1);
                } else {
                    result++;
                    break;
                }
            }
            map.clear();
        }
        return result;
    }
}