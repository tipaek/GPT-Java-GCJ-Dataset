import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution {
    static PrintWriter out;
    public static void main(String[] args) throws IOException {
//        try (PrintWriter out1 = new PrintWriter(Files.newBufferedWriter(Paths.get("out.txt")))) {
//            _Scanner sc = new _Scanner(Files.newInputStream(Paths.get("in.txt")));
        try (PrintWriter out1 = new PrintWriter(new BufferedOutputStream(System.out))) {
            _Scanner sc = new _Scanner(System.in);

            out = out1;

            int T = sc.nextInt();
            for (int t = 0; t < T; t++) {
                int c = sc.nextInt();
                int d = sc.nextInt();

                int[] xs = new int[c - 1];

                Map<Integer, List<Integer>> map = new HashMap<>();
                for (int i = 0; i < c; i++) map.put(i, new ArrayList<>());
                for (int i = 0; i < xs.length; i++) {
                    map.get(xs[i] = -sc.nextInt()).add(i+1);
                }
                map.get(0).add(0);

                boolean[][] g = new boolean[c][c];
                int[][] gi = new int[c][c];
                for (int i = 0; i < d; i++) {
                    int u = sc.nextInt() - 1;
                    int v = sc.nextInt() - 1;

                    g[u][v] = true;
                    g[v][u] = true;
                    gi[u][v] = i;
                    gi[v][u] = i;
                }

                List<Integer> selected = new ArrayList<>();
                for (int dist = 1; dist < c; dist++) {
                    List<Integer> integerList = map.get(dist);
                    for (Integer node : integerList) {
                        List<Integer> parents = map.get(dist - 1);
                        for (Integer parent : parents) {
                            if (g[parent][node]) {
                                selected.add(gi[parent][node]);
                            }
                        }
                    }
                }

                Collections.sort(selected);

                out.print(String.format("Case #%s:", t + 1));
                int j = 0;
                for (int i = 0; i < c; i++) {
                    if (j < selected.size() && i == selected.get(j)) {
                        out.print(String.format(" %s", 1));
                        j++;
                    } else {
                        out.print(String.format(" %s", 1000000));
                    }
                }
                out.println();

            }

        }
    }


    private static void reverse(int[] vs) {
        for (int i = 0; i < vs.length / 2; i++) {
            swap(vs, i, vs.length - 1 - i);
        }
    }

    static class _Scanner {
        InputStream is;
        _Scanner(InputStream is) {
            this.is = is;
        }
        byte[] bb = new byte[1 << 15];
        int k, l;
        byte getc() {
            try {
                if (k >= l) {
                    k = 0;
                    l = is.read(bb);
                    if (l < 0) return -1;
                }
                return bb[k++];
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        byte skip() {
            byte b;
            while ((b = getc()) <= 32)
                ;
            return b;
        }

        int nextInt() {
            int n = 0;
            int sig = 1;
            for (byte b = skip(); b > 32; b = getc()) {
                if (b == '-') {
                    sig = -1;
                } else {
                    n = n * 10 + b - '0';
                }
            }
            return sig * n;
        }

        long nextLong() {
            long n = 0;
            long sig = 1;
            for (byte b = skip(); b > 32; b = getc()) {
                if (b == '-') {
                    sig = -1;
                } else {
                    n = n * 10 + b - '0';
                }
            }
            return sig * n;
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        public String next() {
            StringBuilder sb = new StringBuilder();
            for (int b = skip(); b > 32; b = getc()) {
                sb.append(((char) b));
            }
            return sb.toString();
        }
    }

    private static void shuffle(int[] ar) {
        Random rnd = new Random();
        shuffle(ar, rnd);
    }

    private static void shuffle(int[] ar, Random rnd) {
        for (int i = 0; i < ar.length; i++) {
            int j = i + rnd.nextInt(ar.length - i);
            swap(ar, i, j);
        }
    }

    private static void shuffle(Object[] ar) {
        Random rnd = new Random();
        for (int i = 0; i < ar.length; i++) {
            int j = i + rnd.nextInt(ar.length - i);
            swap(ar, i, j);
        }
    }

    private static void swap(int[] ar, int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

    private static void swap(Object[] ar, int i, int j) {
        Object t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

}
