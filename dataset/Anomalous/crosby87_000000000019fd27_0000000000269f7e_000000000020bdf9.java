import java.util.*;

public class Solution {
    public static class Event {
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static boolean testOverlap(int x1, int x2, int y1, int y2) {
        return (x1 < x2 && y1 < y2) && (x1 < y2 && y1 < x2);
    }

    public static List<String> generateBinaryStrings(int n) {
        List<String> binaryStrings = new ArrayList<>();
        binaryStrings.add("");
        for (int i = 0; i < n; i++) {
            List<String> newStrings = new ArrayList<>();
            for (String s : binaryStrings) {
                newStrings.add(s + "0");
                newStrings.add(s + "1");
            }
            binaryStrings = newStrings;
        }
        return binaryStrings;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            System.out.print("Case #" + t + ": ");
            Event[] events = new Event[N];

            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events[i] = new Event(start, end);
            }

            List<String> binaryStrings = generateBinaryStrings(N);
            boolean foundSolution = false;

            for (String binaryString : binaryStrings) {
                List<Integer> jamieIndices = new ArrayList<>();
                List<Integer> cameronIndices = new ArrayList<>();

                for (int i = 0; i < binaryString.length(); i++) {
                    if (binaryString.charAt(i) == '0') {
                        jamieIndices.add(i);
                    } else {
                        cameronIndices.add(i);
                    }
                }

                boolean isJamieValid = checkNoOverlap(events, jamieIndices);
                boolean isCameronValid = checkNoOverlap(events, cameronIndices);

                if (isJamieValid && isCameronValid) {
                    for (char c : binaryString.toCharArray()) {
                        System.out.print(c == '0' ? 'J' : 'C');
                    }
                    System.out.println();
                    foundSolution = true;
                    break;
                }
            }

            if (!foundSolution) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static boolean checkNoOverlap(Event[] events, List<Integer> indices) {
        for (int i = 0; i < indices.size(); i++) {
            for (int j = i + 1; j < indices.size(); j++) {
                if (testOverlap(events[indices.get(i)].start, events[indices.get(i)].end,
                        events[indices.get(j)].start, events[indices.get(j)].end)) {
                    return false;
                }
            }
        }
        return true;
    }
}