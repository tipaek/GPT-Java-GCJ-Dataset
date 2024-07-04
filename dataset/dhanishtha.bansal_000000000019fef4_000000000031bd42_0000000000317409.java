import java.util.*;
import java.lang.Math.*;
import java.io.*;

public class Solution{

     public static void main(String []args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
       for(int idx = 1; idx <= test; idx++) {
            String[] vals = br.readLine().trim().split(" ");
            
            int x = Integer.parseInt(vals[0]);
            int y = Integer.parseInt(vals[1]);
            String path = vals[2];
            char[] pathArr = path.toCharArray();
            int ans = -1;
            String str = "";
            for(int i = 0; i < path.length(); i++) {
                if(pathArr[i] == 'S') {
                    y--;
                }
                else if(pathArr[i] == 'N') {
                    y++;
                }
                else if(pathArr[i] == 'W') {
                    x--;
                }
                else {
                    // East
                    x++;
                }
                int sum = Math.abs(x) + Math.abs(y);
                int diff = sum - (i+1);
                
                if(diff == 0 || diff == -1) {
                    ans = i+1;
                    break;
                }
            }
            if(ans == -1) {
                str = "IMPOSSIBLE";
            }
            else {
                str = Integer.toString(ans);
            }
            
            System.out.println("Case #" + idx + ": " + str);
        }
     }
}