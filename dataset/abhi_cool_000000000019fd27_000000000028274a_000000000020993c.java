import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Abhishek Boharpi on 4/4/2020.
 */
public class Vestigium {

    static int noOfTestCases = 0;
    static List<Integer> listOfN = new ArrayList<>();
    static List<Integer[][]> arrays = new ArrayList<>();

    public static void main(String[] args) {
        Vestigium vestigium = new Vestigium();

        vestigium.readInput();

//        System.out.println(noOfTestCases);
//        System.out.println(listOfN);
//        System.out.println(arrays);

        Set<Integer> rowNo = new HashSet<>();
        Set<Integer> colNo = new HashSet<>();

        for (int i = 0; i < noOfTestCases; i++) {

            int n = listOfN.get(i);

            Integer[][] array = arrays.get(i);

            List<Set<Integer>> hSets = new ArrayList<>(n);
            List<Set<Integer>> vSets = new ArrayList<>(n);

            for (int j = 0; j < n; j++) {
                hSets.add(new HashSet<>(n));
                vSets.add(new HashSet<>(n));
            }

            int trace = 0;
            int row = 0;
            int col = 0;

            rowNo.clear();
            colNo.clear();

            for (int j = 0; j < n; j++) {

                for (int k = 0; k < n; k++) {

                    int thisValue = array[j][k];

                    if (j == k) trace += thisValue;

                    if (!rowNo.contains(j) && hSets.get(j).contains(thisValue)) {
                        row += 1;
                        rowNo.add(j);
                    } else {
                        hSets.get(j).add(thisValue);
                    }

                    if (!colNo.contains(k) && vSets.get(k).contains(thisValue)) {
                        col += 1;
                        colNo.add(k);
                    } else {
                        vSets.get(k).add(thisValue);
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d", i + 1, trace, row, col);
            System.out.println();

            hSets = null;
            vSets = null;
        }

    }

    private void readInput() {

        Scanner scanner = new Scanner(System.in);

        noOfTestCases = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i < noOfTestCases; i++) {

            int n = Integer.valueOf(scanner.nextLine());

            listOfN.add(n);

            Integer[][] array = new Integer[n][n];

            for (int j = 0; j < n; j++) {

                String input = scanner.nextLine();

                String[] strArr = input.split(" ");

                for (int k = 0; k < n; k++) {
                    array[j][k] = Integer.valueOf(strArr[k]);
                }
            }

            arrays.add(array);
        }
    }

}
