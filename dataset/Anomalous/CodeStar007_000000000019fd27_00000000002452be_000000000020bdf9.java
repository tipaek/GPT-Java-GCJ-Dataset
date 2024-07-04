import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int N = scanner.nextInt();
            List<Pair> activities = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                activities.add(new Pair(scanner.nextInt(), scanner.nextInt(), i));
            }
            
            solve(N, activities, caseNumber);
        }
    }

    static void solve(int N, List<Pair> activities, int caseNumber) {
        activities.sort(Comparator.comparingInt((Pair p) -> p.S).thenComparingInt(p -> p.E));

        Map<Character, Integer> endTimeMap = new HashMap<>();
        List<Assignment> assignments = new ArrayList<>();
        
        endTimeMap.put('J', activities.get(0).E);
        assignments.add(new Assignment('J', activities.get(0).index));

        for (int i = 1; i < activities.size(); i++) {
            Pair current = activities.get(i);
            boolean assigned = false;

            if (endTimeMap.get('J') <= current.S) {
                endTimeMap.put('J', current.E);
                assignments.add(new Assignment('J', current.index));
                assigned = true;
            } else if (!endTimeMap.containsKey('C') || endTimeMap.get('C') <= current.S) {
                endTimeMap.put('C', current.E);
                assignments.add(new Assignment('C', current.index));
                assigned = true;
            }

            if (!assigned) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        assignments.sort(Comparator.comparingInt(a -> a.idx));
        StringBuilder result = new StringBuilder();
        
        for (Assignment assignment : assignments) {
            result.append(assignment.c);
        }
        
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}

class Pair {
    int S, E, index;

    Pair(int S, int E, int index) {
        this.S = S;
        this.E = E;
        this.index = index;
    }
}

class Assignment {
    char c;
    int idx;

    Assignment(char c, int idx) {
        this.c = c;
        this.idx = idx;
    }
}