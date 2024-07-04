import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(reader.readLine());

            for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
                String[] coordinates = reader.readLine().split(" ");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);

                boolean isNegativeX = x < 0;
                boolean isNegativeY = y < 0;

                x = Math.abs(x);
                y = Math.abs(y);

                int currentStep = 1;
                StringBuilder verticalPath = new StringBuilder();
                StringBuilder horizontalPath = new StringBuilder();

                if ((x % 2 != y % 2)) {
                    while ((x != 0 || y != 0) && (x == 0 || Math.abs(x) >= currentStep) && (y == 0 || Math.abs(y) >= currentStep)) {
                        int direction = determineDirection(x, y, currentStep);

                        switch (direction) {
                            case 0:
                                verticalPath.append("N");
                                horizontalPath.append(" ");
                                y += currentStep;
                                break;
                            case 1:
                                verticalPath.append("S");
                                horizontalPath.append(" ");
                                y -= currentStep;
                                break;
                            case 2:
                                verticalPath.append(" ");
                                horizontalPath.append("E");
                                x += currentStep;
                                break;
                            case 3:
                                verticalPath.append(" ");
                                horizontalPath.append("W");
                                x -= currentStep;
                                break;
                        }
                        currentStep *= 2;
                    }
                }

                String result = (x == 0 && y == 0) ? buildResult(verticalPath, horizontalPath, isNegativeX, isNegativeY) : "IMPOSSIBLE";
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
    }

    private static int determineDirection(int x, int y, int currentStep) {
        if (y % 2 == 1) {
            return (x == 0 || y - currentStep != x) ? 1 : 0;
        } else if (x % 2 == 1) {
            return (y == 0 || x - currentStep != y) ? 3 : 2;
        } else {
            if ((x != 0 && Math.abs(x) < currentStep) || (y != 0 && Math.abs(y) < currentStep)) {
                return -1;
            }
            if (x == 0) {
                return y < 0 ? 0 : 1;
            } else if (y == 0) {
                return x < 0 ? 2 : 3;
            } else {
                if (x < y) {
                    return x < 0 ? 2 : 3;
                } else {
                    return y < 0 ? 0 : 1;
                }
            }
        }
    }

    private static String buildResult(StringBuilder verticalPath, StringBuilder horizontalPath, boolean isNegativeX, boolean isNegativeY) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < verticalPath.length(); i++) {
            char verticalStep = verticalPath.charAt(i);
            char horizontalStep = horizontalPath.charAt(i);
            result.append(verticalStep == ' ' ? horizontalStep : verticalStep);
        }
        if (!isNegativeX) {
            replaceAll(result, "E", "T", "W");
        }
        if (!isNegativeY) {
            replaceAll(result, "N", "T", "S");
        }
        return result.toString();
    }

    private static void replaceAll(StringBuilder sb, String target1, String temp, String target2) {
        int index;
        while ((index = sb.indexOf(target1)) != -1) {
            sb.replace(index, index + 1, temp);
        }
        while ((index = sb.indexOf(target2)) != -1) {
            sb.replace(index, index + 1, target1);
        }
        while ((index = sb.indexOf(temp)) != -1) {
            sb.replace(index, index + 1, target2);
        }
    }
}