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

        StringBuilder result = new StringBuilder();
        Map<Character, ArrayList<Pair>> scheduleMap = new HashMap<>();

        scheduleMap.put('J', new ArrayList<>());
        ArrayList<Pair> cSchedule = new ArrayList<>();
        cSchedule.add(new Pair(pairs.get(0).start, pairs.get(0).end));
        scheduleMap.put('C', cSchedule);
        result.append("C");

        for (int i = 1; i < pairs.size(); i++) {
            Pair currentPair = pairs.get(i);

            if (canAddToSchedule(scheduleMap.get('C'), currentPair)) {
                scheduleMap.get('C').add(currentPair);
                result.append("C");
            } else if (canAddToSchedule(scheduleMap.get('J'), currentPair)) {
                scheduleMap.get('J').add(currentPair);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    private static boolean canAddToSchedule(ArrayList<Pair> schedule, Pair newPair) {
        for (Pair pair : schedule) {
            if (isOverlapping(pair, newPair)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOverlapping(Pair pair1, Pair pair2) {
        return (pair2.start < pair1.end && pair2.end > pair1.start);
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
                scanner.nextLine();
                pairs.add(new Pair(start, end));
            }

            System.out.println("Case #" + caseNumber++ + ": " + solution(pairs));
        }

        scanner.close();
    }
}