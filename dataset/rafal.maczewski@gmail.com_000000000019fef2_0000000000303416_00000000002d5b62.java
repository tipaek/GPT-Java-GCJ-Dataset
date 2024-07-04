import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            solve(i, in);
        }
    }

    static StringBuffer response;

    private static void solve(int caseNr, Scanner in) {
        int x = in.nextInt();
        int y = in.nextInt();

        for (int len = 1; len <= 8; len++) {
            int []arr = new int[len];

            while (true) {
                if (trySolution(arr, x, y)) {
                    printOutput(arr, caseNr);
                    return;
                } else {
                    if (increaseArray(arr)) {
                        break;
                    }
                }
            }
        }

        System.out.println("Case #" + caseNr + ": " + "IMPOSSIBLE");

    }

    private static void printOutput(int[] arr, int caseNr) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                result.append("E");
            } else if (arr[i] == 1) {
                result.append("W");
            } else if (arr[i] == 2) {
                result.append("N");
            } else {
                result.append("S");
            }

        }
        System.out.println("Case #" + caseNr + ": " + result);
    }

    private static boolean trySolution(int[] arr, int X, int Y) {
        int v = 1;
        int x = 0, y = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                x += v;
            } else if (arr[i] == 1) {
                x -= v;
            } else if (arr[i] == 2) {
                y += v;
            } else {
                y -= v;
            }

            v = v * 2;
        }
        return X == x && y == Y;
    }

    private static boolean increaseArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 3) {
                arr[i]++;
                for (int j = 0; j < i; j++) {
                    arr[j] = 0;
                }
                return false;
            }
        }
        return true;
    }

}