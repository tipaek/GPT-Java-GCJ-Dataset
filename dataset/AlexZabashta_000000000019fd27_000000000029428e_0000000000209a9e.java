import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ToDoubleBiFunction;

import static java.lang.Math.*;

public class Solution extends PrintWriter {

    // char[] array = new char[20];
    //
    // int cntq = 0;
    //
    // char get(int p) {
    // ++cntq;
    //
    // if (cntq % 10 == 1) {
    // if (rnd.nextBoolean()) {
    // int l = 0, r = array.length - 1;
    // while (l < r) {
    // char c = array[l];
    // array[l] = array[r];
    // array[r] = c;
    // ++l;
    // --r;
    // }
    // }
    // if (rnd.nextBoolean()) {
    // for (int i = 0; i < array.length; i++) {
    // if (array[i] == '0') {
    // array[i] = '1';
    // } else {
    // array[i] = '0';
    // }
    // }
    // }
    // }
    //
    // return array[p];
    //
    // }
    //
    // boolean ans(String ans) {
    // println(ans);
    // flush();
    // return ans.equals(new String(array));
    // }

    char get(int p) {
        println(p + 1);
        flush();
        char c = nextLine().charAt(0);
        if (c == 'N') {
            throw new IllegalArgumentException("p = " + p);
        }
        return c;
    }

    boolean wrong(String ans) {
        println(ans);
        flush();
        return nextLine().equals("N");
    }

    String solve10() {
        int b = 10;
        char[] ans = new char[b];

        for (int i = 0; i < b; i++) {
            ans[i] = get(i);
        }

        return new String(ans);
    }

    String inv(String string) {
        StringBuilder inv = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '0') {
                inv.append('1');
            } else {
                inv.append('0');
            }
        }
        return inv.toString();
    }

    String solve20(int b) {
        int d = b / 4;
        Random random = new Random();

        int[] id = new int[b];

        for (int i = 0; i < b; i++) {
             int j = random.nextInt(i + 1);
             id[i] = id[j];
            id[j] = i;
           // id[i] = i;
        }

        Map<String, Integer> cnt1 = new HashMap<>();
        Map<String, Integer> cnt2 = new HashMap<>();

        for (int q = 0; q < 7; q++) {
            {
                StringBuilder builder = new StringBuilder();
                for (int i = 0 * d; i < 1 * d; i++) {
                    builder.append(get(id[i]));
                }
                for (int i = 2 * d; i < 3 * d; i++) {
                    builder.append(get(id[i]));
                }
                String key = builder.toString();
                cnt1.put(key, cnt1.getOrDefault(key, 0) + 1);

                key = inv(key);
                cnt1.put(key, cnt1.getOrDefault(key, 0) + 1);

            }

            {
                StringBuilder builder = new StringBuilder();
                for (int i = 1 * d; i < 2 * d; i++) {
                    builder.append(get(id[i]));
                }
                for (int i = 3 * d; i < 4 * d; i++) {
                    builder.append(get(id[i]));
                }
                String key = builder.toString();

                cnt2.put(key, cnt2.getOrDefault(key, 0) + 1);
                key = inv(key);
                cnt2.put(key, cnt2.getOrDefault(key, 0) + 1);
            }
        }

        char[] ans = new char[b];
        {
            StringBuilder builder = new StringBuilder();
            for (int i = 0 * d; i < 1 * d; i++) {
                builder.append(get(id[i]));
            }
            String key = builder.toString();

            for (int i = 0; i < d; i++) {
                ans[id[i + 0 * d]] = key.charAt(i);
            }

            int cnt = 0;

            for (Entry<String, Integer> e : cnt1.entrySet()) {
                String str = e.getKey();
                if (str.startsWith(key) && e.getValue() > cnt) {
                    cnt = e.getValue();
                    for (int i = 0; i < d; i++) {
                        ans[id[i + 2 * d]] = str.charAt(i + d);
                    }
                }
            }
        }

        {
            StringBuilder builder = new StringBuilder();
            for (int i = 1 * d; i < 2 * d; i++) {
                builder.append(get(id[i]));
            }
            String key = builder.toString();

            for (int i = 0; i < d; i++) {
                ans[id[i + 1 * d]] = key.charAt(i);
            }

            int cnt = 0;

            for (Entry<String, Integer> e : cnt2.entrySet()) {
                String str = e.getKey();
                if (str.startsWith(key) && e.getValue() > cnt) {
                    cnt = e.getValue();
                    for (int i = 0; i < d; i++) {
                        ans[id[i + 3 * d]] = str.charAt(i + d);
                    }
                }
            }
        }

       // println(cnt1);
      //  println(cnt2);

        return new String(ans);
    }

    void run() {
        int t = nextInt(), b = nextInt();

        for (int x = 0; x < t; x++) {
            String ans = null;
            if (b == 10) {
                ans = solve10();
            }
            if (b % 4 == 0) {
                ans = solve20(b);
            }

            if (wrong(ans)) {
                return;
            }
        }

        // int b = 4 * 5;
        // for (int i = 0; i < b; i++) {
        // array[i] = rnd.nextBoolean() ? '0' : '1';
        // }
        //
        // System.out.println(ans(solve20(b)));
        // System.out.println(new String(array));

    }

    public static boolean nextPermutation(int[] permutation) {
        int n = permutation.length, a = n - 2;
        while (0 <= a && permutation[a] >= permutation[a + 1]) {
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
        if (i == j) {
            return;
        }
        array[i] ^= array[j];
        array[j] ^= array[i];
        array[i] ^= array[j];
    }

    String next() {
        while (!tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(nextLine());
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
        } catch (IOException err) {
            return null;
        }
    }

    public Solution(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");
    static Random rnd = new Random();

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution(System.out);
        solution.run();
        solution.close();
        reader.close();
    }
}
