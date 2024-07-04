import java.io.*;
import java.nio.CharBuffer;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int caseCount = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= caseCount; ++caseIndex) {
            int n = scanner.nextInt();
            List<List<Integer>> adjacencyList = new ArrayList<>();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            for (int i = 0; i < n; ++i) {
                adjacencyList.add(new LinkedList<>());
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (startTimes[i] < endTimes[j] && endTimes[i] > startTimes[j]) {
                        adjacencyList.get(i).add(j);
                        adjacencyList.get(j).add(i);
                    }
                }
            }
            int[] colors = new int[n];
            Arrays.fill(colors, -1);
            boolean isPossible = true;
            for (int i = 0; i < n; ++i) {
                if (colors[i] == -1 && !bipartiteCheck(adjacencyList, i, 0, colors)) {
                    isPossible = false;
                    break;
                }
            }
            writer.printf("Case #%d: ", caseIndex);
            if (!isPossible) {
                writer.println("IMPOSSIBLE");
            } else {
                for (int color : colors) {
                    writer.print(color == 0 ? 'C' : 'J');
                }
                writer.println();
            }
        }
        writer.close();
    }

    private static boolean bipartiteCheck(List<List<Integer>> adjacencyList, int node, int color, int[] colors) {
        colors[node] = color;
        for (int neighbor : adjacencyList.get(node)) {
            if (colors[neighbor] == -1) {
                if (!bipartiteCheck(adjacencyList, neighbor, 1 - color, colors)) {
                    return false;
                }
            } else if (colors[neighbor] == color) {
                return false;
            }
        }
        return true;
    }

    private static class FastScanner {

        private static final int BUFFER_SIZE = 10240;
        private final Readable input;
        private final CharBuffer buffer;
        private boolean endOfFile;

        public FastScanner(InputStream inputStream) {
            this.input = new BufferedReader(new InputStreamReader(inputStream));
            this.buffer = CharBuffer.allocate(BUFFER_SIZE);
            this.buffer.limit(0);
            this.endOfFile = false;
        }

        private char readChar() {
            if (!buffer.hasRemaining()) {
                buffer.clear();
                try {
                    int bytesRead = input.read(buffer);
                    if (bytesRead == -1) {
                        endOfFile = true;
                        return '\0';
                    }
                } catch (IOException e) {
                    endOfFile = true;
                    return '\0';
                }
                buffer.flip();
            }
            return buffer.get();
        }

        private void checkEndOfFile() {
            if (endOfFile) {
                throw new NoSuchElementException();
            }
        }

        private char nextChar() {
            checkEndOfFile();
            return readChar();
        }

        private String next() {
            StringBuilder sb = new StringBuilder();
            char currentChar;
            do {
                currentChar = readChar();
                checkEndOfFile();
            } while (Character.isWhitespace(currentChar));
            do {
                sb.append(currentChar);
                currentChar = readChar();
            } while (!endOfFile && !Character.isWhitespace(currentChar));
            return sb.toString();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}