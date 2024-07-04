import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = in.readInt();
        
        for (int t = 0; t < testCaseCount; t++) {
            long targetX = in.readLong();
            long targetY = in.readLong();
            PriorityQueue<CellDist> priorityQueue = new PriorityQueue<>(100000, new CellDist());
            Set<Cell> visitedCells = new HashSet<>();
            priorityQueue.add(new CellDist(new Cell(0, 0), 0, ""));
            int step = 0;
            String result = "IMPOSSIBLE";
            
            if ((targetX + targetY) % 2 == 0) {
                out.write("Case #" + (t + 1) + ": " + result);
                out.newLine();
                continue;
            }
            
            while (!priorityQueue.isEmpty() && result.equals("IMPOSSIBLE")) {
                int currentSize = priorityQueue.size();
                for (int i = 0; i < currentSize; i++) {
                    CellDist currentCellDist = priorityQueue.poll();
                    visitedCells.add(currentCellDist.cell);
                    
                    if (currentCellDist.cell.x == targetX && currentCellDist.cell.y == targetY) {
                        result = currentCellDist.path;
                        break;
                    }
                    
                    if (step > 27) {
                        break;
                    }
                    
                    int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
                    for (int[] direction : directions) {
                        long newX = currentCellDist.cell.x;
                        long newY = currentCellDist.cell.y;
                        String newPath = currentCellDist.path;
                        
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
    
    static class CellDist implements Comparator<CellDist> {
        public Cell cell;
        public int distance;
        public String path;

        public CellDist() {}

        public CellDist(Cell cell, int distance, String path) {
            this.cell = cell;
            this.distance = distance;
            this.path = path;
        }

        @Override
        public int compare(CellDist cd1, CellDist cd2) {
            return Integer.compare(cd1.distance, cd2.distance);
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

    private static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}