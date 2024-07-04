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
        if (pairs.isEmpty()) {
            return "";
        }

        StringBuilder ans = new StringBuilder();
        Map<Character, ArrayList<Pair>> scheduleMap = new HashMap<>();

        scheduleMap.put('J', new ArrayList<>());
        ArrayList<Pair> cSchedule = new ArrayList<>();
        cSchedule.add(pairs.get(0));
        scheduleMap.put('C', cSchedule);
        ans.append("C");

        for (int i = 1; i < pairs.size(); i++) {
            Pair current = pairs.get(i);
            boolean canAssignToC = canAssign(current, scheduleMap.get('C'));

            if (canAssignToC) {
                scheduleMap.get('C').add(current);
                ans.append("C");
                continue;
            }

            boolean canAssignToJ = canAssign(current, scheduleMap.get('J'));
            if (canAssignToJ) {
                scheduleMap.get('J').add(current);
                ans.append("J");
                continue;
            }

            return "IMPOSSIBLE";
        }

        return ans.toString();
    }

    private static boolean canAssign(Pair current, ArrayList<Pair> schedule) {
        for (Pair pair : schedule) {
            if ((current.end > pair.start && current.end <= pair.end) ||
                (current.start >= pair.start && current.start < pair.end) ||
                (current.start < pair.start && current.end > pair.end)) {
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
                String[] input = scanner.nextLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                pairs.add(new Pair(start, end));
            }

            System.out.println("Case #" + caseNumber++ + ": " + solution(pairs));
        }
    }
}