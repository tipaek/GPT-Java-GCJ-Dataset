import java.io.*;
import java.util.*;

class Solution {
    static BufferedReader s1;
    static BufferedWriter out;

    static String read() throws IOException {
        String line = "";
        while (line.length() == 0) {
            line = s1.readLine();
        }
        return line;
    }

    static int int_v(String s) {
        return Integer.parseInt(s);
    }

    static long long_v(String s) {
        return Long.parseLong(s);
    }

    static int[] int_arr() throws IOException {
        String[] a = read().split(" ");
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = int_v(a[i]);
        }
        return b;
    }

    static long[] long_arr() throws IOException {
        String[] a = read().split(" ");
        long[] b = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = long_v(a[i]);
        }
        return b;
    }

    static void assign() {
        s1 = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    static List<Character> l1 = new ArrayList<>();
    static boolean b = false;

    static void help(List<Character> l, int x1, int y1) throws IOException {
        int x = 0, y = 0;
        if (l.size() > 8) {
            return;
        }
        for (int i = 0; i < l.size(); i++) {
            char c = l.get(i);
            int move = (int) Math.pow(2, i);
            switch (c) {
                case 'N':
                    y += move;
                    break;
                case 'S':
                    y -= move;
                    break;
                case 'E':
                    x += move;
                    break;
                case 'W':
                    x -= move;
                    break;
            }
        }

        if (x == x1 && y == y1) {
            if (l1.isEmpty()) {
                l1.addAll(l);
            } else if (l.size() < l1.size() && l.size() > 0) {
                l1 = new ArrayList<>(l);
            }
            return;
        }

        char[] c1 = new char[]{'N', 'S', 'E', 'W'};
        for (char cc : c1) {
            l.add(cc);
            help(l, x1, y1);
            l.remove(l.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        assign();
        int t = int_v(read()), cn = 1;
        while (t-- != 0) {
            l1 = new ArrayList<>();
            b = false;
            int[] cc = int_arr();
            int x = cc[0], y = cc[1];
            help(new ArrayList<>(), x, y);
            out.write("Case #" + cn + ": ");
            if (l1.isEmpty()) {
                out.write("IMPOSSIBLE\n");
            } else {
                for (char xx : l1) {
                    out.write(xx);
                }
                out.write("\n");
            }
            cn++;
        }
        out.flush();
    }
}