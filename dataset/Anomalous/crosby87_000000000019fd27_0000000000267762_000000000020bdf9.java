import java.util.*;

public class Parent {

    public static class Event {
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<String> generateBinarySequences(int n) {
        List<String> sequences = new ArrayList<>();
        sequences.add("");
        for (int i = 0; i < n; i++) {
            List<String> temp = new ArrayList<>();
            for (String seq : sequences) {
                temp.add(seq + "0");
                temp.add(seq + "1");
            }
            sequences = temp;
        }
        return sequences;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            System.out.print("Case #" + t + ": ");
            Event[] events = new Event[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                events[i] = new Event(start, end);
            }

            List<String> binarySequences = generateBinarySequences(n);
            boolean foundSolution = false;

            for (String sequence : binarySequences) {
                List<Integer> jamieTasks = new ArrayList<>();
                List<Integer> cameronTasks = new ArrayList<>();

                for (int j = 0; j < sequence.length(); j++) {
                    if (sequence.charAt(j) == '0') {
                        jamieTasks.add(j);
                    } else {
                        cameronTasks.add(j);
                    }
                }

                if (isValidSchedule(events, jamieTasks) && isValidSchedule(events, cameronTasks)) {
                    for (char c : sequence.toCharArray()) {
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

    private static boolean isValidSchedule(Event[] events, List<Integer> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            for (int j = i + 1; j < tasks.size(); j++) {
                Event e1 = events[tasks.get(i)];
                Event e2 = events[tasks.get(j)];
                if (overlaps(e1, e2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean overlaps(Event e1, Event e2) {
        return (e1.start < e2.end && e1.end > e2.start);
    }
}