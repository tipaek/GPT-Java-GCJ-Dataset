import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.util.Collection;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author iavanish
 */
public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        OverexcitedFan solver = new OverexcitedFan();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class OverexcitedFan {

        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int x = in.nextInt();
            int y = in.nextInt();

            String m = in.next();

            if (x == 0 && y == 0) {
                out.printf("Case #%d: %d\n", testNumber, 0);
                return;
            }

            Map<OverexcitedFan.Cell, Integer> visitedCells = new HashMap<>();
            visitedCells.put(new OverexcitedFan.Cell(x, y, 0), 0);
            for (int i = 0; i < m.length(); i++) {
                if (m.charAt(i) == 'N') {
                    y++;
                } else if (m.charAt(i) == 'S') {
                    y--;
                } else if (m.charAt(i) == 'E') {
                    x++;
                } else {
                    x--;
                }
                visitedCells.put(new OverexcitedFan.Cell(x, y, i + 1), i + 1);
            }

            int minPathLength = Integer.MAX_VALUE;
            boolean found = false;
            Queue<OverexcitedFan.Cell> queue = new LinkedList<>();
            Set<OverexcitedFan.Cell> isVisited = new HashSet<>();
            OverexcitedFan.Cell cell = new OverexcitedFan.Cell(0, 0, 0);
            queue.offer(cell);
            isVisited.add(cell);

            int[] deltaX = {0, -1, 1, 0};
            int[] deltaY = {1, 0, 0, -1};
            while (!queue.isEmpty()) {
                cell = queue.poll();
                if (cell.pathLength > m.length()) {
                    break;
                }
                if (visitedCells.containsKey(cell)) {
                    int temp = visitedCells.get(cell);
                    if (cell.pathLength <= temp) {
                        found = true;
                        minPathLength = Math.min(minPathLength, temp);
                    }
                }
                for (int i = 0; i < 4; i++) {
                    int nextX = cell.x + deltaX[i];
                    int nextY = cell.y + deltaY[i];
                    OverexcitedFan.Cell temp = new OverexcitedFan.Cell(nextX, nextY, cell.pathLength + 1);
                    if (!isVisited.contains(temp)) {
                        queue.offer(temp);
                        isVisited.add(temp);
                    }
                }
            }

            if (found) {
                out.printf("Case #%d: %d\n", testNumber, minPathLength);
            } else {
                out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            }
        }

        private static class Cell {

            public int x;
            public int y;
            public int pathLength;

            public Cell(int x, int y, int pathLength) {
                this.x = x;
                this.y = y;
                this.pathLength = pathLength;
            }

            public int hashCode() {
                return x * 100007 + y;
            }

            public boolean equals(Object obj) {
                OverexcitedFan.Cell cell = (OverexcitedFan.Cell) obj;
                return this.x == cell.x && this.y == cell.y;
            }

        }

    }

    static class FastReader {

        private final int BUFFER_SIZE = 1 << 16;
        private final int STRING_BUFFER_SIZE = 10000000;
        private final InputStream inputStream;
        private final byte[] buffer;
        private int bufferPointer;
        private int bytesRead;

        public FastReader() {
            this.inputStream = new DataInputStream(System.in);
            this.buffer = new byte[BUFFER_SIZE];
            this.bufferPointer = bytesRead = 0;
        }

        public FastReader(InputStream inputStream) {
            this.inputStream = inputStream;
            this.buffer = new byte[BUFFER_SIZE];
            this.bufferPointer = bytesRead = 0;
        }

        public FastReader(String fileName) {
            try {
                this.inputStream = new DataInputStream(new FileInputStream(fileName));
                this.buffer = new byte[BUFFER_SIZE];
                this.bufferPointer = bytesRead = 0;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public String next() {
            byte[] buffer = new byte[STRING_BUFFER_SIZE];
            int count = 0;
            int c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buffer[count++] = (byte) c;
            }
            return new String(buffer, 0, count);
        }

        public int nextInt() {
            int nextInt = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                nextInt = nextInt * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (negative) {
                return -nextInt;
            }
            return nextInt;
        }

        private void fillBuffer() {
            try {
                bytesRead = inputStream.read(buffer, bufferPointer = 0, BUFFER_SIZE);
                if (bytesRead == -1) {
                    buffer[0] = -1;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private byte read() {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

    }

}

