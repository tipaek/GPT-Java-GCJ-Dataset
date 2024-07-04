import java.util.*;

public class Solution {

    public static void sortByColumn(Integer[][] arr, int col) {
        Arrays.sort(arr, Comparator.comparingInt(entry -> entry[col]));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();
        List<Integer[][]> testCases = new ArrayList<>();

        for (int i = 0; i < testCaseCount; i++) {
            int rowCount = Integer.parseInt(scanner.nextLine());
            if (rowCount != 0) {
                Integer[][] array = new Integer[rowCount][2];
                for (int row = 0; row < rowCount; row++) {
                    String[] values = scanner.nextLine().split(" ");
                    for (int col = 0; col < 2; col++) {
                        array[row][col] = Integer.parseInt(values[col]);
                    }
                }
                testCases.add(array);
            }
        }
        scanner.close();

        for (int caseIndex = 0; caseIndex < testCases.size(); caseIndex++) {
            Integer[][] array = testCases.get(caseIndex);
            int numRows = array.length;
            int[] startTimes = new int[numRows];
            String[] result = new String[numRows];

            for (int i = 0; i < numRows; i++) {
                startTimes[i] = array[i][0];
            }

            sortByColumn(array, 0);

            String[] assignments = new String[numRows];
            assignments[0] = "J";
            int lastEndTime = array[0][1];

            for (int row = 1; row < numRows; row++) {
                if (array[row][0] >= lastEndTime) {
                    assignments[row] = "J";
                    lastEndTime = array[row][1];
                }
            }

            int unassignedStartIndex = 0;
            for (int i = 0; i < numRows; i++) {
                if (assignments[i] == null) {
                    unassignedStartIndex = i;
                    break;
                }
            }

            lastEndTime = array[unassignedStartIndex][0];
            for (int row = unassignedStartIndex; row < numRows; row++) {
                if (array[row][0] >= lastEndTime && assignments[row] == null) {
                    assignments[row] = "C";
                    lastEndTime = array[row][1];
                }
            }

            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numRows; j++) {
                    if (array[i][0] != null && array[i][0].equals(startTimes[j])) {
                        result[j] = assignments[i];
                        array[i][0] = null;
                        startTimes[j] = -1;
                        break;
                    }
                }
            }

            boolean hasNull = Arrays.stream(result).anyMatch(Objects::isNull);
            String output = "Case #" + (caseIndex + 1) + ": " + (hasNull ? "IMPOSSIBLE" : String.join("", result));
            System.out.println(output);
        }
    }
}