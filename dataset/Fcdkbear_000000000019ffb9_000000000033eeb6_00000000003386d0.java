import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Function;

public class Solution {

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        //start from an empty list
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size()+1; j++) {
                    // + add num[i] to different locations
                    l.add(j, num[i]);

                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);

                    //System.out.println(temp);

                    // - remove num[i] add
                    l.remove(j);
                }
            }

            result = new ArrayList<ArrayList<Integer>>(current);
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
            ArrayList<ArrayList<Integer>> permutations = permute(p);
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; ++i) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }
            int res = 1;
            if (n == 2) {
                res = 2;
            }
            for (List<Integer> permutation : permutations) {
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        if (i == j) {
                            continue;
                        }
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
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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
        public long nextLong() {
            return Long.parseLong(next());
        }


    }
}
