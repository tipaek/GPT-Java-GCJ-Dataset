import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input == null) {
            return;
        }

        int t = Integer.parseInt(input);
        StringBuilder result = new StringBuilder();
        int caseNumber = 1;

        while (t-- > 0) {
            result.append("Case #").append(caseNumber).append(": ");
            caseNumber++;
            String[] coordinates = br.readLine().split(" ");
            int x = Integer.parseInt(coordinates[0]);
            int y = Integer.parseInt(coordinates[1]);
            String solution = findPath(x, y);
            result.append(solution).append("\n");
        }

        System.out.print(result.toString().trim());
    }

    private static String findPath(int x, int y) {
        int totalSteps = Math.abs(x) + Math.abs(y);
        int stepCount = 0;
        int currentStep = 1;

        while (stepCount < totalSteps) {
            stepCount += calculatePower(currentStep);
            currentStep++;
        }

        currentStep--;
        int currentX = x;
        int currentY = y;
        StringBuilder path = new StringBuilder();

        while (currentStep > 0) {
            int stepValue = calculatePower(currentStep);
            int newX1 = currentX >= 0 ? currentX - stepValue : currentX + stepValue;
            int newY1 = currentY;
            int newX2 = currentX;
            int newY2 = currentY >= 0 ? currentY - stepValue : currentY + stepValue;

            double distance1 = Math.sqrt(newX1 * newX1 + newY1 * newY1);
            double distance2 = Math.sqrt(newX2 * newX2 + newY2 * newY2);

            if (distance1 < distance2) {
                path.insert(0, determineDirection(currentX, currentY, newX1, newY1));
                currentX = newX1;
                currentY = newY1;
            } else {
                path.insert(0, determineDirection(currentX, currentY, newX2, newY2));
                currentX = newX2;
                currentY = newY2;
            }

            currentStep--;
        }

        return (currentX == 0 && currentY == 0) ? path.toString() : "IMPOSSIBLE";
    }

    private static String determineDirection(int currentX, int currentY, int newX, int newY) {
        if (currentX == newX && currentY > newY) {
            return "N";
        } else if (currentX == newX && currentY < newY) {
            return "S";
        } else if (currentY == newY && currentX > newX) {
            return "E";
        } else if (currentY == newY && currentX < newX) {
            return "W";
        }
        return null;
    }

    private static int calculatePower(int steps) {
        return (steps == 1) ? 1 : 2 * calculatePower(steps - 1);
    }
}