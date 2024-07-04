import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution extends PrintWriter {

    private char getCharacter(int position) {
        println(position + 1);
        flush();
        char response = nextLine().charAt(0);
        if (response == 'N') {
            throw new IllegalArgumentException("Invalid position: " + position);
        }
        return response;
    }

    private String solveFor10() {
        int length = 10;
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = getCharacter(i);
        }
        return new String(result);
    }

    private String solveFor20() {
        int length = 20;
        Random random = new Random();
        int[] indices = new int[length];
        for (int i = 0; i < length; i++) {
            int j = random.nextInt(i + 1);
            indices[i] = indices[j];
            indices[j] = i;
        }

        Map<String, Integer> firstHalfCounts = new HashMap<>();
        Map<String, Integer> secondHalfCounts = new HashMap<>();

        for (int query = 0; query < 7; query++) {
            String firstHalfKey = buildKey(indices, 0, 5, 10, 15);
            firstHalfCounts.put(firstHalfKey, firstHalfCounts.getOrDefault(firstHalfKey, 0) + 1);

            String secondHalfKey = buildKey(indices, 5, 10, 15, 20);
            secondHalfCounts.put(secondHalfKey, secondHalfCounts.getOrDefault(secondHalfKey, 0) + 1);
        }

        char[] result = new char[length];
        fillResult(result, indices, 0, 5, 10, firstHalfCounts);
        fillResult(result, indices, 5, 10, 15, secondHalfCounts);

        return new String(result);
    }

    private String buildKey(int[] indices, int start1, int end1, int start2, int end2) {
        StringBuilder builder = new StringBuilder();
        for (int i = start1; i < end1; i++) {
            builder.append(getCharacter(indices[i]));
        }
        for (int i = start2; i < end2; i++) {
            builder.append(getCharacter(indices[i]));
        }
        return builder.toString();
    }

    private void fillResult(char[] result, int[] indices, int start1, int end1, int offset, Map<String, Integer> counts) {
        StringBuilder builder = new StringBuilder();
        for (int i = start1; i < end1; i++) {
            builder.append(getCharacter(indices[i]));
        }
        String key = builder.toString();

        for (int i = 0; i < 5; i++) {
            result[indices[i + start1]] = key.charAt(i);
        }

        int maxCount = 0;
        for (Entry<String, Integer> entry : counts.entrySet()) {
            String str = entry.getKey();
            if (str.startsWith(key) && entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                for (int i = 0; i < 5; i++) {
                    result[indices[i + offset]] = str.charAt(i);
                }
            }
        }
    }

    private void run() {
        int testCases = nextInt();
        int length = nextInt();
        for (int i = 0; i < testCases; i++) {
            String result = (length == 10) ? solveFor10() : solveFor20();
            println(result);
            flush();
            if (nextLine().equals("N")) {
                return;
            }
        }
    }

    public static boolean nextPermutation(int[] permutation) {
        int n = permutation.length, a = n - 2;
        while (a >= 0 && permutation[a] >= permutation[a + 1]) {
            a--;
        }
        if (a == -1) {
            return false;
        }

        int b = n - 1;
        while (permutation[b] <= permutation[a]) {
            b--;
        }

        swap(permutation, a, b);
        for (int i = a + 1, j = n - 1; i < j; i++, j--) {
            swap(permutation, i, j);
        }
        return true;
    }

    public static void swap(int[] array, int i, int j) {
        if (i != j) {
            array[i] ^= array[j];
            array[j] ^= array[i];
            array[i] ^= array[j];
        }
    }

    private String next() {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(nextLine());
        }
        return tokenizer.nextToken();
    }

    private boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String line = nextLine();
            if (line == null) {
                return false;
            }
            tokenizer = new StringTokenizer(line);
        }
        return true;
    }

    private int[] nextArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    private int nextInt() {
        return Integer.parseInt(next());
    }

    private long nextLong() {
        return Long.parseLong(next());
    }

    private double nextDouble() {
        return Double.parseDouble(next());
    }

    private String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public Solution(OutputStream outputStream) {
        super(outputStream);
    }

    private static BufferedReader reader;
    private static StringTokenizer tokenizer = new StringTokenizer("");
    private static Random random = new Random();

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution(System.out);
        solution.run();
        solution.close();
        reader.close();
    }
}