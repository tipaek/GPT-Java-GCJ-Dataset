import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // FastReader sc = new FastReader();
        // Print printer = new Print();
        /*
         * long startTime = System.nanoTime();
         */
        /////////////////////////////////////////////////////
        int numTests = sc.nextInt();
        for (int testcase = 1; testcase <= numTests; ++testcase) {
            int n = sc.nextInt();
            String[] arr = new String[n];
            int maxlen = Integer.MIN_VALUE;
            int maxidx = -1;
            for (int i = 0; i < n; i++) {
                String in = sc.next();
                arr[i] = new StringBuilder(in.substring(1)).reverse().toString();
                if (arr[i].length() > maxlen) {
                    maxlen = arr[i].length();
                    maxidx = i;
                }
            }
            boolean ok = true;
            for (int i = 0; i < maxlen; i++) {
                char c = arr[maxidx].charAt(i);
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j].length() < i + 1) {
                        continue;
                    } else if (arr[j].charAt(i) != c) {
                        ok = false;
                        break;
                    } else {
                        continue;
                    }
                }
                if (!ok) {
                    break;
                }
            }

            if (ok) {
                String ans = new StringBuilder(arr[maxidx]).reverse().toString();
                System.out.println(ans);
            } else {
                System.out.println("*");
            }
        }
        // printer.close();
        /////////////////////////////////////////////////////
        /*
         * long endTime = System.nanoTime(); System.out.printf("Executed in: %.2fms\n",
         * ((double)endTime - startTime) / sc.close();
         */
    }

    public static <F extends Comparable<F>, S extends Comparable<S>> Pair<F, S> pair(F f, S s) {
        return new Pair<F, S>(f, s);
    }

    static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        } else {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Print {
        private final BufferedWriter bw;

        public Print() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
}

class Pair<F extends Comparable<F>, S extends Comparable<S>> implements Comparable<Pair<F, S>> {
    public F first;
    public S second;

    public Pair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Pair)) {
            return false;
        } else {
            Pair<?, ?> p = (Pair<?, ?>) o;
            return Objects.equals(this.first, p.first) && Objects.equals(this.second, p.second);
        }
    }

    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
    }

    @Override
    public String toString() {
        return "(" + this.first.toString() + ", " + this.second.toString() + ")";
    }

    @Override
    public int compareTo(Pair<F, S> o) {
        int res = this.first.compareTo(o.first);
        if (res == 0) {
            return this.second.compareTo(o.second);
        }
        return res;
    }
}
