import java.io.*;
import java.util.*;

public class Solution {
    private static final int DIV = 1024;

    private enum Direction {
        N(0, 1), E(1, 0), S(0, -1), W(-1, 0);

        private final int x;
        private final int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();

            int T = Integer.parseInt(br.readLine());

            for (int t = 1; t <= T; t++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String result = "IMPOSSIBLE";
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                String M = st.nextToken();

                int i;
                for (i = 1; i <= M.length(); i++) {
                    Direction direction = Direction.valueOf(String.valueOf(M.charAt(i-1)));
                    X += direction.x;
                    Y += direction.y;
                    if(isPossible(X, Y, i)){
                        result = String.valueOf(i);
                        break;
                    }
                }

                sb.append(String.format("Case #%d: %s\n", t, result));
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }

    private static boolean isPossible(int x, int y, int t){
        return Math.abs(x) + Math.abs(y) <= t;
    }

}