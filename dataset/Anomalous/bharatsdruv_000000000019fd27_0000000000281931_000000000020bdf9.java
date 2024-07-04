import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        for (int tc = 1; tc <= testcases; tc++) {
            int N = in.nextInt();
            int[] startO = new int[N];
            int[] endO = new int[N];
            int[] index = new int[N];
            char[] result = new char[N];
            
            for (int n = 0; n < N; n++) {
                startO[n] = in.nextInt();
                endO[n] = in.nextInt();
                index[n] = n;
            }
            
            // Sort activities by start time using a simple bubble sort
            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < N - i - 1; j++) {
                    if (startO[j] > startO[j + 1]) {
                        // Swap start times
                        int temp = startO[j];
                        startO[j] = startO[j + 1];
                        startO[j + 1] = temp;
                        
                        // Swap end times
                        temp = endO[j];
                        endO[j] = endO[j + 1];
                        endO[j + 1] = temp;
                        
                        // Swap indices
                        temp = index[j];
                        index[j] = index[j + 1];
                        index[j + 1] = temp;
                    }
                }
            }
            
            int C_end = 0, J_end = 0;
            boolean possible = true;
            for (int n = 0; n < N; n++) {
                if (startO[n] >= C_end) {
                    result[index[n]] = 'C';
                    C_end = endO[n];
                } else if (startO[n] >= J_end) {
                    result[index[n]] = 'J';
                    J_end = endO[n];
                } else {
                    possible = false;
                    break;
                }
            }
            
            System.out.print("Case #" + tc + ": ");
            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (char c : result) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
        in.close();
    }
}