import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            List<List<Integer>> matrix = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                List<Integer> row = new ArrayList<>();
                String[] elements = scanner.nextLine().split(" ");
                for (String element : elements) {
                    row.add(Integer.parseInt(element));
                }
                matrix.add(row);
            }

            String caseResult = "Case #" + i + ": " + evaluateLatinSquare(matrix);
            result.append(caseResult);
            if (i < testCaseCount) {
                result.append("\n");
            }
        }

        System.out.print(result);
    }

    private static String evaluateLatinSquare(List<List<Integer>> matrix) {
        int size = matrix.size();
        int expectedXor = 0;
        int trace = 0;
        int rowIssues = 0;
        int colIssues = 0;

        for (int i = 1; i <= size; i++) {
            expectedXor ^= i;
        }

        for (int i = 0; i < size; i++) {
            int rowXor = 0;
            for (int j = 0; j < size; j++) {
                rowXor ^= matrix.get(i).get(j);
            }
            if (rowXor != expectedXor) {
                rowIssues++;
            }
        }

        for (int i = 0; i < size; i++) {
            int colXor = 0;
            for (int j = 0; j < size; j++) {
                colXor ^= matrix.get(j).get(i);
                if (i == j) {
                    trace += matrix.get(i).get(j);
                }
            }
            if (colXor != expectedXor) {
                colIssues++;
            }
        }

        return trace + " " + rowIssues + " " + colIssues;
    }
}