import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int east = Integer.parseInt(tokenizer.nextToken());
            int north = Integer.parseInt(tokenizer.nextToken());
            String path = tokenizer.nextToken();

            int steps = calculateSteps(east, north, path);
            if (steps != -1) {
                System.out.println("Case #" + caseNumber + ": " + steps);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    private static int calculateSteps(int east, int north, String path) {
        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            switch (direction) {
                case 'N':
                    north++;
                    break;
                case 'S':
                    north--;
                    break;
                case 'E':
                    east++;
                    break;
                case 'W':
                    east--;
                    break;
            }

            if (Math.abs(east) + Math.abs(north) <= i + 1) {
                return i + 1;
            }
        }
        return -1;
    }
}