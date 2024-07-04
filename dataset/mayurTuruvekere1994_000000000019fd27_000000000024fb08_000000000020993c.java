import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int x = 1; x <= t; x++) {
            int n = scan.nextInt();
            int rows = 0;
            int cols = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            int[][] arr = new int[n][n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                map = new HashMap<>();
                boolean check = false;
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scan.nextInt();
                    if (!map.containsKey(arr[i][j])) {
                        map.put(arr[i][j], 1);
                    } else {
                        if (!check) {
                            rows++;
                            check = true;
                        }
                    }
                    if (i == j) {
                        sum += arr[i][j];
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                map = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (!map.containsKey(arr[j][i])) {
                        map.put(arr[j][i], 1);
                    } else {
                        cols++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + x + ": " + sum + " " + rows + " " + cols);
        }
    }
}
