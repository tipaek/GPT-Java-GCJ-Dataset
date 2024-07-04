import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        

        int cases = sc.nextInt();

        for(int i = 1; i <= cases; i++) {
            int trace = 0;
            int r = 0;
            int c = 0;
            int size = sc.nextInt();

            int[][] matrix = new int[size][size];
            // Construct matrix
            for(int x = 0; x < size; x++) {
                for(int y = 0; y < size; y++) {
                    int a = sc.nextInt();

                    matrix[x][y] = a;
                    
                    if(x == y) {
                        trace += a; 
                    }

                }
            }

            r = findRow(matrix, size);
            c = findCol(matrix, size);


            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
            
        }
        
        
    }

    public static int findRow(int[][] arr, int s) {
        int ans = 0;

        for(int x = 0; x < s; x++) {

            Set<Integer> set = new HashSet<Integer>();

            for(int y = 0; y < s; y++) {
                
                int curr = arr[x][y];
                set.add(curr);
            }

            if(set.size() != s) {
                ans += 1;
            }
        }
        
        return ans;
    }

    public static int findCol(int[][] arr, int s) {
        int ans = 0;

        for(int x = 0; x < s; x++) {

            Set<Integer> set = new HashSet<Integer>();

            for(int y = 0; y < s; y++) {
                
                int curr = arr[y][x];
                set.add(curr);
            }

            if(set.size() != s) {
                ans += 1;
            }
        }
        
        return ans;
    }
}