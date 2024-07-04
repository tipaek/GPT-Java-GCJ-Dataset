import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            Map<Integer, Set<Integer>> startTimes = new HashMap<>();
            Map<Integer, Set<Integer>> endTimes = new HashMap<>();
            NavigableSet<Integer> allTimes = new TreeSet<>();
            int C = -1, J = -1;
            char[] assignments = new char[n];
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                startTimes.computeIfAbsent(start, k -> new HashSet<>()).add(i);
                endTimes.computeIfAbsent(end, k -> new HashSet<>()).add(i);
                allTimes.add(start);
                allTimes.add(end);
            }

            for (int time : allTimes) {
                if (endTimes.containsKey(time)) {
                    for (int index : endTimes.get(time)) {
                        if (C == index) C = -1;
                        if (J == index) J = -1;
                    }
                }

                if (startTimes.containsKey(time)) {
                    for (int index : startTimes.get(time)) {
                        if (C == -1) {
                            assignments[index] = 'C';
                            C = index;
                        } else if (J == -1) {
                            assignments[index] = 'J';
                            J = index;
                        } else {
                            isImpossible = true;
                            break;
                        }
                    }
                }

                if (isImpossible) break;
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + caseNum + ": ");
                System.out.println(new String(assignments));
            }
        }

        scanner.close();
    }
}