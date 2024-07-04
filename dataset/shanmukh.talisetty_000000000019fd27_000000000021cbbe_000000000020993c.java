import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium {
    public static void main(String[] args) {
        Vestigium vestigium = new Vestigium();
        vestigium.calculateTracesForAllTestcases();

    }

    private void calculateTracesForAllTestcases() {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        int totalCases = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < totalCases; i++) {
            calculateTraceForTestCase(i, scanner, sb);
        }
        scanner.close();
        System.out.println(sb);

    }

    private void calculateTraceForTestCase(int caseNumber, Scanner scanner, StringBuilder sb) {
        int n = scanner.nextInt();
        int[][] input = new int[n][n];

        for (int i = 0; i < n; i++) {

            String eachLine = scanner.next();

            String[] eachDigitStr = eachLine.split(" ");
            for (int j = 0; j < eachDigitStr.length; j++) {
                input[i][j] = Integer.parseInt(eachDigitStr[j]);
            }
        }

        //int[][] input = {{2, 2, 2, 2}, {2, 3, 2, 3}, {2, 2, 2, 3}, {2, 2, 2, 2}};

        int diagonalSum = 0;

        int rowDuplicateCount = 0;
        int columnDuplicateCount = 0;

        Set<Integer> rowSet;
        Set<Integer> colSet;


        for (int i = 0; i < n; i++) {
            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                rowSet.add(input[i][j]);
                colSet.add(input[j][i]);
                if (i == j) {
                    diagonalSum += input[i][j];
                }
            }
            if (rowSet.size() != n) {
                rowDuplicateCount++;
            }
            if (colSet.size() != n) {
                columnDuplicateCount++;
            }
        }
        sb.append(String.format("Case #%d: %d %d %d\n", caseNumber, diagonalSum, rowDuplicateCount, columnDuplicateCount));
    }
}
