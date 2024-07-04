
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
            int k = 0, r = 0, c = 0;
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for(int x=0; x<n; x++) {
                int[] check = new int[n];
                for (int y=0; y< n; y++) {
                    int data = in.nextInt();
                    matrix[x][y] = data;
                    check[data-1] = check[data-1] + 1;
                }
                boolean next = true;
                for(int y=0;y<n && next;y++){
                    if(check[y] > 1){
                        r = r + 1;
                        next = false;
                    }
                }
            }
            for(int x=0; x<n; x++) {
                k = k + matrix[x][x];
                int[] check = new int[n];
                for (int y=0; y<n; y++) {
                    int data = matrix[y][x];
                    check[data-1] = check[data-1] + 1;
                }
                boolean next = true;
                for (int y=0; y<n && next; y++) {
                    if (check[y] > 1) {
                        c = c + 1;
                        next = false;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}
