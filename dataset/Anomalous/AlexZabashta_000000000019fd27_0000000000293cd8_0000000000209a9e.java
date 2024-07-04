import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import static java.lang.Math.*;

public class Solution extends PrintWriter {

    char get(int p) {
        println(p + 1);
        flush();
        char c = nextLine().charAt(0);
        if (c == 'N') {
            throw new IllegalArgumentException("p = " + p);
        }
        return c;
    }

    boolean ans(String ans) {
        println(ans);
        flush();
        return nextLine().equals("Y");
    }

    String solve10() {
        int b = 10;
        char[] ans = new char[b];
        for (int i = 0; i < b; i++) {
            ans[i] = get(i);
        }
        return new String(ans);
    }

    String invert(String str) {
        StringBuilder inverted = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            inverted.append(str.charAt(i) == '0' ? '1' : '0');
        }
        return inverted.toString();
    }

    String solve20(int b) {
        int d = b / 4;
        int[] id = new int[b];
        for (int i = 0; i < b; i++) {
            id[i] = i;
        }

        Map<String, Integer> cnt1 = new HashMap<>();
        Map<String, Integer> cnt2 = new HashMap<>();

        for (int q = 0; q < 7; q++) {
            {
                String key = generateKey(id, 0, d, 2, 3);
                cnt1.put(key, cnt1.getOrDefault(key, 0) + 1);
                cnt1.put(invert(key), cnt1.getOrDefault(invert(key), 0) + 1);
            }
            {
                String key = generateKey(id, 1, d, 3, 4);
                cnt2.put(key, cnt2.getOrDefault(key, 0) + 1);
                cnt2.put(invert(key), cnt2.getOrDefault(invert(key), 0) + 1);
            }
        }

        char[] ans = new char[b];
        fillAnswer(ans, id, 0, d, cnt1);
        fillAnswer(ans, id, 1, d, cnt2);

        println(cnt1);
        println(cnt2);

        return new String(ans);
    }

    private String generateKey(int[] id, int start1, int d, int start2, int end2) {
        StringBuilder builder = new StringBuilder();
        for (int i = start1 * d; i < (start1 + 1) * d; i++) {
            builder.append(get(id[i]));
        }
        for (int i = start2 * d; i < end2 * d; i++) {
            builder.append(get(id[i]));
        }
        return builder.toString();
    }

    private void fillAnswer(char[] ans, int[] id, int start, int d, Map<String, Integer> cnt) {
        StringBuilder builder = new StringBuilder();
        for (int i = start * d; i < (start + 1) * d; i++) {
            builder.append(get(id[i]));
        }
        String key = builder.toString();
        for (int i = 0; i < d; i++) {
            ans[id[i + start * d]] = key.charAt(i);
        }

        int maxCount = 0;
        for (Entry<String, Integer> e : cnt.entrySet()) {
            String str = e.getKey();
            if (str.startsWith(key) && e.getValue() > maxCount) {
                maxCount = e.getValue();
                for (int i = 0; i < d; i++) {
                    ans[id[i + (start + 2) * d]] = str.charAt(i + d);
                }
            }
        }
    }

    void run() {
        int t = nextInt(), b = nextInt();
        for (int x = 0; x < t; x++) {
            String ans = (b == 10) ? solve10() : (b % 4 == 0) ? solve20(b) : null;
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
        if (a == -1) return false;

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

    String next() {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(nextLine());
        }
        return tokenizer.nextToken();
    }

    boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String line = nextLine();
            if (line == null) {
                return false;
            }
            tokenizer = new StringTokenizer(line);
        }
        return true;
    }

    int[] nextArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
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
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public Solution(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution(System.out);
        solution.run();
        solution.close();
        reader.close();
    }
}