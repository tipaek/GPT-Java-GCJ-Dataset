import java.util.*;
import java.io.*;

class Work {
    private int startTime;
    private int endTime;
    private String assignedTo;

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}

public class Solution {

    private static List<Work> workList;
    private static Set<Integer> timeSet;
    private static Map<String, Set<String>> intervalMap;
    private static List<Integer> timeList;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            input(n, in);
            String solution = solve();
            System.out.println("Case #" + i + ": " + solution);
        }
    }

    private static void input(int n, Scanner in) {
        workList = new java.util.ArrayList<>();
        timeSet = new HashSet<>();
        intervalMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Work work = new Work();
            work.setStartTime(in.nextInt());
            work.setEndTime(in.nextInt());
            workList.add(work);
            timeSet.add(work.getStartTime());
            timeSet.add(work.getEndTime());
        }
        timeList = new ArrayList<>(timeSet);
        Collections.sort(timeList);
        intervalMap = getIntervals();
    }

    private static String solve() {
        String sol = "";
        if (!workList.isEmpty()) {
            String assignee = "C";
            int miss = 0;
            for (Work work : workList) {
                work.setAssignedTo(assignee);
                miss = 0;
                int startPos = timeList.indexOf(work.getStartTime());
                int endPos = timeList.indexOf(work.getEndTime());
                for (int i = startPos; i < endPos; i++) {
                    String key = timeList.get(i) + "-" + timeList.get(i + 1);
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

            for (Work work : workList) {
                sol += work.getAssignedTo();
            }
        }
        return sol;
    }

    private static void removePreviousIntervalAssignees(int i, int j, String assignee) {
        for (; i < j; i++) {
            String key = timeList.get(i) + "-" + timeList.get(i + 1);
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