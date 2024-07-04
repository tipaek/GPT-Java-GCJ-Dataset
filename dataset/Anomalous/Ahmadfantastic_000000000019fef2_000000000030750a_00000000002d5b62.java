import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Expogo {

    private static final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final int MAX = 30;
    private static final int[] N = new int[MAX];
    private static final int[] C = new int[MAX];
    private static final HashMap<Integer, Integer> C_MAP = new HashMap<>();

    public static void main(String[] args) {

        // Precompute powers of 2 and cumulative sums
        for (int i = 1; i < MAX; i++) {
            N[i] = 1 << (i - 1);
            C[i] = C[i - 1] + N[i];
            C_MAP.put(C[i], i);
        }

        int T = Integer.parseInt(in.nextLine());

        for (int t = 1; t <= T; t++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            if (in.hasNext()) {
                in.nextLine();
            }

            String result = solve(X, Y);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String solve(int X, int Y) {
        if ((Math.abs(X) % 2 == Math.abs(Y) % 2)) {
            return "IMPOSSIBLE";
        } else if (X == 0) {
            return solveSingleAxis(Y, "N", "S");
        } else if (Y == 0) {
            return solveSingleAxis(X, "E", "W");
        } else {
            return solveGeneralCase(X, Y);
        }
    }

    private static String solveSingleAxis(int value, String positiveDir, String negativeDir) {
        if (C_MAP.containsKey(Math.abs(value))) {
            String direction = value > 0 ? positiveDir : negativeDir;
            return loop(direction, C_MAP.get(Math.abs(value)));
        } else {
            return "IMPOSSIBLE";
        }
    }

    private static String solveGeneralCase(int X, int Y) {
        int even = Math.abs(X % 2 == 0 ? X : Y);
        int posOfJustToEven = findPosition(even);
        int[] used = new int[MAX];
        int numJustToEven = markUsed(used, even, posOfJustToEven);

        int total = accumulateUsed(used, even, posOfJustToEven, numJustToEven);

        int odd = Math.abs(X % 2 == 0 ? Y : X);
        int oddTotal = markOddUsed(used, odd);

        if (oddTotal == odd) {
            return buildResult(X, Y, used);
        } else {
            return "IMPOSSIBLE";
        }
    }

    private static int findPosition(int value) {
        for (int i = 1; i < MAX; i++) {
            if (N[i] >= value) {
                return N[i] == value ? i : i - 1;
            }
        }
        return -1;
    }

    private static int markUsed(int[] used, int even, int posOfJustToEven) {
        int numJustToEven = N[posOfJustToEven];
        used[posOfJustToEven] = 2;
        return numJustToEven;
    }

    private static int accumulateUsed(int[] used, int even, int posOfJustToEven, int total) {
        for (int i = posOfJustToEven - 1; i > 1; i--) {
            if (total + N[i] <= even) {
                total += N[i];
                used[i] = 2;
            }
            if (total == even) {
                break;
            }
        }
        return total;
    }

    private static int markOddUsed(int[] used, int odd) {
        int oddTotal = odd == 1 ? 1 : -1;
        used[1] = 1;
        if (odd != 1) {
            for (int i = 2; i < MAX; i++) {
                if (used[i] == 0) {
                    oddTotal += N[i];
                    used[i] = 1;
                    if (oddTotal >= odd) {
                        break;
                    }
                }
            }
        }
        return oddTotal;
    }

    private static String buildResult(int X, int Y, int[] used) {
        StringBuilder result = new StringBuilder(X % 2 == 1 ? (X > 0 ? "W" : "E") : (Y > 0 ? "S" : "N"));
        for (int i = 2; i < MAX; i++) {
            if (used[i] == 0) {
                break;
            } else if (used[i] == 1) {
                result.append(X % 2 == 1 ? (X > 0 ? "E" : "W") : (Y > 0 ? "N" : "S"));
            } else {
                result.append(X % 2 == 0 ? (X > 0 ? "E" : "W") : (Y > 0 ? "N" : "S"));
            }
        }
        return result.toString();
    }

    private static String loop(String s, int count) {
        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sB.append(s);
        }
        return sB.toString();
    }
}