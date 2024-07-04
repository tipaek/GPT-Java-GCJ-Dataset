import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[][] arr = new int[N][2];
            for (int j = 0; j < N; j++) {
                arr[j][0] = scanner.nextInt();
                arr[j][1] = scanner.nextInt();
            }
            String s = helper(N, arr);
            System.out.printf("Case #%d: %s\n", i + 1, s);
        }
    }
    
    public static String helper(int N, int[][] arr) {
        //add idx to arr
        int[][] arrWithIdx = new int[N][3];
        for (int i = 0; i < N; i++) {
            arrWithIdx[i][0] = arr[i][0];
            arrWithIdx[i][1] = arr[i][1];
            arrWithIdx[i][2] = i;
        }
        //sort by arrWithIdx[i][0]
        Arrays.sort(arrWithIdx, (a, b) -> a[0] - b[0]);
        //decide who work
        int C = 0; //zero at [0]
        int J = -1; //one at [0]
        int[][] pair = new int[N][2];
        pair[0][0] = 0;
        pair[0][1] = arrWithIdx[0][2];
        for (int i = 1; i < N; i++) {
            pair[i][1] = arrWithIdx[i][2];
            if (arrWithIdx[i][0] >= arrWithIdx[C][1]) {
                pair[i][0] = 0;
                C = i;
            } else if (J == -1 || arrWithIdx[i][0] >= arrWithIdx[J][1]) {
                pair[i][0] = 1;
                J = i;
            } else {
                return "IMPOSSIBLE";
            }
        }
        //sort pair by idx, and then build ans
        Arrays.sort(pair, (a, b) -> a[1] - b[1]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (pair[i][0] == 0) {
                sb.append("C");
            } else {
                sb.append("J");
            }
        }
        String s = sb.toString();
        return s;
    }
}