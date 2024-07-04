import java.util.*;

public class Solution {

    static class Pair {
        int first;
        int second;

        public Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int n = 0; n < t; n++) {
            solveProblem3(scanner, n + 1);
        }
    }

    public static void solveProblem3(Scanner scanner, int caseNumber) {
        int numActivities = scanner.nextInt();
        Map<Integer, Pair> times = new TreeMap<>();
        char[] schedule = new char[numActivities];
        String result = "";

        for (int i = 0; i < numActivities; i++) {
            int startTime = scanner.nextInt();
            int endtime = scanner.nextInt();

            times.put(startTime, new Pair(endtime, i));
        }

        Set<Map.Entry<Integer, Pair>> set = times.entrySet();
        Iterator<Map.Entry<Integer, Pair>> i = set.iterator();

        int cEndtime = 0;
        int jEndtime = 0;
        while(i.hasNext()) {
            Map.Entry<Integer, Pair> activity = i.next();

            // try assigning c

            if (activity.getKey() >= cEndtime) {
                schedule[activity.getValue().second] = 'C';
                cEndtime = activity.getValue().first;
                continue;
            }

            // try assigning j
            if (activity.getKey() >= jEndtime) {
                schedule[activity.getValue().second] = 'J';
                jEndtime = activity.getValue().first;
                continue;
            }


            // else we can't do it
            result = "IMPOSSIBLE";
            break;
        }

        if (result.equals("")) {
            result = new String(schedule);
        }

        System.out.println("Case #" + caseNumber + ": " + result);
    }
}