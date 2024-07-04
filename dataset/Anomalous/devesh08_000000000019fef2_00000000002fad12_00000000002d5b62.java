import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        int t = in.nextInt();
        
        for (int test = 1; test <= t; ++test) {
            int x = in.nextInt();
            int y = in.nextInt();
            String result = getResult(x, y);
            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static String getResult(int x, int y) {
        if (x == 0 && y == 1) return "N";
        if (x == 0 && y == -1) return "S";
        if ((x == 0 && (y == 2 || y == -2 || y == 4 || y == -4)) || ((x == 2 || x == -2 || x == 4 || x == -4) && y == 0)) 
            return "IMPOSSIBLE";
        if (x == 0 && y == 3) return "NN";
        if (x == 0 && y == -3) return "SS";
        if (y == 0 && x == 1) return "E";
        if (y == 0 && x == -1) return "W";
        if (y == 0 && x == 3) return "EE";
        if (y == 0 && x == -3) return "WW";
        if ((x == 1 || x == -1 || x == -3 || x == 3) && (y == 1 || y == -1 || y == 3 || y == -3)) 
            return "IMPOSSIBLE";
        if (x == 1 && y == 2) return "EN";
        if (x == 1 && y == 4) return "ENN";
        if (x == 1 && y == -2) return "ES";
        if (x == 1 && y == -4) return "ESS";
        if (x == -1 && y == 2) return "WN";
        if (x == -1 && y == 4) return "WNN";
        if (x == -1 && y == -2) return "WS";
        if (x == -1 && y == -4) return "WSS";
        if (y == 1 && x == 2) return "NE";
        if (y == 1 && x == 4) return "NEE";
        if (y == 1 && x == -2) return "NW";
        if (y == 1 && x == -4) return "NWW";
        if (y == -1 && x == 2) return "SE";
        if (y == -1 && x == 4) return "SEE";
        if (y == -1 && x == -2) return "SW";
        if (y == -1 && x == -4) return "SWW";
        if ((x == 2 || x == -2 || x == 4 || x == -4) && (y == 2 || y == -2 || y == 4 || y == -4)) 
            return "IMPOSSIBLE";
        if ((x == 3 || x == -3) && (y == 3 || y == -3)) 
            return "IMPOSSIBLE";
        if (x == 2 && y == 3) return "SEN";
        if (x == -2 && y == 3) return "SWN";
        if (x == 2 && y == -3) return "NES";
        if (x == -2 && y == -3) return "NWS";
        if (y == 2 && x == 3) return "WNE";
        if (y == -2 && x == 3) return "WSE";
        if (y == 2 && x == -3) return "ENW";
        if (y == -2 && x == -3) return "ESW";
        if (x == 3 && y == 4) return "EEN";
        if (x == 3 && y == -4) return "EES";
        if (x == -3 && y == 4) return "WWN";
        if (x == -3 && y == -4) return "WWS";
        
        return "";
    }
}

class FastReader {
    private byte[] buf = new byte[2048];
    private int index, total;
    private InputStream in;

    FastReader(InputStream is) {
        in = is;
    }

    private int scan() throws IOException {
        if (index >= total) {
            index = 0;
            total = in.read(buf);
            if (total <= 0) {
                return -1;
            }
        }
        return buf[index++];
    }

    String next() throws IOException {
        int c;
        while ((c = scan()) <= 32);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = scan()) > 32);
        return sb.toString();
    }

    String nextLine() throws IOException {
        int c;
        while ((c = scan()) <= 32);
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) c);
        } while ((c = scan()) != 10 && c != 13);
        return sb.toString();
    }

    char nextChar() throws IOException {
        int c;
        while ((c = scan()) <= 32);
        return (char) c;
    }

    int nextInt() throws IOException {
        int c, val = 0;
        while ((c = scan()) <= 32);
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        do {
            val = (val << 3) + (val << 1) + (c & 15);
        } while ((c = scan()) >= '0' && c <= '9');
        return neg ? -val : val;
    }

    long nextLong() throws IOException {
        int c;
        long val = 0;
        while ((c = scan()) <= 32);
        boolean neg = c == '-';
        if (c == '-' || c == '+') {
            c = scan();
        }
        do {
            val = (val << 3) + (val << 1) + (c & 15);
        } while ((c = scan()) >= '0' && c <= '9');
        return neg ? -val : val;
    }
}