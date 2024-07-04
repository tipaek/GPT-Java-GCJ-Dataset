import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc;
        if (System.getProperty("user.name").equals("Alexey")) {
            sc = new Scanner(new FileInputStream("input.txt"));
            System.err.println("development mode, reading from file");
        } else {
            sc = new Scanner(System.in);
        }

        int testCases = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= testCases; i++) {
            String[] taskLine1 = sc.nextLine().split(" ");
            long x = Long.parseLong(taskLine1[0]);
            long y = Long.parseLong(taskLine1[1]);
            String result = resolveSingleCase(x, y);
            System.out.println("Case #" + i + ": " + result);
        }
        sc.close();
    }

    private static String resolveSingleCase(long x, long y) {
        for (int i = 0; i <= 10000; i++) {
            String comb = Integer.toString(i, 4);
            if (isValidCombination(comb, x, y)) {
                return convertToResult(comb);
            }
            for (int j = 1; j < 10; j++) {
                comb = '0' + comb;
                if (isValidCombination(comb, x, y)) {
                    return convertToResult(comb);
                }
            }
        }
        return "IMPOSSIBLE";
    }

    private static boolean isValidCombination(String comb, long x, long y) {
        Coord sum = calculateSum(comb);
        return sum.x == x && sum.y == y;
    }

    private static String convertToResult(String comb) {
        return comb.replace('0', 'W').replace('1', 'E').replace('2', 'S').replace('3', 'N');
    }

    private static Coord calculateSum(String comb) {
        long x = 0;
        long y = 0;

        for (int i = 0; i < comb.length(); i++) {
            long jump = 1L << i;
            switch (comb.charAt(i)) {
                case '0': // W
                    x -= jump;
                    break;
                case '1': // E
                    x += jump;
                    break;
                case '2': // S
                    y -= jump;
                    break;
                case '3': // N
                    y += jump;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid direction");
            }
        }
        return new Coord(x, y);
    }

    static class Coord {
        long x, y;

        Coord(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + "," + y;
        }
    }
}