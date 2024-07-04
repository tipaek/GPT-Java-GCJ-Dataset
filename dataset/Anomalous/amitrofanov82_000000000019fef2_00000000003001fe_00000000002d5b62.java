import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = createScanner();
        int testCases = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= testCases; i++) {
            String[] taskLine = sc.nextLine().split(" ");
            long x = Long.parseLong(taskLine[0]);
            long y = Long.parseLong(taskLine[1]);
            String result = resolveCase(x, y);
            System.out.println("Case #" + i + ": " + result);
        }
        sc.close();
    }

    private static Scanner createScanner() throws Exception {
        if ("Alexey".equals(System.getProperty("user.name"))) {
            System.err.println("development mode, reading from file");
            return new Scanner(new FileInputStream("input.txt"));
        } else {
            return new Scanner(System.in);
        }
    }

    private static String resolveCase(long x, long y) {
        for (int i = 0; i <= 10000; i++) {
            String combination = Integer.toString(i, 4);
            Coord sum = calculateSum(combination);
            if (sum.x == x && sum.y == y) {
                return convertCombinationToResult(combination);
            }
            for (int j = 1; j < 10; j++) {
                combination = '0' + combination;
                sum = calculateSum(combination);
                if (sum.x == x && sum.y == y) {
                    return convertCombinationToResult(combination);
                }
            }
        }
        return "IMPOSSIBLE";
    }

    private static String convertCombinationToResult(String combination) {
        return combination.replace('0', 'W')
                          .replace('1', 'E')
                          .replace('2', 'S')
                          .replace('3', 'N');
    }

    private static Coord calculateSum(String combination) {
        long x = 0;
        long y = 0;
        for (int i = 0; i < combination.length(); i++) {
            long jump = (long) Math.pow(2, i);
            switch (combination.charAt(i)) {
                case '0': x -= jump; break; // W
                case '1': x += jump; break; // E
                case '2': y -= jump; break; // S
                case '3': y += jump; break; // N
                default: throw new IllegalArgumentException("Invalid character in combination");
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