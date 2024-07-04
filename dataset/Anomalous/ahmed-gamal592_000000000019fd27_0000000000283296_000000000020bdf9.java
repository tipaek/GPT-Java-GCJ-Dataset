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
        ArrayList<Pair> initialSchedule = new ArrayList<>();
        initialSchedule.add(new Pair(pairs.get(0).start, pairs.get(0).end));
        scheduleMap.put('C', initialSchedule);
        result.append("C");

        for (int i = 1; i < pairs.size(); i++) {
            Pair currentPair = pairs.get(i);
            ArrayList<Pair> cameronSchedule = scheduleMap.get('C');

            boolean canAssignToCameron = canAssign(cameronSchedule, currentPair);
            if (canAssignToCameron) {
                cameronSchedule.add(currentPair);
                scheduleMap.put('C', cameronSchedule);
                result.append("C");
                continue;
            }

            ArrayList<Pair> jamieSchedule = scheduleMap.get('J');
            boolean canAssignToJamie = canAssign(jamieSchedule, currentPair);
            if (canAssignToJamie) {
                jamieSchedule.add(currentPair);
                scheduleMap.put('J', jamieSchedule);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    private static boolean canAssign(ArrayList<Pair> schedule, Pair newPair) {
        for (Pair pair : schedule) {
            if ((newPair.start <= pair.start && newPair.end > pair.start) ||
                (newPair.start < pair.end && newPair.end >= pair.end) ||
                (newPair.start >= pair.start && newPair.end <= pair.end)) {
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
                String[] timeRange = scanner.nextLine().split(" ");
                int from = Integer.parseInt(timeRange[0]);
                int to = Integer.parseInt(timeRange[1]);
                pairs.add(new Pair(from, to));
            }

            System.out.println("Case #" + caseNumber++ + ": " + solution(pairs));
        }
    }
}