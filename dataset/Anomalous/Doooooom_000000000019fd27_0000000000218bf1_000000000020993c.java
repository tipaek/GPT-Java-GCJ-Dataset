package co.com.fredymosquera.round2020.qualification;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Vestigium {

    public static void main(String[] args) {
        InputStream inputStream = Vestigium.class.getClassLoader().getResourceAsStream("Vestigium_input_file.txt");
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            List<List<Integer>> matrix = new ArrayList<>(matrixSize);

            int repeatedRows = 0;
            int repeatedCols = 0;

            for (int row = 0; row < matrixSize; row++) {
                List<Integer> matrixRow = Arrays.stream(scanner.nextLine().split(" "))
                                                 .map(Integer::parseInt)
                                                 .collect(Collectors.toList());
                if (matrixRow.size() != new HashSet<>(matrixRow).size()) {
                    repeatedRows++;
                }
                matrix.add(matrixRow);
            }

            int trace = IntStream.range(0, matrixSize)
                                 .map(index -> matrix.get(index).get(index))
                                 .sum();

            for (int col = 0; col < matrixSize; col++) {
                Set<Integer> columnSet = new HashSet<>();
                for (List<Integer> row : matrix) {
                    columnSet.add(row.get(col));
                }
                if (columnSet.size() != matrixSize) {
                    repeatedCols++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}