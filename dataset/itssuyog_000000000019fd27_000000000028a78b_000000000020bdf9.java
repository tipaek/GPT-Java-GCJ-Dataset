import java.util.*;
import java.io.*;

class Work {
    private int startTime;
    private int endTime;
    private String assignedTo;

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(final int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(final int endTime) {
        this.endTime = endTime;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(final String assignedTo) {
        this.assignedTo = assignedTo;
    }
}

class WorkComparator implements Comparator<Work> {

    @Override
    public int compare(Work o1, Work o2) {
        return (o2.getEndTime() - o2.getStartTime()) - (o1.getEndTime() - o1.getStartTime());
    }

}

public class Solution {

    private static List<Work> workList;
    private static Set<Integer> timeSet;
    private static Map<String, Set<String>> intervalMap;
    private static List<Integer> timeList;

    public static void main(final String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            final int n = in.nextInt();
            input(n, in);
            final String solution = solve();
            System.out.println("Case #" + i + ": " + solution);
        }
    }

    private static void input(final int n, final Scanner in) {
        workList = new java.util.ArrayList<>();
        timeSet = new HashSet<>();
        intervalMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            final Work work = new Work();
            work.setStartTime(in.nextInt());
            work.setEndTime(in.nextInt());
            workList.add(work);
            timeSet.add(work.getStartTime());
            timeSet.add(work.getEndTime());
        }
    }

    private static String solve() {
        String sol = "";
        if (!workList.isEmpty()) {

            timeList = new ArrayList<>(timeSet);
            Collections.sort(timeList);
            Collections.sort(workList, new WorkComparator());
            intervalMap = getIntervals();

            String assignee = "C";
            int miss = 0;

            for (final Work work : workList) {
                work.setAssignedTo(assignee);
                miss = 0;
                final int startPos = timeList.indexOf(work.getStartTime());
                final int endPos = timeList.indexOf(work.getEndTime());
                for (int i = startPos; i < endPos; i++) {
                    final String key = timeList.get(i) + "-" + timeList.get(i + 1);
                    if (intervalMap.get(key).isEmpty()) {
                        intervalMap.get(key).add(assignee);
                    } else if (intervalMap.get(key).size() == 2) {
                        return "IMPOSSIBLE";
                    } else {
                        if (intervalMap.get(key).iterator().next().equals(assignee)) {
                            if (miss < 1) {
                                miss++;
                                removePreviousIntervalAssignees(startPos, i, assignee);
                                assignee = assignee.equals("C") ? "J" : "C";
                                work.setAssignedTo(assignee);
                                i = startPos - 1;
                                continue;
                            } else {
                                return "IMPOSSIBLE";
                            }
                        } else {
                            intervalMap.get(key).add(assignee);
                        }
                    }
                }
            }

            for (final Work work : workList) {
                sol += work.getAssignedTo();
            }
        } else {
            sol = "IMPOSSIBLE";
        }
        return sol;
    }

    private static void removePreviousIntervalAssignees(int i, final int j, final String assignee) {
        for (; i < j; i++) {
            final String key = timeList.get(i) + "-" + timeList.get(i + 1);
            intervalMap.get(key).remove(assignee);
        }
    }

    private static Map<String, Set<String>> getIntervals() {
        for (int i = 0; i < timeList.size() - 1; i++) {
            intervalMap.put(timeList.get(i) + "-" + timeList.get(i + 1), new HashSet<>());
        }
        return intervalMap;
    }
}