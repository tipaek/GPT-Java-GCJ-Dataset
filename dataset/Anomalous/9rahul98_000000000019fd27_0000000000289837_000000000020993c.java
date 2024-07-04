package codejam_2020;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCasesNum = scanner.nextInt();

        for (int i = 1; i <= testCasesNum; i++) {
            int matrixSize = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline

            List<Integer> matrix = new ArrayList<>();

            for (int j = 0; j < matrixSize; j++) {
                String[] line = scanner.nextLine().split(" ");
                for (String num : line) {
                    matrix.add(Integer.parseInt(num));
                }
            }

            int trace = calculateTrace(matrix, matrixSize);
            int rowMax = rowMaxCount(matrix, matrixSize);
            int colMax = colMaxCount(matrix, matrixSize);

            System.out.println("Case #" + i + ": " + trace + " " + rowMax + " " + colMax);
        }
    }

    public static int calculateTrace(List<Integer> matrix, int matrixSize) {
        int trace = 0;
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix.get(i * matrixSize + i);
        }
        return trace;
    }

    public static int rowMaxCount(List<Integer> matrix, int matrixSize) {
        int maxCount = 0;

        for (int i = 0; i < matrixSize; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int j = 0; j < matrixSize; j++) {
                int value = matrix.get(i * matrixSize + j);
                countMap.put(value, countMap.getOrDefault(value, 0) + 1);
            }
            maxCount = Math.max(maxCount, Collections.max(countMap.values()));
        }

        return maxCount == 1 ? 0 : maxCount;
    }

    public static int colMaxCount(List<Integer> matrix, int matrixSize) {
        int maxCount = 0;

        for (int i = 0; i < matrixSize; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int j = 0; j < matrixSize; j++) {
                int value = matrix.get(j * matrixSize + i);
                countMap.put(value, countMap.getOrDefault(value, 0) + 1);
            }
            maxCount = Math.max(maxCount, Collections.max(countMap.values()));
        }

        return maxCount == 1 ? 0 : maxCount;
    }
}