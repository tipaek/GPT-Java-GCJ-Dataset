import java.util.ArrayList;
import java.util.Scanner;

public class QualifierVestigium {
    static int caseCount = 0;

    public static void main(String[] args) {
        String input = "3\n" + 
                       "4\n" + 
                       "1 2 3 4\n" + 
                       "2 1 4 3\n" + 
                       "3 4 1 2\n" + 
                       "4 3 2 1\n" + 
                       "4\n" + 
                       "2 2 2 2\n" + 
                       "2 3 2 3\n" + 
                       "2 2 2 3\n" + 
                       "2 2 2 2\n" + 
                       "3\n" + 
                       "2 1 3\n" + 
                       "1 3 2\n" + 
                       "1 2 3\n";

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputLines = new ArrayList<>();
        while (scanner.hasNext()) {
            inputLines.add(scanner.nextLine());
        }
        scanner.close();
        
        String[] lines = inputLines.toArray(new String[0]);
        int count = Integer.parseInt(lines[0]);
        int index = 1;

        while (count > 0) {
            int n = Integer.parseInt(lines[index]);
            String[] rows = new String[n];
            for (int i = 0; i < n; i++) {
                index++;
                rows[i] = lines[index];
            }
            index++;
            processCase(n, rows);
            count--;
        }
    }

    public static void processCase(int n, String[] rows) {
        caseCount++;
        int[][] columns = new int[n][n];
        int repeatRows = 0;

        for (int r = 0; r < n; r++) {
            String[] rowStrings = rows[r].split(" ");
            int[] row = stringArrayToIntArray(rowStrings);
            if (hasDuplicate(row, n)) {
                repeatRows++;
            }
            for (int c = 0; c < n; c++) {
                columns[c][r] = row[c];
            }
        }

        int repeatColumns = 0;
        for (int[] column : columns) {
            if (hasDuplicate(column, n)) {
                repeatColumns++;
            }
        }

        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += columns[i][i];
        }

        System.out.println("Case #" + caseCount + ": " + trace + " " + repeatRows + " " + repeatColumns);
    }

    public static int[] stringArrayToIntArray(String[] array) {
        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        return intArray;
    }

    public static boolean hasDuplicate(int[] array, int n) {
        for (int i = 1; i <= n; i++) {
            if (!arrayIncludes(array, i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean arrayIncludes(int[] array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }
}