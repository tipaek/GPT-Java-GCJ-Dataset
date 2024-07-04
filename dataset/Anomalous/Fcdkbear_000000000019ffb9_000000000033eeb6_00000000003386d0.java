import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < num.length; i++) {
            List<List<Integer>> current = new ArrayList<>();

            for (List<Integer> l : result) {
                for (int j = 0; j <= l.size(); j++) {
                    l.add(j, num[i]);
                    List<Integer> temp = new ArrayList<>(l);
                    current.add(temp);
                    l.remove(j);
                }
            }

            result = new ArrayList<>(current);
        }

        return result;
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int tests = in.nextInt();
        
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            int n = in.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; ++i) {
                p[i] = i;
            }
            
            List<List<Integer>> permutations = permute(p);
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; ++i) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }
            
            int res = (n == 2) ? 2 : 1;
            
            for (List<Integer> permutation : permutations) {
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        if (i == j) continue;

                        long dx = x[i] - x[j];
                        long dy = y[i] - y[j];
                        boolean used = false;
                        boolean failed = false;

                        for (int k = 1; k < permutation.size(); ++k) {
                            long ndx = x[permutation.get(k)] - x[permutation.get(k - 1)];
                            long ndy = y[permutation.get(k)] - y[permutation.get(k - 1)];

                            if (dx * ndy == ndx * dy) {
                                used = false;
                            } else {
                                if (used) {
                                    res = Math.max(res, k);
                                    failed = true;
                                    break;
                                } else {
                                    used = true;
                                }
                            }
                        }

                        if (!failed) {
                            res = n;
                        }
                    }
                }
            }
            
            out.printf("Case #%d: %d\n", testNumber, res);
            out.flush();
        }
        
        out.close();
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}