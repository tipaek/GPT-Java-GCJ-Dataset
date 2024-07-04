import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNum = 0; caseNum < testCases; caseNum++) {
            int numPairs = scanner.nextInt();
            ArrayList<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < numPairs; i++) {
                pairs.add(new Pair(scanner.nextInt(), scanner.nextInt()));
            }
            processCase(numPairs, pairs, caseNum);
        }
    }

    private static void processCase(int numPairs, ArrayList<Pair> pairs, int caseNum) {
        Collections.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.start != p2.start) {
                    return Integer.compare(p1.start, p2.start);
                } else {
                    return Integer.compare(p1.end, p2.end);
                }
            }
        });

        HashMap<Character, Integer> schedule = new HashMap<>();
        StringBuilder result = new StringBuilder("J");
        schedule.put('J', pairs.get(0).end);

        for (int i = 1; i < pairs.size(); i++) {
            Pair currentPair = pairs.get(i);
            if (schedule.get('J') <= currentPair.start) {
                schedule.put('J', currentPair.end);
                result.append('J');
            } else if (!schedule.containsKey('C') || schedule.get('C') <= currentPair.start) {
                schedule.put('C', currentPair.end);
                result.append('C');
            } else {
                result = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + caseNum + ": " + result.toString());
    }
}

class Pair {
    int start, end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}