/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

// /* Name of the class has to be "Main" only if the class is public. */
// class Codechef
// {
// 	public static void main (String[] args) throws java.lang.Exception
// 	{
// 		// your code goes here
// 	}
// }

class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int t = in.nextInt();
        int t1=1;
        while(t1<=t) {
            
            String str = in.next();
            String ans="";
            int depth=0;
            
            for(int i=0;i<str.length();i++) {
                int toincrease = str.charAt(i)-'0' - depth;
                while(toincrease>0) {
                    ans+='(';
                    toincrease--;
                }
                while(toincrease<0) {
                    ans+=')';
                    toincrease++;
                }
                ans+=str.charAt(i);
                depth=str.charAt(i)-'0';
            }
            while(depth>0) {
                ans+=')';
                depth--;
            }
            
            System.out.println("Case #" + t1 + ": " + ans);
            t1++;
        }
    }
}
