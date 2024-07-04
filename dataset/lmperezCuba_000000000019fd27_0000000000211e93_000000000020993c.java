import java.util.Scanner;

/**
 *
 * @author lmperez
 */
public class Main {

    public static int getTrace(int[][] M) {
        int trace = 0;
        for (int i = 0; i < M.length; i++) {
            trace += M[i][i];
        }
        return trace;
    }

    public static int repRows(int[][] M) {
        int sol = 0, cell;
        for (int i = 0; i < M.length; i++) {
            int MAP[] = new int[M.length + 1];
            for (int j = 0; j < M.length; j++) {
                cell = M[i][j];
                if (MAP[cell]++ == 1) {
                    sol++;
                    break;
                }
            }
        }
        return sol;
    }

    public static int repCols(int[][] M) {
        int sol = 0, cell;
        for (int i = 0; i < M.length; i++) {
            int MAP[] = new int[M.length + 1];
            for (int j = 0; j < M.length; j++) {
                cell = M[j][i];
                if (MAP[cell]++ == 1) {
                    sol++;
                    break;
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(), K, r, c;
        for (int i = 0; i < T; i++) {
            int M_LENGHT = sc.nextInt();
            int M[][] = new int[M_LENGHT][M_LENGHT];
            for (int j = 0; j < M.length; j++) {
                for (int k = 0; k < M.length; k++) {
                    M[j][k] = sc.nextInt();
                }
            }
            K = getTrace(M);
            r = repRows(M);
            c = repCols(M);
            System.out.printf("Case #%d: %d %d %d\n", (i + 1), K, r, c);
        }
    }

}
