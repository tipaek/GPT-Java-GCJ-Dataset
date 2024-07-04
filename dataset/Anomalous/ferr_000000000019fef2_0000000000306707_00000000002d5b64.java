import java.io.*;
import java.math.BigInteger;
import java.util.*;

public final class Solution implements Runnable {

    private int R, S;

    private class Permutation {
        private final byte[] array;

        Permutation() {
            array = new byte[R * S];
            int k = 0;
            for (int j = 0; j < S; j++) {
                for (int i = 0; i < R; i++) {
                    array[k++] = (byte) (i * S + j);
                }
            }
        }

        Permutation(byte[] array) {
            this.array = array;
        }

        Permutation mutate(int A, int B) {
            byte[] newArray = array.clone();
            System.arraycopy(array, A, newArray, 0, B);
            System.arraycopy(array, 0, newArray, B, A);
            return new Permutation(newArray);
        }

        boolean isValid() {
            for (int i = 0; i + 1 < array.length; i++) {
                if (array[i] / S > array[i + 1] / S) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Permutation that = (Permutation) obj;
            return Arrays.equals(array, that.array);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(array);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(String.format("(%d, %d) ", b / S + 1, b % S + 1));
            }
            return sb.toString();
        }
    }

    private String solveCase() {
        R = nextInt();
        S = nextInt();
        Permutation initialPermutation = new Permutation();
        Queue<Permutation> queue = new LinkedList<>();
        Map<Permutation, String> mutationMap = new HashMap<>();
        Map<Permutation, Permutation> parentMap = new HashMap<>();

        queue.add(initialPermutation);
        mutationMap.put(initialPermutation, null);

        while (!queue.isEmpty()) {
            Permutation current = queue.poll();
            if (current.isValid()) {
                List<String> steps = new ArrayList<>();
                while (current != null) {
                    String step = mutationMap.get(current);
                    if (step != null) {
                        steps.add(step);
                    }
                    current = parentMap.get(current);
                }
                StringBuilder result = new StringBuilder();
                result.append(steps.size()).append("\n");
                for (int i = steps.size() - 1; i >= 0; i--) {
                    result.append(steps.get(i)).append("\n");
                }
                return result.toString().trim();
            }
            for (int a = 1; a < R * S; a++) {
                for (int b = 1; a + b <= R * S; b++) {
                    Permutation mutated = current.mutate(a, b);
                    if (!mutationMap.containsKey(mutated)) {
                        queue.add(mutated);
                        mutationMap.put(mutated, String.format("%d %d", a, b));
                        parentMap.put(mutated, current);
                    }
                }
            }
        }
        return "NO";
    }

    private void solve() {
        int testCases = nextInt();
        for (int i = 0; i < testCases; i++) {
            String result = solveCase();
            pw.printf("Case #%d: %s\n", i + 1, result);
        }
    }

    private static final String FILENAME = "A";
    private static final boolean FROM_CONSOLE = true;

    public void run() {
        try {
            if (!FROM_CONSOLE) {
                in = new BufferedReader(new FileReader(FILENAME + ".in"));
                pw = new PrintWriter(FILENAME + ".out");
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                pw = new PrintWriter(System.out);
            }
            st = new StringTokenizer("");
            solve();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private StringTokenizer st;
    private BufferedReader in;
    private PrintWriter pw;

    private boolean hasNext() {
        try {
            while (!st.hasMoreTokens()) {
                String line = in.readLine();
                if (line == null) {
                    return false;
                }
                st = new StringTokenizer(line);
            }
            return st.hasMoreTokens();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String next() {
        return hasNext() ? st.nextToken() : null;
    }

    private int nextInt() {
        return Integer.parseInt(next());
    }

    private BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    private long nextLong() {
        return Long.parseLong(next());
    }

    private double nextDouble() {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }
}