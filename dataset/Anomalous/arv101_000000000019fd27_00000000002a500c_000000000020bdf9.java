import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        for (int q = 0; q < T; q++) {
            boolean keepGoing = true;
            StringBuilder answer = new StringBuilder();
            int N = Integer.parseInt(in.readLine());
            int[][] times = new int[2][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer line = new StringTokenizer(in.readLine());
                times[0][i] = Integer.parseInt(line.nextToken());
                times[1][i] = Integer.parseInt(line.nextToken());
            }

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int r = 0; r < 2; r++) {
                for (int c = 0; c < N; c++) {
                    if (times[r][c] > max) max = times[r][c];
                    if (times[r][c] < min) min = times[r][c];
                }
            }

            for (int i = min; i <= max; i++) {
                boolean cam = true, jam = true;
                if (!keepGoing) break;

                for (int c = 0; c < N; c++) {
                    if (times[0][c] <= i && i <= times[1][c]) {
                        if (cam) {
                            cam = false;
                            if (i == times[0][c]) answer.append("C");
                            if (i == times[1][c]) cam = true;
                        } else if (jam) {
                            jam = false;
                            if (i == times[0][c]) answer.append("J");
                            if (i == times[1][c]) jam = true;
                        } else {
                            answer = new StringBuilder("IMPOSSIBLE");
                            keepGoing = false;
                            break;
                        }
                    }
                }
            }

            if (!answer.toString().equals("IMPOSSIBLE")) {
                answer.setLength(answer.length() / 2);
            }

            System.out.println("Case #" + (q + 1) + ": " + answer);
        }
    }
}