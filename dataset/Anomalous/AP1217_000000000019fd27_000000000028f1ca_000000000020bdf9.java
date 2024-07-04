import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = getValidInput(scanner, 1, 100, "Value must be between 1 and 100");

        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            int numActivities = getValidInput(scanner, 2, 1000, "Value must be between 2 and 1000");
            int[][] timespan = new int[numActivities][2];

            for (int i = 0; i < numActivities; i++) {
                while (true) {
                    String input = scanner.nextLine();
                    String[] splitted = input.split(" ");
                    if (splitted.length != 2 || !isNumeric(splitted[0]) || !isNumeric(splitted[1])) {
                        System.out.println("Enter numeric values separated by a space.");
                        continue;
                    }
                    int start = Integer.parseInt(splitted[0]);
                    int end = Integer.parseInt(splitted[1]);
                    if (start < 0 || end > 1440) {
                        System.out.println("Input should be between 0 and 1440.");
                        continue;
                    }
                    timespan[i][0] = start;
                    timespan[i][1] = end;
                    break;
                }
            }
            process(timespan, numActivities, testCase);
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
        return input;
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void sortbyColumn(int[][] arr, int col) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o[col]));
    }

    private static void process(int[][] array, int num, int testCase) {
        int[] originalStartTimes = new int[num];
        for (int i = 0; i < num; i++) {
            originalStartTimes[i] = array[i][0];
        }

        sortbyColumn(array, 0);

        String[] result = new String[num];
        String[] code = new String[num];
        code[0] = "C";
        int compare = array[0][1];

        for (int i = 1; i < num; i++) {
            if (array[i][0] >= compare) {
                code[i] = "C";
                compare = array[i][1];
            }
        }

        compare = array[0][1];
        for (int i = 0; i < num; i++) {
            if (code[i] == null) {
                compare = array[i][0];
                break;
            }
        }

        for (int i = 0; i < num; i++) {
            if (array[i][0] >= compare && code[i] == null) {
                code[i] = "J";
                compare = array[i][1];
            }
        }

        for (int i = 0; i < num; i++) {
            int index = findIndex(originalStartTimes, array[i][0]);
            result[index] = code[i];
        }

        String output = Arrays.stream(result).anyMatch(Objects::isNull) ? "IMPOSSIBLE" : String.join("", result);
        System.out.println("Case #" + testCase + ": " + output);
    }

    private static int findIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}