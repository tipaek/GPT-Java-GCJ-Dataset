import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        int tc = scan.nextInt();
        for (int i = 0; i < tc; i++) {
            out.print("Case #" + (i + 1) + ": ");
            solve();
        }
        out.close();
    }

    static class Pair {
        String number;
        String output;

        public Pair(String number, String output) {
            this.number = number;
            this.output = output;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(number, pair.number) &&
                    Objects.equals(output, pair.output);
        }

        @Override
        public int hashCode() {
            return Objects.hash(number, output);
        }
    }

    private static void solve() {
        int u = scan.nextInt();
        List<Pair> inputs = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            String number = scan.next();
            String output = scan.next();
            inputs.add(new Pair(number, output));
        }
        inputs.sort((o1, o2) -> {
            int diff1 = o1.number.length() - o1.output.length();
            int diff2 = o2.number.length() - o2.output.length();
            if (diff1 == diff2) {
                return o1.number.compareTo(o2.number);
            }
            return diff1 - diff2;
        });
        Map<Character, Integer> minAssumption = new HashMap<>();
        TreeMap<Integer, Character> sureAssumption = new TreeMap<>();
        for (Pair pair : inputs) {
            if (pair.number.length() == pair.output.length()) {
                char currChar = pair.output.charAt(0);
                if (minAssumption.getOrDefault(currChar, 10) > (pair.number.charAt(0) - '0')) {
                    minAssumption.put(currChar, (pair.number.charAt(0) - '0'));
                }
            }
        }
        boolean done = false;
        for (Pair pair : inputs) {
            if (done) break;
            for (int i = 0; i < pair.output.length(); i++) {
                if (!minAssumption.containsKey(pair.output.charAt(i))) {
                    sureAssumption.put(0, pair.output.charAt(i));
                    done = true;
                    break;
                }
            }
        }
        for (Pair pair : inputs) {
            for (int i = 0; i < pair.output.length(); i++) {
                char currChar = pair.output.charAt(0);
                Integer minKeyOfCurrentChar = minAssumption.get(currChar);
                Integer floorKey = sureAssumption.floorKey(minKeyOfCurrentChar);
                if (minKeyOfCurrentChar == 0 || (floorKey != null && floorKey == minKeyOfCurrentChar - 1)) {
                    sureAssumption.put(minKeyOfCurrentChar, currChar);
                } else {
                    break;
                }
            }
        }

        StringBuilder d = new StringBuilder();
        for (Map.Entry<Integer, Character> e : sureAssumption.entrySet()) {
            d.append(e.getValue());
        }
        out.println(d.toString());
    }


    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static MyScanner scan = new MyScanner();

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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
//--------------------------------------------------------

}