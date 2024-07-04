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

    public static List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        result.add("");
        for (int i = 0; i < n; i++) {
            List<String> temp = new ArrayList<>();
            for (String str : result) {
                temp.add(str + "0");
                temp.add(str + "1");
            }
            result = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt();
            System.out.print("Case #" + testCase + ": ");
            Event[] events = new Event[N];

            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events[i] = new Event(start, end);
            }

            List<String> binaryStrings = generateBinaryStrings(N);
            boolean foundSolution = false;

            for (String binaryString : binaryStrings) {
                List<Integer> jamieEvents = new ArrayList<>();
                List<Integer> cameronEvents = new ArrayList<>();
                boolean jamieWorks = true;
                boolean cameronWorks = true;

                for (int j = 0; j < binaryString.length(); j++) {
                    if (binaryString.charAt(j) == '0') {
                        jamieEvents.add(j);
                    } else {
                        cameronEvents.add(j);
                    }
                }

                for (int j = 0; j < jamieEvents.size(); j++) {
                    for (int k = j + 1; k < jamieEvents.size(); k++) {
                        if (isOverlapping(events[jamieEvents.get(j)], events[jamieEvents.get(k)])) {
                            jamieWorks = false;
                        }
                    }
                }

                for (int j = 0; j < cameronEvents.size(); j++) {
                    for (int k = j + 1; k < cameronEvents.size(); k++) {
                        if (isOverlapping(events[cameronEvents.get(j)], events[cameronEvents.get(k)])) {
                            cameronWorks = false;
                        }
                    }
                }

                if (jamieWorks && cameronWorks) {
                    for (int k = 0; k < binaryString.length(); k++) {
                        System.out.print(binaryString.charAt(k) == '0' ? 'J' : 'C');
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

    private static boolean isOverlapping(Event e1, Event e2) {
        return (e1.start < e2.end && e2.start < e1.end);
    }
}