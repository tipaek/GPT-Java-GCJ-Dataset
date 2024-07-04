import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Parent {

    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            solve(i + 1, sc, out);
        }
        out.close();
    }

    public static void solve(int testNumber, FastReader sc, PrintWriter pw) {
        int n = sc.nextInt();
        Tuple[] arr = new Tuple[n * 2];
        int[] test = new int[n * 2];
        int index = 0;

        for (int i = 0; i < arr.length; i += 2) {
            arr[i] = new Tuple(sc.nextInt(), index + 1);
            arr[i + 1] = new Tuple(sc.nextInt(), -index - 1);
            test[i] = arr[i].a;
            test[i + 1] = arr[i + 1].a;
            index++;
        }

        Arrays.sort(arr);
        ArrayList<Integer> C = new ArrayList<>();
        ArrayList<Integer> J = new ArrayList<>();
        int cCount = 0, jCount = 0;
        int cIndex = 0, jIndex = 0;

        for (Tuple each : arr) {
            if (each.b > 0) {
                if (cCount == 0) {
                    cIndex = each.b;
                    cCount++;
                    C.add(each.b);
                } else if (jCount == 0) {
                    jIndex = each.b;
                    jCount++;
                    J.add(each.b);
                } else {
                    pw.printf("Case #%d: IMPOSSIBLE%n", testNumber);
                    return;
                }
            } else {
                if (Math.abs(each.b) == cIndex) {
                    cCount = 0;
                } else if (Math.abs(each.b) == jIndex) {
                    jCount = 0;
                }
            }
        }

        pw.print("Case #" + testNumber + ": ");
        for (int x = 1; x <= n; x++) {
            if (C.contains(x)) {
                pw.print("C");
            } else {
                pw.print("J");
            }
        }
        pw.println();
    }

    public static boolean works(int[] arr, ArrayList<Integer> min, ArrayList<Integer> max) {
        for (int i = 0; i < min.size(); i++) {
            if ((arr[0] > min.get(i) && arr[0] < max.get(i)) || arr[0] == min.get(i) ||
                (arr[1] > min.get(i) && arr[1] < max.get(i)) || arr[1] == max.get(i) ||
                (arr[0] > min.get(i) && arr[1] < max.get(i)) ||
                (arr[0] < min.get(i) && arr[1] > max.get(i))) {
                return false;
            }
        }
        return true;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

    static class Tuple implements Comparable<Tuple> {
        int a, b;

        Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Tuple other) {
            return this.a == other.a ? Integer.compare(this.b, other.b) : Integer.compare(this.a, other.a);
        }
    }
}