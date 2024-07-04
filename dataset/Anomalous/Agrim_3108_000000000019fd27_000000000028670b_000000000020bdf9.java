import java.util.*;

class Pair {
    int start;
    int end;

    Pair(int start, int end) {
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
            StringBuilder ans = new StringBuilder("C");
            String noAns = "IMPOSSIBLE";
            HashMap<Integer, Character> map = new HashMap<>();
            map.put(times[0].start, 'C');

            for (int j = 1; j < n; j++) {
                if (times[j].start < times[cIndex].end) {
                    if (jIndex == -1 || times[j].start >= times[jIndex].end) {
                        jIndex = j;
                        ans.append('J');
                        map.put(times[j].start, 'J');
                    } else if (times[j].start < times[jIndex].end) {
                        break;
                    }
                } else {
                    cIndex = j;
                    ans.append('C');
                    map.put(times[j].start, 'C');
                }
            }

            int caseNum = i + 1;
            if (ans.length() < n) {
                System.out.println("Case #" + caseNum + ": " + noAns);
            } else {
                StringBuilder newAns = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    newAns.append(map.get(unsortedTimes[j].start));
                }
                System.out.println("Case #" + caseNum + ": " + newAns);
            }
        }
    }
}