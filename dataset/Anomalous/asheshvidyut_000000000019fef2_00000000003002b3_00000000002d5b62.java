import java.util.*;
import java.math.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = in.readInt();
        
        for (int t = 0; t < testCaseCount; t++) {
            long x = in.readLong();
            long y = in.readLong();
            PriorityQueue<CellDist> priorityQueue = new PriorityQueue<>();
            Set<Cell> visitedCells = new HashSet<>();
            priorityQueue.add(new CellDist(new Cell(0, 0), 0, ""));
            int step = 0;
            String result = "IMPOSSIBLE";
            
            if ((x + y) % 2 == 0) {
                out.write("Case #" + (t + 1) + ": " + result);
                out.newLine();
                continue;
            }
            
            while (!priorityQueue.isEmpty() && result.equals("IMPOSSIBLE")) {
                int queueSize = priorityQueue.size();
                
                for (int i = 0; i < queueSize; i++) {
                    CellDist current = priorityQueue.poll();
                    visitedCells.add(current.cell);
                    
                    if (current.cell.x == x && current.cell.y == y) {
                        result = current.path;
                        break;
                    }
                    
                    if (step > 27) {
                        break;
                    }
                    
                    int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
                    
                    for (int[] direction : directions) {
                        long newX = current.cell.x;
                        long newY = current.cell.y;
                        String newPath = current.path;
                        
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
                        
                        if (visitedCells.contains(new Cell(newX, newY))) {
                            continue;
                        }
                        
                        priorityQueue.add(new CellDist(new Cell(newX, newY), step + 1, newPath));
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

        @Override
        public String toString() {
            return cell + " ** " + this.path;
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

    public String readLine() {
        StringBuilder sb = new StringBuilder();
        int c = read();
        while (c != '\n' && c != -1) {
            if (c != '\r') sb.appendCodePoint(c);
            c = read();
        }
        return sb.toString();
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}