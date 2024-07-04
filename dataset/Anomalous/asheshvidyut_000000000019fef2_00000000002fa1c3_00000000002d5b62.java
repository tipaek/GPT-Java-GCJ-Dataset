import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = in.readInt();
        for (int t = 0; t < tc; t++) {
            long x = in.readLong();
            long y = in.readLong();
            Queue<CellDist> queue = new LinkedList<>();
            queue.add(new CellDist(new Cell(0, 0), 0, ""));
            int step = 0;
            String result = "IMPOSSIBLE";

            if ((x + y) % 2 == 0) {
                out.write("Case #" + (t + 1) + ": " + result);
                out.newLine();
                continue;
            }

            while (!queue.isEmpty() && result.equals("IMPOSSIBLE")) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    CellDist cellDist = queue.poll();
                    if (cellDist.cell.x == x && cellDist.cell.y == y) {
                        result = cellDist.path;
                        break;
                    }
                    if (step >= 10) {
                        break;
                    }
                    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
                    for (int[] direction : directions) {
                        long newX = cellDist.cell.x;
                        long newY = cellDist.cell.y;
                        String newPath = cellDist.path;
                        if (direction[0] == 1) {
                            newPath += "E";
                            newX += (1L << step);
                        } else if (direction[0] == -1) {
                            newPath += "W";
                            newX -= (1L << step);
                        } else if (direction[1] == 1) {
                            newPath += "S";
                            newY -= (1L << step);
                        } else if (direction[1] == -1) {
                            newPath += "N";
                            newY += (1L << step);
                        }
                        queue.add(new CellDist(new Cell(newX, newY), step + 1, newPath));
                    }
                }
                step++;
            }
            out.write("Case #" + (t + 1) + ": " + result);
            out.newLine();
        }
        out.close();
    }

    static class CellDist {
        Cell cell;
        int distance;
        String path;

        CellDist(Cell cell, int distance, String path) {
            this.cell = cell;
            this.distance = distance;
            this.path = path;
        }
    }

    static class Cell {
        long x, y;

        Cell(long x, long y) {
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
    private InputStream stream;
    private byte[] buffer = new byte[1024];
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

    private static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}