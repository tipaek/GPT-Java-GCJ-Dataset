import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

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
            long x = Long.parseLong(coordinates[0]);
            long y = Long.parseLong(coordinates[1]);

            String solution = findPath(x, y);
            result.append(solution).append("\n");
        }

        System.out.println(result.toString().trim());
    }

    private static String findPath(long x, long y) {
        long steps = Math.abs(x) + Math.abs(y);
        int currentStep = 1;
        int totalSteps = 0;

        while (totalSteps < steps) {
            totalSteps += (1 << (currentStep - 1));
            currentStep++;
        }

        currentStep--;
        long currentX = x;
        long currentY = y;
        StringBuilder path = new StringBuilder();

        while (currentStep > 0) {
            int stepValue = (1 << (currentStep - 1));
            long newX1 = currentX >= 0 ? currentX - stepValue : currentX + stepValue;
            long newY1 = currentY;
            long newX2 = currentX;
            long newY2 = currentY >= 0 ? currentY - stepValue : currentY + stepValue;

            double distance1 = Math.sqrt(newX1 * newX1 + newY1 * newY1);
            double distance2 = Math.sqrt(newX2 * newX2 + newY2 * newY2);

            if (distance1 < distance2) {
                path.insert(0, getDirection(currentX, currentY, newX1, newY1));
                currentX = newX1;
                currentY = newY1;
            } else {
                path.insert(0, getDirection(currentX, currentY, newX2, newY2));
                currentX = newX2;
                currentY = newY2;
            }

            currentStep--;
        }

        return (currentX == 0 && currentY == 0) ? path.toString() : "IMPOSSIBLE";
    }

    private static String getDirection(long currentX, long currentY, long newX, long newY) {
        if (currentX == newX) {
            return (currentY > newY) ? "N" : "S";
        } else {
            return (currentX > newX) ? "E" : "W";
        }
    }
}