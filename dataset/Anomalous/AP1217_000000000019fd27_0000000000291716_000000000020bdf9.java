import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = getValidInput(scanner, 1, 100, "Value must be between 1 and 100");

        for (int testCase = 0; testCase < numTestCases; testCase++) {
            int numActivities = getValidInput(scanner, 2, 1000, "Value must be between 2 and 1000");
            int[][] timespan = new int[numActivities][2];

            for (int i = 0; i < numActivities; i++) {
                while (true) {
                    String input = scanner.nextLine();
                    String[] parts = input.split(" ");
                    if (parts.length != 2 || !isNumeric(parts[0]) || !isNumeric(parts[1])) {
                        System.out.println("Enter numeric values");
                        continue;
                    }

                    int start = Integer.parseInt(parts[0]);
                    int end = Integer.parseInt(parts[1]);

                    if (start < 0 || end > 1440) {
                        System.out.println("Input should be between 0 and 1440");
                    } else {
                        timespan[i][0] = start;
                        timespan[i][1] = end;
                        break;
                    }
                }
            }
            process(timespan, numActivities, testCase + 1);
        }
        scanner.close();
    }

    private static int getValidInput(Scanner scanner, int min, int max, String errorMessage) {
        int value;
        while (true) {
            value = scanner.nextInt();
            if (value >= min && value <= max) {
                break;
            } else {
                System.out.println(errorMessage);
            }
        }
        scanner.nextLine(); // Consume the newline character
        return value;
    }

    private static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static void sortbyColumn(int[][] arr, int col) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[col]));
    }

    private static void process(int[][] timespan, int numActivities, int testCaseNum) {
        int[] startTimes = new int[numActivities];
        String[] result = new String[numActivities];
        String[] codes = new String[numActivities];

        for (int i = 0; i < numActivities; i++) {
            startTimes[i] = timespan[i][0];
        }

        sortbyColumn(timespan, 0);
        codes[0] = "C";
        int cEnd = timespan[0][1];
        int jEnd = -1;

        for (int i = 1; i < numActivities; i++) {
            if (timespan[i][0] >= cEnd) {
                codes[i] = "C";
                cEnd = timespan[i][1];
            } else if (timespan[i][0] >= jEnd) {
                codes[i] = "J";
                jEnd = timespan[i][1];
            } else {
                System.out.println("Case #" + testCaseNum + ": IMPOSSIBLE");
                return;
            }
        }

        for (int i = 0; i < numActivities; i++) {
            for (int j = 0; j < numActivities; j++) {
                if (timespan[j][0] == startTimes[i]) {
                    result[i] = codes[j];
                    break;
                }
            }
        }

        System.out.println("Case #" + testCaseNum + ": " + String.join("", result));
    }
}