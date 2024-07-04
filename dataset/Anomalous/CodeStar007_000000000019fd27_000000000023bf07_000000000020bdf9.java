import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            int numPairs = scanner.nextInt();
            ArrayList<Pair> pairs = new ArrayList<>();
            
            for (int i = 0; i < numPairs; i++) {
                pairs.add(new Pair(scanner.nextInt(), scanner.nextInt()));
            }
            
            processCase(numPairs, pairs, caseNumber++);
        }
    }

    static void processCase(int numPairs, ArrayList<Pair> pairs, int caseNumber) {
        Collections.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.start != p2.start) {
                    return Integer.compare(p1.start, p2.start);
                }
                return Integer.compare(p1.end, p2.end);
            }
        });

        HashMap<Character, Integer> scheduleMap = new HashMap<>();
        StringBuilder result = new StringBuilder("J");
        scheduleMap.put('J', pairs.get(0).end);

        for (int i = 1; i < pairs.size(); i++) {
            Pair currentPair = pairs.get(i);
            
            if (scheduleMap.get('J') <= currentPair.start) {
                scheduleMap.put('J', currentPair.end);
                result.append("J");
            } else if (!scheduleMap.containsKey('C') || scheduleMap.get('C') <= currentPair.start) {
                scheduleMap.put('C', currentPair.end);
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