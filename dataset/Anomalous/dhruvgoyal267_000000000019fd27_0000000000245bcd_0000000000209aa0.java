import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int originalTestCases = testCases;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int trace = scanner.nextInt();
            HashMap<Integer, ArrayList<Integer>> matrix = new HashMap<>();

            // Construct the matrix
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add((i + j) % n);
                }
                matrix.put(i, row);
            }

            int validIndex = -1;

            // Find a valid index with the desired trace
            for (int i = 0; i < n; i++) {
                int currentTrace = 0;
                for (int j = 0; j < n; j++) {
                    ArrayList<Integer> row = matrix.get((i + j) % n);
                    currentTrace += row.get(j) + 1;
                }
                if (currentTrace == trace) {
                    validIndex = i;
                    break;
                }
            }

            // Output the result
            if (validIndex == -1) {
                System.out.println("Case #" + (originalTestCases - testCases) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (originalTestCases - testCases) + ": POSSIBLE");
                for (int i = 0; i < n; i++) {
                    ArrayList<Integer> row = matrix.get((validIndex + i) % n);
                    for (int j = 0; j < row.size(); j++) {
                        System.out.print(row.get(j) + 1 + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}