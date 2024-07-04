import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = getInputScanner();
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

    private static Scanner getInputScanner() throws Exception {
        if (System.getProperty("user.name").equals("Alexey")) {
            System.err.println("development mode, reading from file");
            return new Scanner(new FileInputStream("input.txt"));
        } else {
            return new Scanner(System.in);
        }
    }

    private static String resolveSingleCase(long x, long y) {
        for (int i = 0; i <= 2000000; i++) {
            String comb = Integer.toString(i, 5);
            Coord sum = calculateSum(comb);
            if (sum.x == x && sum.y == y) {
                return convertCombToResult(comb);
            }
        }
        return "IMPOSSIBLE";
    }

    private static String convertCombToResult(String comb) {
        return comb.replaceAll("0", "")
                   .replaceAll("1", "W")
                   .replaceAll("2", "E")
                   .replaceAll("3", "S")
                   .replaceAll("4", "N");
    }

    private static Coord calculateSum(String comb) {
        long x = 0;
        long y = 0;

        for (int i = 0; i < comb.length(); i++) {
            long jump = (long) Math.pow(2, i);
            switch (comb.charAt(i)) {
                case '1': // W
                    x -= jump;
                    break;
                case '2': // E
                    x += jump;
                    break;
                case '3': // S
                    y -= jump;
                    break;
                case '4': // N
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