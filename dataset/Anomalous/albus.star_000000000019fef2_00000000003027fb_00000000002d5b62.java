import java.io.*;
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
        long X = input.nextLong();
        long Y = input.nextLong();

        char[] wid = {'E', 'W'};
        char[] he = {'N', 'S'};

        if (X < 0) {
            swap(wid);
            X = -X;
        }
        if (Y < 0) {
            swap(he);
            Y = -Y;
        }

        int[] startX = toBinary(X);
        int[] startY = toBinary(Y);
        StringBuilder sb = new StringBuilder();
        long two = 1;

        for (int i = 33; i >= 1; i--) {
            if (!processCoordinates(startX, startY, i, X, Y, wid, he, sb)) {
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

    private static boolean processCoordinates(int[] startX, int[] startY, int i, long X, long Y, char[] wid, char[] he, StringBuilder sb) {
        long two = 1L << (i - 1);
        if (startX[i] == 1 && startX[i - 1] == 1) {
            return processDoubleOne(startX, startY, i, X, Y, wid, sb, two);
        } else if (startX[i] == 1 && startX[i - 1] == 0) {
            return processSingleOne(startX, startY, i, X, Y, wid, sb, two);
        } else if (startY[i] == 1 && startY[i - 1] == 1) {
            return processDoubleOne(startY, startX, i, Y, X, he, sb, two);
        } else if (startY[i] == 1 && startY[i - 1] == 0) {
            return processSingleOne(startY, startX, i, Y, X, he, sb, two);
        } else {
            return false;
        }
    }

    private static boolean processDoubleOne(int[] primary, int[] secondary, int i, long primaryValue, long secondaryValue, char[] directions, StringBuilder sb, long two) {
        if (secondary[i] == 0 && secondary[i - 1] == 0) {
            sb.append(directions[0]);
            primaryValue -= two;
        } else if (secondary[i] == 0 && secondary[i - 1] == 1) {
            sb.append(directions[1]);
            primaryValue += two;
        } else {
            return false;
        }
        return true;
    }

    private static boolean processSingleOne(int[] primary, int[] secondary, int i, long primaryValue, long secondaryValue, char[] directions, StringBuilder sb, long two) {
        if (secondary[i] == 0 && secondary[i - 1] == 0) {
            if (primaryValue - two == 0) {
                sb.append(directions[0]);
                primaryValue -= two;
            } else {
                sb.append(directions[1]);
                primaryValue += two;
            }
        } else if (secondary[i] == 0 && secondary[i - 1] == 1) {
            sb.append(directions[0]);
            primaryValue -= two;
        } else {
            return false;
        }
        return true;
    }

    private static void swap(char[] arr) {
        char temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }

    public static int[] toBinary(long number) {
        int[] binary = new int[34];
        int index = 33;
        while (number > 0) {
            binary[index--] = (int) (number % 2);
            number /= 2;
        }
        return binary;
    }

    public static class Scanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stk;

        public Scanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            ensureTokens();
            return Integer.parseInt(stk.nextToken());
        }

        public long nextLong() throws IOException {
            ensureTokens();
            return Long.parseLong(stk.nextToken());
        }

        public String next() throws IOException {
            ensureTokens();
            return stk.nextToken();
        }

        private void ensureTokens() throws IOException {
            if (stk == null || !stk.hasMoreTokens()) {
                stk = new StringTokenizer(bufferedReader.readLine());
            }
        }
    }
}