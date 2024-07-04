import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution extends PrintWriter {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer = new StringTokenizer("");
    private static final Random RANDOM = new Random();

    public Solution(OutputStream outputStream) {
        super(outputStream);
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution(System.out);
        solution.run();
        solution.close();
        reader.close();
    }

    private char get(int p) {
        println(p + 1);
        flush();
        char c = nextLine().charAt(0);
        if (c == 'N') {
            throw new IllegalArgumentException("p = " + p);
        }
        return c;
    }

    private String solve10() {
        int length = 10;
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = get(i);
        }
        return new String(result);
    }

    private String solve20() {
        int length = 20;
        int[] indices = new int[length];
        for (int i = 0; i < length; i++) {
            int j = RANDOM.nextInt(i + 1);
            indices[i] = indices[j];
            indices[j] = i;
        }

        Map<String, Integer> countMap1 = new HashMap<>();
        Map<String, Integer> countMap2 = new HashMap<>();

        for (int q = 0; q < 70; q++) {
            String key1 = buildKey(indices, 0, 5, 10, 15);
            countMap1.put(key1, countMap1.getOrDefault(key1, 0) + 1);

            String key2 = buildKey(indices, 5, 10, 15, 20);
            countMap2.put(key2, countMap2.getOrDefault(key2, 0) + 1);
        }

        char[] result = new char[length];
        fillResult(result, indices, countMap1, 0, 5, 10);
        fillResult(result, indices, countMap2, 5, 10, 15);

        return new String(result);
    }

    private String buildKey(int[] indices, int start1, int end1, int start2, int end2) {
        StringBuilder builder = new StringBuilder();
        for (int i = start1; i < end1; i++) {
            builder.append(get(indices[i]));
        }
        for (int i = start2; i < end2; i++) {
            builder.append(get(indices[i]));
        }
        return builder.toString();
    }

    private void fillResult(char[] result, int[] indices, Map<String, Integer> countMap, int start, int mid, int end) {
        String key = buildKey(indices, start, mid, mid, end);
        for (int i = 0; i < 5; i++) {
            result[indices[i + start]] = key.charAt(i);
        }

        int maxCount = 0;
        for (Entry<String, Integer> entry : countMap.entrySet()) {
            String str = entry.getKey();
            if (str.startsWith(key) && entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                for (int i = 0; i < 5; i++) {
                    result[indices[i + mid]] = str.charAt(i);
                }
            }
        }
    }

    private void run() {
        int t = nextInt();
        int b = nextInt();

        for (int x = 0; x < t; x++) {
            String answer = (b == 10) ? solve10() : (b == 20) ? solve20() : null;
            println(answer);
            flush();
            if ("N".equals(nextLine())) {
                return;
            }
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

    public static boolean nextPermutation(int[] permutation) {
        int n = permutation.length;
        int i = n - 2;
        while (i >= 0 && permutation[i] >= permutation[i + 1]) {
            i--;
        }
        if (i == -1) {
            return false;
        }

        int j = n - 1;
        while (permutation[j] <= permutation[i]) {
            j--;
        }

        swap(permutation, i, j);
        for (int k = i + 1, l = n - 1; k < l; k++, l--) {
            swap(permutation, k, l);
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

    private int[] nextArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }
}