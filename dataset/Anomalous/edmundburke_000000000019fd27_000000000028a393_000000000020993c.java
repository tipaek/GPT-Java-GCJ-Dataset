import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static int caseCount = 0;

    public static void main(String[] args) {
        String input = "3\n" + 
                       "4\n" + "1 2 3 4\n" + "2 1 4 3\n" + "3 4 1 2\n" + "4 3 2 1\n" + 
                       "4\n" + "2 2 2 2\n" + "2 3 2 3\n" + "2 2 2 3\n" + "2 2 2 2\n" + 
                       "3\n" + "2 1 3\n" + "1 3 2\n" + "1 2 3\n";

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputLines = new ArrayList<>();
        while(scanner.hasNext()) {
            inputLines.add(scanner.nextLine());
        }
        scanner.close();

        String[] lines = inputLines.toArray(new String[0]);
        int caseCount = Integer.parseInt(lines[0]);
        int index = 1;

        while (caseCount > 0) {
            int n = Integer.parseInt(lines[index]);
            String[] rows = new String[n];
            for (int i = 0; i < n; i++) {
                rows[i] = lines[++index];
            }
            processCase(n, rows);
            index++;
            caseCount--;
        }
    }

    private static void processCase(int n, String[] rows) {
        caseCount++;
        int[][] columns = new int[n][n];
        int repeatRows = 0;

        for (int r = 0; r < n; r++) {
            int[] row = stringArrayToIntArray(rows[r].split(" "));
            if (hasDuplicate(row)) {
                repeatRows++;
            }
            for (int c = 0; c < n; c++) {
                columns[c][r] = row[c];
            }
        }

        int repeatColumns = 0;
        for (int[] column : columns) {
            if (hasDuplicate(column)) {
                repeatColumns++;
            }
        }

        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += columns[i][i];
        }

        System.out.println("Case #" + caseCount + ": " + trace + " " + repeatRows + " " + repeatColumns);
    }

    private static int[] stringArrayToIntArray(String[] array) {
        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        return intArray;
    }

    private static boolean hasDuplicate(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int num : array) {
            if (num < 1 || num > array.length || seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        return false;
    }
}