import java.util.*;

public class Solution {

    static Map<Integer, Set<Integer>> columnsMap = new HashMap<>();
    static Map<Integer, Set<Integer>> rowsMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int trace = 0;
            Set<Integer> columnRepeated = new HashSet<>();
            Set<Integer> rowRepeated = new HashSet<>();

            for (int i = 0; i < n; i++) {
                rowsMap.put(i, new HashSet<>());
                for (int j = 0; j < n; j++) {
                    int value = sc.nextInt();

                    // Initialize columns set on the first row
                    columnsMap.computeIfAbsent(j, k -> new HashSet<>());

                    // Calculate trace
                    if (i == j) {
                        trace += value;
                    }

                    // Check for duplicates in the current row and column
                    if (!rowsMap.get(i).add(value)) {
                        rowRepeated.add(i);
                    }
                    if (!columnsMap.get(j).add(value)) {
                        columnRepeated.add(j);
                    }
                }
            }

            System.out.println("Case #" + caseNumber++ + ": " + trace + " " + rowRepeated.size() + " " + columnRepeated.size());

            // Clear maps for the next test case
            columnsMap.clear();
            rowsMap.clear();
        }

        sc.close();
    }
}