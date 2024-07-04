/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		   Scanner sc=new Scanner (System.in);
        int t=sc.nextInt();
        int r=1;
        while(t!=0)
        {
        	String s="";
            int n=sc.nextInt();
            int flag=0;
            int a[]=new int[1441];
            for(int i=0;i<1441;i++)
            a[i]=0;
            int b[]=new int[n];
            int c[]=new int[n];
            for(int i=0;i<n;i++)
            {
                b[i]=sc.nextInt();
                c[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++)
            {
                for(int j=b[i];j<c[i];j++)
                a[j]++;
            }
            for(int i=0;i<n;i++)
            {
                if(a[i]>2)
                {
                    s="IMPOSSIBLE";
                   flag=1;
                   break;
                }
            }
            if(flag==1)
            {
            	 System.out.println("Case #"+r+":"+" "+s);
            	 r++;
            	 
            }
                else
                {
                char ch[]=new char[n];
                for(int j=0;j<n;j++)
                ch[j]='J';
                for(int i=0;i<n;++i){
                int min = 11111;
                int pos = i;
                for(int j=0;j<n;++j){
                    if(a[b[j]] == 2){
                        if(b[j] <= min)
                        {
                            min =b[j] ;
                            pos = j;
                        }
                    }
                }
                if(min!=11111){
                ch[pos]='C'; // ch is the array where jib is assigned
                for(int k=b[pos];k<c[pos];++k){
                    --a[k];
                }
                }
                }
        for(int i=0;i<n;i++)
        s=s+ch[i];
        System.out.println("Case #"+r+":"+" "+s);
        r++;
                }
     t--;
    } 
	}
}