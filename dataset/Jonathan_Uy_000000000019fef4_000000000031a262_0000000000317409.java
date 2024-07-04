import java.io.*;
import java.util.*;

public class Solution {
    static int X, Y;
    static String M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            M = st.nextToken();
            
            boolean done = false;
            for(int i = 0; i < M.length() && !done; i++){
                if(M.charAt(i) == 'N')  Y++;
                if(M.charAt(i) == 'S')  Y--;
                if(M.charAt(i) == 'E')  X++;
                if(M.charAt(i) == 'W')  X--;
                
                if(Math.abs(X) + Math.abs(Y) <= i+1){
                    System.out.printf("Case #%d: %d\n", t, i+1);
                    done = true;
                }
            }
            
            if(!done)   System.out.printf("Case #%d: IMPOSSIBLE\n", t);
        }
    }
}