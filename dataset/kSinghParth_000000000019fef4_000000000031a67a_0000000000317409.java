import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int q = sc.nextInt();
        int m=(int )1E9;
      
        for (int k=1;k<=q;k++) {
            int x=sc.nextInt();
            int y=sc.nextInt();
            char ch[] =sc.next().toCharArray();

            int ans=10000000;
            int t=0;
            int d=x+y;
            if(d<=t){
                ans=Math.min(ans,d);
            }
            for(char c: ch){
                t++;
                if(c=='N')
                    y++;
                if(c=='S')
                    y--;
                if(c=='E')
                    x++;
                if(c=='W')
                    x--;
                d=Math.abs(x)+Math.abs(y);
                // System.out.println(x+" "+y+" "+t);
                if(d<=t){
                    ans=Math.min(ans,t);
                }
            }
            if(ans==10000000)
            System.out.println("Case #"+k+": IMPOSSIBLE");
            else
                System.out.println("Case #"+k+": "+ans);
        }
    }
  
}

