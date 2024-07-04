import java.util.*;

public class Solution {

    private void solve(Scanner scan) {
        int n = scan.nextInt();
        Map<Integer, Set<Integer>> columns = new HashMap<>();
        int trace = 0;
        Set<Integer> rowsWithRepeats = new HashSet<>();
        Set<Integer> columnsWithRepeats = new HashSet<>();
        for (int i = 0; i < n; i++) {
            columns.put(i, new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            Set<Integer> row = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int next = scan.nextInt();

                if (j == i) {
                    trace += next;
                }

                if (row.contains(next)) {
                    rowsWithRepeats.add(i);
                } else {
                    row.add(next);
                }

                if (columns.containsKey(j) && columns.get(j).contains(next)) {
                    columnsWithRepeats.add(j);
                } else {
                    columns.get(j).add(next);
                }
            }
        }

        System.out.println(trace + " " + rowsWithRepeats.size() + " " + columnsWithRepeats.size());
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count+1) + ": ");
            new Solution().solve(scan);
        }
        scan.close();
    }

}