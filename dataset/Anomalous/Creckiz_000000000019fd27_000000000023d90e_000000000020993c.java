import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {

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

    static class RecurrenceChecker {
        HashSet<Integer> set;

        public RecurrenceChecker() {
            set = new HashSet<>();
        }

        public void add(int value) {
            set.add(value);
        }

        public boolean hasRecurrence(int expectedSize) {
            return set.size() != expectedSize;
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = reader.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRecurrences = 0, colRecurrences = 0;

            for (int i = 0; i < n; i++) {
                RecurrenceChecker rowChecker = new RecurrenceChecker();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = reader.nextInt();
                    rowChecker.add(matrix[i][j]);
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
                if (rowChecker.hasRecurrence(n)) {
                    rowRecurrences++;
                }
            }

            for (int j = 0; j < n; j++) {
                RecurrenceChecker colChecker = new RecurrenceChecker();
                for (int i = 0; i < n; i++) {
                    colChecker.add(matrix[i][j]);
                }
                if (colChecker.hasRecurrence(n)) {
                    colRecurrences++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRecurrences + " " + colRecurrences);
            caseNumber++;
        }
    }
}