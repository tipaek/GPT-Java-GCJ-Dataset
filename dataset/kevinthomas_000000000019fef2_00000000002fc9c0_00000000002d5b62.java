import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {



    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            for (int i = 0; i < testCount; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                System.out.println("Case #" + i + ": " + calcSolution(x, y));
            }
        }
    }

    private static String calcSolution(int x, int y) {
        int max = Math.max(Math.abs(x), Math.abs(y));
        String sol1 = solve(x, y, log2(max));
        if (sol1 != null) return sol1;
        String sol2 = solve(x, y, log2(max *2));
        if (sol2 != null) return sol2;
        return "IMPOSSIBLE";
    }

    private static String solve(int x, int y, int i) {
        if (i < 0) {
            if (x == 0 && y == 0) {
                return "";
            } else {
                return null;
            }
        }
        if (Math.abs(x) > Math.abs(y)) {
            if (x > 0) {
                String solE = solve(x - (int) Math.pow(2, i), y, i - 1);
                if (solE != null) return solE + "E";
            } else {
                String solW = solve(x + (int) Math.pow(2, i), y, i - 1);
                if (solW != null) return solW + "W";
            }
        } else {
            if (y > 0) {
                String solN = solve(x, y - (int) Math.pow(2, i), i - 1);
                if (solN != null) return solN + "N";
            } else {
                String solS = solve(x, y + (int) Math.pow(2, i), i - 1);
                if (solS != null) return solS + "S";
            }
        }
        return null;
    }

    private static int log2(int i) {
        return (int) Math.floor(Math.log(i) / Math.log(2));
    }

}
