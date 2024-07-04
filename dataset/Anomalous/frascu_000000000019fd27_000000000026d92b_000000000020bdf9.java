import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class IntPair {
        private final int start;
        private final int end;
        private final int position;
        private char assignedTo;

        IntPair(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getPosition() {
            return position;
        }

        public char getAssignedTo() {
            return assignedTo;
        }

        public void setAssignedTo(char assignedTo) {
            this.assignedTo = assignedTo;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int i = 0; i < testCases; i++) {
                int n = scanner.nextInt();

                List<IntPair> activities = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    activities.add(new IntPair(start, end, j));
                }

                activities.sort(Comparator.comparingInt(IntPair::getStart).thenComparingInt(IntPair::getEnd));

                int lastEndC = 0;
                int lastEndJ = 0;
                boolean isImpossible = false;

                for (IntPair activity : activities) {
                    if (lastEndC <= activity.getStart()) {
                        activity.setAssignedTo('C');
                        lastEndC = activity.getEnd();
                    } else if (lastEndJ <= activity.getStart()) {
                        activity.setAssignedTo('J');
                        lastEndJ = activity.getEnd();
                    } else {
                        isImpossible = true;
                        break;
                    }
                }

                if (isImpossible) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                } else {
                    char[] result = new char[n];
                    for (IntPair activity : activities) {
                        result[activity.getPosition()] = activity.getAssignedTo();
                    }
                    System.out.println("Case #" + (i + 1) + ": " + new String(result));
                }
            }
        }
    }
}