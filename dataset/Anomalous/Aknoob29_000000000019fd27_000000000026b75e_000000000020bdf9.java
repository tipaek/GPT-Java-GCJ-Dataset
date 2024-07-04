import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int N = sc.nextInt();
            int[][] intervals = new int[N][2];
            int[] startTimes = new int[N];

            for (int j = 0; j < N; j++) {
                intervals[j][0] = sc.nextInt();
                intervals[j][1] = sc.nextInt();
                startTimes[j] = intervals[j][0];
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            int overlapCount = 0;
            for (int j = 0; j + 1 < N; j++) {
                if (intervals[j][1] > intervals[j + 1][0]) {
                    overlapCount++;
                }
            }

            if (overlapCount == N - 1) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder schedule = new StringBuilder();
                schedule.append("C");
                char current = 'C';

                for (int j = 0; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        if (intervals[j][1] > intervals[k][0]) {
                            current = (current == 'C') ? 'J' : 'C';
                            schedule.append(current);
                            break;
                        }
                        schedule.append(current);
                    }
                }

                List<Character> charList = new ArrayList<>();
                List<Integer> endTimes = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    charList.add(schedule.charAt(j));
                    endTimes.add(intervals[j][1]);
                }

                List<Integer> cameronEndTimes = new ArrayList<>();
                List<Integer> jamieEndTimes = new ArrayList<>();
                for (int j = 0; j < charList.size(); j++) {
                    if (charList.get(j) == 'C') {
                        cameronEndTimes.add(endTimes.get(j));
                    } else {
                        jamieEndTimes.add(endTimes.get(j));
                    }
                }

                adjustSchedule(schedule, charList, endTimes, cameronEndTimes, 'C');
                adjustSchedule(schedule, charList, endTimes, jamieEndTimes, 'J');

                StringBuilder finalSchedule = new StringBuilder();
                int[] sortedStartTimes = Arrays.copyOf(startTimes, startTimes.length);
                Arrays.sort(sortedStartTimes);
                for (int p = 0; p < N; p++) {
                    int index = Arrays.binarySearch(sortedStartTimes, startTimes[p]);
                    finalSchedule.append(schedule.charAt(index));
                }

                System.out.println("Case #" + (i + 1) + ": " + finalSchedule);
            }
        }
    }

    private static void adjustSchedule(StringBuilder schedule, List<Character> charList, List<Integer> endTimes, List<Integer> specificEndTimes, char targetChar) {
        for (int j = 0; j < specificEndTimes.size(); j++) {
            if (j + 1 < specificEndTimes.size() && specificEndTimes.get(j) > specificEndTimes.get(j + 1)) {
                int nextEndTime = specificEndTimes.get(j + 1);
                for (int k = 0; k < endTimes.size(); k++) {
                    if (nextEndTime == endTimes.get(k)) {
                        if (charList.get(k) == targetChar) {
                            schedule.setCharAt(k, targetChar == 'C' ? 'J' : 'C');
                        }
                    }
                }
            }
        }
    }
}