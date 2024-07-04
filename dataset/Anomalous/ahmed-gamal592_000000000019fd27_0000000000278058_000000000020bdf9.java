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
        scheduleMap.put('C', new ArrayList<>());

        scheduleMap.get('C').add(pairs.get(0));
        ans.append("C");

        for (int i = 1; i < pairs.size(); i++) {
            Pair current = pairs.get(i);

            if (isNonOverlapping(scheduleMap.get('C'), current)) {
                scheduleMap.get('C').add(current);
                ans.append("C");
            } else if (isNonOverlapping(scheduleMap.get('J'), current)) {
                scheduleMap.get('J').add(current);
                ans.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return ans.toString();
    }

    private static boolean isNonOverlapping(ArrayList<Pair> schedule, Pair current) {
        for (Pair pair : schedule) {
            if (!(current.end <= pair.start || current.start >= pair.end)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            ArrayList<Pair> pairs = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                pairs.add(new Pair(start, end));
            }

            String result = solution(pairs);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}