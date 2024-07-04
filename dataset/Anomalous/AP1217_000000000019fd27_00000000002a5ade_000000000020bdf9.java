import java.util.*;

public class Solution {

    public static void sortByColumn(Integer[][] arr, int col) {
        Arrays.sort(arr, (entry1, entry2) -> {
            return entry1[col].compareTo(entry2[col]);
        });
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        List<Integer[][]> testCases = new ArrayList<>();

        for (int i = 0; i < testCaseCount; i++) {
            int arrayLength = Integer.parseInt(scanner.nextLine());
            if (arrayLength != 0) {
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

        for (int testCaseIndex = 0; testCaseIndex < testCases.size(); testCaseIndex++) {
            Integer[][] array = testCases.get(testCaseIndex);

            int numRows = array.length;
            int[] originalFirstColumn = new int[numRows];
            String[] result = new String[numRows];

            for (int i = 0; i < numRows; i++) {
                originalFirstColumn[i] = array[i][0];
            }

            sortByColumn(array, 0);

            String[] code = new String[numRows];
            code[0] = "J";

            if (!(array[0][0].equals(array[1][0]) && array[0][1].equals(array[1][1]))) {
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
                    for (int j = 0; j < originalFirstColumn.length; j++) {
                        if (array[i][0] != null && array[i][0].equals(originalFirstColumn[j])) {
                            result[i] = code[j];
                            array[i][0] = null;
                            originalFirstColumn[j] = -1;
                            break;
                        }
                    }
                }

                boolean isImpossible = Arrays.stream(result).anyMatch(Objects::isNull);

                if (isImpossible) {
                    System.out.println("Case #" + (testCaseIndex + 1) + ": IMPOSSIBLE");
                } else {
                    StringBuilder resultString = new StringBuilder();
                    for (String res : result) {
                        resultString.append(res);
                    }
                    System.out.println("Case #" + (testCaseIndex + 1) + ": " + resultString.toString());
                }
            } else {
                System.out.println("Case #" + (testCaseIndex + 1) + ": JC");
            }
        }
    }
}