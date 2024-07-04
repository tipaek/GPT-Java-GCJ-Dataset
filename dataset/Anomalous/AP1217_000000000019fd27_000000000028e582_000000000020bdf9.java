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
                    String str = scanner.nextLine();
                    String[] splitted = str.split(" ");

                    if (splitted.length != 2 || !isNumeric(splitted[0]) || !isNumeric(splitted[1])) {
                        System.out.println("Enter numeric value");
                        continue;
                    }

                    int minutesAfter12Start = Integer.parseInt(splitted[0]);
                    int minutesAfter12End = Integer.parseInt(splitted[1]);

                    if (minutesAfter12Start < 0 || minutesAfter12End > 1440) {
                        System.out.println("Input should be between 0 and 1440");
                        continue;
                    }

                    timespan[eachInput][0] = minutesAfter12Start;
                    timespan[eachInput][1] = minutesAfter12End;
                    break;
                }
            }
            process(timespan, numActivities, eachTestCase + 1);
        }
        scanner.close();
    }

    private static int getValidInput(Scanner scanner, int min, int max, String errorMessage) {
        int input;
        while (true) {
            input = scanner.nextInt();
            if (input >= min && input <= max) {
                break;
            } else {
                System.out.println(errorMessage);
            }
        }
        scanner.nextLine(); // Consume the newline character
        return input;
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

        for (int i = 0; i < nums.length; i++) {
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
            int index = 0;
            for (int j = 0; j < nums.length; j++) {
                if (array[i][0] == nums[j]) {
                    index = j;
                }
            }
            result[i] = code[index];
        }

        boolean isImpossible = Arrays.stream(result).anyMatch(Objects::isNull);
        StringBuilder output = new StringBuilder("Case #" + eachTestCase + ": ");
        if (isImpossible) {
            output.append("IMPOSSIBLE");
        } else {
            for (String res : result) {
                output.append(res);
            }
        }
        System.out.println(output);
    }
}