import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            List<Pair> pairs = new ArrayList<>(n);

            for (int j = 0; j < n; j++) {
                String[] elements = scanner.nextLine().split(" ");
                pairs.add(new Pair(Integer.parseInt(elements[0]), Integer.parseInt(elements[1])));
            }

            String result = allocateSlot(new ArrayList<>(pairs));
            StringBuilder currentOutput = new StringBuilder();

            if (result.equals("0")) {
                for (Pair pair : pairs) {
                    currentOutput.append(pair.getSlot());
                }
            } else {
                currentOutput.append(result);
            }

            output.append(String.format("Case #%d: %s", i, currentOutput));
            if (i < testCaseCount) {
                output.append("\n");
            }
        }

        System.out.println(output);
    }

    static class Pair implements Comparable<Pair> {
        int start;
        int end;
        char slot;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        void setSlot(char slot) {
            this.slot = slot;
        }

        char getSlot() {
            return this.slot;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.start, other.start);
        }
    }

    static String allocateSlot(List<Pair> pairs) {
        Collections.sort(pairs);
        int cEnd = -1, jEnd = -1;

        for (Pair pair : pairs) {
            if (cEnd <= pair.start) {
                pair.setSlot('C');
                cEnd = pair.end;
            } else if (jEnd <= pair.start) {
                pair.setSlot('J');
                jEnd = pair.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return "0";
    }
}