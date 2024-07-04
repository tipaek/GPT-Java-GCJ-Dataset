import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public static int countDiffC(int[][] arr) {
        int count = 0;
        for (int j = 0; j < arr.length; ++j) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < arr.length; ++i) {
                if (set.contains(arr[i][j])) {
                    count++;
                    break;
                }
                set.add(arr[i][j]);
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; ++i) {
            int N = scan.nextInt();
            int[][] arr = new int[N][N];
            int traces = 0;
            int countR = 0;
            for (int j = 0; j < N; ++j) {
                HashSet<Integer> set = new HashSet<>();
                boolean repeated = false;
                for (int k = 0; k < N; ++k) {
                    arr[j][k] = scan.nextInt();
                    if (j == k) traces += arr[j][k];
                    if (!repeated && set.contains(arr[j][k])) {
                        countR++;
                        repeated = true;
                    }
                    set.add(arr[j][k]);
                }
            }
            int countC = countDiffC(arr);
            answer.append("Case #" + (i + 1) + ": " + traces + " " + countR + " " + countC + "\n");
        }
        System.out.println(answer);
    }
}