import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution extends PrintWriter {

    public Solution(OutputStream outputStream) {
        super(outputStream);
    }

    private static BufferedReader reader;
    private static StringTokenizer tokenizer = new StringTokenizer("");
    private static Random rnd = new Random();

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
        int b = 10;
        char[] ans = new char[b];
        for (int i = 0; i < b; i++) {
            ans[i] = get(i);
        }
        return new String(ans);
    }

    private String solve20(int b) {
        int d = b / 4;
        Random random = new Random();
        int[] id = new int[b];
        for (int i = 0; i < b; i++) {
            int j = random.nextInt(i + 1);
            id[i] = id[j];
            id[j] = i;
        }

        Map<String, Integer> cnt1 = new HashMap<>();
        Map<String, Integer> cnt2 = new HashMap<>();

        for (int q = 0; q < 7; q++) {
            collectData(cnt1, id, 0, 1, 2, 3, d);
            collectData(cnt2, id, 1, 2, 3, 4, d);
        }

        char[] ans = new char[b];
        processSegment(cnt1, id, ans, 0, 2, d);
        processSegment(cnt2, id, ans, 1, 3, d);
        return new String(ans);
    }

    private void collectData(Map<String, Integer> cnt, int[] id, int start1, int end1, int start2, int end2, int d) {
        StringBuilder builder = new StringBuilder();
        for (int i = start1 * d; i < end1 * d; i++) {
            builder.append(get(id[i]));
        }
        for (int i = start2 * d; i < end2 * d; i++) {
            builder.append(get(id[i]));
        }
        String key = builder.toString();
        cnt.put(key, cnt.getOrDefault(key, 0) + 1);
    }

    private void processSegment(Map<String, Integer> cnt, int[] id, char[] ans, int start, int end, int d) {
        StringBuilder builder = new StringBuilder();
        for (int i = start * d; i < (start + 1) * d; i++) {
            builder.append(get(id[i]));
        }
        String key = builder.toString();
        for (int i = 0; i < d; i++) {
            ans[id[i + start * d]] = key.charAt(i);
        }

        int maxCount = 0;
        for (Entry<String, Integer> entry : cnt.entrySet()) {
            String str = entry.getKey();
            if (str.startsWith(key) && entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                for (int i = 0; i < d; i++) {
                    ans[id[i + end * d]] = str.charAt(i);
                }
            }
        }
    }

    private void run() {
        int t = nextInt(), b = nextInt();
        for (int x = 0; x < t; x++) {
            String ans = null;
            if (b == 10) {
                ans = solve10();
            } else if (b % 4 == 0) {
                ans = solve20(b);
            }
            println(ans);
            flush();
            if (nextLine().equals("N")) {
                return;
            }
        }
    }

    private static boolean nextPermutation(int[] permutation) {
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

    private static void swap(int[] array, int i, int j) {
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
}