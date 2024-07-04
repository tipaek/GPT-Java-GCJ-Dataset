import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static int getTrace(int mat[][]) {
        int trace = 0;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if (i == j) {
                    trace += mat[i][j];
                }
            }
        }
        return trace;
    }

    public static int getRepeatedRow(int mat[][]) {
        int ans = 0;
        for(int i = 0; i < mat.length; i++) {
            boolean isDup[] = new boolean[mat.length + 1];
            for(int j = 0; j < mat[i].length; j++) {
                if (isDup[mat[i][j]] == false) {
                    isDup[mat[i][j]] = true;
                } else {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static int getRepeatedCol(int mat[][]) {
        int ans = 0;
        for(int i = 0; i < mat.length; i++) {
            boolean isDup[] = new boolean[mat.length + 1];
            for(int j = 0; j < mat[i].length; j++) {
                if (isDup[mat[j][i]] == false) {
                    isDup[mat[j][i]] = true;
                } else {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int mat[][] = new int[N][N];

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    mat[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int trace = getTrace(mat);
            int rows = getRepeatedRow(mat);
            int cols = getRepeatedCol(mat);
            System.out.printf("Case #%d: %d %d %d\n", t + 1, trace, rows, cols);
        }
        br.close();
    }
}
