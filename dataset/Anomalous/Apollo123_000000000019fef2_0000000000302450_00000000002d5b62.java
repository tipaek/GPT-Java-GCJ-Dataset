import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static String numToBin(int n) {
        if (n == 0) return "0";
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            s.insert(0, n % 2);
            n /= 2;
        }
        return s.toString();
    }

    static String sendUp(String s, int k) {
        StringBuilder s2 = new StringBuilder(s.substring(k + 1));
        boolean start = false, stop = false;

        for (int i = k; i >= 0; i--) {
            if (!start) {
                s2.insert(0, '0');
                if (s.charAt(i) == '1') start = true;
            } else if (!stop) {
                if (s.charAt(i) == '1') {
                    s2.insert(0, '0');
                } else {
                    s2.insert(0, '1');
                    stop = true;
                }
            } else {
                s2.insert(0, s.charAt(i));
            }
        }

        return s2.toString();
    }

    public static void main(String[] args) {
        Kattio scan = new Kattio(System.in);
        int T = scan.getInt();
        for (int t = 1; t <= T; t++) {
            int x = scan.getInt(), y = scan.getInt();
            int posX = x < 0 ? -1 : 1, posY = y < 0 ? -1 : 1;
            x = Math.abs(x);
            y = Math.abs(y);

            String sx = numToBin(x), sy = numToBin(y);
            int a = sx.length(), b = sy.length();

            if (a > b) sy = "0".repeat(a - b) + sy;
            else sx = "0".repeat(b - a) + sx;

            sx = "0" + sx;
            sy = "0" + sy;
            StringBuilder out = new StringBuilder();

            for (int i = sx.length() - 1; i >= 1; i--) {
                char cx = sx.charAt(i), cy = sy.charAt(i);
                if (cx == '0' && cy == '0') {
                    out = new StringBuilder("IMPOSSIBLE");
                    break;
                } else if (cx == '1' && cy == '0') {
                    if ((sx.charAt(i - 1) == '1' && sy.charAt(i - 1) == '1') || 
                        (i != 1 && (sx.charAt(i - 1) == '0' && sy.charAt(i - 1) == '0'))) {
                        out.append(posX == 1 ? "W" : "E");
                        sx = sendUp(sx, i);
                    } else {
                        out.append(posX == 1 ? "E" : "W");
                    }
                } else if (cx == '0' && cy == '1') {
                    if ((sy.charAt(i - 1) == '1' && sx.charAt(i - 1) == '1') || 
                        (i != 1 && (sy.charAt(i - 1) == '0' && sx.charAt(i - 1) == '0'))) {
                        out.append(posY == 1 ? "S" : "N");
                        sy = sendUp(sy, i);
                    } else {
                        out.append(posY == 1 ? "N" : "S");
                    }
                } else if (cx == '1' && cy == '1') {
                    out = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (sx.charAt(0) == '1' && sy.charAt(0) == '1') {
                out = new StringBuilder("IMPOSSIBLE");
            } else if (sx.charAt(0) == '1' && sy.charAt(0) == '0') {
                out.append(posX == 1 ? "E" : "W");
            } else if (sx.charAt(0) == '0' && sy.charAt(0) == '1') {
                out.append(posY == 1 ? "N" : "S");
            }

            System.out.println("Case #" + t + ": " + out);
        }
    }

    private static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        private String token;

        public Kattio(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public Kattio(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public boolean hasMoreTokens() {
            return peekToken() != null;
        }

        public int getInt() {
            return Integer.parseInt(nextToken());
        }

        public double getDouble() {
            return Double.parseDouble(nextToken());
        }

        public long getLong() {
            return Long.parseLong(nextToken());
        }

        public String getWord() {
            return nextToken();
        }

        private String peekToken() {
            if (token == null) {
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        String line = r.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return token;
        }

        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }
    }
}