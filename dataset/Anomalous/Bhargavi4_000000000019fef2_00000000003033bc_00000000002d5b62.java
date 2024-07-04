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

            String solution = solve(x, y);
            result.append(solution).append("\n");
        }

        System.out.print(result.toString().trim());
    }

    private static String solve(int x, int y) {
        if (Math.abs(x) == Math.abs(y)) {
            return "IMPOSSIBLE";
        }

        int totalSteps = Math.abs(x) + Math.abs(y);
        int currentStep = 1;
        int powerSum = 0;

        while (powerSum < totalSteps) {
            powerSum += powerOfTwo(currentStep);
            currentStep++;
        }

        currentStep--;
        int remainingX = x;
        int remainingY = y;
        StringBuilder path = new StringBuilder();

        while (currentStep > 0) {
            int stepValue = powerOfTwo(currentStep);
            int newX1 = remainingX >= 0 ? remainingX - stepValue : remainingX + stepValue;
            int newY1 = remainingY;
            int newX2 = remainingX;
            int newY2 = remainingY >= 0 ? remainingY - stepValue : remainingY + stepValue;

            double distance1 = Math.hypot(newX1, newY1);
            double distance2 = Math.hypot(newX2, newY2);

            if (distance1 < distance2) {
                path.insert(0, getDirection(remainingX, remainingY, newX1, newY1));
                remainingX = newX1;
                remainingY = newY1;
            } else {
                path.insert(0, getDirection(remainingX, remainingY, newX2, newY2));
                remainingX = newX2;
                remainingY = newY2;
            }

            currentStep--;
        }

        return path.toString();
    }

    private static String getDirection(int currentX, int currentY, int newX, int newY) {
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

    private static int powerOfTwo(int exponent) {
        return 1 << (exponent - 1);
    }
}