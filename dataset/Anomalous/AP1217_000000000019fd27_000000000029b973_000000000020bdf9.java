import java.util.*;

public class Solution {

    // Method to sort 2D array by a specific column
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
        List<Integer[][]> testCases = new ArrayList<>();
        scanner.nextLine(); // Consume newline

        // Read test cases
        for (int i = 0; i < testCaseCount; i++) {
            int rows = Integer.parseInt(scanner.nextLine());
            if (rows != 0) {
                Integer[][] array = new Integer[rows][2];
                for (int row = 0; row < rows; row++) {
                    String[] values = scanner.nextLine().split(" ");
                    array[row][0] = Integer.parseInt(values[0]);
                    array[row][1] = Integer.parseInt(values[1]);
                }
                testCases.add(array);
            }
        }
        scanner.close();

        // Process each test case
        for (Integer[][] array : testCases) {
            int numRows = array.length;
            int[] originalStartTimes = new int[numRows];
            String[] result = new String[numRows];

            // Store original start times
            for (int i = 0; i < numRows; i++) {
                originalStartTimes[i] = array[i][0];
            }

            // Sort array by start times
            sortByColumn(array, 0);

            String[] assignments = new String[numRows];
            assignments[0] = "C";
            int lastCEndTime = array[0][1];

            // Assign 'C' or 'J' to tasks
            for (int row = 1; row < numRows; row++) {
                if (array[row][0] >= lastCEndTime) {
                    assignments[row] = "C";
                    lastCEndTime = array[row][1];
                }
            }

            int start = 0;
            for (int i = 0; i < assignments.length; i++) {
                if (assignments[i] == null) {
                    start = i;
                    break;
                }
            }

            int lastJEndTime = array[start][0];
            for (int row = start; row < numRows; row++) {
                if (array[row][0] >= lastJEndTime && assignments[row] == null) {
                    assignments[row] = "J";
                    lastJEndTime = array[row][1];
                }
            }

            // Generate result based on original order
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numRows; j++) {
                    if (array[i][0].equals(originalStartTimes[j])) {
                        result[j] = assignments[i];
                        break;
                    }
                }
            }

            // Check if all tasks are assigned
            boolean isPossible = true;
            for (String res : result) {
                if (res == null) {
                    isPossible = false;
                    break;
                }
            }

            // Output result
            if (isPossible) {
                for (String res : result) {
                    System.out.print(res);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}