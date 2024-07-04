import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        new Solution();
    }

    public Solution() throws FileNotFoundException {
        FasterScanner sc = new FasterScanner(System.in);

        int numTasks = sc.nextInt();
        for (int task = 1; task <= numTasks; task++) {
            int c = sc.nextInt();
            int d = sc.nextInt();
            List<Pair> distances = new ArrayList<>();
            Map<Integer, Set<Integer>> amountBefore = new HashMap<>();
            for (int i = 0; i < c - 1; i++) {
                int val = sc.nextInt();
                if (val < 0) {
                    amountBefore.computeIfAbsent(-val, k -> new HashSet<>()).add(i + 2);
                } else {
                    distances.add(new Pair(val, i + 2));
                }
            }
            Collections.sort(distances);
            int listIndex = 0;

            Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
            int[][] edges = new int[d][2];
            int[][] distanceMatrix = new int[c + 1][c + 1];
            int[] distancesFromStart = new int[c + 1];
            Arrays.fill(distancesFromStart, -1);
            distancesFromStart[1] = 0;

            for (int i = 0; i < d; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                edges[i][0] = a;
                edges[i][1] = b;
                adjacencyMap.computeIfAbsent(a, k -> new HashSet<>()).add(b);
                adjacencyMap.computeIfAbsent(b, k -> new HashSet<>()).add(a);
            }

            Set<Integer> processedNodes = new HashSet<>();
            processedNodes.add(1);
            List<Integer> assignedDistances = new ArrayList<>();
            assignedDistances.add(0);

            for (int i = 1; i < c; i++) {
                if (amountBefore.containsKey(i)) {
                    Set<Integer> nodes = amountBefore.get(i);
                    for (int node : nodes) {
                        int targetDist = assignedDistances.get(i - 1) + 1;
                        for (int neighbor : adjacencyMap.get(node)) {
                            if (processedNodes.contains(neighbor)) {
                                distanceMatrix[node][neighbor] = targetDist - distancesFromStart[neighbor];
                                distanceMatrix[neighbor][node] = targetDist - distancesFromStart[neighbor];
                            }
                        }
                        processedNodes.add(node);
                        assignedDistances.add(targetDist);
                        distancesFromStart[node] = targetDist;
                    }
                    i += (nodes.size() - 1);
                } else {
                    Pair p = distances.get(listIndex++);
                    int targetDist = p.value;
                    int node = p.index;
                    for (int neighbor : adjacencyMap.get(node)) {
                        if (processedNodes.contains(neighbor)) {
                            distanceMatrix[node][neighbor] = targetDist - distancesFromStart[neighbor];
                            distanceMatrix[neighbor][node] = targetDist - distancesFromStart[neighbor];
                        }
                    }
                    processedNodes.add(node);
                    assignedDistances.add(targetDist);
                    distancesFromStart[node] = targetDist;
                }
            }

            StringBuilder solution = new StringBuilder("Case #").append(task).append(":");
            for (int i = 0; i < d; i++) {
                int a = edges[i][0];
                int b = edges[i][1];
                int dist = distanceMatrix[a][b];
                if (dist == 0) dist = 100000;
                solution.append(' ').append(dist);
            }

            System.out.println(solution);
        }

        sc.close();
    }

    class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.value != other.value) {
                return Integer.compare(this.value, other.value);
            }
            return Integer.compare(this.index, other.index);
        }
    }

    public class FasterScanner {
        private InputStream inputStream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FasterScanner(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        private int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = inputStream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buffer[currentChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return result.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public long nextLong() {
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

        public int nextInt() {
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

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public void close() {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}