import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(reader.readLine());

            for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
                String[] inputs = reader.readLine().split(" ");
                int x = Integer.parseInt(inputs[0]);
                int y = Integer.parseInt(inputs[1]);

                boolean isXNegative = x < 0;
                boolean isYNegative = y < 0;
                x = Math.abs(x);
                y = Math.abs(y);

                int stepSize = 1;
                StringBuilder verticalSteps = new StringBuilder();
                StringBuilder horizontalSteps = new StringBuilder();

                if ((x % 2 == 0 && y % 2 == 1) || (x % 2 == 1 && y % 2 == 0)) {
                    while ((x != 0 || y != 0) && (x == 0 || Math.abs(x) >= stepSize) && (y == 0 || Math.abs(y) >= stepSize)) {
                        int direction;

                        if (y % 2 == 1) {
                            direction = (x == 0 || y - stepSize != 0) ? 1 : 0;
                        } else if (x % 2 == 1) {
                            direction = (y == 0 || x - stepSize != 0) ? 3 : 2;
                        } else {
                            if ((x != 0 && Math.abs(x) < stepSize) || (y != 0 && Math.abs(y) < stepSize)) {
                                break;
                            }
                            if (x == 0) {
                                direction = (y < 0) ? 0 : 1;
                            } else if (y == 0) {
                                direction = (x < 0) ? 2 : 3;
                            } else {
                                direction = (x < y) ? (x < 0 ? 2 : 3) : (y < 0 ? 0 : 1);
                            }
                        }

                        switch (direction) {
                            case 0:
                                verticalSteps.append("N");
                                horizontalSteps.append(" ");
                                y += stepSize;
                                break;
                            case 1:
                                verticalSteps.append("S");
                                horizontalSteps.append(" ");
                                y -= stepSize;
                                break;
                            case 2:
                                verticalSteps.append(" ");
                                horizontalSteps.append("E");
                                x += stepSize;
                                break;
                            default:
                                verticalSteps.append(" ");
                                horizontalSteps.append("W");
                                x -= stepSize;
                        }

                        stepSize *= 2;
                    }
                }

                String result = "IMPOSSIBLE";
                if (x == 0 && y == 0) {
                    result = "";
                    for (int i = 0; i < verticalSteps.length(); i++) {
                        char verticalStep = verticalSteps.charAt(i);
                        char horizontalStep = horizontalSteps.charAt(i);
                        result += (verticalStep == ' ') ? horizontalStep : verticalStep;
                    }
                    if (!isXNegative) {
                        result = result.replace("E", "T").replace("W", "E").replace("T", "W");
                    }
                    if (!isYNegative) {
                        result = result.replace("N", "T").replace("S", "N").replace("T", "S");
                    }
                }
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
    }
}