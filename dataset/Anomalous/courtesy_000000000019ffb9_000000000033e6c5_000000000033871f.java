import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);
    public static OutputWriter outputWriter = new OutputWriter();

    public static void main(String[] args) throws IOException {
        int testCases = scanner.nextInt();
        for (int cs = 1; cs <= testCases; cs++) {
            int N = scanner.nextInt();
            int R = scanner.nextInt();
            int[] A = new int[N];
            List<List<Integer>> adjacencyList = new ArrayList<>();
            int[][] edges = new int[R][2];
            Map<Pair, Integer> timeMap = new HashMap<>();

            adjacencyList.add(new ArrayList<>());
            for (int i = 1; i < N; i++) {
                A[i] = -scanner.nextInt();
                if (A[i] > 0) return;
                adjacencyList.add(new ArrayList<>());
            }

            for (int i = 0; i < R; i++) {
                edges[i][0] = scanner.nextInt() - 1;
                edges[i][1] = scanner.nextInt() - 1;
                adjacencyList.get(edges[i][0]).add(edges[i][1]);
                adjacencyList.get(edges[i][1]).add(edges[i][0]);
            }

            int[] time = new int[N];
            int totalNodes = 1;
            int currentTime = 1;

            while (totalNodes < N) {
                int minTime = Integer.MAX_VALUE;
                List<Integer> nodesToProcess = new ArrayList<>();
                for (int i = 1; i < N; i++) {
                    if (time[i] == 0 && A[i] < minTime) {
                        minTime = A[i];
                        nodesToProcess.clear();
                        nodesToProcess.add(i);
                    } else if (time[i] == 0 && A[i] == minTime) {
                        nodesToProcess.add(i);
                    }
                }
                for (int node : nodesToProcess) {
                    for (int neighbor : adjacencyList.get(node)) {
                        if (time[neighbor] > 0 || neighbor == 0) {
                            int t = currentTime - time[neighbor];
                            t = Math.max(t, 1);
                            timeMap.put(new Pair(node, neighbor), t);
                            timeMap.put(new Pair(neighbor, node), t);
                        }
                    }
                    time[node] = currentTime;
                }
                totalNodes += nodesToProcess.size();
                currentTime++;
            }

            System.out.print("Case #" + cs + ": ");
            for (int i = 0; i < R; i++) {
                System.out.print(timeMap.get(new Pair(edges[i][0], edges[i][1])) + " ");
            }
            System.out.println();
        }
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair other = (Pair) obj;
            return x == other.x && y == other.y;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }
}