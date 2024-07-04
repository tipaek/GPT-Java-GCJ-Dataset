import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        final boolean DEBUG = false;
        Scanner scanner = null;
        try {
            if (DEBUG) {
                scanner = new Scanner(new FileInputStream("test.in"));
            } else {
                scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();
            System.out.println("Case #" + i + ": " + calculateSteps(x, y, path));
        }
    }

    private static String calculateSteps(int x, int y, String path) {
        char[] directions = path.toCharArray();
        for (int i = 0; i <= directions.length; i++) {
            if (Math.abs(x) + Math.abs(y) <= i) {
                return String.valueOf(i);
            } else if (i < directions.length) {
                switch (directions[i]) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
            }
        }
        return "IMPOSSIBLE";
    }
}