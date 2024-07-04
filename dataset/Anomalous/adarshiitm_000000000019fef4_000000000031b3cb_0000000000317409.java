import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String path = scanner.next();
            System.out.println("Case #" + caseNumber + ": " + calculateSteps(x, y, path));
        }
    }

    private static String calculateSteps(int x, int y, String path) {
        if (path.length() < x) {
            return "IMPOSSIBLE";
        }

        int minutes = 0;
        for (; minutes < x; minutes++) {
            y += (path.charAt(minutes) == 'N') ? 1 : -1;
        }

        int location = 0;

        while (y != location && minutes < path.length()) {
            y += (path.charAt(minutes) == 'N') ? 1 : -1;
            if (y > location) {
                location++;
            } else if (y < location) {
                location--;
            }
            minutes++;
        }

        if (y == location) {
            return Integer.toString(minutes);
        }
        return "IMPOSSIBLE";
    }

}