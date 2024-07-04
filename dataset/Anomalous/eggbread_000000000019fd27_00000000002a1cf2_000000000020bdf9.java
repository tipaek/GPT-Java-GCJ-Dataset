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
            
            boolean[] isOccupied = new boolean[2];
            int[] endTime = new int[2];
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;
            
            for (int j = 0; j < N; j++) {
                if (intervals[j][0] > endTime[0]) {
                    isOccupied[0] = false;
                }
                if (intervals[j][0] > endTime[1]) {
                    isOccupied[1] = false;
                }
                
                if (!isOccupied[0]) {
                    endTime[0] = intervals[j][1];
                    result.append("C");
                    isOccupied[0] = true;
                } else if (!isOccupied[1]) {
                    endTime[1] = intervals[j][1];
                    result.append("J");
                    isOccupied[1] = true;
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }
            
            if (!isImpossible) {
                System.out.print("Case #" + (i + 1) + ": ");
                char[] output = new char[N];
                for (int n = 0; n < N; n++) {
                    output[intervals[n][2]] = result.charAt(n);
                }
                System.out.println(new String(output));
            }
        }
        
        scanner.close();
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
}