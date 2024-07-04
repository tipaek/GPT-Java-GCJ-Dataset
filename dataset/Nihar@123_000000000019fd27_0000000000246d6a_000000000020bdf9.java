/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution {
    public static void main(String args[]) {
       // System.out.println("enter the number of test cases");
        int t = 0;
       Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
           // System.out.println("enter the value of n");
            int n=sc.nextInt();
            //int a[]=new int[n];
            //int b[]=new int[n];
            //System.out.println("enter the time");
            boolean C[]=new boolean[1440];
            boolean J[]=new boolean[1440];
            StringBuilder sol=new StringBuilder();
            boolean tem=false;
            for(int j=0;j<n;j++)
            {
                int start=sc.nextInt();
                int end=sc.nextInt();
                boolean flag=false;
                boolean flag1=false;
                for(int z=start;z<end;z++)
                {
                    if(C[z])
                    {
                        flag=true;
                    }
                    if(J[z])
                    {
                        flag1=true;
                    }
                }
                if(flag&&flag1)
                {
                    System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
                    tem=true;
                }
                else if(flag)
                {
                    for(int x=start;x<end;x++)
                    {
                        J[x]=true;
                    }
                    sol.append('J');
                }
                else
                {
                    for(int x=start;x<end;x++)
                    {
                        C[x]=true;
                    }
                    sol.append('C');
                }
            }
            if(!tem)
            System.out.println("Case #"+(i+1)+": "+sol);
        }
    }
}
