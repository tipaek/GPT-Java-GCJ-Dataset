/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class GFG {
	public static void main (String[] args) {
// 		System.out.println("GfG!");
        
        Scanner scn = new Scanner(System.in);
        int t= scn.nextInt();
        for(int u=1; u<=t; u++){
            int c= scn.nextInt();
            int r = scn.nextInt();
            String str = scn.next();
            int len = str.length();
            // int[] dp = new int[str.length()+1];
            // dp[0]= r+c;
            // int temp = r+c;
            
            System.out.print("Case #" + u + ": ");
            int i=0;
            boolean check = false;
            while(str.length()>=0){
                int temp  = Math.abs(r)+ Math.abs(c);
                // i++;
                if(temp<=i) {
                    check= true;
                    break;
                }
                
                if(str.length()==0) break;
                char ch = str.charAt(0);
                if(ch=='S') r--;
                if(ch=='N') r++;
                if(ch=='E') c++;
                if(ch=='W') c--;
                str= str.substring(1);
                i++;
            }
            
            // int ans = dp[0];
            // for(int j=0; j<dp.length; j++){
            //     if(ans>dp[j]) ans= dp[j];
            // }
            
            if(check==false) System.out.println("IMPOSSIBLE");
            else System.out.println(i);
        }

	}
}