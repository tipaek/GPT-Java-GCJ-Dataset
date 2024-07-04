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
            
            Queue<CellDist> queue = new LinkedList<>();
            Set<Cell> visited = new HashSet<>();
            queue.add(new CellDist(new Cell(0, 0), 0, ""));
            
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
                    CellDist current = queue.poll();
                    visited.add(current.cell);
                    
                    if (current.cell.x == targetX && current.cell.y == targetY) {
                        result = current.path;
                        break;
                    }
                    
                    if (step >= 27) {
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
                        
                        if (!visited.contains(new Cell(newX, newY))) {
                            queue.add(new CellDist(new Cell(newX, newY), step + 1, newPath));
                        }
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
        public int distance;
        public String path;

        public CellDist(Cell cell, int distance, String path) {
            this.cell = cell;
            this.distance = distance;
            this.path = path;
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
        int character = read();
        while (isSpaceChar(character)) character = read();
        int sign = 1;
        if (character == '-') {
            sign = -1;
            character = read();
        }
        int result = 0;
        do {
            if (character < '0' || character > '9') throw new InputMismatchException();
            result = result * 10 + character - '0';
            character = read();
        } while (!isSpaceChar(character));
        return result * sign;
    }

    public long readLong() {
        int character = read();
        while (isSpaceChar(character)) character = read();
        int sign = 1;
        if (character == '-') {
            sign = -1;
            character = read();
        }
        long result = 0;
        do {
            if (character < '0' || character > '9') throw new InputMismatchException();
            result = result * 10 + character - '0';
            character = read();
        } while (!isSpaceChar(character));
        return result * sign;
    }

    public String readLine() {
        StringBuilder sb = new StringBuilder();
        int character = read();
        while (character != '\n' && character != -1) {
            if (character != '\r') sb.appendCodePoint(character);
            character = read();
        }
        return sb.toString();
    }

    public boolean isSpaceChar(int character) {
        return character == ' ' || character == '\n' || character == '\r' || character == '\t' || character == -1;
    }
}