import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());

        for(int test = 1; test <= testCases; test++) {
            int size = Integer.parseInt(scanner.nextLine());

            Map<Integer, Set<Integer>> rowSeen = new HashMap<>();
            Map<Integer, Set<Integer>> colSeen = new HashMap<>();

            boolean[] duplicateRows = new boolean[size];
            boolean[] duplicateCols = new boolean[size];

            int sumOfMainDiagonal = 0;

            for(int row = 0; row < size; row++) {
                String[] r = scanner.nextLine().split(" ");
                for(int col = 0; col < size; col++) {
                    int e = Integer.parseInt(r[col]);

                    rowSeen.putIfAbsent(row, new HashSet<>());
                    colSeen.putIfAbsent(col, new HashSet<>());

                    if (row == col) {
                        sumOfMainDiagonal += e;
                    }

                    if (!rowSeen.get(row).add(e)) {
                        duplicateRows[row] = true;
                    }

                    if (!colSeen.get(col).add(e)) {
                        duplicateCols[col] = true;
                    }
                }
            }

            int dupRows = 0;
            for (boolean dup : duplicateRows) {
                dupRows += dup ? 1 : 0;
            }

            int dupCols = 0;
            for (boolean dup : duplicateCols) {
                dupCols += dup ? 1 : 0;
            }

            System.out.println("Case #" + test + ": " + sumOfMainDiagonal + " " + dupRows + " " + dupCols);
        }
    }
}
