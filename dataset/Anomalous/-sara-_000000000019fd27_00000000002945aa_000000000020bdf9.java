import java.util.*;
import java.util.stream.Collectors;

public abstract class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[] overlaps = new int[1440];
            Map<Integer, Integer> beginTimes = new HashMap<>();
            Map<Integer, Integer> endTimes = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                int beginTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                beginTimes.put(i, beginTime);
                endTimes.put(i, endTime);
                for (int j = beginTime; j < endTime; j++) {
                    overlaps[j]++;
                }
            }
            
            String solution = determineSolution(n, overlaps, beginTimes, endTimes);
            System.out.println("Case #" + caseNumber + ": " + solution);
        }
        scanner.close();
    }
    
    private static String determineSolution(int n, int[] overlaps, Map<Integer, Integer> beginTimes, Map<Integer, Integer> endTimes) {
        if (Arrays.stream(overlaps).anyMatch(overlap -> overlap >= 3)) {
            return "IMPOSSIBLE";
        }
        
        if (Arrays.stream(overlaps).noneMatch(overlap -> overlap == 2)) {
            return "J".repeat(n);
        }
        
        Map<Integer, String> assignments = new HashMap<>();
        int lastEndTime = -1;
        String lastAssignment = "J";
        
        Map<Integer, Integer> sortedBeginTimes = beginTimes.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                          (e1, e2) -> e1, LinkedHashMap::new));
        
        for (int choreNumber : sortedBeginTimes.keySet()) {
            int beginTime = sortedBeginTimes.get(choreNumber);
            if (assignments.isEmpty()) {
                assignments.put(choreNumber, "J");
                lastEndTime = endTimes.get(choreNumber);
            } else {
                if (beginTime >= lastEndTime) {
                    assignments.put(choreNumber, lastAssignment);
                } else {
                    lastAssignment = lastAssignment.equals("J") ? "C" : "J";
                    assignments.put(choreNumber, lastAssignment);
                }
                lastEndTime = endTimes.get(choreNumber);
            }
        }
        
        StringBuilder solution = new StringBuilder();
        for (int i = 0; i < n; i++) {
            solution.append(assignments.get(i));
        }
        return solution.toString();
    }
}