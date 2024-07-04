import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(bf.readLine());

        for (int c = 1; c <= T; c++) {
            int N = Integer.parseInt(bf.readLine());
            int[][] mat = new int[N][N];
            int rr = 0, rc = 0, diag = 0;
            int[] rep = new int[N];

            for (int i = 0; i < N; i++) {
                boolean rowRepeat = false;
                StringTokenizer tk = new StringTokenizer(bf.readLine());

                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(tk.nextToken());
                    mat[i][j] = num;

                    if (!rowRepeat && j > 0 && Arrays.binarySearch(mat[i], 0, j, num) >= 0) {
                        rr++;
                        rowRepeat = true;
                    }

                    if (i > 0 && rep[j] == 0) {
                        for (int k = 0; k < i; k++) {
                            if (mat[k][j] == num) {
                                rep[j] = 1;
                                rc++;
                                break;
                            }
                        }
                    }

                    if (i == j) {
                        diag += num;
                    }
                }
            }

            pw.println("Case #" + c + ": " + diag + " " + rr + " " + rc);
        }

        bf.close();
        pw.flush();
        pw.close();
    }
}