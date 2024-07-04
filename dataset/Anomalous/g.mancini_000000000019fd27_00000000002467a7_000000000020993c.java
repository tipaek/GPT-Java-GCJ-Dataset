package com.google.code.jam;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Solution {

    private static long testCases;
    private static VestigiumInput vestigiumInput;

    public static void main(String[] args) {
        readInput(Solution::initializeVestigiumInput, Solution::parseVestigiumInput);
        solveVestigium();
    }

    private static void solveVestigium() {
        for (int i = 0; i < testCases; i++) {
            long trace = 0;
            StringBuilder result = new StringBuilder();

            Map.Entry<Integer, Long[][]> input = vestigiumInput.matrix.get(i);
            int size = input.getKey();
            Long[][] matrix = input.getValue();
            long duplicateRows = 0;
            long duplicateColumns = 0;
            Map<Integer, Set<Long>> columnValuesMap = new HashMap<>();

            for (int r = 0; r < size; r++) {
                Set<Long> rowValues = new HashSet<>();
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

            for (Set<Long> columnValues : columnValuesMap.values()) {
                if (columnValues.size() != size) {
                    duplicateColumns++;
                }
            }

            result.append(trace).append(" ").append(duplicateRows).append(" ").append(duplicateColumns);
            printSolution(i + 1, result.toString());
        }
    }

    private static void readInput(Consumer<Integer> initializer, BiConsumer<Scanner, Integer> inputReader) {
        Scanner scanner = new Scanner(System.in);
        testCases = scanner.nextLong();
        scanner.nextLine();

        initializer.accept((int) testCases);

        for (int i = 0; i < testCases; i++) {
            inputReader.accept(scanner, i);
        }
    }

    private static void printSolution(long index, String output) {
        System.out.println("Case #" + index + ": " + output);
    }

    private static void parseVestigiumInput(Scanner scanner, int index) {
        int matrixSize = scanner.nextInt();
        scanner.nextLine();
        Long[][] matrix = new Long[matrixSize][matrixSize];
        vestigiumInput.matrix.add(index, new AbstractMap.SimpleEntry<>(matrixSize, matrix));
        
        for (int i = 0; i < matrixSize; i++) {
            String[] values = scanner.nextLine().split(" ");
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = Long.valueOf(values[j]);
            }
        }
    }

    private static void initializeVestigiumInput(int size) {
        vestigiumInput = new VestigiumInput();
        vestigiumInput.matrix = new ArrayList<>(size);
    }

    private static class VestigiumInput {
        private List<Map.Entry<Integer, Long[][]>> matrix;
    }
}