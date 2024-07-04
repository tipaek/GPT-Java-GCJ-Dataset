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
            String result = solveCase(x, y);
            System.out.println("Case #" + i + ": " + result);
        }
        sc.close();
    }

    private static String solveCase(long x, long y) {
        for (int i = 0; i <= 4200000; i++) {
            String comb = Integer.toString(i, 4);
            if (isValidCombination(comb, x, y)) {
                return convertCombinationToResult(comb);
            }
            comb = String.format("%7s", comb).replace(' ', '0');
            if (isValidCombination(comb, x, y)) {
                return convertCombinationToResult(comb);
            }
        }
        return "IMPOSSIBLE";
    }

    private static boolean isValidCombination(String comb, long x, long y) {
        Coord sum = calculateSum(comb);
        return sum.x == x && sum.y == y;
    }

    private static String convertCombinationToResult(String comb) {
        return comb.replace('0', 'W')
                   .replace('1', 'E')
                   .replace('2', 'S')
                   .replace('3', 'N');
    }

    private static Coord calculateSum(String comb) {
        long x = 0;
        long y = 0;

        for (int i = 0; i < comb.length(); i++) {
            long jump = (long) Math.pow(2, i);
            switch (comb.charAt(i)) {
                case '0': x -= jump; break; // W
                case '1': x += jump; break; // E
                case '2': y -= jump; break; // S
                case '3': y += jump; break; // N
                default: throw new IllegalArgumentException("Invalid combination character");
            }
        }
        return new Coord(x, y);
    }
}

class Coord {
    long x, y;

    public Coord(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}