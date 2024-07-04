import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        PrintWriter writer = new PrintWriter(System.out);
        ProblemSolver solver = new ProblemSolver();
        int testCases = reader.nextInt();
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, reader, writer);
        }
        writer.close();
    }

    static class ProblemSolver {

        public void solve(int testCase, FastReader reader, PrintWriter writer) {
            int size = reader.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = reader.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowRepeats = 0;
            for (int i = 0; i < size; i++) {
                if (hasDuplicate(matrix[i])) {
                    rowRepeats++;
                }
            }

            int colRepeats = 0;
            for (int j = 0; j < size; j++) {
                int[] column = new int[size];
                for (int i = 0; i < size; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicate(column)) {
                    colRepeats++;
                }
            }

            writer.printf("Case #%d: %d %d %d%n", testCase, trace, rowRepeats, colRepeats);
        }

        private boolean hasDuplicate(int[] array) {
            Set<Integer> set = new HashSet<>();
            for (int value : array) {
                if (!set.add(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    static void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    static void shuffleArray(long[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            long temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(fileName)));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}