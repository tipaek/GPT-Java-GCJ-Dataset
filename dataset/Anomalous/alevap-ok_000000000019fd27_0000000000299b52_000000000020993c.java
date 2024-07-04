import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(br.readLine());
            for (int i = 1; i <= T; i++) {
                int N = Integer.parseInt(br.readLine());
                boolean[][] columns = new boolean[N][N];
                int trace = 0, rowRepeats = 0, colRepeats = 0;

                for (int j = 0; j < N; j++) {
                    boolean[] rowCheck = new boolean[N];
                    String[] rowValues = br.readLine().split(" ");

                    for (int k = 0; k < N; k++) {
                        int num = Integer.parseInt(rowValues[k]) - 1;

                        if (j == k) {
                            trace += num + 1;
                        }
                        if (rowCheck[num]) {
                            rowRepeats++;
                        }
                        rowCheck[num] = true;

                        if (columns[k][num]) {
                            colRepeats++;
                        }
                        columns[k][num] = true;
                    }
                }

                bw.write(String.format("Case #%d: %d %d %d", i, trace, rowRepeats, colRepeats));
                bw.newLine();
            }

            bw.flush();
        }
    }
}