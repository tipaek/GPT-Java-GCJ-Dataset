import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            Pair[] originalPairs = new Pair[n];
            Pair[] sortedPairs = new Pair[n];

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                originalPairs[j] = new Pair(start, end);
                sortedPairs[j] = new Pair(start, end);
            }

            Arrays.sort(sortedPairs, Comparator.comparingInt(Pair::getStart));

            char[] assignments = new char[n];
            Integer cEnd = null, jEnd = null;
            boolean impossible = false;

            for (int j = 0; j < n; j++) {
                int start = sortedPairs[j].getStart();
                int end = sortedPairs[j].getEnd();

                if (cEnd == null || cEnd <= start) {
                    cEnd = end;
                    assignments[j] = 'C';
                } else if (jEnd == null || jEnd <= start) {
                    jEnd = end;
                    assignments[j] = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }

            StringBuilder result = new StringBuilder("Case #" + i + ": ");
            if (impossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (Pair originalPair : originalPairs) {
                    int index = findIndex(sortedPairs, originalPair.getStart());
                    result.append(assignments[index]);
                }
            }
            System.out.println(result);
        }
    }

    private static int findIndex(Pair[] pairs, int start) {
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i].getStart() == start) {
                return i;
            }
        }
        return -1;
    }

    static class Pair {
        private final int start;
        private final int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}