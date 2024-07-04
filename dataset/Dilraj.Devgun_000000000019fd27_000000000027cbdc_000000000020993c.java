import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int n = 0; n < t; n++) {
            solveProblem1(scanner, n+1);
        }
    }

    public static void solveProblem1(Scanner scanner, int caseNumber) {
        int size = scanner.nextInt();
        int[] values = new int[size * size];
        for (int i = 0; i < size * size; i++) {
            values[i] = scanner.nextInt();
        }


        int trace = 0;
        int numRepeatedColumns = 0;
        int numRepeatedRows = 0;

        boolean rowHadDuplicate = false;
        Set<Integer> rowValues = new HashSet<>();
        HashMap<Integer, Set<Integer>> colValues = new HashMap<>();
        for (int idx = 0; idx < size * size; idx++) {
            int i = idx / size;
            int j = idx % size;

            if (i == j) {
                trace += values[idx];
            }

            if (j == 0) {
                rowValues.clear();
                rowHadDuplicate = false;
            }

            if (rowValues.contains(values[idx]) && !rowHadDuplicate) {
                numRepeatedRows++;
                rowHadDuplicate = true;
            } else {
                rowValues.add(values[idx]);
            }


            if (colValues.containsKey(j)) {
                colValues.get(j).add(values[idx]);
            } else {
                Set<Integer> col = new HashSet<>();
                col.add(values[idx]);
                colValues.put(j, col);
            }
        }

        for (int i : colValues.keySet()) {
            if (colValues.get(i).size() != size) {
                numRepeatedColumns++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + numRepeatedRows + " " + numRepeatedColumns);
    }
}
