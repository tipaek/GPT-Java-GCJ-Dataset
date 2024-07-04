import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int intervals = scanner.nextInt();
            Map<Integer, Set<Integer>> startMap = new HashMap<>();
            Map<Integer, Set<Integer>> endMap = new HashMap<>();
            Map<Integer, Set<Integer>> midMap = new HashMap<>();
            NavigableSet<Integer> allPoints = new TreeSet<>();
            int[] assignments = new int[intervals];
            
            for (int i = 0; i < intervals; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                startMap.computeIfAbsent(start, k -> new HashSet<>()).add(i);
                endMap.computeIfAbsent(end, k -> new HashSet<>()).add(i);
                allPoints.add(start);
                allPoints.add(end);
                
                for (Integer point : allPoints.subSet(start, false, end, false)) {
                    midMap.computeIfAbsent(point, k -> new HashSet<>()).add(i);
                }
            }
        }
    }
}