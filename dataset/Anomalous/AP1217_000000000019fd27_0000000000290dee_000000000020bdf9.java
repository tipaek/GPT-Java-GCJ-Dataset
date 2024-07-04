import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = getValidInput(scanner, 1, 100, "Value must be between 1 and 100");

        for (int testCase = 1; testCase <= numTestCases; testCase++) {
            int numActivities = getValidInput(scanner, 2, 1000, "Value must be between 2 and 1000");
            int[][] timespan = new int[numActivities][2];
            scanner.nextLine();

            for (int i = 0; i < numActivities; i++) {
                while (true) {
                    String str = scanner.nextLine();
                    String[] splitted = str.split(" ");
                    if (splitted.length != 2 || !isNumeric(splitted[0]) || !isNumeric(splitted[1])) {
                        System.out.println("Enter numeric value");
                        continue;
                    }
                    int start = Integer.parseInt(splitted[0]);
                    int end = Integer.parseInt(splitted[1]);
                    if (start < 0 || end > 1440) {
                        System.out.println("Input should be between 0 and 1440");
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
        int value;
        while (true) {
            value = scanner.nextInt();
            if (value >= min && value <= max) {
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

    public static void sortbyColumn(int arr[][], int col) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o[col]));
    }

    public static void process(int[][] array, int num, int testCase) {
        int[] originalStartTimes = new int[num];
        for (int i = 0; i < num; i++) {
            originalStartTimes[i] = array[i][0];
        }

        sortbyColumn(array, 0);
        String[] code = new String[num];
        code[0] = "C";
        int lastC = array[0][1];

        for (int i = 1; i < num; i++) {
            if (array[i][0] >= lastC) {
                code[i] = "C";
                lastC = array[i][1];
            }
        }

        int lastJ = 0;
        for (int i = 0; i < num; i++) {
            if (code[i] == null) {
                lastJ = i;
                break;
            }
        }

        boolean possible = true;
        for (int i = lastJ; i < num; i++) {
            if (array[i][0] >= lastJ) {
                code[i] = "J";
                lastJ = array[i][1];
            } else {
                possible = false;
                break;
            }
        }

        StringBuilder result = new StringBuilder();
        if (possible) {
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    if (array[j][0] == originalStartTimes[i]) {
                        result.append(code[j]);
                        break;
                    }
                }
            }
        } else {
            result.append("IMPOSSIBLE");
        }

        System.out.println("Case #" + testCase + ": " + result);
    }
}