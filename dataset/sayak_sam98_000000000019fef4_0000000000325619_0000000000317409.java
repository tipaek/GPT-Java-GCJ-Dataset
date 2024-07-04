import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        int x, y, len, ctime, mtime, mintime; String all, dir; char step;
        for(int t = 1; t <= test; t++){
            //taking inputs
            all = br.readLine();
            String[] inp = all.split(" ");
            x = Integer.parseInt(inp[0]);
            y = Integer.parseInt(inp[1]);
            dir = inp[2];
            
            //problem
            boolean possible = false;
            mintime = Integer.MAX_VALUE;
            if(x == 0 && y == 0){
                mintime = 0;
                possible = true;
            }
            else{
                ctime = 0;
                len = dir.length();
                for(int i = 0; i < len; i++){
                    ctime++;
                    step = dir.charAt(i);
                    if(step == 'N')
                        y++;
                    else if(step == 'S')
                        y--;
                    else if(step == 'E')
                        x++;
                    else
                        x--;
                        
                    mtime = Math.abs(x) +Math.abs(y);
                    if(mtime <= ctime && ctime < mintime){
                        mintime = ctime;
                        possible = true;
                    }
                }
            }
            if(!possible)
                System.out.println("Case #"+t+": IMPOSSIBLE");
            else
                System.out.println("Case #"+t+": "+mintime);
        }
    }
}