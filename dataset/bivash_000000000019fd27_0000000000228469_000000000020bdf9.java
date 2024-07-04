import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = input.nextInt();
        String[] ans = new String[t];
        boolean isJamAvail = true, isCamAvail = true;
        for(int a=0; a<t; a++) {
            int n = input.nextInt();
            int[][] time = new int[n][2];
            String work = "CJ";
            for(int i=0; i<n; i++) {
                for(int j=0; j<2; j++) {
                    time[i][j] = input.nextInt();
                }
            }
            int camStart = time[0][0], camEnd = time[0][1];
            int jamStart = time[1][0], jamEnd = time[1][1];
            for(int i=2; i<n; i++) {
                if(time[i][0] >= camEnd || time[i][1]<=camStart) {
                    work += "C";
                    camStart = time[i][0];
                    camEnd = time[i][1];
                }
                else if(time[i][0] >= jamEnd || time[i][1] <= jamStart) {
                    work += "J";
                    jamStart = time[i][0];
                    jamEnd = time[i][1];
                }
                else {
                    work = "IMPOSSIBLE";
                    break;
                }
            }
            ans[a] = work;
        }
        
        for(int i=0; i<t; i++) {
            System.out.println("Case #"+(i+1)+": "+ans[i]);
        }
    }
}