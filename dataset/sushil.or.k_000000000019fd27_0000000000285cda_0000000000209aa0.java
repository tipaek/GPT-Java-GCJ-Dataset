import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int numCases = scanner.nextInt();
            Map<Integer, Map<Integer, Matrix>> matrixMap = generateMatrix();
            for (int idx = 0; idx < numCases; ++idx) {
                int n = scanner.nextInt();
                int trace = scanner.nextInt();
                Matrix matrix = null;
                if (matrixMap.containsKey(n)) {
                    matrix = matrixMap.get(n).get(trace);
                }
                String result = matrix == null ? "IMPOSSIBLE" : "POSSIBLE";
                System.out.println("Case #" + (idx + 1) + ": " + result);
                if (matrix != null)
                    matrix.print();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static Map<Integer, Map<Integer, Matrix>> generateMatrix() {
        Map<Integer, Map<Integer, Matrix>> matrixMap = new HashMap<>();
        // size 2
        Map<Integer, Matrix> temp = new HashMap<>();
        matrixMap.put(2, temp);
        Matrix matrix = new Matrix(2);
        matrix.setMatrix(new int[][] { { 1, 2 }, { 2, 1 } });
        temp.put(2, matrix);
        matrix = new Matrix(2);
        matrix.setMatrix(new int[][] { { 2, 1 }, { 1, 2 } });
        temp.put(4, matrix);

        // size 3
        temp = new HashMap<>();
        matrixMap.put(3, temp);
        matrix = new Matrix(3);
        matrix.setMatrix(new int[][] { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } });
        temp.put(3, matrix);
        matrix = new Matrix(3);
        matrix.setMatrix(new int[][] { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 1, 2 } });
        temp.put(6, matrix);
        matrix = new Matrix(3);
        matrix.setMatrix(new int[][] { { 3, 1, 2 }, { 2, 3, 1 }, { 1, 2, 3 } });
        temp.put(9, matrix);

        // size 4
        temp = new HashMap<>();
        matrixMap.put(4, temp);
        matrix = new Matrix(4);
        matrix.setMatrix(new int[][] { { 1, 2, 3, 4 }, { 2, 1, 4, 3 }, { 3, 4, 1, 2 }, { 4, 3, 2, 1 } });
        temp.put(4, matrix);
        matrix = new Matrix(4);
        matrix.setMatrix(new int[][] { { 1, 2, 3, 4 }, { 2, 1, 4, 3 }, { 3, 4, 2, 1 }, { 4, 3, 1, 2 } });
        temp.put(6, matrix);
        matrix = new Matrix(4);
        matrix.setMatrix(new int[][] { { 1, 3, 4, 2 }, { 2, 1, 3, 4 }, { 3, 4, 2, 1 }, { 4, 2, 1, 3 } });
        temp.put(7, matrix);
        matrix = new Matrix(4);
        matrix.setMatrix(new int[][] { { 2, 1, 3, 4 }, { 4, 2, 1, 3 }, { 3, 4, 2, 1 }, { 1, 3, 4, 2 } });
        temp.put(8, matrix);
        matrix = new Matrix(4);
        matrix.setMatrix(new int[][] { { 1, 4, 3, 2 }, { 3, 1, 2, 4 }, { 2, 3, 4, 1 }, { 4, 2, 1, 3 } });
        temp.put(9, matrix);
        matrix = new Matrix(4);
        matrix.setMatrix(new int[][] { { 3, 2, 1, 4 }, { 2, 3, 4, 1 }, { 4, 1, 2, 3 }, { 1, 4, 3, 2 } });
        temp.put(10, matrix);
        matrix = new Matrix(4);
        matrix.setMatrix(new int[][] { { 1, 4, 2, 3 }, { 4, 2, 3, 1 }, { 3, 1, 4, 2 }, { 2, 3, 1, 4 } });
        temp.put(11, matrix);
        matrix = new Matrix(4);
        matrix.setMatrix(new int[][] { { 3, 4, 2, 1 }, { 4, 3, 1, 2 }, { 1, 2, 3, 4 }, { 2, 1, 4, 3 } });
        temp.put(12, matrix);
        matrix = new Matrix(4);
        matrix.setMatrix(new int[][] { { 2, 4, 3, 1 }, { 4, 3, 1, 2 }, { 1, 2, 4, 3 }, { 3, 1, 2, 4 } });
        temp.put(13, matrix);
        matrix = new Matrix(4);
        matrix.setMatrix(new int[][] { { 3, 4, 1, 2 }, { 4, 3, 2, 1 }, { 1, 2, 4, 3 }, { 2, 1, 3, 4 } });
        temp.put(14, matrix);
        matrix = new Matrix(4);
        matrix.setMatrix(new int[][] { { 4, 3, 2, 1 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 1, 2, 3, 4 } });
        temp.put(16, matrix);

        // size 5
        temp = new HashMap<>();
        matrixMap.put(5, temp);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{1,2,3,4,5},{5,1,2,3,4},{4,5,1,2,3},{3,4,5,1,2},{2,3,4,5,1}});
        temp.put(5, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{1,2,3,4,5},{5,1,2,3,4},{2,4,1,5,3},{4,3,5,2,1},{3,5,4,1,2}});
        temp.put(7, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{1,2,3,4,5},{2,1,5,3,4},{4,5,2,1,3},{5,3,4,2,1},{3,4,1,5,2}});
        temp.put(8, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{1,2,3,4,5},{3,1,5,2,4},{4,3,1,5,2},{2,5,4,3,1},{5,4,2,1,3}});
        temp.put(9, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{2,1,3,4,5},{5,2,1,3,4},{4,5,2,1,3},{3,4,5,2,1},{1,3,4,5,2}});
        temp.put(10, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{1,4,5,2,3},{2,1,4,3,5},{4,3,1,5,2},{5,2,3,4,1},{3,5,2,1,4}});
        temp.put(11, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{1,4,5,2,3},{3,1,4,5,2},{2,5,1,3,4},{5,2,3,4,1},{4,3,2,1,5}});
        temp.put(12, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{1,4,5,2,3},{5,1,2,3,4},{3,5,1,4,2},{2,3,4,5,1},{4,2,3,1,5}});
        temp.put(13, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{1,2,5,3,4},{5,1,4,2,3},{3,5,2,4,1},{4,3,1,5,2},{2,4,3,1,5}});
        temp.put(14, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{3,1,2,4,5},{5,3,1,2,4},{4,5,3,1,2},{2,4,5,3,1},{1,2,4,5,3}});
        temp.put(15, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{2,4,1,3,5},{4,2,5,1,3},{1,3,4,5,2},{3,5,2,4,1},{5,1,3,2,4}});
        temp.put(16, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{2,4,1,3,5},{4,3,5,1,2},{1,2,4,5,3},{3,5,2,4,1},{5,1,3,2,4}});
        temp.put(17, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{3,4,1,2,5},{4,3,5,1,2},{1,2,4,5,3},{2,5,3,4,1},{5,1,2,3,4}});
        temp.put(18, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{3,4,5,1,2},{5,3,1,2,4},{2,5,3,4,1},{4,1,2,5,3},{1,2,4,3,5}});
        temp.put(19, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{4,1,2,3,5},{5,4,1,2,3},{3,5,4,1,2},{2,3,5,4,1},{1,2,3,5,4}});
        temp.put(20, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{3,5,2,4,1},{5,3,4,1,2},{1,4,5,2,3},{2,1,3,5,4},{4,2,1,3,5}});
        temp.put(21, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{4,3,5,1,2},{5,4,1,2,3},{2,5,4,3,1},{3,1,2,5,4},{1,2,3,4,5}});
        temp.put(22, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{5,3,4,1,2},{4,5,1,2,3},{2,4,5,3,1},{3,1,2,4,5},{1,2,3,5,4}});
        temp.put(23, matrix);
        matrix = new Matrix(5);
        matrix.setMatrix(new int[][] {{5,1,2,3,4},{4,5,1,2,3},{3,4,5,1,2},{2,3,4,5,1},{1,2,3,4,5}});
        temp.put(25, matrix);
        return matrixMap;
    }
}

class Matrix {
    int size;
    int[][] arr;
    public Matrix(int size) {
        this.size = size;
        this.arr = new int[size][size];
    }

    public void setMatrix(int[][] matrix) {
        this.arr = matrix;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}