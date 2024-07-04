import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scan.nextInt();
            int[][] intervals = new int[n][2];
            int[] originalIndices = new int[n];
            char[] result = new char[n];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scan.nextInt();
                intervals[i][1] = scan.nextInt();
                originalIndices[i] = i;
            }
            
            quickSort(intervals, originalIndices, 0, n - 1);
            
            if (assignActivities(intervals, originalIndices, result)) {
                System.out.println("Case #" + t + ": " + new String(result));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        
        scan.close();
    }
    
    private static void quickSort(int[][] intervals, int[] indices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(intervals, indices, low, high);
            quickSort(intervals, indices, low, pivotIndex - 1);
            quickSort(intervals, indices, pivotIndex + 1, high);
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
    
    private static boolean assignActivities(int[][] intervals, int[] originalIndices, char[] result) {
        TreeSet<Integer> cSet = new TreeSet<>();
        TreeSet<Integer> jSet = new TreeSet<>();
        
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if (canAssign(cSet, start, end)) {
                result[originalIndices[i]] = 'C';
                addToSet(cSet, start, end);
            } else if (canAssign(jSet, start, end)) {
                result[originalIndices[i]] = 'J';
                addToSet(jSet, start, end);
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    private static boolean canAssign(TreeSet<Integer> set, int start, int end) {
        Integer floor = set.floor(start);
        Integer ceiling = set.ceiling(end - 1);
        return (floor == null || floor < start) && (ceiling == null || ceiling >= end);
    }
    
    private static void addToSet(TreeSet<Integer> set, int start, int end) {
        for (int i = start; i < end; i++) {
            set.add(i);
        }
    }
}