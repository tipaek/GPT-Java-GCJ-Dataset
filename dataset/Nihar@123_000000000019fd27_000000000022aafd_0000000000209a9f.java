/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution {
    public static void main(String args[]) {
        //System.out.println("entre the number of test cases");
        int t = 0;
       Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            //System.out.println("enter the string");
            String s1=sc.next();
            int depth=0;
            StringBuilder sol=new StringBuilder();
            for(int j=0;j<s1.length();j++)
            {
                int temp=s1.charAt(j)-'0';
                for(;depth<temp;depth++)
                {
                    sol.append('(');
                }
                if(j!=0&&s1.charAt(j)<s1.charAt(j-1))
                {
                    while(depth!=temp)
                    {
                        sol.append(')');
                        depth--;
                    }
                }
                sol.append(s1.charAt(j));
            }
            while(depth!=0)
            {
                sol.append(')');
                depth--;
            }
            System.out.println("Case #"+(i+1)+": "+sol);

        }
    }
}
