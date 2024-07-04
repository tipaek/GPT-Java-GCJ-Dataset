import java.util.*;

public class Solution {

    public static void sortByColumn(Integer[][] arr, int col) {
        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(final Integer[] entry1, final Integer[] entry2) {
                return Integer.compare(entry1[col], entry2[col]);
            }
        });
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Integer[][]> testCases = new ArrayList<>();

        for (int testCaseIndex = 0; testCaseIndex < testCaseCount; testCaseIndex++) {
            int numRows = Integer.parseInt(scanner.nextLine());

            if (numRows > 0) {
                Integer[][] array = new Integer[numRows][2];

                for (int row = 0; row < numRows; row++) {
                    String[] values = scanner.nextLine().split(" ");
                    for (int col = 0; col < 2; col++) {
                        array[row][col] = Integer.parseInt(values[col]);
                    }
                }

                testCases.add(array);
            }
        }

        scanner.close();

        for (int testCaseIndex = 0; testCaseIndex < testCases.size(); testCaseIndex++) {
            Integer[][] array = testCases.get(testCaseIndex);
            int numRows = array.length;
            int[] originalStartTimes = new int[numRows];
            String[] result = new String[numRows];

            for (int i = 0; i < numRows; i++) {
                originalStartTimes[i] = array[i][0];
            }

            sortByColumn(array, 0);

            String[] assignments = new String[numRows];
            assignments[0] = "J";
            int lastEndTime = array[0][1];

            for (int i = 1; i < numRows; i++) {
                if (array[i][0] >= lastEndTime) {
                    assignments[i] = "J";
                    lastEndTime = array[i][1];
                }
            }

            int firstUnassignedIndex = 0;
            while (firstUnassignedIndex < numRows && assignments[firstUnassignedIndex] != null) {
                firstUnassignedIndex++;
            }

            if (firstUnassignedIndex < numRows) {
                lastEndTime = array[firstUnassignedIndex][0];
                for (int i = firstUnassignedIndex; i < numRows; i++) {
                    if (array[i][0] >= lastEndTime && assignments[i] == null) {
                        assignments[i] = "C";
                        lastEndTime = array[i][1];
                    }
                }
            }

            for (int i = 0; i < numRows; i++) {
                if (assignments[i] == null) {
                    System.out.println("Case #" + (testCaseIndex + 1) + ": IMPOSSIBLE");
                    continue;
                }
            }

            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numRows; j++) {
                    if (array[i][0] != null && array[i][0].equals(originalStartTimes[j])) {
                        result[j] = assignments[i];
                        array[i][0] = null;
                        break;
                    }
                }
            }

            StringBuilder resultString = new StringBuilder();
            for (String res : result) {
                resultString.append(res);
            }

            System.out.println("Case #" + (testCaseIndex + 1) + ": " + resultString);
        }
    }
}