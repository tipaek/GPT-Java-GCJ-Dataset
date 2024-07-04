import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int i = 0; i < t; i++) {
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
            int sum = 0;
            int rowRepeat = 0;
            int colRepeat = 0;
            for(int x = 0; x < n; x++) {
                for(int y = 0; y < n; y++) {
                    int temp = input.nextInt();
                    matrix[x][y] = temp;
                    if(x == y) {
                        sum += matrix[x][y];
                    }
                }
            }
            for(int x = 0; x < n; x++) {
                boolean[] used = new boolean[n + 1];
                for(int y = 0; y < n; y++) {
                    if(used[matrix[x][y]]) {
                        rowRepeat++;
                        break;
                    } else used[matrix[x][y]] = true;
                }
            }
            for(int x = 0; x < n; x++) {
                boolean[] used = new boolean[n + 1];
                for(int y = 0; y < n; y++) {
                    if(used[matrix[y][x]]) {
                        colRepeat++;
                        break;
                    } else used[matrix[y][x]] = true;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + sum + " " + rowRepeat + " " + colRepeat);
        }
    }
}
