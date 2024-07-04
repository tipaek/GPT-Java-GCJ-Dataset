package googlecodejam;

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

            Set<Integer> rowNo = new HashSet<>();
            Set<Integer> colNo = new HashSet<>();

            List<Set<Integer>> hSets = new ArrayList<>(Collections.nCopies(n, new HashSet<>()));
            List<Set<Integer>> vSets = new ArrayList<>(Collections.nCopies(n, new HashSet<>()));

            int trace = 0, row = 0, col = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int thisValue = array[j][k];
                    if (j == k) trace += thisValue;

                    if (hSets.get(j).contains(thisValue)) {
                        if (!rowNo.contains(j)) {
                            row++;
                            rowNo.add(j);
                        }
                    } else {
                        hSets.get(j).add(thisValue);
                    }

                    if (vSets.get(k).contains(thisValue)) {
                        if (!colNo.contains(k)) {
                            col++;
                            colNo.add(k);
                        }
                    } else {
                        vSets.get(k).add(thisValue);
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

            int[][] array = new int[n][n];
            for (int j = 0; j < n; j++) {
                String[] strArr = scanner.nextLine().split(" ");
                for (int k = 0; k < n; k++) {
                    array[j][k] = Integer.parseInt(strArr[k]);
                }
            }
            arrays.add(array);
        }
    }
}