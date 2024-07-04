import java.io.*;
import java.util.*;

public class Solution {
    public static Scan sc = new Scan();
    public static Print pr = new Print();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int T = sc.scanInt();
        for (int t = 0; t < T; t++) {
            int U = sc.scanInt();

            Map<Character, Integer> m = new HashMap<>();
            for (int q = 0; q < 10000; q++) {
                int Q = sc.scanInt();
                String R = sc.scanString();
                int length = R.length();
                for (int i = 0; i < length; i++) {
                    m.put(R.charAt(i), m.getOrDefault(R.charAt(i), 0) + 1);
                }
            }
            List<Pair> p = new ArrayList<>();
            for (char c : m.keySet()) {
                p.add(new Pair(m.get(c), c));
            }
            Collections.sort(p, Collections.reverseOrder());

            StringBuilder answer = new StringBuilder();
            answer.append(p.get(9).s);
            for (int i = 0; i < 9; i++) {
                answer.append(p.get(i).s);
            }
            // for (Pair pair : p) {
            // pr.println(pair.value + " " + pair.s);
            // }
            pr.println("Case #" + (t + 1) + ": " + answer.toString());

            // Map<Integer, Map<String, Integer>> m = new HashMap<>();
            // for (int i = 0; i < 10000; i++) {
            // int Q = sc.scanInt();
            // String R = sc.scanString();
            // int length = R.length();
            // if (m.keySet().contains(length)) {
            // Map<String, Integer> innerMap = m.get(length);
            // innerMap.put(R, innerMap.getOrDefault(R, 0) + 1);
            // } else {
            // Map<String, Integer> newInner = new HashMap<>();
            // newInner.put(R, 1);
            // m.put(length, newInner);
            // }
            // }

            // for (int i = 1; i < 3; i++) {
            // pr.println("------ length: " + i);
            // Map<String, Integer> innerMap = m.get(i);
            // List<Pair> l = new ArrayList<>();
            // for (String s : innerMap.keySet()) {
            // l.add(new Pair(innerMap.get(s), s));
            // }
            // Collections.sort(l, Collections.reverseOrder());
            // for (Pair p : l) {
            // pr.println(p.value + " " + p.s);
            // }
            // }

            // Map<Integer, List<String>> m = new HashMap<>();
            // for (int i = 0; i < 10000; i++) {
            // int Q = sc.scanInt();
            // String R = sc.scanString();
            // List<String> l;
            // if (m.keySet().contains(Q)) {
            // l = m.get(Q);
            // } else {
            // l = new ArrayList<>();
            // }
            // l.add(R);
            // m.put(Q, l);
            // }
            // List<Pair> p = new ArrayList<>();
            // for (int x : m.keySet()) {
            // p.add(new Pair(x, m.get(x)));
            // }
            // Collections.sort(p);
            // char[] D = new char[10];
            // for (Pair pair : p) {
            // pr.print(pair.value + ": ");
            // for (String x : pair.s) {
            // pr.print(x + ", ");
            // }
            // pr.println("");
            // }
        }
        pr.close();
    }
}

class Pair implements Comparable<Pair> {
    public int value;
    public char s;

    public Pair(int value, char s) {
        this.value = value;
        this.s = s;
    }

    @Override
    public int compareTo(Pair p) {
        return this.value - p.value;
    }
}
// class Pair implements Comparable<Pair> {
// public int value;
// public String s;

// public Pair(int value, String s) {
// this.value = value;
// this.s = s;
// }

// @Override
// public int compareTo(Pair p) {
// return this.value - p.value;
// }
// }

// class Pair implements Comparable<Pair> {
// public int value;
// public List<String> s;

// public Pair(int value, List<String> s) {
// this.value = value;
// this.s = s;
// }

// @Override
// public int compareTo(Pair p) {
// return this.value - p.value;
// }
// }

class Scan {
    private byte[] buf = new byte[1024];
    private int index;
    private InputStream in;
    private int total;

    public Scan() {
        in = System.in;
    }

    public int scan() throws IOException {
        if (total < 0)
            throw new InputMismatchException();
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0)
                return -1;
        }
        return buf[index++];
    }

    public int scanInt() throws IOException {
        int integer = 0;
        int n = scan();
        while (isWhiteSpace(n))
            n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = scan();
            } else
                throw new InputMismatchException();
        }
        return neg * integer;
    }

    public double scanDouble() throws IOException {
        double doub = 0;
        int n = scan();
        while (isWhiteSpace(n))
            n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n) && n != '.') {
            if (n >= '0' && n <= '9') {
                doub *= 10;
                doub += n - '0';
                n = scan();
            } else
                throw new InputMismatchException();
        }
        if (n == '.') {
            n = scan();
            double temp = 1;
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    temp /= 10;
                    doub += (n - '0') * temp;
                    n = scan();
                } else
                    throw new InputMismatchException();
            }
        }
        return doub * neg;
    }

    public String scanString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = scan();
        while (isWhiteSpace(n))
            n = scan();
        while (!isWhiteSpace(n)) {
            sb.append((char) n);
            n = scan();
        }
        return sb.toString();
    }

    private boolean isWhiteSpace(int n) {
        if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
            return true;
        return false;
    }
}

class Print {
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