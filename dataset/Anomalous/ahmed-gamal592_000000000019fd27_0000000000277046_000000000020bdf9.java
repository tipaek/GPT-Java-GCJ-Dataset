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

        StringBuilder answer = new StringBuilder();
        Map<Character, ArrayList<Pair>> scheduleMap = new HashMap<>();
        scheduleMap.put('J', new ArrayList<>());
        scheduleMap.put('C', new ArrayList<>());

        scheduleMap.get('C').add(pairs.get(0));
        answer.append("C");

        for (int i = 1; i < pairs.size(); i++) {
            Pair currentPair = pairs.get(i);

            if (canAssign(scheduleMap.get('C'), currentPair)) {
                scheduleMap.get('C').add(currentPair);
                answer.append("C");
            } else if (canAssign(scheduleMap.get('J'), currentPair)) {
                scheduleMap.get('J').add(currentPair);
                answer.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return answer.toString();
    }

    private static boolean canAssign(ArrayList<Pair> schedule, Pair currentPair) {
        for (Pair pair : schedule) {
            if ((currentPair.start < pair.end && currentPair.end > pair.start)) {
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
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                pairs.add(new Pair(start, end));
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }

            System.out.println("Case #" + caseNumber++ + ": " + solution(pairs));
        }
    }
}