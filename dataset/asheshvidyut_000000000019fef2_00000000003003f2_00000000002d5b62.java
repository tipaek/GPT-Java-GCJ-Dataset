import java.util.*;
import java.math.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = in.readInt();
        for (int t = 0; t < tc; t++) {
            long x = in.readLong();
            long y = in.readLong();
            Queue<CellDist> pq = new PriorityQueue<>(1000000, new CellDist());
            Set<Cell> moves = new HashSet<>();
            pq.add(new CellDist(new Cell(0, 0), 0, ""));
            int step = 0;
            String ans = "IMPOSSIBLE";
            if ((x + y) % 2 == 0) {
                out.write("Case #"+(t + 1)+": "+ans);
                out.newLine();
                continue;
            }
            while(!pq.isEmpty() && ans.equalsIgnoreCase("IMPOSSIBLE")) {
                int size = pq.size();
                for (int i = 0; i < size; i++) {
                    CellDist cellDist = pq.poll();
                    moves.add(cellDist.c);
                    if (cellDist.c.x == x && cellDist.c.y == y) {
                        ans = cellDist.ans;
                        break;
                    }
                    if (step > 27) {
                        break;
                    }
                    int dxy[][] = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
                    for (int j = 0; j < dxy.length; j++) {
                        long nx = cellDist.c.x, ny = cellDist.c.y;
                        String lans = "";
                        if (dxy[j][0] == 1) {
                            lans += "E";
                            nx += (1L << step);
                        }
                        else if (dxy[j][0] == -1) {
                            nx -= (1L << step);
                            lans += "W";
                        }
                        else if (dxy[j][1] == 1) {
                            lans += "S";
                            ny -= (1L << step);
                        }
                        else if (dxy[j][1] == -1) {
                            ny += (1L << step);
                            lans += "N";
                        }
                        if (moves.contains(new Cell(nx, ny))) {
                            continue;
                        }
                        pq.add(new CellDist(new Cell(nx, ny), step + 1, cellDist.ans + lans));
                    }
                }
                step++;
            }
            out.write("Case #"+(t + 1)+": "+ans);
            out.newLine();
        }
        out.close();
    }
    static class CellDist implements Comparable<CellDist>{
        public Cell c;
        public int dist;
        public String ans;

        public CellDist() {
        }

        public CellDist(Cell c, int dist, String ans) {
            this.c = c;
            this.dist = dist;
            this.ans = ans;
        }

        @Override
        public int compareTo(CellDist o) {
            return Integer.compare(this.dist, o.dist);
        }

        @Override
        public String toString() {
            return c.toString() + " ** " + this.ans;
        }
    }
    static class Cell {
        public long x, y;

        public Cell(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
class InputReader {
    private boolean finished = false;

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int peek() {
        if (numChars == -1)
            return -1;
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                return -1;
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int length = readInt();
        if (length < 0)
            return null;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++)
            bytes[i] = (byte) read();
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(bytes);
        }
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private String readLine0() {
        StringBuffer buf = new StringBuffer();
        int c = read();
        while (c != '\n' && c != -1) {
            if (c != '\r')
                buf.appendCodePoint(c);
            c = read();
        }
        return buf.toString();
    }

    public String readLine() {
        String s = readLine0();
        while (s.trim().length() == 0)
            s = readLine0();
        return s;
    }

    public String readLine(boolean ignoreEmptyLines) {
        if (ignoreEmptyLines)
            return readLine();
        else
            return readLine0();
    }

    public BigInteger readBigInteger() {
        try {
            return new BigInteger(readString());
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }

    public char readCharacter() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        return (char) c;
    }

    public double readDouble() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E')
                return res * Math.pow(10, readInt());
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, readInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }

    public boolean isExhausted() {
        int value;
        while (isSpaceChar(value = peek()) && value != -1)
            read();
        return value == -1;
    }

    public String next() {
        return readString();
    }

    public boolean readBoolean() {
        return readInt() == 1;
    }
}
