import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner();

        int T = scanner.nextInt();
        char[] ans = new char[1005];

        int c = 1;
        while (T-- != 0) {
            int n = scanner.nextInt();
            ArrayList<Pair> p = new ArrayList <>();
            for (int i = 0; i < n; i++) {
                int[] tmp = scanner.nextIntArray();
                p.add(new Pair(tmp[0], tmp[1], i));
            }
            Collections.sort(p);
            int ec, ej; ec = ej = 0;
            boolean imp = false;
            for (int i = 0; i < n; i++) {
                // System.out.println(ec + " " + ej);
                if (p.get(i).x >= ec && p.get(i).x >= ej) {
                    ec = p.get(i).y;
                    ans[p.get(i).id] = 'C';
                } else if (p.get(i).x >= ec) {
                    ec = p.get(i).y;
                    ans[p.get(i).id] = 'C';
                } else if (p.get(i).x >= ej) {
                    ej = p.get(i).y;
                    ans[p.get(i).id] = 'J';
                } else {
                    imp = true;
                    break;
                }
            }

            System.out.print("Case #" + c + ": "); c++;
            if (imp)
                System.out.println("IMPOSSIBLE");
            else {
                for (int i = 0; i < n; i++) {
                    System.out.print(ans[i]);
                }
                System.out.println();
            }
        }
    }

    public static class Pair implements Comparable<Pair> {
        int x, y, id;

        public Pair(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(this.x, pair.x);
        }
    }

    private static class FastScanner {
        private BufferedReader br;

        public FastScanner() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public FastScanner(String input) throws Exception { br = new BufferedReader(new FileReader(input)); }
        public int[] nextIntArray() throws IOException {
            String line = br.readLine();
            String[] strings = line.trim().split("\\s+");
            int[] array = new int[strings.length];
            for (int i = 0; i < array.length; i++)
                array[i] = Integer.parseInt(strings[i]);
            return array;
        }
        public int nextInt() throws IOException { return Integer.parseInt(br.readLine()); }
        public long[] nextLongArray() throws IOException {
            String line = br.readLine();
            String[] strings = line.trim().split("\\s+");
            long[] array = new long[strings.length];
            for (int i = 0; i < array.length; i++)
                array[i] = Long.parseLong(strings[i]);
            return array;
        }
        public ArrayList<Integer> nextIntegerArrayList() throws IOException {
            String line = br.readLine();
            String[] strings = line.trim().split("\\s+");
            ArrayList<Integer> array = new ArrayList<Integer>();
            for (int i = 0; i < strings.length; i++)
                array.add(Integer.parseInt(strings[i]));
            return array;
        }
        public ArrayList<Long> nextLongArrayList() throws IOException {
            String line = br.readLine();
            String[] strings = line.trim().split("\\s+");
            ArrayList<Long> array = new ArrayList<Long>();
            for (int i = 0; i < strings.length; i++)
                array.add(Long.parseLong(strings[i]));
            return array;
        }
        public long nextLong() throws IOException { return Long.parseLong(br.readLine()); }
        public double nextDouble() throws IOException { return Double.parseDouble(br.readLine()); }
        public String nextLine() throws IOException { return br.readLine(); }


        public ArrayList<BigInteger> nextBigIntegers() throws IOException {
            String line = br.readLine();
            String[] strings = line.trim().split("\\s+");
            ArrayList<BigInteger> array = new ArrayList<BigInteger>();
            for (int i = 0; i < strings.length; i++)
                array.add(BigInteger.valueOf(Long.valueOf(strings[i])));
            return array;
        }
    }
}
