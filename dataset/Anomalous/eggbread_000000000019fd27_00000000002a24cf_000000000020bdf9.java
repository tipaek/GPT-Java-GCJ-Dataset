import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            int[][] activities = new int[N][3];
            
            for (int j = 0; j < N; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                activities[j][2] = j;
            }
            
            insertionSort(activities);
            
            boolean[] isBusy = new boolean[2];
            int[] endTime = new int[2];
            StringBuilder result = new StringBuilder();
            boolean impossible = false;
            
            for (int j = 0; j < N; j++) {
                if (activities[j][0] >= endTime[0]) {
                    isBusy[0] = false;
                }
                if (activities[j][0] >= endTime[1]) {
                    isBusy[1] = false;
                }
                if (isBusy[0] && isBusy[1]) {
                    System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
                if (!isBusy[0]) {
                    endTime[0] = activities[j][1];
                    result.append("C");
                    isBusy[0] = true;
                } else if (!isBusy[1]) {
                    endTime[1] = activities[j][1];
                    result.append("J");
                    isBusy[1] = true;
                }
            }
            
            if (!impossible) {
                System.out.print("Case #" + (t + 1) + ": ");
                char[] output = new char[N];
                for (int n = 0; n < N; n++) {
                    output[activities[n][2]] = result.charAt(n);
                }
                System.out.println(output);
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
}