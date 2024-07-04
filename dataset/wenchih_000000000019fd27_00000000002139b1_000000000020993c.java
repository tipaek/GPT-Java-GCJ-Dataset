import java.util.*;
import java.util.Scanner;
public class Solution {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int k = 1; k <= num; k++) {
            int n = scanner.nextInt();
            int matrix[][] = new int[n][n];
            for(int i = 0; i < n; i++) {
                scanner.nextLine();
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int result[] = helper(matrix, n);
            System.out.println("Case #" + k + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }

    static int[] helper(int matrix[][], int n) {
        int result[] = new int[3];
        Set[] rowSet = new Set[n];
        Set[] colSet = new Set[n];
        for(int i = 0; i < n; i++){
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
        }
        for(int i = 0; i < n; i++) {
            Set row = rowSet[i];
            for(int j = 0; j < n; j++) {
                Set col = colSet[j];
                row.add(matrix[i][j]);
                col.add(matrix[i][j]);
                if(i == j) {
                    result[0] += matrix[i][j];
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(rowSet[i].size() < n) {
                result[1]++;
            }
            if(colSet[i].size() < n) {
                result[2]++;
            }
        }
        return result;
    }

}