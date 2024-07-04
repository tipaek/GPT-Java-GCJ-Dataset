import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] input = reader.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String directions = input[2];

            int result = calculateSteps(x, y, directions);
            if (result == -1) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
    }

    private static int calculateSteps(int x, int y, String directions) {
        int length = directions.length();
        for (int step = 1; step <= length; step++) {
            char direction = directions.charAt(step - 1);
            switch (direction) {
                case 'N': y += 1; break;
                case 'S': y -= 1; break;
                case 'E': x += 1; break;
                case 'W': x -= 1; break;
            }

            if (Math.abs(x) + Math.abs(y) <= step) {
                return step;
            }
        }
        return -1;
    }
}