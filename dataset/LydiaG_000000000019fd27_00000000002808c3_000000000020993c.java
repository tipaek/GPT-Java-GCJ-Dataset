import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(sc.nextLine());
            int trace = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            List<Set<Integer>> row = new ArrayList<>();
            Set<Integer> rowsWithDuplicate = new HashSet<>();
            List<Set<Integer>> column = new ArrayList<>();
            Set<Integer> columnsWithDuplicate = new HashSet<>();

            for (int j = 0; j < n; j++) {
                String[] input = sc.nextLine().split(" ");
                row.add(new HashSet<>());
                for (int k = 0; k < n; k++) {
                    if (j == 0) {
                        column.add(new HashSet<>());
                    }
                    int item = Integer.parseInt(input[k]);
                    if (j == k) {
                        trace += item;
                    }

                    if (row.get(j).contains(item)) {
                        if (!rowsWithDuplicate.contains(j)) {
                            duplicateRows++;
                            rowsWithDuplicate.add(j);
                        }
                    }
                    row.get(j).add(item);

                    if (column.get(k).contains(item)) {
                        if (!columnsWithDuplicate.contains(k)) {
                            duplicateColumns++;
                            columnsWithDuplicate.add(k);
                        }
                    }

                    column.get(k).add(item);
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}
