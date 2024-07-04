import java.util.*;

class Solution
{
    // Indicium
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        if (t>=1 && t<=100) {
            
            for (int x=0; x<t; x++) {
                int n = in.nextInt();
                if (n>=2 && n<=50) {
                    int[][] arr = new int[n][n];
                    for (int j=0; j<n; j++) {
                        int sum = j+1;
                        for (int i=0; i<n; i++) {
                            arr[i][j] = sum % n+1;
                            if (sum == n) {
                                sum = 0;
                            }
                            sum++;
                        }
                    }
                    int k = in.nextInt();
                    if (k>=n && k<=n*n) {
                        processArray(arr, x+1, k);
                    }
                }
            }
        }
    }
    
    private static void processArray(int[][] arr, int c, int k) {
        int trace = 0;
        int swapCounter = 0;
        boolean flag = false;
        while (swapCounter<=arr.length) {
            // compute trace
            for (int i=0; i<arr.length; i++) {
                for (int j=0; j<arr.length; j++) {
                    if (i==j) {
                       trace = trace + arr[i][j]; 
                    }
                }
            }
            
            // compare trace
            if (trace==k) {
                flag = true;
                break;
            }
            else {
                // swap
                if (arr.length>2) {
                    for (int i=0; i<arr.length; i++) {
                        int t = arr[i][0]; 
                        arr[i][0] = arr[i][i+1]; 
                        arr[i][i+1] = t; 
                    }
                }
                swapCounter++;
            }
        }
        
        if (flag) {
            System.out.println("Case #" + c + ": " + "POSSIBLE");
            // print array
            for (int i=0; i<arr.length; i++) { 
                for (int j=0; j<arr.length; j++) {
                    System.out.print(arr[i][j] + " "); 
                     
                }
                System.out.println("");
            }
        }
        else {
            System.out.println("Case #" + c + ": " + "IMPOSSIBLE");
        }
    }
}
