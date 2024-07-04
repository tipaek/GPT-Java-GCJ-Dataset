import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 0; caseNum < testCases; caseNum++) {
            int n = scanner.nextInt();
            Map<Integer, Set<Integer>> startTimes = new HashMap<>();
            Map<Integer, Set<Integer>> endTimes = new HashMap<>();
            NavigableSet<Integer> allTimes = new TreeSet<>();
            int currentC = -1;
            int currentJ = -1;
            char[] assignments = new char[n];
            boolean isImpossible = false;
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                startTimes.computeIfAbsent(start, k -> new HashSet<>()).add(i);
                if (startTimes.get(start).size() > 2) {
                    isImpossible = true;
                    break;
                }
                
                endTimes.computeIfAbsent(end, k -> new HashSet<>()).add(i);
                if (endTimes.get(end).size() > 2) {
                    isImpossible = true;
                    break;
                }
                
                allTimes.add(start);
                allTimes.add(end);
            }
            
            for (Integer time : allTimes) {
                if (endTimes.containsKey(time)) {
                    for (Integer task : endTimes.get(time)) {
                        if (currentC == task) currentC = -1;
                        if (currentJ == task) currentJ = -1;
                    }
                }
                
                if (startTimes.containsKey(time)) {
                    for (Integer task : startTimes.get(time)) {
                        if (currentC == -1) {
                            assignments[task] = 'C';
                            currentC = task;
                        } else if (currentJ == -1) {
                            assignments[task] = 'J';
                            currentJ = task;
                        } else {
                            isImpossible = true;
                            break;
                        }
                    }
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + (caseNum + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (caseNum + 1) + ": ");
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }
        }
        
        scanner.close();
    }
}