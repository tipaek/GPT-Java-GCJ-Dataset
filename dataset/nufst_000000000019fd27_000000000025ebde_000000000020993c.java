import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = 0;
        if(scanner.hasNextInt())
            t = scanner.nextInt();
        for(int i = 0 ; i < t ; i++) {
            int n = 0;
            if(scanner.hasNextInt())
                n = scanner.nextInt();
            int r = 0;
            int c = 0;
            int trace = 0;
            int[] arr;
            int[][] matrix = new int[n][n];
            for(int j = 0 ; j < n ; j++) {
                arr = new int[n];
                boolean flag = true;
                for(int k = 0 ; k < n ; k++) {
                    int m = 0;
                    if(scanner.hasNextInt())
                        m = scanner.nextInt();
                    matrix[j][k] = m;
                    if(arr[m-1] != 0 && flag) {
                        r++;
                        flag = false;
                    }
                    arr[m-1] = 1;
                    if(j == k) {
                        trace += m;
                    }
                }
            }
            
            for(int j = 0 ; j < n ; j++) {
                arr = new int[n];
                for(int k = 0 ; k < n ; k++) {
                    if(arr[matrix[k][j]-1] != 0) {
                        c++;
                        break;
                    }
                    arr[matrix[k][j]-1] = 1;
                }
            }
            System.out.println("Case #" + (i+1) + ": " + trace + " " + r + " " + c);
        }
    }
}