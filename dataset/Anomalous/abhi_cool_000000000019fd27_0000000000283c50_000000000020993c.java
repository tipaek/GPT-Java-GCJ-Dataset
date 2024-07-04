import java.util.*;
import java.util.stream.Stream;

public class Solution {

    private static int noOfTestCases = 0;
    private static List<Integer> listOfN = new ArrayList<>();
    private static List<Integer[][]> arrays = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();

        for (int i = 0; i < noOfTestCases; i++) {
            int n = listOfN.get(i);
            Integer[][] array = arrays.get(i);

            Set<Integer> rowNo = new HashSet<>();
            Set<Integer> colNo = new HashSet<>();

            List<Set<Integer>> hSets = new ArrayList<>(Collections.nCopies(n, new HashSet<>()));
            List<Set<Integer>> vSets = new ArrayList<>(Collections.nCopies(n, new HashSet<>()));

            int trace = 0, row = 0, col = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int value = array[j][k];
                    if (j == k) trace += value;

                    if (!rowNo.contains(j) && hSets.get(j).contains(value)) {
                        row++;
                        rowNo.add(j);
                    } else {
                        hSets.get(j).add(value);
                    }

                    if (!colNo.contains(k) && vSets.get(k).contains(value)) {
                        col++;
                        colNo.add(k);
                    } else {
                        vSets.get(k).add(value);
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, row, col);
        }
    }

    private void readInput() {
        Scanner scanner = new Scanner(System.in);
        noOfTestCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < noOfTestCases; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            listOfN.add(n);

            Integer[][] array = new Integer[n][n];
            for (int j = 0; j < n; j++) {
                String[] input = scanner.nextLine().split(" ");
                for (int k = 0; k < n; k++) {
                    array[j][k] = Integer.parseInt(input[k]);
                }
            }
            arrays.add(array);
        }
    }
}