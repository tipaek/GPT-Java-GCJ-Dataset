import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i=1;i<=t;i++){
            solve(s, i);
        }
    }
//    public static final int C = 1;
//    public static final int J = 2;
    private static void solve(Scanner s, int testCases) {
        int n = s.nextInt();
        char[] sb = new char[n];
        int[][] time = new int[n][2];
        int[] im = new int[n];
//        int[] schedule = new int[n];
        int bc = 0;
        int bj = 0;
        for (int i=0;i<n;i++){
            time[i][0] = s.nextInt();
            time[i][1] = s.nextInt();
            int ti = i;
            im[i] = i;
            for (int j=i-1;j>-1;j--){
                if (time[j][0] > time[ti][0]){
                    int[] temp = time[j];
                    time[j] = time[ti];
                    time[ti] = temp;
                    int tmp = im[j];
                    im[j] = im[ti];
                    im[ti] = tmp;
                    ti = j;
                }
            }

        }



        for (int i=0;i<n;i++){
            if (bc <= time[i][0]){
                bc = time[i][1];
                sb[im[i]] = 'C';
            }
            else if (bj <= time[i][0]){
                bj = time[i][1];
                sb[im[i]] = 'J';
            }
            else{
                System.out.println(String.format("Case #%d: %s", testCases, "IMPOSSIBLE"));
                return;
            }
        }

        System.out.println(String.format("Case #%d: %s", testCases,new String(sb)));
    }


}
