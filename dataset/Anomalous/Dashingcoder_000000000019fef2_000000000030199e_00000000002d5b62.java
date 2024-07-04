import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    private static final long[] arr = new long[31];
    private static final long[] arr1 = new long[31];
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(System.out, false);

    static {
        long k = 1;
        long b = 1;
        for (int i = 0; i < 31; i++) {
            b = b << 1;
            arr1[i] = b - 1;
            if (i == 0) {
                arr[i] = 1;
            } else {
                k = k << 1;
                arr[i] = k;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if (isPossible(X, Y)) {
                handleSimpleCases(i, X, Y);
            } else {
                handleComplexCases(i, X, Y);
            }
        }
        pw.flush();
    }

    private static void handleSimpleCases(int caseNumber, int X, int Y) {
        if (X == 0) {
            handleZeroX(caseNumber, Y);
        } else if (Y == 0) {
            handleZeroY(caseNumber, X);
        } else {
            handleNonZeroXY(caseNumber, X, Y);
        }
    }

    private static void handleZeroX(int caseNumber, int Y) {
        for (int j = 0; j < arr1.length; j++) {
            if (Math.abs(Y) == arr1[j]) {
                String direction = (Y > 0) ? "N" : "S";
                pw.print("Case #" + caseNumber + ": ");
                for (int k = 0; k <= j; k++) {
                    pw.print(direction);
                }
                pw.println();
                return;
            }
        }
        pw.println("Case #" + caseNumber + ": IMPOSSIBLE");
    }

    private static void handleZeroY(int caseNumber, int X) {
        for (int j = 0; j < arr1.length; j++) {
            if (Math.abs(X) == arr1[j]) {
                String direction = (X > 0) ? "E" : "W";
                pw.print("Case #" + caseNumber + ": ");
                for (int k = 0; k <= j; k++) {
                    pw.print(direction);
                }
                pw.println();
                return;
            }
        }
        pw.println("Case #" + caseNumber + ": IMPOSSIBLE");
    }

    private static void handleNonZeroXY(int caseNumber, int X, int Y) {
        if ((Math.abs(X) == arr[0] && Math.abs(Y) == arr[1]) ||
            (Math.abs(Y) == arr[0] && Math.abs(X) == arr[1])) {
            pw.print("Case #" + caseNumber + ": ");
            if (Math.abs(X) == arr[0]) {
                pw.print((X < 0) ? "W" : "E");
                pw.print((Y > 0) ? "N" : "S");
            } else {
                pw.print((Y < 0) ? "S" : "N");
                pw.print((X > 0) ? "E" : "W");
            }
            pw.println();
        } else {
            pw.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    private static void handleComplexCases(int caseNumber, int X, int Y) {
        int[] res1 = checkIndex(X, Y);
        char[] result = new char[32];
        if (res1[0] == 1) {
            handleDirection(caseNumber, X, Y, result, res1, 'E', 'W', 'N', 'S');
        } else if (res1[0] == 2) {
            handleDirection(caseNumber, Y, X, result, res1, 'N', 'S', 'E', 'W');
        } else if (!specialCase(X, Y, caseNumber)) {
            pw.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    private static void handleDirection(int caseNumber, int primary, int secondary, char[] result, int[] res1, char positivePrimary, char negativePrimary, char positiveSecondary, char negativeSecondary) {
        result[res1[1]] = (primary > 0) ? positivePrimary : negativePrimary;
        int s = 0;
        boolean found = false;
        for (int j = 0; j < arr.length; j++) {
            if (j == res1[1]) continue;
            if (secondary > 0) {
                s += arr[j];
                result[j] = positiveSecondary;
                found = adjustResult(result, res1, secondary, s, positiveSecondary, negativeSecondary);
            } else {
                s -= arr[j];
                result[j] = negativeSecondary;
                found = adjustResult(result, res1, secondary, s, positiveSecondary, negativeSecondary);
            }
            if (found) break;
        }
        if (!found) {
            pw.println("Case #" + caseNumber + ": IMPOSSIBLE");
        } else {
            pw.println("Case #" + caseNumber + ": " + String.valueOf(result));
        }
    }

    private static boolean adjustResult(char[] result, int[] res1, int value, int s, char positive, char negative) {
        if (Math.abs(s) > Math.abs(value)) {
            for (int e = 0; e < arr.length; e++) {
                if (e != res1[1] && Math.abs(value) == Math.abs(s - 2 * arr[e])) {
                    result[e] = (positive == result[e]) ? negative : positive;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean specialCase(int x, int y, int i) {
        if (Math.abs(x) == 2 && Math.abs(y) == 1) {
            pw.println("Case #" + i + ": " + ((y < 0) ? "S" : "N") + ((x < 0) ? "W" : "E"));
            return true;
        }
        if (Math.abs(x) == 1 && Math.abs(y) == 2) {
            pw.println("Case #" + i + ": " + ((x < 0) ? "W" : "E") + ((y < 0) ? "S" : "N"));
            return true;
        }
        return false;
    }

    private static int[] checkIndex(int X, int Y) {
        int[] result = new int[2];
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == Math.abs(X)) {
                result[0] = 1;
                result[1] = j;
                break;
            }
            if (arr[j] == Math.abs(Y)) {
                result[0] = 2;
                result[1] = j;
                break;
            }
        }
        return result;
    }

    private static boolean isPossible(int X, int Y) {
        boolean a = false;
        boolean b = false;
        for (long value : arr) {
            if (value == Math.abs(X)) a = true;
            if (value == Math.abs(Y)) b = true;
        }
        if (a && b) return false;
        for (long value : arr1) {
            if (value == Math.abs(X)) a = true;
            if (value == Math.abs(Y)) b = true;
        }
        return !(a && b);
    }
}