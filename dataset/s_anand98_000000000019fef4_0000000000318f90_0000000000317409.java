import java.io.*;
import java.util.*;

class Solution {

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine().trim());
        for(int test=1;test<=t;test++){
           
            String s[] = br.readLine().trim().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            String str = s[2];
            int ans = 0;
            for(int i=0;i<str.length();i++){
                int time = i+1;

                char chr = str.charAt(i);
                if(chr=='N')y++;
                else if(chr=='S')y--;
                else if(chr == 'E')x++;
                else if(chr == 'W')x--;

                int val = (int)((int)Math.abs(x)+(int)Math.abs(y));
                if(val<=time){
                    ans = time;
                    break;
                }

            }

            if(ans == 0)sb.append("Case #"+test+": "+"IMPOSSIBLE"+"\n");

            else 
                sb.append("Case #"+test+": "+ans+"\n");
            
        }
              
        System.out.print(sb);
    }
}