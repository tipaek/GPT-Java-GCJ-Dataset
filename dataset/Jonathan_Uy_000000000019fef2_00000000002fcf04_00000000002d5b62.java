import java.io.*;
import java.util.*;

/**
 * Problem 1
 */

public class Solution {
    public static String f(String original, boolean x, boolean y){
        String result = "";
        for(int i = 0; i < original.length(); i++){
            if(original.charAt(i) == 'N')
                result += y ? "S" : "N";
            if(original.charAt(i) == 'S')
                result += y ? "N" : "S";
            if(original.charAt(i) == 'E')
                result += x ? "W" : "E";
            if(original.charAt(i) == 'W')
                result += x ? "E" : "W";
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        String[][] dp = new String[5][5];
        dp[0][1] = "N";
        dp[1][0] = "E";
        dp[0][3] = "NN";
        dp[3][0] = "EE";
        dp[1][2] = "EN";
        dp[2][1] = "NE";
        dp[1][4] = "WEN";
        dp[4][1] = "SNE";
        dp[2][3] = "SEN";
        dp[3][2] = "WNE";
        dp[3][4] = "EEN";
        dp[4][3] = "NNE";
        
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            
            if(-4 > X || X > 4 || -4 > Y || Y > 4)  break;
            
            String answer = dp[Math.abs(X)][Math.abs(Y)];
            if(answer == null)  System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            else {
                answer = f(answer, X < 0, Y < 0);
                System.out.printf("Case #%d: %s\n", t, answer);
            }
        }
    }
}