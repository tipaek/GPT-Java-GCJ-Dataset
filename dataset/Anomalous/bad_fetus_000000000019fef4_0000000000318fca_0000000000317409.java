import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        
        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            String[] input = scanner.nextLine().split("\\s+");
            int initialX = Integer.parseInt(input[0]);
            int initialY = Integer.parseInt(input[1]);
            String movementSequence = input[2];

            int[] currentCoordinates = {initialX, initialY};
            int stepsRequired = 0;

            for (int stepIndex = 0; stepIndex < movementSequence.length(); stepIndex++) {
                char direction = movementSequence.charAt(stepIndex);
                switch (direction) {
                    case 'N':
                        currentCoordinates[1]++;
                        break;
                    case 'S':
                        currentCoordinates[1]--;
                        break;
                    case 'E':
                        currentCoordinates[0]++;
                        break;
                    case 'W':
                        currentCoordinates[0]--;
                        break;
                }

                if (Math.abs(currentCoordinates[0]) + Math.abs(currentCoordinates[1]) <= stepIndex + 1) {
                    stepsRequired = stepIndex + 1;
                    break;
                }
            }

            if (stepsRequired != 0) {
                System.out.println("Case #" + (testIndex + 1) + ": " + stepsRequired);
            } else {
                System.out.println("Case #" + (testIndex + 1) + ": IMPOSSIBLE");
            }
        }
    }
}