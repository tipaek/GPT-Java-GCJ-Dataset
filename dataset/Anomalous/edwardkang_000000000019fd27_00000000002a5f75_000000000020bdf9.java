import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt(); // Number of test cases

        for (int g = 1; g <= t; ++g) {
            int n = scanner.nextInt(); // Number of intervals
            Frame[] frames = new Frame[n];

            for (int i = 0; i < n; i++) {
                frames[i] = new Frame(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(frames);

            ArrayList<Frame> jFrames = new ArrayList<>();
            ArrayList<Frame> cFrames = new ArrayList<>();

            for (int i = 1; i < frames.length; i++) {
                if (frames[i - 1].intersects(frames[i])) {
                    jFrames.add(frames[i - 1]);
                    cFrames.add(frames[i]);
                } else {
                    jFrames.add(frames[i - 1]);
                    jFrames.add(frames[i]);
                }
            }

            boolean isImpossible = false;

            for (int i = 1; i < jFrames.size(); i++) {
                if (jFrames.get(i - 1).intersects(jFrames.get(i))) {
                    isImpossible = true;
                    break;
                }
            }

            for (int i = 1; i < cFrames.size(); i++) {
                if (cFrames.get(i - 1).intersects(cFrames.get(i))) {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + g + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + g + ": ");
                for (int i = 0; i < n; i++) {
                    boolean isC = false;
                    for (Frame frame : cFrames) {
                        if (frame.getIndex() == i) {
                            System.out.print("C");
                            isC = true;
                            break;
                        }
                    }
                    if (!isC) {
                        System.out.print("J");
                    }
                }
                System.out.println();
            }
        }
    }

    static class Frame implements Comparable<Frame> {
        private final int start;
        private final int end;
        private final int index;

        public Frame(int start, int end, int index) {
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
        public int compareTo(Frame other) {
            return Integer.compare(this.start, other.start);
        }

        public boolean intersects(Frame other) {
            return this.start < other.end && this.end > other.start;
        }
    }
}