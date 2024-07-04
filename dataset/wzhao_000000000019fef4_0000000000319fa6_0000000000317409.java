import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t < T; t++){
            output.print("Case #" + (t+1) + ": ");
            StringTokenizer st = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String path = st.nextToken();
            boolean printed = false;
            for(int i = 0; i < path.length(); i++){
                if(path.charAt(i) == 'N') y++;
                else if(path.charAt(i) == 'S') y--;
                else if(path.charAt(i) == 'E') x++;
                else x--;
                if(Math.abs(x)+Math.abs(y)<=i+1){
                    printed = true;
                    output.println(i+1);
                    break;
                }
            }
            if(!printed) output.println("IMPOSSIBLE");
        }
        output.flush();
        output.close();
    }
}