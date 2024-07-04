import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];
            int[] indices = new int[n];
            char[] result = new char[n];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
                indices[i] = i;
            }
            
            quickSort(intervals, indices, 0, n - 1);
            
            HashSet<Integer> cameron = new HashSet<>();
            HashSet<Integer> jamie = new HashSet<>();
            boolean possible = true;
            
            for (int i = 0; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                
                if (canAssign(jamie, start, end)) {
                    result[indices[i]] = 'J';
                    addTimeRange(jamie, start, end);
                } else if (canAssign(cameron, start, end)) {
                    result[indices[i]] = 'C';
                    addTimeRange(cameron, start, end);
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.println("Case #" + t + ": " + new String(result));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
    
    private static void quickSort(int[][] intervals, int[] indices, int low, int high) {
        if (low < high) {
            int pi = partition(intervals, indices, low, high);
            quickSort(intervals, indices, low, pi - 1);
            quickSort(intervals, indices, pi + 1, high);
        }
    }
    
    private static int partition(int[][] intervals, int[] indices, int low, int high) {
        int pivot = intervals[high][0];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (intervals[j][0] < pivot) {
                i++;
                swap(intervals, indices, i, j);
            }
        }
        
        swap(intervals, indices, i + 1, high);
        return i + 1;
    }
    
    private static void swap(int[][] intervals, int[] indices, int i, int j) {
        int[] tempInterval = intervals[i];
        intervals[i] = intervals[j];
        intervals[j] = tempInterval;
        
        int tempIndex = indices[i];
        indices[i] = indices[j];
        indices[j] = tempIndex;
    }
    
    private static boolean canAssign(HashSet<Integer> set, int start, int end) {
        for (int k = start; k < end; k++) {
            if (set.contains(k)) {
                return false;
            }
        }
        return true;
    }
    
    private static void addTimeRange(HashSet<Integer> set, int start, int end) {
        for (int k = start; k < end; k++) {
            set.add(k);
        }
    }
}