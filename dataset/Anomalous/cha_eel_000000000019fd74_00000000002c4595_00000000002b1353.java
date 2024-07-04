import java.io.*;
import java.util.*;

public class Solution {

    static final int TEST_MODE = 10; // 0 for local testing, 1 for standard input
    static final int[][] DIRECTIONS = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
    static final int INF = 1_000_000;
    static BufferedReader reader;
    static PrintWriter writer = new PrintWriter(System.out);
    static String inputFile = "../in";

    public static void main(String[] args) throws Exception {
        if (TEST_MODE > 0) {
            reader = new BufferedReader(new InputStreamReader(System.in));
        } else {
            reader = new BufferedReader(new FileReader(inputFile));
        }

        int testCaseCount = readInt();
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int N = readInt();
            int[][] arr = new int[N + 2][N + 2];
            arr[1][1] = 1;
            arr[2][1] = 1;

            Set<Integer> unvisited = new HashSet<>();
            unvisited.add(N + 1);
            unvisited.add(N + 2);

            for (int i = 2; i <= N; i++) {
                for (int j = 1; j <= i; j++) {
                    if (j == 1) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= i; j++) {
                    unvisited.add(i * N + j);
                }
            }

            List<int[]> path = new ArrayList<>();
            Deque<int[]> queue = new ArrayDeque<>();
            queue.offerLast(new int[]{1, 1});
            path.add(new int[]{1, 1});
            unvisited.remove(N + 1);

            int sum = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] current = queue.pollFirst();
                    if (sum == N) break;
                    sum += arr[current[0]][current[1]];

                    for (int[] direction : DIRECTIONS) {
                        int x = direction[0] + current[0];
                        int y = direction[1] + current[1];
                        if (x < 1 || y < 1 || x >= N + 1 || y >= N + 1 || arr[x][y] == 0) continue;
                        int[] newPosition = {x, y};
                        if (unvisited.contains(x * N + y)) {
                            queue.offerLast(newPosition);
                            path.add(newPosition);
                            unvisited.remove(x * N + y);
                        }
                    }
                }
            }

            List<int[]> result = new ArrayList<>();
            result.add(path.get(path.size() - 1));
            for (int i = path.size() - 1; i >= 1; i--) {
                int[] before = path.get(i - 1);
                int[] after = path.get(i);
                if (isNeighbor(before[0], before[1], after[0], after[1])) {
                    result.add(before);
                }
            }
            Collections.reverse(result);

            StringBuilder output = new StringBuilder("\n");
            for (int[] position : result) {
                output.append(position[0]).append(" ").append(position[1]).append('\n');
            }
            writer.printf("Case #%d: %s\n", testCase, output.toString());
        }
        writer.flush();
    }

    static boolean isNeighbor(int x1, int y1, int x2, int y2) {
        for (int[] direction : DIRECTIONS) {
            if (direction[0] + x1 == x2 || direction[1] + y1 == y2) return true;
        }
        return false;
    }

    static int readInt() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    static String[] split() throws IOException {
        return reader.readLine().split(" ");
    }

    static int[] toIntArray() throws IOException {
        String[] tokens = split();
        int n = tokens.length;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(tokens[i]);
        }
        return array;
    }

    static long[] toLongArray() throws IOException {
        String[] tokens = split();
        int n = tokens.length;
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = Long.parseLong(tokens[i]);
        }
        return array;
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static int dfs(Trie root, int length, int k) {
        if (root == null) return 0;
        int count = root.strCount;
        int result = 0;

        for (int i = 0; i < 26; i++) {
            int ans = dfs(root.child[i], length + 1, k);
            if (ans > 0) {
                count -= (root.child[i].strCount / k) * k;
                result += ans;
            }
        }

        result += length * (count / k);
        return result;
    }

    static class Trie {
        Trie[] child = new Trie[26];
        int strCount = 0;

        void insert(String str) {
            Trie current = this;
            for (char c : str.toCharArray()) {
                if (current.child[c - 'A'] == null) {
                    current.child[c - 'A'] = new Trie();
                }
                current = current.child[c - 'A'];
                current.strCount++;
            }
        }
    }
}