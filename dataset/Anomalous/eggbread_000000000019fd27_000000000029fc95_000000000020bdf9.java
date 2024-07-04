import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] intervals = new int[N][3];
            
            for (int j = 0; j < N; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
                intervals[j][2] = j;
            }
            
            insertionSort(intervals);
            String result = assignTasks(intervals);
            
            if (result.equals("IMPOSSIBLE")) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                char[] output = new char[N];
                for (int j = 0; j < N; j++) {
                    output[intervals[j][2]] = result.charAt(j);
                }
                System.out.println("Case #" + (i + 1) + ": " + new String(output));
            }
        }
    }
    
    private static void insertionSort(int[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            int[] key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j][0] > key[0]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    private static String assignTasks(int[][] intervals) {
        int[] endTimes = new int[2]; // endTimes[0] for 'C', endTimes[1] for 'J'
        StringBuilder result = new StringBuilder();
        
        for (int[] interval : intervals) {
            if (interval[0] >= endTimes[0]) {
                endTimes[0] = interval[1];
                result.append('C');
            } else if (interval[0] >= endTimes[1]) {
                endTimes[1] = interval[1];
                result.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return result.toString();
    }
}