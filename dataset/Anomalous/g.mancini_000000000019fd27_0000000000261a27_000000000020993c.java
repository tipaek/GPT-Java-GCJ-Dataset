import java.util.*;

public class Solution {

    private static long testCases;
    private static VestigiumInput vestigiumInput;

    public static void main(String[] args) {
        readInput(Solution::initializeVestigium, Solution::processVestigiumInput);
        solveVestigium();
        System.exit(0);
    }

    private static void solveVestigium() {
        for (int i = 0; i < testCases; i++) {
            long trace = 0;
            StringBuilder result = new StringBuilder();

            Map.Entry<Integer, Integer[][]> input = vestigiumInput.matrix.get(i);
            int size = input.getKey();
            Integer[][] matrix = input.getValue();
            long rowsWithDuplicates = 0;
            long columnsWithDuplicates = 0;
            Map<Integer, Set<Integer>> columnValuesMap = new HashMap<>();

            for (int r = 0; r < size; r++) {
                Set<Integer> rowValues = new HashSet<>();
                for (int c = 0; c < size; c++) {
                    rowValues.add(matrix[r][c]);
                    columnValuesMap.computeIfAbsent(c, k -> new HashSet<>()).add(matrix[r][c]);
                    if (c == r) {
                        trace += matrix[r][c];
                    }
                }
                if (rowValues.size() != size) {
                    rowsWithDuplicates++;
                }
            }

            for (Set<Integer> columnValues : columnValuesMap.values()) {
                if (columnValues.size() != size) {
                    columnsWithDuplicates++;
                }
            }

            result.append(trace).append(" ").append(rowsWithDuplicates).append(" ").append(columnsWithDuplicates);
            printSolution(i + 1, result.toString());
        }
    }

    private static void readInput(Consumer<Integer> initInput, BiConsumer<Scanner, Integer> inputReader) {
        Scanner scanner = new Scanner(System.in);
        testCases = scanner.nextLong();
        initInput.accept((int) testCases);

        for (int i = 0; i < testCases; i++) {
            inputReader.accept(scanner, i);
        }
    }

    private static void printSolution(long index, String output) {
        System.out.println("Case #" + index + ": " + output);
    }

    private static void processVestigiumInput(Scanner scanner, int index) {
        int size = scanner.nextInt();
        Integer[][] matrix = new Integer[size][size];
        vestigiumInput.matrix.add(new AbstractMap.SimpleEntry<>(size, matrix));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void initializeVestigium(int size) {
        vestigiumInput = new VestigiumInput();
        vestigiumInput.matrix = new ArrayList<>(size);
    }

    private static class VestigiumInput {
        private List<Map.Entry<Integer, Integer[][]>> matrix;
    }
}