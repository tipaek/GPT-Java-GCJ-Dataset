import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        int q = 0;

        while (t != 0) {
            int a = 0, b = 0, c = 0;
            int n = scanner.nextInt();
            int[][] z = new int[n][n];

            for (int i = 0; i < n; ++i) {
                int[] cr = new int[100];
                for (int j = 0; j < n; ++j) {
                    z[i][j] = scanner.nextInt();
                    if (i == j) {
                        a += z[i][j];
                    }

                    cr[z[i][j]]++;
                    if (cr[z[i][j]] > 1) {
                        if (b <= i) {
                            b++;
                        }
                    }
                }
            }

            for (int i = 0; i < n; ++i) {
                int[] cc = new int[100];
                for (int j = 0; j < n; ++j) {
                    cc[z[j][i]]++;
                    if (cc[z[j][i]] > 1) {
                        if (c <= j) {
                            c++;
                        }
                    }
                }
            }

            q++;
            System.out.printf("case #%d: %d %d %d\n", q, a, b, c);

            t--;
        }

        scanner.close();
    }
}