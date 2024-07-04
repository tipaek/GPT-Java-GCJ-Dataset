import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int trace = 0;
            int repeatRows = 0;
            int repeatCols = 0;
            Set<String> rowSet = new HashSet<>();
            Set<String> colSet = new HashSet<>();

            for (int j = 0; j < n; j++) {
                String[] rowElements = scanner.nextLine().split(" ");
                trace += Integer.parseInt(rowElements[j]);
                boolean rowRepeatFound = false;

                for (int k = 0; k < n; k++) {
                    String rowKey = j + rowElements[k];
                    String colKey = k + rowElements[k];

                    if (!rowRepeatFound && rowSet.contains(rowKey)) {
                        rowRepeatFound = true;
                        repeatRows++;
                    } else {
                        rowSet.add(rowKey);
                    }

                    if (colSet.contains(colKey) && !colSet.contains(k + "found")) {
                        colSet.add(k + "found");
                        repeatCols++;
                    } else {
                        colSet.add(colKey);
                    }
                }
            }
            results[i] = "Case #" + (i + 1) + ": " + trace + " " + repeatRows + " " + repeatCols;
        }

        for (String result : results) {
            System.out.println(result);
        }
    }
}