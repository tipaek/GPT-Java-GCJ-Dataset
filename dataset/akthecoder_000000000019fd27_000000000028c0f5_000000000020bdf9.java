import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        for(int i = 0; i < testCases; i++) {
            int N = scan.nextInt();
            int time[][] = new int[N][2];

            for(int r = 0; r < N; r++) {
                for(int c = 0; c < 2; c++) {
                    time[r][c] = scan.nextInt();
                }
            }
            bubbleSort(time, N);
            System.out.println("Case #" + (i + 1) + ": " +  calculatePartnering(time, N));
        }
        scan.close();
    }

    public static void bubbleSort(int arr[][] , int n) {
        if (n == 1) 
            return; 
       
        for (int i=0; i<n-1; i++) 
            if (arr[i][0] > arr[i+1][0]) 
            { 
                int temp0 = arr[i][0];
                int temp1 = arr[i][1];

                arr[i][0] = arr[i+1][0];
                arr[i][1] = arr[i+1][1];

                arr[i+1][0] = temp0;
                arr[i+1][1] = temp1;
            } 
       
        bubbleSort(arr, n-1);   
    }

    public static String calculatePartnering(int[][] time, int N) {
        String result = "";
        int JE = 0;
        int CE = 0;
        
        for(int i = 0; i < N; i++) {
            int ST = time[i][0];
            if(JE <= ST) {
                JE = time[i][1];
                result += "J";
            }
            else if(CE <= ST) {
                CE = time[i][1];
                result += "C";
            }
            else {
                return "IMPOSSIBLE";
            }
        }

        return result;
    }
}