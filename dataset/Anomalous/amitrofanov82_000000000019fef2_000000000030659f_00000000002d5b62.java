import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc;
        if ("Alexey".equals(System.getProperty("user.name"))) {
            sc = new Scanner(new FileInputStream("input.txt"));
            System.err.println("development mode, reading from file");
        } else {
            sc = new Scanner(System.in);
        }

        int testCases = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= testCases; i++) {
            String[] taskLine = sc.nextLine().split(" ");
            long x = Long.parseLong(taskLine[0]);
            long y = Long.parseLong(taskLine[1]);
            String result = solveCase(x, y);
            System.out.println("Case #" + i + ": " + result);
        }
        sc.close();
    }

    private static String solveCase(long x, long y) {
        for (int i = 0; i <= 3000000; i++) {
            String combination = Integer.toString(i, 5);
            Coord sum = calculateSum(combination);
            if (sum.x == x && sum.y == y) {
                return combinationToResult(combination);
            }
        }
        return "IMPOSSIBLE";
    }

    private static String combinationToResult(String combination) {
        return combination
                .replace("0", "")
                .replace("1", "W")
                .replace("2", "E")
                .replace("3", "S")
                .replace("4", "N");
    }

    private static Coord calculateSum(String combination) {
        long x = 0;
        long y = 0;

        for (int i = 0; i < combination.length(); i++) {
            long jump = (long) Math.pow(2, i);
            switch (combination.charAt(i)) {
                case '1':
                    x -= jump;
                    break;
                case '2':
                    x += jump;
                    break;
                case '3':
                    y -= jump;
                    break;
                case '4':
                    y += jump;
                    break;
                case '0':
                    return new Coord(-10, -10);
                default:
                    throw new IllegalArgumentException("Invalid character in combination");
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