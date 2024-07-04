import java.io.*;
import java.util.*;

public class Solution {

    public String solve(int[][] times){
        int[][] cTime = new int[times.length][2];
        int[][] jTime = new int[times.length][2];
        boolean canC;
        boolean canJ;
        String retVal = "";
        int cIndex = 0;
        int jIndex = 0;
        for (int[] activity :times){
            canC = true;
            canJ = true;
            for(int[] c: cTime){
                if((activity[0]>c[0] && activity[0] <c[1] ) || (activity[1]>c[0] && activity[1] <c[1] ) || (activity[0]<c[0] && activity[1]>c[1])){
                    canC = false;
                }
            }
            if(canC){
                cTime[cIndex] = activity;
                cIndex ++;
                retVal+="C";
            }
            else{
                for(int[] j : jTime){
                    if((activity[0]>j[0] && activity[0] <j[1] ) || (activity[1]>j[0] && activity[1] <j[1] ) || (activity[0]<j[0] && activity[1]>j[1])){
                        canJ = false;
                    }
                }
                if(canJ){
                    jTime[jIndex] = activity;
                    jIndex++;
                    retVal+="J";
                }
                else{
                    return"IMPOSSIBLE";
                }
            }
        }
        return retVal;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution app = new Solution();
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][2];
            for(int j=0; j<n; j++){
                for( int k=0; k<2; k++){
                    matrix[j][k] = in.nextInt();
                }
            }
            String solved = app.solve(matrix);
            System.out.println("Case #" + i + ": " + solved);
        }
    }


}
