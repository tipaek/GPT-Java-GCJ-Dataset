package com.google.code.jam;

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
            long duplicateRows = 0;
            long duplicateColumns = 0;
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
                    duplicateRows++;
                }
            }
            for (Set<Integer> columnValues : columnValuesMap.values()) {
                if (columnValues.size() != size) {
                    duplicateColumns++;
                }
            }
            result.append(trace).append(" ").append(duplicateRows).append(" ").append(duplicateColumns);
            printSolution(i + 1, result.toString());
        }
    }

    private static void readInput(Consumer<Integer> initFunction, BiConsumer<Scanner, Integer> inputFunction) {
        Scanner scanner = new Scanner(System.in);
        testCases = scanner.nextLong();

        initFunction.accept((int) testCases);

        for (int i = 0; i < testCases; i++) {
            inputFunction.accept(scanner, i);
        }
    }

    private static void printSolution(long index, String output) {
        System.out.println("Case #" + index + ": " + output);
    }

    private static void processVestigiumInput(Scanner scanner, int index) {
        int matrixSize = scanner.nextInt();
        Integer[][] matrix = new Integer[matrixSize][matrixSize];
        vestigiumInput.matrix.add(index, new AbstractMap.SimpleEntry<>(matrixSize, matrix));
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
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