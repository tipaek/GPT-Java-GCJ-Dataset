import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                int n = scanner.nextInt();
                scanner.nextLine();
                int[][] array = new int[n][n];
                
                for (int j = 0; j < n; j++) {
                    array[j] = Arrays.stream(scanner.nextLine().split(" "))
                                     .mapToInt(Integer::parseInt)
                                     .toArray();
                }

                int rowRepeatCount = 0;
                int columnRepeatCount = 0;
                int sum = 0;

                List<List<Integer>> rowList = new ArrayList<>();
                List<List<Integer>> columnList = new ArrayList<>();
                boolean[] columnChecked = new boolean[n];

                for (int j = 0; j < n; j++) {
                    List<Integer> currentRow = new ArrayList<>();
                    rowList.add(currentRow);
                    boolean rowHasDuplicate = false;

                    for (int k = 0; k < n; k++) {
                        if (j == k) {
                            sum += array[j][k];
                        }

                        if (!rowHasDuplicate) {
                            if (currentRow.contains(array[j][k])) {
                                rowRepeatCount++;
                                rowHasDuplicate = true;
                            } else {
                                currentRow.add(array[j][k]);
                            }
                        }

                        if (columnList.size() <= k) {
                            columnList.add(new ArrayList<>());
                        }

                        List<Integer> currentColumn = columnList.get(k);
                        if (!columnChecked[k]) {
                            if (currentColumn.contains(array[j][k])) {
                                columnRepeatCount++;
                                columnChecked[k] = true;
                            } else {
                                currentColumn.add(array[j][k]);
                            }
                        }
                    }
                }
                System.out.println("Case #" + i + ": " + sum + " " + rowRepeatCount + " " + columnRepeatCount);
            }
        }
    }
}