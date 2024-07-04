import java.util.*;

public class Main {
    public static void calculator(Scanner sc, int caseNumber) {
        int n = Integer.parseInt(sc.nextLine());
        List<List<Integer>> matrix = new ArrayList<>();
        int trace = 0;
        int repeatRowCount = 0, repeatColCount = 0;

        for (int i = 0; i < n; i++) {
            String[] rowElements = sc.nextLine().split("\\s+");
            List<Integer> row = new ArrayList<>();
            boolean[] usedInRow = new boolean[n];
            boolean rowHasRepetition = false;

            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(rowElements[j]);
                row.add(value);

                if (i == j) {
                    trace += value;
                }

                if (usedInRow[value - 1]) {
                    rowHasRepetition = true;
                }
                usedInRow[value - 1] = true;
            }
            matrix.add(row);

            if (rowHasRepetition) {
                repeatRowCount++;
            }
        }

        for (int j = 0; j < n; j++) {
            boolean[] usedInCol = new boolean[n];
            boolean colHasRepetition = false;

            for (int i = 0; i < n; i++) {
                int value = matrix.get(i).get(j);

                if (usedInCol[value - 1]) {
                    colHasRepetition = true;
                    break;
                }
                usedInCol[value - 1] = true;
            }

            if (colHasRepetition) {
                repeatColCount++;
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, repeatRowCount, repeatColCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testCases; i++) {
            calculator(sc, i + 1);
        }
    }
}