
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scanner.nextInt();
                    if (j == k) {
                        sum += matrix[j][k];
                    }
                }
            }
            int row = 0;
            for (int j = 0; j < n; j++) {
                HashSet<Integer> hash= new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if(hash.contains(matrix[j][k])){
                        row++;
                        break;
                    }else{
                        hash.add(matrix[j][k]);
                    }
                }
            }
            int col = 0;
            for (int j = 0; j < n; j++) {
                HashSet<Integer> hash= new HashSet<>();
                for (int k = 0; k < n; k++) {
                    if(hash.contains(matrix[k][j])){
                        col++;
                        break;
                    }else{
                        hash.add(matrix[k][j]);
                    }
                }
            }
            System.out.println(String.format("Case #%d: %d %d %d",i,sum,row,col));
        }
    }
}
