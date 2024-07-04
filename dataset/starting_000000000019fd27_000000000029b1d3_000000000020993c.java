package org.romith.google.codejam2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Vestigium {

    static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        ArrayList<ArrayList<ArrayList<Integer>>> cases = new ArrayList<>();
        int noCases = Integer.parseInt(readline());
        for (int i = 0; i < noCases; i++) {
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            // read matrix size
            int matrixSize = Integer.parseInt(readline());
            // read all the lines of matrix
            for (int j = 0; j < matrixSize; j++) {
                ArrayList<Integer> row = new ArrayList<>();
                // read a single row
                String rowString = readline();
                // convert individual cells to integers
                for (String cellString : rowString.split("\\s")) {
                    row.add(Integer.parseInt(cellString, 10));
                }
                // add single row to matrix
                matrix.add(row);
            }
            // add completed matrix
            cases.add(matrix);
        }


        for (int caseIndex = 0; caseIndex < cases.size(); caseIndex++) {
            var matrix = cases.get(caseIndex);

            Integer trace = 0;
            Integer repeatingRows = 0;
            Integer repeatingCols = 0;

            var columnElementList = new ArrayList<HashSet<Integer>>();
            var matrixSize = matrix.size();

            for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
                var rawElementSet = new HashSet<Integer>();
                var row = matrix.get(rowIndex);
                for (int colIndex = 0; colIndex < row.size(); colIndex++) {

                    if (rowIndex == 0) {
                        //initialize individual column set
                        columnElementList.add(new HashSet<>());
                    }

                    var cell = row.get(colIndex);

                    columnElementList.get(colIndex).add(cell);
                    rawElementSet.add(cell);

                    // calculate trace
                    if (rowIndex == colIndex) {
                        trace += row.get(colIndex);
                    }
                }
                if (rawElementSet.size() != matrixSize) {
                    repeatingRows++;
                }
            }
            // find the repeating cols
            for (var colSet : columnElementList) {
                if (colSet.size() != matrixSize) {
                    repeatingCols++;
                }
            }
            System.out.println(String.format("Case #%d: %d %d %d", caseIndex, trace, repeatingRows, repeatingCols));
        }

    }

    private static String readline() throws IOException {
        return console.readLine();
    }
}
