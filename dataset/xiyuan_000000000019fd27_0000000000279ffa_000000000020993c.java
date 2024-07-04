import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x =new Scanner(System.in);
        int T = x.nextInt();
        int TN = 0;
        while (TN++ < T) {
            int M = x.nextInt();
            int[][] case_ = new int[M][M];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    case_[i][j] = x.nextInt();
                }
            }
            int[] answer = help(case_, M);
            System.out.println(String.format("Case #%d: %d %d %d", TN, answer[0], answer[1], answer[2]));
        }
    }

    public static int[] help(int[][] case_, int M) {
        int[] res = new int[3];
        int k = 0;
        int r = 0;
        int c = 0;
        int i = 0;
        int j = 0;
        while (i < M) {
            k += case_[i][i];
            i++;
        }
        for (i = 0; i < M; i++) {
            HashSet<Integer> rows = new HashSet<>();
            for (j = 0; j < M; j++) {
                if (rows.contains(case_[i][j])) {
                    r++;
                    break;
                }
                rows.add(case_[i][j]);
            }
        }
        for (i = 0; i < M; i++) {
            HashSet<Integer> columns = new HashSet<>();
            for (j = 0; j < M; j++) {
                if (columns.contains(case_[j][i])) {
                    c++;
                    break;
                }
                columns.add(case_[j][i]);
            }
        }
        res[0] = k;
        res[1] = r;
        res[2] = c;
        return res;
    }
}