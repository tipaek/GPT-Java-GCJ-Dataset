import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = getValidInput(scanner, 1, 100, "Value must be between 1 and 100");

        for (int eachTestCase = 0; eachTestCase < numTestCases; eachTestCase++) {
            int numActivities = getValidInput(scanner, 2, 1000, "Value must be between 2 and 1000");
            int[][] timespan = new int[numActivities][2];

            for (int eachInput = 0; eachInput < numActivities; eachInput++) {
                while (true) {
                    String input = scanner.nextLine();
                    String[] splitted = input.split(" ");
                    if (splitted.length == 2 && isNumeric(splitted[0]) && isNumeric(splitted[1])) {
                        int start = Integer.parseInt(splitted[0]);
                        int end = Integer.parseInt(splitted[1]);
                        if (start >= 0 && end <= 1440) {
                            timespan[eachInput][0] = start;
                            timespan[eachInput][1] = end;
                            break;
                        }
                    }
                    System.out.println("Input should be two numeric values between 0 and 1440");
                }
            }
            process(timespan, numActivities, eachTestCase + 1);
        }
        scanner.close();
    }

    private static int getValidInput(Scanner scanner, int min, int max, String errorMessage) {
        int value;
        while (true) {
            value = scanner.nextInt();
            if (value >= min && value <= max) {
                scanner.nextLine(); // consume the newline
                break;
            } else {
                System.out.println(errorMessage);
            }
        }
        return value;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void sortbyColumn(int[][] arr, int col) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o[col]));
    }

    public static void process(int[][] array, int num, int eachTestCase) {
        int[] nums = new int[num];
        String[] result = new String[num];
        String[] code = new String[num];

        for (int i = 0; i < num; i++) {
            nums[i] = array[i][0];
        }

        sortbyColumn(array, 0);

        code[0] = "J";
        int compare = array[0][1];

        for (int row = 1; row < array.length; row++) {
            if (array[row][0] >= compare) {
                code[row] = "J";
                compare = array[row][1];
            }
        }

        int start = 0;
        for (int i = 0; i < code.length; i++) {
            if (code[i] == null) {
                start = i;
                break;
            }
        }

        compare = array[start][0];
        for (int row = start; row < array.length; row++) {
            if (array[row][0] >= compare && code[row] == null) {
                code[row] = "C";
                compare = array[row][1];
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (array[i][0] == nums[j]) {
                    result[i] = code[j];
                    break;
                }
            }
        }

        boolean isPossible = Arrays.stream(result).noneMatch(Objects::isNull);

        String output = isPossible ? String.join("", result) : "IMPOSSIBLE";
        System.out.println("Case #" + eachTestCase + ": " + output);
    }
}