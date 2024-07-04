
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int p = 0;
        while (t-- > 0) {
            ++p;
            int n = scan.nextInt();
            int[][] mt = new int[n][n];
            int diag = 0;
            int x = 0;
            int y = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mt[i][j] = scan.nextInt();
                    if (i == j) {
                        diag += mt[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int u = 0;
                    for (int k = i; k <= i; k++) {
                        for (int l = 0; l < n; l++) {
                            if (mt[i][j] == mt[k][l]) {
                                u++;

                            }
                            if (u >= 2) {
                                break;
                            }
                        }
                        if (u >= 2) {
                            ++x;
                            break;
                        }

                    }
                    if (u >= 2) {
                        break;
                    }
                }

            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int u = 0;
                    for (int k = i; k <= i; k++) {
                        for (int l = 0; l < n; l++) {
                            if (mt[i][j] == mt[l][k]) {
                                u++;

                            }
                            if (u >= 2) {
                                break;
                            }
                        }
                        if (u >= 2) {
                            ++y;
                            break;
                        }

                    }
                    if (u >= 2) {
                        break;
                    }
                }

            }
            System.out.println("Case #" + p + ": " + diag + " " + x + " " + y);

        }

    }

}
