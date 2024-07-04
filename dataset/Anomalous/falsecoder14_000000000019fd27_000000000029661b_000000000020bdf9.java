import java.util.*;

class Pair {
    int start;
    int end;
    int id;

    Pair(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }
}

class TimeComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        return Integer.compare(p1.start, p2.start);
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            Pair[] intervals = new Pair[n];

            for (int j = 0; j < n; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                intervals[j] = new Pair(startTime, endTime, j);
            }

            Arrays.sort(intervals, new TimeComparator());

            int lastC = 0;
            int lastJ = -1;
            StringBuilder result = new StringBuilder("C");
            Map<Integer, Character> assignmentMap = new HashMap<>();
            assignmentMap.put(intervals[0].id, 'C');

            boolean possible = true;

            for (int j = 1; j < n; j++) {
                if (intervals[j].start < intervals[lastC].end) {
                    if (lastJ == -1 || intervals[j].start >= intervals[lastJ].end) {
                        lastJ = j;
                        result.append('J');
                        assignmentMap.put(intervals[j].id, 'J');
                    } else {
                        possible = false;
                        break;
                    }
                } else {
                    lastC = j;
                    result.append('C');
                    assignmentMap.put(intervals[j].id, 'C');
                }
            }

            int caseNumber = i + 1;
            if (!possible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                StringBuilder finalResult = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    finalResult.append(assignmentMap.get(j));
                }
                System.out.println("Case #" + caseNumber + ": " + finalResult);
            }
        }
    }
}