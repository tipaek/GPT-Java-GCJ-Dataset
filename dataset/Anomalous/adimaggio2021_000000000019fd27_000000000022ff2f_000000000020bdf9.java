import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int m = 0; m < n; m++) {
            int x = in.nextInt();
            int[][] intervals = new int[x][2];
            int[] order = new int[24 * 60 + 1];
            
            for (int i = 0; i < x; i++) {
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();
                order[intervals[i][0]] = i;
            }
            
            if (isSchedulable(intervals)) {
                char[] schedule = new char[x];
                sort(intervals, 0, x - 1);
                assignTasks(intervals, order, schedule);
                System.out.println("Case #" + (m + 1) + ": " + new String(schedule));
            } else {
                System.out.println("Case #" + (m + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isSchedulable(int[][] intervals) {
        int[] timeline = new int[24 * 60 + 1];
        for (int[] interval : intervals) {
            timeline[interval[0]]++;
            timeline[interval[1]]--;
        }
        
        int ongoingTasks = 0;
        for (int count : timeline) {
            ongoingTasks += count;
            if (ongoingTasks > 2) {
                return false;
            }
        }
        return true;
    }

    private static void assignTasks(int[][] intervals, int[] order, char[] schedule) {
        int endC = -1, endJ = -1;
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int idx = order[start];
            if (start >= endC) {
                endC = end;
                schedule[idx] = 'C';
            } else if (start >= endJ) {
                endJ = end;
                schedule[idx] = 'J';
            }
        }
    }

    private static void sort(int[][] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[][] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[][] L = new int[n1][2];
        int[][] R = new int[n2][2];
        
        for (int i = 0; i < n1; i++) {
            L[i][0] = arr[l + i][0];
            L[i][1] = arr[l + i][1];
        }
        for (int j = 0; j < n2; j++) {
            R[j][0] = arr[m + 1 + j][0];
            R[j][1] = arr[m + 1 + j][1];
        }
        
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i][0] <= R[j][0]) {
                arr[k][0] = L[i][0];
                arr[k][1] = L[i][1];
                i++;
            } else {
                arr[k][0] = R[j][0];
                arr[k][1] = R[j][1];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k][0] = L[i][0];
            arr[k][1] = L[i][1];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k][0] = R[j][0];
            arr[k][1] = R[j][1];
            j++;
            k++;
        }
    }
}