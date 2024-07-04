import java.util.*;

/**
 * Created by Abhishek Boharpi on 4/4/2020.
 */
public class Vestigium {

    private static int noOfTestCases;
    private static final List<Integer> listOfN = new ArrayList<>();
    private static final List<int[][]> arrays = new ArrayList<>();

    public static void main(String[] args) {
        Vestigium vestigium = new Vestigium();
        vestigium.readInput();

        for (int i = 0; i < noOfTestCases; i++) {
            int n = listOfN.get(i);
            int[][] array = arrays.get(i);

            int trace = 0;
            int row = 0;
            int col = 0;

            for (int j = 0; j < n; j++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();

                for (int k = 0; k < n; k++) {
                    int value = array[j][k];
                    if (j == k) trace += value;

                    if (!rowSet.add(value)) row++;
                    if (!colSet.add(array[k][j])) col++;
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

            int[][] array = new int[n][n];
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