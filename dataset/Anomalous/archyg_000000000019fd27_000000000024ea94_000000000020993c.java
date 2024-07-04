import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int size = sc.nextInt();
            int[][] arr = new int[size][size];
            int diagonal = 0;
            int rowCount = 0;
            int colCount = 0;
            
            for (int j = 0; j < size; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int k = 0; k < size; k++) {
                    arr[j][k] = sc.nextInt();
                    if (j == k) {
                        diagonal += arr[j][k];
                    }
                    rowSet.add(arr[j][k]);
                }
                if (rowSet.size() < size) {
                    rowCount++;
                }
            }
            
            for (int j = 0; j < size; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int k = 0; k < size; k++) {
                    if (colSet.contains(arr[k][j])) {
                        colCount++;
                        break;
                    }
                    colSet.add(arr[k][j]);
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + diagonal + " " + rowCount + " " + colCount);
        }
        
        sc.close();
    }
}