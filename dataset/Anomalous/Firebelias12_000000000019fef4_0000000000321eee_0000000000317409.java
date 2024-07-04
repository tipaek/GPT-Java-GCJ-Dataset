import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String directions = scanner.next();
            
            boolean reached = false;
            int[] xPositions = new int[directions.length() + 1];
            int[] yPositions = new int[directions.length() + 1];

            xPositions[0] = startX;
            yPositions[0] = startY;

            for (int step = 1; step <= directions.length(); step++) {
                switch (directions.charAt(step - 1)) {
                    case 'N':
                        xPositions[step] = xPositions[step - 1];
                        yPositions[step] = yPositions[step - 1] + 1;
                        break;
                    case 'S':
                        xPositions[step] = xPositions[step - 1];
                        yPositions[step] = yPositions[step - 1] - 1;
                        break;
                    case 'E':
                        xPositions[step] = xPositions[step - 1] + 1;
                        yPositions[step] = yPositions[step - 1];
                        break;
                    case 'W':
                        xPositions[step] = xPositions[step - 1] - 1;
                        yPositions[step] = yPositions[step - 1];
                        break;
                }
            }

            for (int step = 0; step <= directions.length(); step++) {
                if (step >= Math.abs(xPositions[step]) + Math.abs(yPositions[step])) {
                    System.out.println("Case #" + (caseIndex + 1) + ": " + step);
                    reached = true;
                    break;
                }
            }

            if (!reached) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}