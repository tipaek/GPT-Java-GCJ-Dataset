import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int trace = 0;
            int[][] mat = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mat[j][k] = in.nextInt();
                    if (j == k) trace += mat[j][k];
                }
            }

            int rowRep = 0;
            for (int j = 0; j < n; j++) {
                boolean[] check = new boolean[n];
                for (int k = 0; k < n; k++) {

                    int num = mat[j][k];
                    if (check[num - 1]) {
                        rowRep ++;
                        break;
                    } else {
                        check[num - 1] = true;
                    }
                }
            }

            int colRep = 0;
            for (int j = 0; j < n; j++) {
                boolean[] check = new boolean[n];
                for (int k = 0; k < n; k++) {

                    int num = mat[k][j];
                    if (check[num - 1]) {
                        colRep ++;
                        break;
                    } else {
                        check[num - 1] = true;
                    }
                }
            }

            System.out.println("Case#" + (t + 1) + ": " + trace + " " + rowRep + " " + colRep);
        }
    }
}
