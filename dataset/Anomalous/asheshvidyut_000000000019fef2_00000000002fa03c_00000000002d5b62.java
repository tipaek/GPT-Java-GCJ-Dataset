import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = in.readInt();

        for (int t = 0; t < testCases; t++) {
            long targetX = in.readLong();
            long targetY = in.readLong();
            Queue<CellDistance> queue = new LinkedList<>();
            queue.add(new CellDistance(new Cell(0, 0), 0, ""));
            int step = 0;
            String result = "IMPOSSIBLE";

            if ((targetX + targetY) % 2 == 0) {
                out.write("Case #" + (t + 1) + ": " + result);
                out.newLine();
                continue;
            }

            while (!queue.isEmpty() && result.equals("IMPOSSIBLE")) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    CellDistance current = queue.poll();
                    if (current.cell.x == targetX && current.cell.y == targetY) {
                        result = current.path;
                        break;
                    }
                    if (step >= 27) {
                        break;
                    }

                    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
                    for (int[] direction : directions) {
                        long newX = current.cell.x;
                        long newY = current.cell.y;
                        String newPath = "";

                        if (direction[0] == 1) {
                            newPath += "E";
                            newX += (1L << step);
                        } else if (direction[0] == -1) {
                            newX -= (1L << step);
                            newPath += "W";
                        } else if (direction[1] == 1) {
                            newPath += "S";
                            newY -= (1L << step);
                        } else if (direction[1] == -1) {
                            newY += (1L << step);
                            newPath += "N";
                        }

                        queue.add(new CellDistance(new Cell(newX, newY), step + 1, current.path + newPath));
                    }
                }
                step++;
            }
            out.write("Case #" + (t + 1) + ": " + result);
            out.newLine();
        }
        out.close();
    }

    static class CellDistance implements Comparable<CellDistance> {
        public Cell cell;
        public int distance;
        public String path;

        public CellDistance(Cell cell, int distance, String path) {
            this.cell = cell;
            this.distance = distance;
            this.path = path;
        }

        @Override
        public int compareTo(CellDistance other) {
            return Integer.compare(this.distance, other.distance);
        }

        @Override
        public String toString() {
            return cell.toString() + " ** " + this.path;
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
    private InputStream stream;
    private byte[] buffer = new byte[1024];
    private int currentChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (currentChar >= numChars) {
            currentChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buffer[currentChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        int result = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            result = result * 10 + (c - '0');
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        long result = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            result = result * 10 + (c - '0');
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}