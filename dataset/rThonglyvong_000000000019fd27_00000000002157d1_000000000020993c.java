import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    static int N = 0;
    static String[][] matrix = new String[1][1];
    public static void main(String[] args) {
        int test = Integer.parseInt(args[0]);
        int index = 1;
        for (int i = 0; i < test; i++) {
            N = Integer.parseInt(args[index++]);
            matrix = new String[N][N];

            int columnMatch = 0;
            int rowMatch = 0;

            Map<Integer, Set<String>> columnToSet = new HashMap<>();
            boolean[] columnHasDup = new boolean[N];
            int diagonalSum = 0;
            for (int j = 0; j < N; j++) {
                String[] temp = args[index++].split(" ");
                HashSet<String> currentRow = new HashSet<>();
                boolean rowHas = false;
                for (int k = 0; k < N; k++) {
                    String current = temp[k];
                    if (j == k) diagonalSum += Integer.parseInt(current);
                    if (currentRow.contains(current)) {
                        rowHas = true;
                    } else {
                        currentRow.add(current);
                    }
                    if (columnToSet.containsKey(k)) {
                        Set<String> tempSet = columnToSet.get(k);
                        if (tempSet.contains(current)) columnHasDup[k] = true;
                        else {
                            tempSet.add(current);
                        }
                    } else {
                        Set<String> tempSet = new HashSet<>();
                        tempSet.add(current);
                        columnToSet.put(k, tempSet);
                    }
                }
                if (rowHas) rowMatch++;

            }
            for(int l = 0; l < columnHasDup.length; l++) {
                if (columnHasDup[l]) columnMatch++;
            }
            System.out.println(solve(i, diagonalSum, columnMatch, rowMatch));
        }
    }

    public static String solve(int caseNum, int diagonalSum, int columnMatch, int rowMatch) {
        return "Case #" + (caseNum + 1) + ": " + diagonalSum + " " + columnMatch + " " + rowMatch;
    }
}