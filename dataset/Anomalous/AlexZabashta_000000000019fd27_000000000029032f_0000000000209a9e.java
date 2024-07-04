import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution extends PrintWriter {

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

    private static BufferedReader reader;
    private static StringTokenizer tokenizer = new StringTokenizer("");
    private static Random random = new Random();

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

    private String solve20() {
        int b = 20;
        int[] id = new int[b];
        for (int i = 0; i < b; i++) {
            int j = random.nextInt(i + 1);
            id[i] = id[j];
            id[j] = i;
        }

        Map<String, Integer> cnt1 = new HashMap<>();
        Map<String, Integer> cnt2 = new HashMap<>();

        for (int q = 0; q < 70; q++) {
            processQuery(id, cnt1, 0, 5, 10, 15);
            processQuery(id, cnt2, 5, 10, 15, 20);
        }

        char[] ans = new char[b];
        fillAnswer(id, cnt1, ans, 0, 5, 10);
        fillAnswer(id, cnt2, ans, 5, 10, 15);

        return new String(ans);
    }

    private void processQuery(int[] id, Map<String, Integer> cnt, int start1, int end1, int start2, int end2) {
        StringBuilder builder = new StringBuilder();
        for (int i = start1; i < end1; i++) {
            builder.append(get(id[i]));
        }
        for (int i = start2; i < end2; i++) {
            builder.append(get(id[i]));
        }
        String key = builder.toString();
        cnt.put(key, cnt.getOrDefault(key, 0) + 1);
    }

    private void fillAnswer(int[] id, Map<String, Integer> cnt, char[] ans, int start1, int end1, int start2) {
        StringBuilder builder = new StringBuilder();
        for (int i = start1; i < end1; i++) {
            builder.append(get(id[i]));
        }
        String key = builder.toString();
        for (int i = 0; i < end1 - start1; i++) {
            ans[id[i + start1]] = key.charAt(i);
        }

        int maxCount = 0;
        for (Entry<String, Integer> e : cnt.entrySet()) {
            String str = e.getKey();
            if (str.startsWith(key) && e.getValue() > maxCount) {
                maxCount = e.getValue();
                for (int i = 0; i < end1 - start1; i++) {
                    ans[id[i + start2]] = str.charAt(i);
                }
            }
        }
    }

    private void run() {
        int t = nextInt(), b = nextInt();
        for (int x = 0; x < t; x++) {
            String ans = (b == 10) ? solve10() : solve20();
            println(ans);
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
        } catch (IOException err) {
            return null;
        }
    }
}