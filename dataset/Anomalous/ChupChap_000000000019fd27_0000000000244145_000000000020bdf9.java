import java.util.*;
import java.io.*;

public class Solution {
    
    public static String sequence(int[][] arr, int N) {
        int[] ar = new int[N];
        ar[0] = 1;

        for (int i = 1; i < N; i++) {
            boolean isPossible = true;
            for (int j = 0; j < i; j++) {
                if ((arr[i][0] > arr[j][0] && arr[i][0] < arr[j][1]) || 
                    (arr[i][1] > arr[j][0] && arr[i][1] < arr[j][1]) ||
                    (arr[i][0] < arr[j][0] && arr[i][1] > arr[j][1])) {
                    isPossible = false;
                    break;
                }
            }
            ar[i] = isPossible ? 0 : 1;
        }

        StringBuilder seq = new StringBuilder("C");
        for (int k = 1; k < N; k++) {
            seq.append(ar[k] == 1 ? "C" : "J");
        }
        return seq.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Number of test cases
        for (int i = 1; i <= T; ++i) {
            int N = in.nextInt();
            int[][] arr = new int[N][2];
            for (int j = 0; j < N; j++) {
                arr[j][0] = in.nextInt();
                arr[j][1] = in.nextInt();
            }
            String seq = sequence(arr, N);
            System.out.println("Case #" + i + ": " + seq);
        }
    }
}