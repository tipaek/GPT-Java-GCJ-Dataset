import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            Map<List<Integer>, Integer> taskIndexMap = new HashMap<>();
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int j = 0; j < n; j++) {
                startTimes[j] = sc.nextInt();
                endTimes[j] = sc.nextInt();
                taskIndexMap.put(Arrays.asList(startTimes[j], endTimes[j]), j);
            }
            
            boolean[] isCameron = new boolean[n];
            int[][] sortedTasks = sortTasks(startTimes, endTimes, n);
            
            for (int j = 0; j < n; j++) {
                startTimes[j] = sortedTasks[j][0];
                endTimes[j] = sortedTasks[j][1];
            }
            
            Set<Integer> cameronTasks = findNonOverlappingTasks(startTimes, endTimes, n);
            int[] remainingStartTimes = new int[n - cameronTasks.size()];
            int[] remainingEndTimes = new int[n - cameronTasks.size()];
            Map<Integer, Integer> indexMap = new HashMap<>();
            
            int k = 0;
            for (int j = 0; j < n; j++) {
                if (!cameronTasks.contains(j)) {
                    remainingStartTimes[k] = startTimes[j];
                    indexMap.put(j, k);
                    remainingEndTimes[k++] = endTimes[j];
                }
            }
            
            Set<Integer> jamieTasks = findNonOverlappingTasks(remainingStartTimes, remainingEndTimes, n - cameronTasks.size());
            boolean isImpossible = false;
            
            for (int j = 0; j < n; j++) {
                if (!jamieTasks.contains(indexMap.get(j)) && !cameronTasks.contains(j)) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }
            
            for (int j = 0; j < n; j++) {
                if (cameronTasks.contains(j)) {
                    isCameron[j] = true;
                }
            }
            
            if (!isImpossible) {
                char[] result = new char[n];
                for (int j = 0; j < n; j++) {
                    List<Integer> task = Arrays.asList(startTimes[j], endTimes[j]);
                    int originalIndex = taskIndexMap.get(task);
                    result[originalIndex] = isCameron[j] ? 'C' : 'J';
                }
                System.out.println("Case #" + (i + 1) + ": " + new String(result));
            }
        }
        
        sc.close();
    }

    private static int[][] sortTasks(int[] startTimes, int[] endTimes, int n) {
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            tasks[i][0] = startTimes[i];
            tasks[i][1] = endTimes[i];
        }
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
        return tasks;
    }

    private static Set<Integer> findNonOverlappingTasks(int[] startTimes, int[] endTimes, int n) {
        Set<Integer> nonOverlappingTasks = new HashSet<>();
        int lastEndTime = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || startTimes[i] >= lastEndTime) {
                nonOverlappingTasks.add(i);
                lastEndTime = endTimes[i];
            }
        }
        return nonOverlappingTasks;
    }
}