import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        int nextInt() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return Integer.parseInt(st.nextToken());
        }
    }

    static class RecurrenceCounter {
        HashSet<Integer> set;

        public RecurrenceCounter() {
            set = new HashSet<>();
        }

        public void add(int data) {
            set.add(data);
        }

        public boolean hasRecurrence(int size) {
            return size != set.size();
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int matrixSize = reader.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int trace = 0, rowRecurrences = 0, colRecurrences = 0;

            for (int i = 0; i < matrixSize; i++) {
                RecurrenceCounter rowCounter = new RecurrenceCounter();
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = reader.nextInt();
                    rowCounter.add(matrix[i][j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                if (rowCounter.hasRecurrence(matrixSize)) {
                    rowRecurrences++;
                }
            }

            for (int j = 0; j < matrixSize; j++) {
                RecurrenceCounter colCounter = new RecurrenceCounter();
                for (int i = 0; i < matrixSize; i++) {
                    colCounter.add(matrix[i][j]);
                }
                if (colCounter.hasRecurrence(matrixSize)) {
                    colRecurrences++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRecurrences + " " + colRecurrences);
        }
    }
}