import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Heap heap = new Heap();
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                heap.insert(start, end);
            }
            StringBuilder result = new StringBuilder("C");
            int cameronEnd = heap.getMin().getEnd();
            int jamieEnd = -1;
            boolean impossible = false;
            heap.removeMin();
            for (int j = 0; j < n - 1; j++) {
                Range range = heap.getMin();
                heap.removeMin();
                if (range.getStart() >= cameronEnd) {
                    result.append("C");
                    cameronEnd = range.getEnd();
                } else if (range.getStart() >= jamieEnd) {
                    result.append("J");
                    jamieEnd = range.getEnd();
                } else {
                    impossible = true;
                    break;
                }
            }
            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + result.toString());
            }
        }
    }

    private static class Heap {
        private ArrayList<Range> nodes;

        public Heap() {
            nodes = new ArrayList<>();
        }

        public Range getMin() {
            return nodes.get(0);
        }

        private void swap(int a, int b) {
            Range temp = nodes.get(a);
            nodes.set(a, nodes.get(b));
            nodes.set(b, temp);
        }

        private void insert(int start, int end) {
            nodes.add(new Range(start, end));
            int i = nodes.size() - 1;
            int nextIndex = (int) Math.floor((i - 1) / 2);
            if (nextIndex < 0) {
                nextIndex = 0;
            }
            while (i > 0 && nodes.get(nextIndex).getStart() > nodes.get(i).getStart()) {
                swap(nextIndex, i);
                i = nextIndex;
                nextIndex = (int) Math.floor((i - 1) / 2);
                if (nextIndex < 0) {
                    nextIndex = 0;
                }
            }
        }

        public void removeMin() {
            if (!nodes.isEmpty()) {
                nodes.set(0, nodes.get(nodes.size() - 1));
                nodes.remove(nodes.size() - 1);
                int i = 0;
                while (2 * i + 1 < nodes.size()) {
                    int j = i;
                    if (2 * i + 1 < nodes.size() && nodes.get(i).getStart() > nodes.get(2 * i + 1).getStart()) {
                        j = 2 * i + 1;
                    }
                    if (2 * i + 2  < nodes.size() && nodes.get(i).getStart() > nodes.get(2 * i + 2).getStart() && nodes.get(2 * i + 1).getStart() > nodes.get(2 * i + 2).getStart()) {
                        j = 2 * i + 2;
                    }
                    if (i != j) {
                        swap(i, j);
                        i = j;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private static class Range {
        private int start;
        private int end;

        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return this.start;
        }

        public int getEnd() {
            return this.end;
        }
    }
}
