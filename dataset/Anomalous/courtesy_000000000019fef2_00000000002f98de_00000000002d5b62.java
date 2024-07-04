import java.io.*;
import java.util.*;

public class Solution {
    public static Scanner scanner = new Scanner(System.in);
    public static OutputWriter outputWriter = new OutputWriter();

    public static void main(String[] args) throws IOException {
        int lm = 500;
        Map<Pair, String> dp = new HashMap<>();
        Pair start = new Pair(0, 0);
        start.s = "";
        dp.put(start, "");
        Queue<Pair> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            String currentPath = p.s;
            int nextStep = 1 << currentPath.length();

            addNextStep(queue, dp, p, currentPath, nextStep, lm, "E", p.x + nextStep, p.y);
            addNextStep(queue, dp, p, currentPath, nextStep, lm, "N", p.x, p.y + nextStep);
            addNextStep(queue, dp, p, currentPath, nextStep, lm, "W", p.x - nextStep, p.y);
            addNextStep(queue, dp, p, currentPath, nextStep, lm, "S", p.x, p.y - nextStep);
        }

        int T = scanner.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String result = dp.get(new Pair(x, y));

            System.out.print("Case #" + cs + ": ");
            if (result == null) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }

    private static void addNextStep(Queue<Pair> queue, Map<Pair, String> dp, Pair p, String currentPath, int nextStep, int lm, String direction, int newX, int newY) {
        if (Math.abs(newX) <= lm && Math.abs(newY) <= lm) {
            Pair newPair = new Pair(newX, newY);
            newPair.s = currentPath + direction;
            queue.add(newPair);
            dp.putIfAbsent(newPair, newPair.s);
        }
    }

    static class Pair {
        int x, y;
        String s;

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

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
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