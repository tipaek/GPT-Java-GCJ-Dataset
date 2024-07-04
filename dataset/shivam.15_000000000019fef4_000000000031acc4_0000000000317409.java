import java.util.*;
import java.io.*;
class Solution{
    static int a[][];
    static boolean visited[][];
    static boolean bf[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int t_=1;t_<=t;t_++){
            String s[] = br.readLine().trim().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);            
            char direction[] = s[2].toCharArray();
             
            int res = -1;
            for(int i=0;i<direction.length;i++){
                if(direction[i] == 'N') y++;
                else if(direction[i] == 'S') y--;
                else if(direction[i] == 'E') x++;
                else x--;
                
                //System.out.println("x : "+x+" y : "+y);
                if(Math.abs(x)+Math.abs(y) <= i+1){
                    //System.out.println("x : "+x+" y : "+y);
                    res = i+1;break;
                }
            }
            if(res == -1)
                System.out.println("Case #"+t_+": IMPOSSIBLE");
            else
                System.out.println("Case #"+t_+": "+res);   
            //System.out.println("\n\n");
        }
    } 
} 
