import java.util.*;
import java.io.*;

public class Solution {

    private static class Task {

        private final int id;
        private final int size;
        private final int trace;

        public Task(int id, int size, int trace) {
            this.id = id;
            this.size = size;
            this.trace = trace;
        }

        public int getSize() {
            return size;
        }

        public int getTrace() {
            return trace;
        }

        public void process() {
            int[][] matrix = generateBaseMatrix(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int trace = getTrace(matrix, i, j, size);
                    if (trace == this.trace) {
                        System.out.println(String.format("Case #%d: POSSIBLE", id));
                        System.out.print(printMatrix(matrix, i, j, size));
                        return;
                    }
                }
//                shiftRow(matrix);
            }
            System.out.println(String.format("Case #%d: IMPOSSIBLE", id));
        }

        private void shiftColumn(int[][] matrix) {
            int[] last = matrix[matrix.length - 1];
            for (int i = matrix.length; i > 0; i--) {
                matrix[i] = matrix[i - 1];
            }
        }

        private int getTrace(int[][] matrix, int rowOffset, int colOffset, int size) {
            int result = 0;
            for (int i = 0; i < size; i++) {
                result += matrix[(i + rowOffset) % size][(i + colOffset) % size];
            }
            return result;
        }

        private int[][] generateBaseMatrix(int size) {
            int[][] result = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    result[i][j] = ((j + i) % size) + 1;
                }
            }
            return result;
        }
    }

    public static String printMatrix(int[][] matrix, int rowOffset, int colOffset, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = rowOffset; i < size + rowOffset; i++) {
            int iIndex = i % size;
            for (int j = colOffset; j < size + colOffset; j++) {
                int jIndex = j % size;
                int value = matrix[iIndex][jIndex];
                sb.append(value);
                if (j < size + colOffset - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        List<Task> tasks = new ArrayList<>();
        for (int caseId = 1; caseId <= testCount; caseId++) {
            int size = in.nextInt();
            int trace = in.nextInt();
            System.err.println(String.format("Test case #%d, size=%d trace=%d", caseId, size, trace));
            tasks.add(new Task(caseId, size, trace));
        }
        tasks.forEach(Task::process);
    }



}
