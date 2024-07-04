import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        // Read number of test cases
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {

            // Read initial coordinates
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            // Read movement directions
            String directions = scanner.next();
            boolean canTakePhoto = false;
            int time = 0;

            // Process each movement direction
            for (char direction : directions.toCharArray()) {
                time++;

                // Update coordinates based on direction
                switch (direction) {
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }

                // Calculate Manhattan distance
                int distance = Math.abs(x) + Math.abs(y);

                // Check if photo can be taken
                if (distance <= time) {
                    canTakePhoto = true;
                    break;
                }
            }

            // Output result for each test case
            if (canTakePhoto) {
                System.out.println("Case #" + caseNum + ": " + time);
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }
}