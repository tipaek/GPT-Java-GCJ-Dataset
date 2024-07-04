import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[][] result = new int[t][4];
        for (int i = 0; i < t; i++) {
            result[i][0] = i + 1;
            int n = scanner.nextInt();
            int trace = 0;
            int[][] array = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    array[j][k] = scanner.nextInt();
                    if (j == k) {
                        trace += array[j][k];
                    }
                }
            }
            result[i][1] = trace;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < k; l++) {
                        if (array[j][l] == array[j][k]) {
                            result[i][2]++;
                            break;
                        }
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < k; l++) {
                        if (array[j][l] == array[j][k]) {
                            result[i][3]++;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + result[i][0] + ": " + result[i][1] + " " + result[i][2] + " " + result[i][3]);
        }
    }
}