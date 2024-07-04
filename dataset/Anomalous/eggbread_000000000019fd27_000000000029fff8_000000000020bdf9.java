import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }
            
            insertionSort(intervals);
            boolean[] assigned = new boolean[2];
            int[] endTime = new int[2];
            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;
            
            for (int i = 0; i < n; i++) {
                if (intervals[i][0] >= endTime[0]) {
                    assigned[0] = false;
                }
                if (intervals[i][0] >= endTime[1]) {
                    assigned[1] = false;
                }
                
                if (!assigned[0]) {
                    endTime[0] = intervals[i][1];
                    schedule.append("C");
                    assigned[0] = true;
                } else if (!assigned[1]) {
                    endTime[1] = intervals[i][1];
                    schedule.append("J");
                    assigned[1] = true;
                } else {
                    if (endTime[0] <= intervals[i][0]) {
                        endTime[0] = intervals[i][1];
                        schedule.append("C");
                    } else if (endTime[1] <= intervals[i][0]) {
                        endTime[1] = intervals[i][1];
                        schedule.append("J");
                    } else {
                        System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }
            }
            
            if (!impossible) {
                System.out.print("Case #" + (t + 1) + ": ");
                char[] result = new char[n];
                for (int i = 0; i < n; i++) {
                    result[intervals[i][2]] = schedule.charAt(i);
                }
                System.out.println(new String(result));
            }
        }
        
        scanner.close();
    }
    
    private static void insertionSort(int[][] array) {
        for (int i = 1; i < array.length; i++) {
            int[] key = array[i];
            int j = i - 1;
            
            while (j >= 0 && array[j][0] > key[0]) {
                array[j + 1] = array[j];
                j--;
            }
            
            array[j + 1] = key;
        }
    }
}