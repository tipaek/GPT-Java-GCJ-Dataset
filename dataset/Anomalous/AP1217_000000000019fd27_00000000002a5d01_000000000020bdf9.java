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
        List<Integer[][]> testCases = new ArrayList<>();
        scanner.nextLine();

        for (int i = 0; i < testCaseCount; i++) {
            int arrayLength = Integer.parseInt(scanner.nextLine());
            if (arrayLength > 0) {
                Integer[][] array = new Integer[arrayLength][2];
                for (int row = 0; row < array.length; row++) {
                    String[] values = scanner.nextLine().split(" ");
                    for (int col = 0; col < array[row].length; col++) {
                        array[row][col] = values[col].isEmpty() ? 0 : Integer.parseInt(values[col]);
                    }
                }
                testCases.add(array);
            }
        }
        scanner.close();

        for (int caseIndex = 0; caseIndex < testCases.size(); caseIndex++) {
            Integer[][] array = testCases.get(caseIndex);
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

            for (int row = 1; row < numRows; row++) {
                if (array[row][0] >= lastEndTime) {
                    assignments[row] = "J";
                    lastEndTime = array[row][1];
                }
            }

            int startIndex = 0;
            for (int i = 0; i < assignments.length; i++) {
                if (assignments[i] == null) {
                    startIndex = i;
                    break;
                }
            }

            lastEndTime = array[startIndex][0];
            for (int row = startIndex; row < numRows; row++) {
                if (array[row][0] >= lastEndTime && assignments[row] == null) {
                    assignments[row] = "C";
                    lastEndTime = array[row][1];
                }
            }

            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < originalStartTimes.length; j++) {
                    if (array[i][0] != null && array[i][0].equals(originalStartTimes[j])) {
                        result[j] = assignments[i];
                        array[i][0] = null;
                        originalStartTimes[j] = -1;
                        break;
                    }
                }
            }

            boolean impossible = Arrays.stream(result).anyMatch(Objects::isNull);
            if (impossible) {
                System.out.println("Case #" + (caseIndex + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder output = new StringBuilder("Case #" + (caseIndex + 1) + ": ");
                for (String res : result) {
                    output.append(res);
                }
                System.out.println(output);
            }
        }
    }
}