import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static String solution(ArrayList<Pair> pairs) {
        if (pairs.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        Map<Character, ArrayList<Pair>> scheduleMap = new HashMap<>();
        scheduleMap.put('J', new ArrayList<>());
        ArrayList<Pair> cSchedule = new ArrayList<>();
        cSchedule.add(new Pair(pairs.get(0).start, pairs.get(0).end));
        scheduleMap.put('C', cSchedule);
        result.append("C");

        for (int i = 1; i < pairs.size(); i++) {
            Pair current = pairs.get(i);
            boolean canAssignToC = canAssign(scheduleMap.get('C'), current);
            if (canAssignToC) {
                scheduleMap.get('C').add(current);
                result.append("C");
                continue;
            }

            boolean canAssignToJ = canAssign(scheduleMap.get('J'), current);
            if (canAssignToJ) {
                scheduleMap.get('J').add(current);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    private static boolean canAssign(ArrayList<Pair> schedule, Pair current) {
        for (Pair p : schedule) {
            if ((current.start >= p.start && current.end <= p.end) ||
                (current.start >= p.start && current.start < p.end) ||
                (current.start <= p.start && current.end >= p.start)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine();

            ArrayList<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                pairs.add(new Pair(start, end));
            }

            System.out.println("Case #" + caseNumber++ + ": " + solution(pairs));
        }
    }
}