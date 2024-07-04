import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            
            int n = in.nextInt();
            
            int[][] matrix = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            
            run(matrix, n);
        }
    }
    
    public static void run(int[][] matrix, int n)
    {
        int columns = 0;
        int rows = 0;
        int sum = 0;
        
        List<Integer> list = new ArrayList();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (list.contains(matrix[i][j])) {
                    rows++;
                    break;
                }
                
                list.add(matrix[i][j]);
            }
            
            sum += matrix[i][i];
            
            list = new ArrayList();
        }
        
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (list.contains(matrix[i][j])) {
                    columns++;
                    break;
                }
                
                list.add(matrix[i][j]);
            }
            
            list = new ArrayList();
        }
        
        System.out.println(sum + " " + rows + " " + columns);
    }
    
    public static void printMatrix(int[][] result)
    {
        System.out.println();
        for (int i = 0; i < result.length; i++) {
            printArray(result[i]);
        }
    }
    
    public static void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}