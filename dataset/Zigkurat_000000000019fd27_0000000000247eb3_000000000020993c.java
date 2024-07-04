package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<String> lines = new ArrayList<>();
        while (in.hasNext()) {
            lines.add(in.nextLine());
        }


        int matrixCount = Integer.parseInt(lines.get(0));
        int currentMatrixId = 1;

        int currentLine = 1;
        while (currentMatrixId <= matrixCount) {
            int matrixSize = Integer.parseInt(lines.get(currentLine++));
            List<String> matrixData = lines.subList(currentLine, currentLine + matrixSize);

            Matrix matrix = new Matrix(currentMatrixId, matrixSize, matrixData);
            matrix.printResult();

            currentLine += matrixSize;
            currentMatrixId++;
        }
    }

    public static class Matrix {
        private int id;
        private int size;
        private int[][] elements;

        private int trace = 0;
        private int repeatedRows = 0;
        private int repeatedCols = 0;

        public Matrix(int id, int size, List<String> input) {
            this.id = id;
            this.size = size;
            this.elements = new int[size][size];
            for (int i = 0; i < size; i++) {
                String row = input.get(i);
                String[] cols = row.split(" ");
                for (int j = 0; j < cols.length; j++) {
                    elements[i][j] = Integer.parseInt(cols[j]);
                }
            }
        }

        private void calculateTrace() {
            for (int i = 0; i < size; i++) {
                trace += elements[i][i];
            }
        }

        private void calculateRepeatedRows() {
            for (int i = 0; i < size; i++) {

                Set<Integer> elementsSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    elementsSet.add(elements[i][j]);
                }
                if (elementsSet.size() < size) {
                    repeatedRows++;
                }
            }
        }

        private void calculateRepeatedCols() {
            for (int i = 0; i < size; i++) {

                Set<Integer> elementsSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    elementsSet.add(elements[j][i]);
                }
                if (elementsSet.size() < size) {
                    repeatedCols++;
                }
            }
        }

        public void printResult() {
            calculateTrace();
            calculateRepeatedRows();
            calculateRepeatedCols();

            System.out.println("Case #" + id + ": " + trace + " " + repeatedRows + " " + repeatedCols + "\n");
        }
    }
}