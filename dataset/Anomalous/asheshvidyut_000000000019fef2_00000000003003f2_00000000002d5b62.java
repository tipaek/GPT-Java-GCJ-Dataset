import java.util.*;
import java.math.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = in.readInt();

        for (int t = 0; t < testCases; t++) {
            long x = in.readLong();
            long y = in.readLong();
            PriorityQueue<CellDist> pq = new PriorityQueue<>();
            Set<Cell> visited = new HashSet<>();
            pq.add(new CellDist(new Cell(0, 0), 0, ""));
            int step = 0;
            String result = "IMPOSSIBLE";

            if ((x + y) % 2 == 0) {
                out.write("Case #" + (t + 1) + ": " + result);
                out.newLine();
                continue;
            }

            while (!pq.isEmpty() && result.equals("IMPOSSIBLE")) {
                int size = pq.size();
                for (int i = 0; i < size; i++) {
                    CellDist current = pq.poll();
                    visited.add(current.cell);

                    if (current.cell.x == x && current.cell.y == y) {
                        result = current.path;
                        break;
                    }

                    if (step > 27) {
                        break;
                    }

                    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
                    for (int[] dir : directions) {
                        long newX = current.cell.x;
                        long newY = current.cell.y;
                        String newPath = current.path;

                        if (dir[0] == 1) {
                            newPath += "E";
                            newX += (1L << step);
                        } else if (dir[0] == -1) {
                            newPath += "W";
                            newX -= (1L << step);
                        } else if (dir[1] == 1) {
                            newPath += "S";
                            newY -= (1L << step);
                        } else if (dir[1] == -1) {
                            newPath += "N";
                            newY += (1L << step);
                        }

                        Cell newCell = new Cell(newX, newY);
                        if (visited.contains(newCell)) {
                            continue;
                        }

                        pq.add(new CellDist(newCell, step + 1, newPath));
                    }
                }
                step++;
            }

            out.write("Case #" + (t + 1) + ": " + result);
            out.newLine();
        }
        out.close();
    }

    static class CellDist implements Comparable<CellDist> {
        public Cell cell;
        public int distance;
        public String path;

        public CellDist(Cell cell, int distance, String path) {
            this.cell = cell;
            this.distance = distance;
            this.path = path;
        }

        @Override
        public int compareTo(CellDist other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    static class Cell {
        public long x, y;

        public Cell(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Cell cell = (Cell) obj;
            return x == cell.x && y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

class InputReader {
    private final InputStream stream;
    private final byte[] buffer = new byte[1024];
    private int currentChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    private int read() {
        if (numChars == -1) throw new InputMismatchException();
        if (currentChar >= numChars) {
            currentChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) return -1;
        }
        return buffer[currentChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c)) c = read();
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        int result = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            result = result * 10 + c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c)) c = read();
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        long result = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            result = result * 10 + c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    public String readString() {
        int length = readInt();
        if (length < 0) return null;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) bytes[i] = (byte) read();
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(bytes);
        }
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}