import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = in.readInt();
        for (int t = 0; t < tc; t++) {
            int x = in.readInt();
            int y = in.readInt();
            Queue<CellDist> queue = new LinkedList<>();
            Set<Cell> visited = new HashSet<>();
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
                    CellDist current = queue.poll();
                    if (current.cell.x == x && current.cell.y == y) {
                        result = current.path;
                        break;
                    }
                    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
                    for (int[] dir : directions) {
                        long newX = current.cell.x, newY = current.cell.y;
                        String newPath = "";
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
                        queue.add(new CellDist(newCell, step + 1, current.path + newPath));
                        visited.add(newCell);
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
        public Cell cell;
        public int steps;
        public String path;

        public CellDist(Cell cell, int steps, String path) {
            this.cell = cell;
            this.steps = steps;
            this.path = path;
        }

        @Override
        public String toString() {
            return cell + " ** " + path;
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
            result = result * 10 + c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}