import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(new File("a.in")))));
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] a = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }
            int k = 0;
            for (int i = 0; i < N; i++) {
                k += a[i][i];
            }
            int r = 0;
            for (int i = 0; i < N; i++) {
                boolean[] m = new boolean[N];
                for (int j = 0; j < N; j++) {
                    if (m[a[i][j] - 1]) {
                        r++;
                        break;
                    }
                    m[a[i][j] - 1] = true;
                }
            }
            int c = 0;
            for (int i = 0; i < N; i++) {
                boolean[] m = new boolean[N];
                for (int j = 0; j < N; j++) {
                    if (m[a[j][i] - 1]) {
                        c++;
                        break;
                    }
                    m[a[j][i] - 1] = true;
                }
            }
            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
        }
    }
}
