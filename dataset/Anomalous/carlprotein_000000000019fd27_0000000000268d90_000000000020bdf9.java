import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfRounds = scanner.nextInt();

        for (int i = 1; i <= numberOfRounds; i++) {
            int size = scanner.nextInt();
            Solution solution = new Solution();
            solution.processRound(i, size, scanner);
        }
    }

    private static class Pair implements Comparable<Pair> {
        private final int start;
        private final int end;
        private final int index;

        public Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.start, other.start);
        }
    }

    private void processRound(int roundIndex, int size, Scanner scanner) {
        StringBuilder schedule = new StringBuilder();
        schedule.setLength(size);
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            pairs.add(new Pair(start, end, i));
        }

        Collections.sort(pairs);

        schedule.setCharAt(pairs.get(0).getIndex(), 'C');
        Pair cameron = pairs.get(0);
        schedule.setCharAt(pairs.get(1).getIndex(), 'J');
        Pair jamie = pairs.get(1);

        for (int i = 2; i < size; i++) {
            Pair current = pairs.get(i);
            int start = current.getStart();

            if (start >= cameron.getEnd()) {
                schedule.setCharAt(current.getIndex(), 'C');
                cameron = current;
            } else if (start >= jamie.getEnd()) {
                schedule.setCharAt(current.getIndex(), 'J');
                jamie = current;
            } else {
                schedule.setLength(0);
                schedule.append("IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + roundIndex + ": " + schedule);
    }
}