import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final int[] N = new int[30];
    private static final int[] C = new int[30];
    private static final HashMap<Integer, Integer> C_MAP = new HashMap<>();

    static {
        for (int i = 1; i < 30; i++) {
            N[i] = (int) Math.pow(2, i - 1);
            C[i] = C[i - 1] + N[i];
            C_MAP.put(C[i], i);
        }
    }

    public static void main(String[] args) {
        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= T; t++) {
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            if (scanner.hasNext()) {
                scanner.nextLine();
            }

            if ((Math.abs(X) % 2 == 0 && Math.abs(Y) % 2 == 0) || (Math.abs(X) % 2 == 1 && Math.abs(Y) % 2 == 1)) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else if (X == 0) {
                handleZeroCase(t, Y, "N", "S");
            } else if (Y == 0) {
                handleZeroCase(t, X, "E", "W");
            } else {
                handleGeneralCase(t, X, Y);
            }
        }
    }

    private static void handleZeroCase(int t, int coordinate, String positiveDirection, String negativeDirection) {
        if (C_MAP.containsKey(Math.abs(coordinate))) {
            if (coordinate < 0) {
                System.out.println("Case #" + t + ": " + loop(negativeDirection, C_MAP.get(Math.abs(coordinate))));
            } else {
                System.out.println("Case #" + t + ": " + loop(positiveDirection, C_MAP.get(Math.abs(coordinate))));
            }
        } else {
            System.out.println("Case #" + t + ": IMPOSSIBLE");
        }
    }

    private static void handleGeneralCase(int t, int X, int Y) {
        int even = Math.abs(X % 2 == 0 ? X : Y);
        int numJustToEven = findNumJustToEven(even);
        int posOfJustToEven = findPosOfJustToEven(even);

        int total = numJustToEven;
        int[] used = new int[30];
        used[posOfJustToEven] = 2;

        for (int i = posOfJustToEven - 1; i > 1; i--) {
            if (total + N[i] <= even) {
                total += N[i];
                used[i] = 2;
            }
            if (total == even) {
                break;
            }
        }

        int odd = Math.abs(X % 2 == 0 ? Y : X);
        int oddTotal = findOddTotal(odd, used);

        if (oddTotal == odd) {
            String result = buildResult(X, Y, used);
            System.out.println("Case #" + t + ": " + result);
        } else {
            System.out.println("Case #" + t + ": IMPOSSIBLE");
        }
    }

    private static int findNumJustToEven(int even) {
        for (int i = 1; i < 30; i++) {
            if (N[i] >= even) {
                return N[i] == even ? N[i] : N[i - 1];
            }
        }
        return -1;
    }

    private static int findPosOfJustToEven(int even) {
        for (int i = 1; i < 30; i++) {
            if (N[i] >= even) {
                return N[i] == even ? i : i - 1;
            }
        }
        return -1;
    }

    private static int findOddTotal(int odd, int[] used) {
        int oddTotal = -1;
        used[1] = 1;
        for (int i = 2; i < 30; i++) {
            if (used[i] == 0) {
                oddTotal += N[i];
                used[i] = 1;
                if (oddTotal >= odd) {
                    break;
                }
            }
        }
        return oddTotal;
    }

    private static String buildResult(int X, int Y, int[] used) {
        StringBuilder result = new StringBuilder();
        if (X % 2 == 1) {
            result.append(X > 0 ? "W" : "E");
        } else {
            result.append(Y > 0 ? "S" : "N");
        }
        for (int i = 2; i < 30; i++) {
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