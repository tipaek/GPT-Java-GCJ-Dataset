
import java.util.*;
import java.io.*;
class Solution {

    public static Matrix readFromScanner(Scanner in) {
        int size = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        Matrix matrix = new Matrix(size, size);
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                matrix.setValue(x, y, in.nextInt());
            }
        }
        return matrix;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // Scanner in = new Scanner(new File("input.txt"));
        int cases = in.nextInt(); 
        for (int i = 0; i < cases; i++) {
            runOutput(readFromScanner((in)), i);
        }
    }


    public static void runOutput(Matrix matrix, int caseId) {
        // System.out.println("Matrix: " + matrix.getWidth() + " " + matrix.getHeight());
        
        int trace = calculateTrace(matrix);
        int rowsRepeated = calculateRowsRepeated(matrix);
        int columnsRepeated = calculateColsRepeated(matrix);
        
        System.out.println("Case #" + caseId + ": " + trace + " " + columnsRepeated + " " + rowsRepeated);
    }

    public static int calculateTrace(Matrix matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.getWidth(); i++) {
            trace += matrix.getValue(i, i);
        }
        return trace;
    }   

    public static int calculateRowsRepeated(Matrix matrix) {
        Matrix rowMatrix = new Matrix(matrix.getWidth(), matrix.getHeight());
        
        for (int y = 0; y < matrix.getHeight(); y++) {
            for (int x = 0; x < matrix.getWidth(); x++) {
                rowMatrix.setValue(matrix.getValue(x, y) - 1, y, 1);
            }
        }

        int rowsRepeated = 0;

        for (int y = 0; y < matrix.getHeight(); y++) {
            for (int x = 0; x < matrix.getWidth(); x++) {
                if (rowMatrix.getValue(x, y) == 0) {
                    rowsRepeated++;
                    break;
                }
            }
        }
        
        return rowsRepeated;
    }   

    public static int calculateColsRepeated(Matrix matrix) {
        Matrix rowMatrix = new Matrix(matrix.getWidth(), matrix.getHeight());
        
        for (int y = 0; y < matrix.getHeight(); y++) {
            for (int x = 0; x < matrix.getWidth(); x++) {
                rowMatrix.setValue(x, matrix.getValue(x, y) - 1, 1);
            }
        }

        int rowsRepeated = 0;

        for (int x = 0; x < matrix.getWidth(); x++) {
            for (int y = 0; y < matrix.getHeight(); y++) {
                if (rowMatrix.getValue(x, y) == 0) {
                    rowsRepeated++;
                    break;
                }
            }
        }
        
        return rowsRepeated;
    }   
}

class Matrix {
    private int width;
    private int height;
    private int[] array;

    public Matrix(int width, int height) {
        this.width = width;
        this.height = height;
        this.array = new int[width * height];
        for (int i = 0; i < width * height; i++) {
            this.array[i] = 0;
        }
    } 

    public int getWidth() {
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public void setValue(int x, int y, int value) {
        this.array[x + y * this.width] = value;
    }

    public int getValue(int x, int y) {
        return this.array[x + y * this.width];
    }
}