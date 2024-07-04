import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNum = scanner.nextInt();
        long x;
        long y;
        String moves;
        long result;
        for (int test = 1; test <= testNum; test++) {
            x = scanner.nextLong();
            y = scanner.nextLong();
            moves = scanner.next();
            result = solve(x, y, moves);
            System.out.println("Case #" + test + ": " + (result == -1? "IMPOSSIBLE" : result));
        }
    }

    private static long solve(long x, long y, String moves) {
        char tmpChar;
        long max;
        for (int i = 0; i < moves.length(); i++) {
            tmpChar = moves.charAt(i);
            switch (tmpChar) {
                case 'N':
                    y++;
                case 'S':
                    y--;
                case 'W':
                    x--;
                case 'E':
                    x++;
            }
            if ( (x == 0) && (y == 0) ) {
                return (i + 1);
            }
            if (Math.abs(x) > Math.abs(y)) {
                if (x < 0) {
                    x++;
                } else {
                    x--;
                }
            } else if (Math.abs(x) < Math.abs(y)) {
                if (y < 0) {
                    y++;
                } else {
                    y--;
                }
            } else {
                tmpChar = moves.charAt(i + 1);
                switch (tmpChar) {
                    case 'N':
                    case 'W':
                        if (y < 0) {
                            y++;
                        } else {
                            y--;
                        }
                        break;
                    case 'S':
                    case 'E':
                        if (x < 0) {
                            x++;
                        } else {
                            x--;
                        }
                        break;
                }
            }
            if ( (x == 0) && (y == 0) ) {
                return (i + 1);
            }
        }
        return -1;
    }
}
