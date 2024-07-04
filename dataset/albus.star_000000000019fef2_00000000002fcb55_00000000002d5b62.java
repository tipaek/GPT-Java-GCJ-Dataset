import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCase = input.nextInt();

        for (int testNumber = 1; testNumber <= testCase; testNumber++) {
            pw.print("Case #" + testNumber + ": ");
            solve(input, pw);
            pw.println();
        }
        pw.close();
    }

    public static void solve(Scanner input, PrintWriter pw) throws IOException {
        long X = input.nextInt();
        long Y = input.nextInt();

        char[] wid = {'E', 'W'};
        char[] he = {'N', 'S'};
        if (X < 0) {
            char temp = wid[0];
            wid[0] = wid[1];
            wid[1] = temp;
            X = -X;
        }
        if (Y < 0) {
            char temp = he[0];
            he[0] = he[1];
            he[1] = temp;
            Y = -Y;
        }
        int[] startX = toBinary(X);
        int[] startY = toBinary(Y);
        StringBuilder sb = new StringBuilder();
        long two = 1;
        for (int i = 33; i >= 0; i--) {
            if (startX[i] == 1 && startX[i - 1] == 1) {
                if (startY[i] == 0 && startY[i - 1] == 0) {
                    sb.append(wid[0]);
                    X -= two;
                } else if (startY[i] == 0 && startY[i - 1] == 1) {
                    sb.append(wid[1]);
                    X += two;
                }
            } else if (startX[i] == 1 && startX[i - 1] == 0) {
                if (startY[i] == 0 && startY[i - 1] == 0) {
                    sb.append(wid[0]);
                    X -= two;
                } else if (startY[i] == 0 && startY[i - 1] == 1) {
                    sb.append(wid[0]);
                    X -= two;
                }
            } else if (startY[i] == 1 && startY[i - 1] == 1) {
                if (startX[i] == 0 && startX[i - 1] == 0) {
                    sb.append(he[0]);
                    Y -= two;
                } else if (startX[i] == 0 && startX[i - 1] == 1) {
                    sb.append(he[1]);
                    Y += two;
                }
            } else if (startY[i] == 1 && startY[i - 1] == 0) {
                if (startX[i] == 0 && startX[i - 1] == 0) {
                    sb.append(he[0]);
                    Y -= two;
                } else if (startX[i] == 0 && startX[i - 1] == 1) {
                    sb.append(he[0]);
                    Y -= two;
                }
            } else {
                pw.print("IMPOSSIBLE");
                return;
            }

            if (X == 0 && Y == 0) {
                pw.print(sb);
                return;
            } else {
                startX = toBinary(X);
                startY = toBinary(Y);
            }
            two *= 2;
        }
        pw.print("IMPOSSIBLE");
    }

    public static int[] toBinary(long number) {
        int[] chars = new int[34];
        int start = 33;
        while (number > 0) {
            chars[start--] = (int) (number % 2);
            number /= 2;
        }
        return chars;
    }

    public static class Scanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stk;

        public Scanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            nullOrGet();
            return Integer.parseInt(stk.nextToken());
        }

        public long nextLong() throws IOException {
            nullOrGet();
            return Long.parseLong(stk.nextToken());
        }

        public String next() throws IOException {
            nullOrGet();
            return stk.nextToken();
        }

        private StringTokenizer nullOrGet() throws IOException {
            if (stk == null || !stk.hasMoreTokens()) {
                stk = new StringTokenizer(bufferedReader.readLine());
            }
            return stk;
        }
    }

}
