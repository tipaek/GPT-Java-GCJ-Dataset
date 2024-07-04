import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    class Node {
        Node top, bottom, left, right;
        int value;

        Node(int value) {
            this.value = value;
        }

        boolean shouldEliminate() {
            int sum = 0;
            sum += (top == null ? value : top.value);
            sum += (bottom == null ? value : bottom.value);
            sum += (left == null ? value : left.value);
            sum += (right == null ? value : right.value);
            return sum > 4 * value;
        }
    }

    public Solution() {
        FastScanner scanner = new FastScanner();
        java.io.PrintWriter out = new java.io.PrintWriter(System.out);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int rows = scanner.nextInt(), cols = scanner.nextInt();
            Node[][] grid = new Node[rows + 2][cols + 2];

            for (int y = 1; y <= rows; y++) {
                for (int x = 1; x <= cols; x++) {
                    grid[y][x] = new Node(scanner.nextInt());
                }
            }

            long totalSum = 0, score = 0;
            ArrayDeque<Node> toEliminate = new ArrayDeque<>();

            for (int y = 1; y <= rows; y++) {
                for (int x = 1; x <= cols; x++) {
                    Node node = grid[y][x];
                    totalSum += node.value;
                    node.top = grid[y - 1][x];
                    node.bottom = grid[y + 1][x];
                    node.left = grid[y][x - 1];
                    node.right = grid[y][x + 1];
                    toEliminate.add(node);
                }
            }

            ArrayDeque<Node> secondaryEliminate = new ArrayDeque<>();

            while (!toEliminate.isEmpty()) {
                score += totalSum;

                while (!toEliminate.isEmpty()) {
                    Node node = toEliminate.poll();
                    if (node.shouldEliminate()) {
                        secondaryEliminate.add(node);
                    }
                }

                while (!secondaryEliminate.isEmpty()) {
                    Node node = secondaryEliminate.poll();
                    totalSum -= node.value;

                    if (node.top != null) {
                        node.top.bottom = node.bottom;
                        toEliminate.add(node.top);
                    }
                    if (node.bottom != null) {
                        node.bottom.top = node.top;
                        toEliminate.add(node.bottom);
                    }
                    if (node.left != null) {
                        node.left.right = node.right;
                        toEliminate.add(node.left);
                    }
                    if (node.right != null) {
                        node.right.left = node.left;
                        toEliminate.add(node.right);
                    }
                }
            }

            out.println(String.format("Case #%d: %d", t, score));
        }
        out.flush();
    }

    static class FastScanner {
        private final java.io.InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) return true;
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            return buflen > 0;
        }

        private byte readByte() {
            return hasNextByte() ? buffer[ptr++] : -1;
        }

        private static boolean isPrintableChar(byte c) {
            return 32 < c || c < 0;
        }

        private static boolean isNumber(int c) {
            return '0' <= c && c <= '9';
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;
            return hasNextByte();
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            byte b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            if (!hasNext()) throw new NoSuchElementException();
            int n = 0;
            try {
                byte b = readByte();
                if (b == '-') {
                    do n = n * 10 + '0' - b; while (isNumber(b = readByte()));
                    return n;
                } else if (!isNumber(b)) throw new NumberFormatException();
                do n = n * 10 + b - '0'; while (isNumber(b = readByte()));
                return n;
            } catch (NoSuchElementException e) {
                return n;
            }
        }

        public long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            try {
                byte b = readByte();
                if (b == '-') {
                    do n = n * 10 + '0' - b; while (isNumber(b = readByte()));
                    return n;
                } else if (!isNumber(b)) throw new NumberFormatException();
                do n = n * 10 + b - '0'; while (isNumber(b = readByte()));
                return n;
            } catch (NoSuchElementException e) {
                return n;
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}