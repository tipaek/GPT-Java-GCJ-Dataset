package com.company;

import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        int i = -1, j = -1, k = 0, l = 0, m = 0;
        int[][] tempMatrix = null;
        int totalTestCases = 0;
        int tempMatrixSize = 0;
        String tempLine = "";

        HashMap<Integer, Matrix> generalMap = new HashMap<Integer, Matrix>();

        while ((tempLine = scanner.nextLine()) != null && !tempLine.equals("")) {
            if (i == -1) {
                totalTestCases = Integer.parseInt(tempLine);
            } else {
                if (j == -1) {
                    tempMatrixSize = Integer.parseInt(tempLine);
                    tempMatrix = new int[tempMatrixSize][tempMatrixSize];
                    l = 0;
                } else {
                    m = 0;
                    for (String tempString : tempLine.split(" ")) {
                        tempMatrix[l][m] = Integer.parseInt(tempString);
                        m++;
                    }
                    l++;
                }
                if (l == tempMatrixSize) {
                    j = -1;
                    generalMap.put(++k,new Matrix(tempMatrixSize,tempMatrix));
                } else {
                    j++;
                }
            }
            i++;
        }

        for (Integer key: generalMap.keySet()) {
            System.out.println("Case #" + key + ": "
                + generalMap.get(key).getResultLine());
        }
    }
}

class Matrix {
    private int matrixSize;
    private int[][] matrix;
    private int trace;
    private int rowsContainingDuplicates;
    private int columnsContainingDuplicates;

    public Matrix (int matrixSize, int [][] matrix) {
        if (matrixSize > 0) {
            this.matrixSize = matrixSize;
            this.matrix = matrix;
            this.evaluateMatrix();
        } else {
            this.matrixSize = 0;
            this.matrix = null;
            this.trace = 0;
            this.rowsContainingDuplicates = 0;
            this.columnsContainingDuplicates = 0;
        }
    }

    private void evaluateMatrix () {
        this.trace = 0;
        this.rowsContainingDuplicates = 0;
        this.columnsContainingDuplicates = 0;
        this.calculateTrace();
        this.calculateDuplicateRowsCount();
        this.calculateDuplicateColumnsCount();
    }

    private void calculateTrace () {
        for (int i = 0; i < this.matrixSize; i++) {
            this.trace += this.matrix[i][i];
        }
    }

    private void calculateDuplicateRowsCount () {
        boolean duplicateFound;
        for (int i = 0; i < this.matrixSize; i++) {
            duplicateFound = false;
            for (int j = 0; (j < this.matrixSize - 1) && !duplicateFound; j++) {
                for (int k = 1; (j + k < this.matrixSize) && !duplicateFound; k++) {
                    if (this.matrix[i][j] == this.matrix[i][j+k]) {
                        this.rowsContainingDuplicates += 1;
                        duplicateFound = true;
                    }
                }
            }
        }
    }

    private void calculateDuplicateColumnsCount () {
        boolean duplicateFound;
        for (int j = 0; j < this.matrixSize; j++) {
            duplicateFound = false;
            for (int i = 0; (i < this.matrixSize - 1) && !duplicateFound; i++) {
                for (int k = 1; (i + k < this.matrixSize) && !duplicateFound; k++) {
                    if (this.matrix[i][j] == this.matrix[i+k][j]) {
                        this.columnsContainingDuplicates += 1;
                        duplicateFound = true;
                    }
                }
            }
        }
    }

    public int[][] getMatrix () {
        return this.matrix;
    }

    public void print () {
        String ret = "";
        if (this.matrixSize > 0) {
            for (int i = 0; i < this.matrixSize; i++) {
                System.out.print("   ");
                for (int j = 0; j < this.matrixSize; j++) {
                    System.out.print(this.matrix[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("   trace:" + this.trace + " duplicateRowCount:" + this.rowsContainingDuplicates
                    + " duplicateColumnCount:" + this.columnsContainingDuplicates);
        }
    }

    public String getResultLine () {
        String ret = "";

        ret += this.trace + " " + this.rowsContainingDuplicates + " " + this.columnsContainingDuplicates;

        return ret;
    }

    @Override
    public String toString () {
        String ret = "";

        if (this.matrixSize > 0) {
            for (int i = 0; i < this.matrixSize; i++) {
                for (int j = 0; j < this.matrixSize; j++) {
                    ret += this.matrix[i][j] + " ";
                }
                ret += "\n";
            }
        }

        return ret;
    }
}