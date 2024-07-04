import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            Frame[] frames = new Frame[n];

            for (int i = 0; i < n; i++) {
                frames[i] = new Frame(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(frames);
            List<Frame> jFrames = new ArrayList<>();
            List<Frame> cFrames = new ArrayList<>();

            for (int i = 1; i < frames.length; i++) {
                if (frames[i - 1].intersects(frames[i])) {
                    jFrames.add(frames[i - 1]);
                    cFrames.add(frames[i]);
                } else {
                    jFrames.add(frames[i - 1]);
                    jFrames.add(frames[i]);
                }
            }

            boolean conflict = false;
            conflict = checkConflicts(jFrames) || checkConflicts(cFrames);

            if (conflict) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + testCase + ": ");
                for (int i = 0; i < n; i++) {
                    boolean assignedToC = false;
                    for (Frame frame : cFrames) {
                        if (frame.getIndex() == i) {
                            System.out.print("C");
                            assignedToC = true;
                            break;
                        }
                    }
                    if (!assignedToC) {
                        System.out.print("J");
                    }
                }
                System.out.println();
            }
        }
    }

    private static boolean checkConflicts(List<Frame> frames) {
        for (int i = 1; i < frames.size(); i++) {
            if (frames.get(i - 1).intersects(frames.get(i))) {
                return true;
            }
        }
        return false;
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

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Frame other) {
            return Integer.compare(this.start, other.start);
        }

        public boolean intersects(Frame other) {
            return (this.start < other.end && this.end > other.start);
        }
    }
}