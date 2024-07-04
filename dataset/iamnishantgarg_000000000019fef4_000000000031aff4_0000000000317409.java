/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

 class Solution {
	public static void main (String[] args) {
// 		System.out.println("GfG!");
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int ll=1;ll<=t;ll++)
        {
            int x=in.nextInt(),y=in.nextInt();
            String str=in.next();
            int time=0;
            boolean poss=false;
            if(x==0&&y==0)
            {
                poss=true;
            }
            else{
            for(int i=0;i<str.length();i++)
            {
                time++;
            char c=str.charAt(i);
                if(i=='N')
                    {
                        y+=1;
                    }
                else if(c=='S')
                y-=1;
                else if(c=='E')
                x+=1;
                else
                x-=1;
                int ans=Math.abs(x)+Math.abs(y);
                if(ans<=time)
                {
                    // time=ans;
                    poss=true;
                    break;
                }
            }
            }
                if(poss)
                {
                    System.out.println("Case #"+ll+": "+time);
                }
                else{
                    System.out.println("Case #"+ll+": IMPOSSIBLE");
                }
            
        }
	}
}