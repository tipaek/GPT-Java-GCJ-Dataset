import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        PrintWriter writer = new PrintWriter(System.out);
        Task solver = new Task();
        int testCases = reader.nextInt();
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, reader, writer);
        }
        writer.close();
    }

    static class Task {

        public void solve(int testNumber, FastReader reader, PrintWriter writer) {
            String input = reader.nextLine();
            StringBuilder result = new StringBuilder();
            int currentLevel = 0;

            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';
                while (currentLevel > digit) {
                    result.append(')');
                    currentLevel--;
                }
                while (currentLevel < digit) {
                    result.append('(');
                    currentLevel++;
                }
                result.append(input.charAt(i));
            }

            while (currentLevel-- > 0) {
                result.append(')');
            }

            writer.printf("Case #%d: %s%n", testNumber, result.toString());
        }
    }

    static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    static void shuffle(long[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            long temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    static class FastReader {
        BufferedReader bufferedReader;
        StringTokenizer tokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String filePath) throws FileNotFoundException {
            bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
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
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}