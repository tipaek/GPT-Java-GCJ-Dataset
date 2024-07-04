import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        int t = in.nextInt();
        for (int q = 1; q <= t; q++) {
            String s = in.next();
            ArrayList<Integer> ss = new ArrayList<>();
            for (char c : s.toCharArray()) {
                ss.add(Character.getNumericValue(c));
            }
            String res = "";
            for (int i = 0; i < ss.size(); i++) {
                if (i == 0) {
                    for (int j = 0; j < ss.get(i); j++) {
                        res += '(';
                    }
                    res += ss.get(i);
                }
                if (i > 0) {
                    if (ss.get(i - 1) < ss.get(i)) {
                        for (int j = ss.get(i - 1); j < ss.get(i); j++) {
                            res += '(';
                        }
                        res += ss.get(i);
                    }
                    if (ss.get(i - 1) > ss.get(i)) {
                        for (int j = ss.get(i); j < ss.get(i - 1); j++) {
                            res += ')';
                        }
                        res += ss.get(i);
                    }
                    if (ss.get(i - 1) == ss.get(i)) {
                        res += ss.get(i);
                    }
                }
            }
            for (int i = ss.get(ss.size() - 1); i > 0; i--) {
                res += ')';
            }
            out.println(get(q, res));
        }

        long endTime = System.nanoTime();
        err.println("Execution Time : +" + (endTime - startTime) / 1000000 + " ms");

        exit(0);
    }

    static void old2(ArrayList<Integer> ss) {
        String res = "";
        for (int i = 0; i < ss.size(); i++) {
            if (ss.get(i) == 0) {
                res += '0';
            } else {
                if (ss.get(i) == 1) {
                    res += '(';
                    while (i < ss.size() && ss.get(i) == 1) {
                        res += '1';
                        i++;
                    }
                    res += ')';
                    i--;
                }
            }
        }
    }

    static void old(final String s) {
        ArrayList<Integer> ss = new ArrayList<>();
        for (char c : s.toCharArray()) {
            ss.add(Character.getNumericValue(c));
        }
        ArrayList<Integer> list = new ArrayList<>();
        TreeMap<Integer, ArrayList<Integer>> sol_in = new TreeMap<>();
        TreeMap<Integer, ArrayList<Integer>> sol_de = new TreeMap<>();
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < ss.size(); i++) {
            if (ss.get(i - 1) == 0) {
                continue;
            }
            if (ss.get(i - 1) <= ss.get(i)) {
                list.add(ss.get(i - 1));
                ss.set(i - 1, -1);
            } else {
                if (!list.isEmpty()) {
                    list.add(ss.get(i - 1));
                    ss.set(i - 1, -1);
                    sol_in.put(i - 1, list);
                }
                list = new ArrayList<>();
            }
        }
        if (!list.isEmpty()) {
            list.add(ss.get(ss.size() - 1));
            ss.set(ss.size() - 1, -1);
            sol_in.put(ss.size() - 1, list);
        }
        list = new ArrayList<>();
        for (int i = 1; i < ss.size(); i++) {
            if (ss.get(i - 1) == 0) {
                continue;
            }
            if (ss.get(i) == -1) {
                continue;
            }
            if (ss.get(i - 1) > ss.get(i)) {
                list.add(ss.get(i - 1));
                ss.set(i - 1, -1);
            } else {
                if (!list.isEmpty()) {
                    list.add(ss.get(i - 1));
                    ss.set(i - 1, -1);
                    sol_de.put(i - 1, list);
                }
                list = new ArrayList<>();
            }
        }
        if (!list.isEmpty()) {
            list.add(ss.get(ss.size() - 1));
            ss.set(ss.size() - 1, -1);
            sol_de.put(ss.size() - 1, list);
        }
        list = new ArrayList<>();
        for (int i = 0; i < ss.size(); i++) {
            if (ss.get(i) >= 0) {
                res.append(single(ss.get(i)));
            }
            if (sol_in.containsKey(i)) {
                res.append(increasing(sol_in.get(i)));
            }
            if (sol_de.containsKey(i)) {
                res.append(decreasing(sol_de.get(i)));
            }
        }
    }

    static String get(Object... args) {
        String res = "Case #" + args[0] + ":";
        for (int i = 1; i < args.length; i++) {
            res += " ";
            res += args[i];
        }
        return res;
    }

    static String increasing(ArrayList<Integer> list) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < list.get(0); i++) {
            res.append('(');
        }
        res.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) == list.get(i)) {
                res.append(list.get(i));
            } else {
                res.append(list.get(i));
                res.append(')');
            }
        }
        for (int i = 0; i < list.get(list.size() - 1); i++) {
            res.append(')');
        }
        return res.toString();
    }

    static String decreasing(ArrayList<Integer> list) {
        StringBuilder res = new StringBuilder();
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < list.get(0); i++) {
            res.append('(');
        }
        res.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) == list.get(i)) {
                res.append(list.get(i));
            } else {
                res.append(list.get(i));
                res.append(')');
            }
        }
        if (!res.toString().endsWith(")")) {
            res.append(')');
        }
        return res.toString();
    }

    static String single(int a) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < a; i++) {
            res.append('(');
        }
        res.append(a);
        for (int i = 0; i < a; i++) {
            res.append(')');
        }
        return res.toString();
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

    static void exit(int a) {
        out.close();
        err.close();
        System.exit(a);
    }

    static InputStream inputStream = System.in;
    static OutputStream outputStream = System.out;
    static OutputStream errStream = System.err;
    static InputReader in = new InputReader(inputStream);
    static PrintWriter out = new PrintWriter(outputStream);
    static PrintWriter err = new PrintWriter(errStream);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

}
