import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tt = 1; tt <= t; ++tt) {
            int n = sc.nextInt();
            int trace = 0;
            Set<Integer> duplicateColsSet = new TreeSet<>();
            Set<Integer> duplicateRowsSet = new TreeSet<>();
            Map<Integer, Set<Integer>> colValuesMap = new TreeMap<>();
            Map<Integer, Set<Integer>> rowValuesMap = new TreeMap<>();
            for (int i = 0; i < n; ++i) {
                rowValuesMap.put(i, new TreeSet<>());
                Set<Integer> currRowValues = rowValuesMap.get(i);
                for (int j = 0; j < n; ++j) {
                    if (i == 0) {
                        colValuesMap.put(j, new TreeSet<>());
                    }
                    int el = sc.nextInt();
                    if (i == j) {
                        trace += el;
                    }
                    if (currRowValues.contains(el)) {
                        duplicateRowsSet.add(i);
                    } else {
                        currRowValues.add(el);
                    }
                    Set<Integer> currColValues = colValuesMap.get(j);
                    if (currColValues.contains(el)) {
                        duplicateColsSet.add(j);
                    } else {
                        currColValues.add(el);
                    }
                }
            }
            System.out.println("Case #" + tt + ": " + trace + " " + duplicateRowsSet.size() + " " + duplicateColsSet.size());
        }
    }
}
