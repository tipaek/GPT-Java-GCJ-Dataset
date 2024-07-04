import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Writer writer = new PrintWriter(System.out);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            List<Set<Integer>> rows = new ArrayList<>();
            List<Set<Integer>> columns = new ArrayList<>();

            for (int i = 0; i < matrixSize; i++) {
                rows.add(new HashSet<>());
                columns.add(new HashSet<>());
            }

            int diagonalSum = 0, duplicateRows = 0, duplicateColumns = 0;

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    rows.get(i).add(value);
                    columns.get(j).add(value);
                    if (i == j) {
                        diagonalSum += value;
                    }
                }
            }

            for (int i = 0; i < matrixSize; i++) {
                if (rows.get(i).size() < matrixSize) duplicateRows++;
                if (columns.get(i).size() < matrixSize) duplicateColumns++;
            }

            writer.write(diagonalSum + " " + duplicateRows + " " + duplicateColumns + System.lineSeparator());
        }

        writer.flush();
        writer.close();
        scanner.close();
    }
}