import java.util.*;

class Pair {
    int start;
    int end;
    int index;

    Pair(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class Pair2 {
    int start;
    int end;

    Pair2(int start, int end) {
        this.start = start;
        this.end = end;
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
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            Pair[] timePairs = new Pair[n];
            Pair2[] unsortedPairs = new Pair2[n];

            for (int j = 0; j < n; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                timePairs[j] = new Pair(startTime, endTime, j);
                unsortedPairs[j] = new Pair2(startTime, endTime);
            }

            Arrays.sort(timePairs, new TimeComparator());

            int cIndex = 0;
            int jIndex = -1;
            StringBuilder answer = new StringBuilder("C");
            String impossible = "IMPOSSIBLE";
            Map<Integer, Character> scheduleMap = new HashMap<>();
            scheduleMap.put(timePairs[0].index, 'C');

            for (int j = 1; j < n; j++) {
                if (timePairs[j].start < timePairs[cIndex].end) {
                    if (jIndex == -1 || timePairs[j].start >= timePairs[jIndex].end) {
                        jIndex = j;
                        answer.append("J");
                        scheduleMap.put(timePairs[j].index, 'J');
                    } else if (timePairs[j].start < timePairs[jIndex].end) {
                        break;
                    }
                } else {
                    cIndex = j;
                    answer.append("C");
                    scheduleMap.put(timePairs[j].index, 'C');
                }
            }

            int caseNumber = i + 1;
            if (answer.length() < n) {
                System.out.println("Case #" + caseNumber + ": " + impossible);
            } else {
                StringBuilder finalAnswer = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    finalAnswer.append(scheduleMap.get(j));
                }
                System.out.println("Case #" + caseNumber + ": " + finalAnswer.toString());
            }
        }
        
        scanner.close();
    }
}