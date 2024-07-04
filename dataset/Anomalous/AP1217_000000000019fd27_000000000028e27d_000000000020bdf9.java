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
                    if (parts.length == 2 && isNumeric(parts[0]) && isNumeric(parts[1])) {
                        int start = Integer.parseInt(parts[0]);
                        int end = Integer.parseInt(parts[1]);
                        if (start >= 0 && end <= 1440 && start < end) {
                            timespan[i][0] = start;
                            timespan[i][1] = end;
                            break;
                        }
                    }
                    System.out.println("Input should be two numbers between 0 and 1440, with the first number less than the second.");
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
        scanner.nextLine(); // Consume newline
        return value;
    }

    private static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void process(int[][] timespan, int numActivities, int testCaseNumber) {
        Arrays.sort(timespan, Comparator.comparingInt(a -> a[0]));

        String[] result = new String[numActivities];
        int cameronEnd = 0, jamieEnd = 0;

        for (int i = 0; i < numActivities; i++) {
            if (timespan[i][0] >= cameronEnd) {
                result[i] = "C";
                cameronEnd = timespan[i][1];
            } else if (timespan[i][0] >= jamieEnd) {
                result[i] = "J";
                jamieEnd = timespan[i][1];
            } else {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        StringBuilder output = new StringBuilder("Case #" + testCaseNumber + ": ");
        for (String res : result) {
            output.append(res);
        }
        System.out.println(output.toString());
    }
}