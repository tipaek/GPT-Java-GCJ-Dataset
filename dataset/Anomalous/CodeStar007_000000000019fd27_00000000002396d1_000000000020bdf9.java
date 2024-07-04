import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int numOfPairs = scanner.nextInt();
            ArrayList<Pair> pairs = new ArrayList<>();

            for (int i = 0; i < numOfPairs; i++) {
                pairs.add(new Pair(scanner.nextInt(), scanner.nextInt()));
            }

            processCase(numOfPairs, pairs, caseNumber++);
        }
    }

    static void processCase(int numOfPairs, ArrayList<Pair> pairs, int caseNumber) {
        Collections.sort(pairs, (pair1, pair2) -> {
            if (pair1.start != pair2.start) {
                return Integer.compare(pair1.start, pair2.start);
            }
            return Integer.compare(pair1.end, pair2.end);
        });

        HashMap<Character, Integer> schedule = new HashMap<>();
        StringBuilder result = new StringBuilder("J");
        schedule.put('J', pairs.get(0).end);

        for (int i = 1; i < pairs.size(); i++) {
            Pair currentPair = pairs.get(i);
            if (schedule.get('J') <= currentPair.start) {
                schedule.put('J', currentPair.end);
                result.append("J");
            } else if (!schedule.containsKey('C') || schedule.get('C') <= currentPair.start) {
                schedule.put('C', currentPair.end);
                result.append("C");
            } else {
                result = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}

class Pair {
    int start, end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}