import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, UTF_8));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out, UTF_8))) {
            int tests = parseInt(in.readLine().trim());
            for (int t = 1; t <= tests; t++) {
                StringTokenizer tokens = new StringTokenizer(in.readLine());
                int x = parseInt(tokens.nextToken());
                int y = parseInt(tokens.nextToken());
                String m = tokens.nextToken();
                int[] posX = new int[m.length() + 1];
                int[] posY = new int[m.length() + 1];
                posX[0] = x;
                posY[0] = y;
                for (int i = 1; i <= m.length(); i++) {
                    char c = m.charAt(i - 1);
                    if (c == 'W') {
                        posX[i] = posX[i - 1] - 1;
                        posY[i] = posY[i - 1];
                    } else if (c == 'E') {
                        posX[i] = posX[i - 1] + 1;
                        posY[i] = posY[i - 1];
                    } else if (c == 'N') {
                        posY[i] = posY[i - 1] + 1;
                        posX[i] = posX[i - 1];
                    } else if (c == 'S') {
                        posY[i] = posY[i - 1] - 1;
                        posX[i] = posX[i - 1];
                    }
                }
                int answer = -1;
                for (int i = 1; i <= m.length(); i++) {
                    if (abs(posX[i]) + abs(posY[i]) <= i) {
                        answer = i;
                        break;
                    }
                }
                out.write("Case #" + t + ": " + (answer > -1 ? answer + "" : "IMPOSSIBLE"));
                out.newLine();
            }
        }
    }
}
