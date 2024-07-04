import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private void solve() throws IOException {
        int x = nextInt();
        int y = nextInt();
        int sx = x < 0 ? -1 : 1;
        int sy = y < 0 ? -1 : 1;
        x = Math.abs(x);
        y = Math.abs(y);

        char[] binaryX = Integer.toBinaryString(x).toCharArray();
        char[] binaryY = Integer.toBinaryString(y).toCharArray();

        boolean[] X = new boolean[33];
        boolean[] Y = new boolean[33];
        long[] powers = new long[33];

        powers[0] = 1;
        for (int i = 0; i < X.length; i++) {
            if (i < binaryX.length) X[i] = binaryX[binaryX.length - i - 1] == '1';
            if (i < binaryY.length) Y[i] = binaryY[binaryY.length - i - 1] == '1';
            if (i > 0) powers[i] = powers[i - 1] * 2;
        }

        for (int max = Math.max(binaryX.length, binaryY.length); max < Math.max(binaryX.length, binaryY.length) + 3; max++) {
            for (int mask = 0; mask < (1 << 16); mask++) {
                boolean[] takeX = new boolean[33];
                char[] result = new char[33];
                int length = 0, id = 0;

                for (int i = 0; i < max; i++) {
                    if (X[i]) {
                        length++;
                    } else {
                        if (length == 0) continue;
                        if ((mask & (1 << id)) > 0) {
                            for (int j = i - length; j < i; j++) {
                                takeX[j] = true;
                                result[j] = sx == 1 ? 'E' : 'W';
                            }
                        } else {
                            takeX[i] = true;
                            result[i] = sx == 1 ? 'E' : 'W';
                            takeX[i - length] = true;
                            result[i - length] = sx == 1 ? 'W' : 'E';
                        }
                        id++;
                        length = 0;
                    }
                }

                if (X[max - 1]) {
                    for (int j = max - length; j < max; j++) {
                        takeX[j] = true;
                        result[j] = sx == 1 ? 'E' : 'W';
                    }
                }

                boolean[] takeY = new boolean[33];
                boolean invalid = false;
                long sum = 0;
                length = 0;

                for (int i = 0; i < max; i++) {
                    if (sum == y) break;
                    takeY[i] = !takeX[i];
                    if (Y[i]) {
                        length++;
                    } else {
                        if (takeY[i]) {
                            if (length == 0 || !takeY[i - length]) invalid = true;
                            result[i] = sy == 1 ? 'N' : 'S';
                            result[i - length] = sy == 1 ? 'S' : 'N';
                            sum += powers[i] - powers[i - length];
                        } else {
                            for (int j = i - length; j < i; j++) {
                                if (!takeY[j]) invalid = true;
                                sum += powers[j];
                                result[j] = sy == 1 ? 'N' : 'S';
                            }
                        }
                        length = 0;
                    }
                }

                if (Y[max - 1]) {
                    for (int j = max - length; j < max; j++) {
                        if (!takeY[j]) invalid = true;
                        sum += powers[j];
                        result[j] = sy == 1 ? 'N' : 'S';
                    }
                }

                for (int i = 0; i < max; i++) {
                    if (takeX[i] == takeY[i]) invalid = true;
                }

                int finalX = 0, finalY = 0;
                for (int i = 0; i < max; i++) {
                    switch (result[i]) {
                        case 'N': finalY += powers[i]; break;
                        case 'S': finalY -= powers[i]; break;
                        case 'E': finalX += powers[i]; break;
                        case 'W': finalX -= powers[i]; break;
                        default: invalid = true;
                    }
                }

                if (x * sx != finalX || y * sy != finalY || invalid) continue;

                out.println(new String(result, 0, max));
                return;
            }
        }
        out.println("IMPOSSIBLE");
    }

    private void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            int t = nextInt();
            for (int i = 0; i < t; i++) {
                out.print(String.format("Case #%d: ", i + 1));
                solve();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}