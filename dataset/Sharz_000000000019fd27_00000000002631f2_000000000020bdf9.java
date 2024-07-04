import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            int n = in.nextInt();
            int arr[][] = new int[n][2];
            for (int itr = 0; itr < n; itr++) {
                arr[itr][0] = in.nextInt();
                arr[itr][1] = in.nextInt();
            }
            solve(arr, n);
        }
	}
	
	public static void solve (int arr[][], int n) {
        int dependencyMatrix[][] = new int[n][n];
        for (int j = 1; j < n; j++) {
            for (int k = j - 1; k>=0; k--) {
                if ((arr[k][0] <= arr[j][0] && arr[k][1] > arr[j][0])
                        || (arr[k][0] <= arr[j][1] && arr[k][1] > arr[j][1])) {
                    dependencyMatrix[j][k] = 1;
                }
            }
        }
        for (int j = 2; j<n; j++) {
            for (int k = 1; k<j; k++) {
                if (dependencyMatrix[j][k] == 1) {
                    if (dependencyMatrix[j][0] == 1 && dependencyMatrix[k][0] == 1) {
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                }
            }
        }

        String s = "";
        for (int itr = 0; itr < n; itr++) {
            if (dependencyMatrix[itr][0] == 1) {
                s += "J";
            } else
                s += "C";
        }
        System.out.println(s);
        return;
    }
}
