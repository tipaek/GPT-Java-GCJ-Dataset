import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(scanner.nextLine().trim());

        for (int t = 0; t < testCases; t++) {
            int matrixSize = Integer.parseInt(scanner.nextLine().trim());
            List<List<Integer>> matrix = new ArrayList<>();

            for (int i = 0; i < matrixSize; i++) {
                StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
                List<Integer> row = new ArrayList<>();
                while (tokenizer.hasMoreTokens()) {
                    row.add(Integer.parseInt(tokenizer.nextToken()));
                }
                matrix.add(row);
            }

            int trace = 0, repeatedRows = 0, repeatedCols = 0;

            for (int i = 0; i < matrixSize; i++) {
                trace += matrix.get(i).get(i);
                if (hasDuplicates(matrix.get(i))) {
                    repeatedRows++;
                }
            }

            for (int j = 0; j < matrixSize; j++) {
                List<Integer> column = new ArrayList<>();
                for (int i = 0; i < matrixSize; i++) {
                    column.add(matrix.get(i).get(j));
                }
                if (hasDuplicates(column)) {
                    repeatedCols++;
                }
            }

            writer.println("Case #" + (t + 1) + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }

        writer.close();
        scanner.close();
    }

    private static boolean hasDuplicates(List<Integer> list) {
        return list.size() != list.stream().distinct().count();
    }
}