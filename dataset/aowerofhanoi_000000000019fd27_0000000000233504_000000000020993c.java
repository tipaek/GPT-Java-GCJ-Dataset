import java.util.Scanner;

public class Solution {

    static void innerSolve(int T, Scanner sc) {
        int N = sc.nextInt();
        int MX[][] = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                MX[r][c] = sc.nextInt();
            }
        }
        int rs = 0, cs = 0, t = 0;
        for (int r = 0; r < N; r++) {
            boolean count[] = new boolean[N + 1];
            for (int c = 0; c < N; c++) {
                if (count[MX[r][c]]) {
                    rs++;
                    break;
                } else {
                    count[MX[r][c]] = true;
                }
            }
        }
        for (int c = 0; c < N; c++) {
            boolean count[] = new boolean[N + 1];
            for (int r = 0; r < N; r++) {
                if (count[MX[r][c]]) {
                    cs++;
                    break;
                } else {
                    count[MX[r][c]] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            t += MX[i][i];
        }

        System.out.println("Case #" + T + ": " + t + " " + rs + " " + cs);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            innerSolve(t, sc);
        }
    }
}
