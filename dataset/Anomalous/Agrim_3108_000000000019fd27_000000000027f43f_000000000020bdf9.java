import java.util.*;

class Pair {
    int start;
    int end;

    Pair(int x, int y) {
        start = x;
        end = y;
    }
}

class TimeComparator implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
        return Integer.compare(p1.start, p2.start);
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            Pair[] times = new Pair[n];
            Pair[] unsortedTimes = new Pair[n];

            for (int j = 0; j < n; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                Pair p = new Pair(startTime, endTime);
                times[j] = p;
                unsortedTimes[j] = p;
            }

            Arrays.sort(times, new TimeComparator());

            int cIndex = 0;
            int jIndex = -1;
            StringBuilder schedule = new StringBuilder("C");
            String impossible = "IMPOSSIBLE";
            Map<Integer, Character> scheduleMap = new HashMap<>();
            scheduleMap.put(times[0].start, 'C');

            for (int j = 1; j < n; j++) {
                if (times[j].start < times[cIndex].end) {
                    if (jIndex == -1 || times[j].start >= times[jIndex].end) {
                        jIndex = j;
                        schedule.append("J");
                        scheduleMap.put(times[j].start, 'J');
                    } else if (times[j].start < times[jIndex].end) {
                        break;
                    }
                } else {
                    cIndex = j;
                    schedule.append("C");
                    scheduleMap.put(times[j].start, 'C');
                }
            }

            int caseNum = i + 1;
            if (schedule.length() < n) {
                System.out.println("Case #" + caseNum + ": " + impossible);
            } else {
                StringBuilder finalSchedule = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    finalSchedule.append(scheduleMap.get(unsortedTimes[j].start));
                }
                System.out.println("Case #" + caseNum + ": " + finalSchedule);
            }
        }
    }
}