
import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
	
		Scanner sc=new Scanner(System.in);
		int t1=sc.nextInt();
		int d=1;
		while(t1-->0)
		{
		    int n=sc.nextInt();
		    int s[]=new int[n];
		    int e[]=new int[n];
		    int pos[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        s[i]=sc.nextInt();
		        e[i]=sc.nextInt();
		        pos[i]=i;
		    }
		    for (int i = 0; i < n-1; i++) 
        { 
            
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (s[j] < s[min_idx]) 
                    min_idx = j; 
  
            int temp = s[min_idx]; 
            s[min_idx] = s[i]; 
            s[i] = temp; 
            temp=e[min_idx];
            e[min_idx]=e[i];
            e[i]=temp;
            temp=pos[min_idx];
            pos[min_idx]=pos[i];
            pos[i]=temp;
        } 
        
        int jc=0,cc=0;
        char ch[]=new char[n];
        String ans="";
        for(int i=0;i<n;i++)
        {
            if(jc<=s[i])
            {
                jc=e[i];
                ch[pos[i]]='J';
            }
            else if(cc<=s[i])
            {
                cc=e[i];
                ch[pos[i]]='C';
            }
            else
            {
                ans="IMPOSSIBLE";
                break;
            }
        }
        if(ans=="IMPOSSIBLE")
        System.out.println("Case #"+d+": "+ans);
        else
        {
            for(int i=0;i<n;i++)
            ans=ans+ch[i];
            System.out.println("Case #"+d+": "+ans);
        }
		    d++;
		}
	}
}