import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in  = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        int[][] answer = new int[t][3];

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            int temp[][] = new int[n][n];

            for (int j = 0; j < n; j++) {

                for (int k = 0; k < n; k++) {
                    temp[j][k] = in.nextInt();
                }
            }

            for (int j = 0; j < n; j++) {
                answer[i][0] = answer[i][0] + temp[j][j];
            }
            
            for (int j = 0; j < n; j++) {
                boolean[] check = new boolean[n];

                for (int k = 0; k < n; k++) {
                    if (check[temp[j][k] - 1] == true) {
                        answer[i][1]++;
                        break;
                    }
                    check[temp[j][k] - 1] = true;
                }
            }
            
            for (int j = 0; j < n; j++) {
                boolean[] check = new boolean[n];

                for (int k = 0; k < n; k++) {
                    if (check[temp[k][j] - 1] == true) {
                        answer[i][2]++;
                        break;
                    }
                    check[temp[k][j] - 1] = true;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i+1) + ": " + String.valueOf(answer[i][0]) + " " + answer[i][1] + " " + answer[i][2]);
        }
    }
}