import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Solution().execute();
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
        int xx = nextInt();
        int yy = nextInt();
        int sx = xx < 0 ? -1 : 1;
        int sy = yy < 0 ? -1 : 1;
        xx = Math.abs(xx);
        yy = Math.abs(yy);

        char[] xBinary = Integer.toBinaryString(xx).toCharArray();
        char[] yBinary = Integer.toBinaryString(yy).toCharArray();

        boolean[] xBits = new boolean[33];
        boolean[] yBits = new boolean[33];
        long[] powersOfTwo = new long[33];

        powersOfTwo[0] = 1;
        for (int i = 0; i < xBits.length; i++) {
            if (xBinary.length > i) xBits[i] = xBinary[xBinary.length - i - 1] == '1';
            if (yBinary.length > i) yBits[i] = yBinary[yBinary.length - i - 1] == '1';
            if (i > 0) powersOfTwo[i] = powersOfTwo[i - 1] * 2;
        }

        int maxLength = Math.max(xBinary.length, yBinary.length);
        for (int max = maxLength; max < maxLength + 3; max++) {
            for (int mask = 0; mask < (1 << 16); mask++) {
                boolean[] takeX = new boolean[33];
                char[] result = new char[33];
                int length = 0;
                int id = 0;

                for (int i = 0; i < max; i++) {
                    if (xBits[i]) {
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
                if (xBits[max - 1]) {
                    for (int j = max - length; j < max; j++) {
                        takeX[j] = true;
                        result[j] = sx == 1 ? 'E' : 'W';
                    }
                }

                boolean[] takeY = new boolean[33];
                boolean invalid = false;
                long currentSum = 0;
                length = 0;

                for (int i = 0; i < max; i++) {
                    if (currentSum == yy) break;
                    takeY[i] = !takeX[i];
                    if (yBits[i]) {
                        length++;
                    } else {
                        if (takeY[i]) {
                            if (length == 0 || !takeY[i - length]) invalid = true;
                            result[i] = sy == 1 ? 'N' : 'S';
                            result[i - length] = sy == 1 ? 'S' : 'N';
                            currentSum += powersOfTwo[i] - powersOfTwo[i - length];
                        } else {
                            for (int j = i - length; j < i; j++) {
                                if (!takeY[j]) invalid = true;
                                currentSum += powersOfTwo[j];
                                result[j] = sy == 1 ? 'N' : 'S';
                            }
                        }
                        length = 0;
                    }
                }

                if (yBits[max - 1]) {
                    for (int j = max - length; j < max; j++) {
                        if (!takeY[j]) invalid = true;
                        currentSum += powersOfTwo[j];
                        result[j] = sy == 1 ? 'N' : 'S';
                    }
                }

                for (int i = 0; i < max; i++) {
                    if (takeX[i] == takeY[i]) invalid = true;
                }

                int finalX = 0;
                int finalY = 0;
                for (int i = 0; i < max; i++) {
                    switch (result[i]) {
                        case 'N':
                            finalY += powersOfTwo[i];
                            break;
                        case 'S':
                            finalY -= powersOfTwo[i];
                            break;
                        case 'E':
                            finalX += powersOfTwo[i];
                            break;
                        case 'W':
                            finalX -= powersOfTwo[i];
                            break;
                        default:
                            invalid = true;
                    }
                }

                if (xx * sx != finalX || yy * sy != finalY || invalid) {
                    continue;
                }

                out.println(new String(result, 0, max));
                return;
            }
        }
        out.println("IMPOSSIBLE");
    }

    private void execute() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            int t = nextInt();
            for (int i = 0; i < t; i++) {
                out.printf("Case #%d: ", i + 1);
                solve();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}