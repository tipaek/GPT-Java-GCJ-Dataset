import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = in.readInt();
        for (int t = 0; t < tc; t++) {
            long x = in.readLong();
            long y = in.readLong();
            PriorityQueue<CellDist> pq = new PriorityQueue<>(100000, Comparator.comparingInt(cd -> cd.dist));
            Set<Cell> visited = new HashSet<>();
            pq.add(new CellDist(new Cell(0, 0), 0, ""));
            String result = "IMPOSSIBLE";

            if ((x + y) % 2 == 0) {
                out.write("Case #" + (t + 1) + ": " + result);
                out.newLine();
                continue;
            }

            while (!pq.isEmpty() && result.equals("IMPOSSIBLE")) {
                CellDist current = pq.poll();
                visited.add(current.cell);
                if (current.cell.x == x && current.cell.y == y) {
                    result = current.path;
                    break;
                }

                int step = current.dist;
                if (step > 27) break;

                int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
                String[] directionLabels = {"W", "S", "E", "N"};

                for (int i = 0; i < directions.length; i++) {
                    long nx = current.cell.x + directions[i][0] * (1L << step);
                    long ny = current.cell.y + directions[i][1] * (1L << step);
                    String newPath = current.path + directionLabels[i];

                    if (visited.contains(new Cell(nx, ny))) continue;

                    pq.add(new CellDist(new Cell(nx, ny), step + 1, newPath));
                }
            }

            out.write("Case #" + (t + 1) + ": " + result);
            out.newLine();
        }
        out.close();
    }
}

class CellDist {
    public Cell cell;
    public int dist;
    public String path;

    public CellDist(Cell cell, int dist, String path) {
        this.cell = cell;
        this.dist = dist;
        this.path = path;
    }
}

class Cell {
    public long x, y;

    public Cell(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
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

    public int read() {
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
            result = result * 10 + (c - '0');
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
            result = result * 10 + (c - '0');
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}