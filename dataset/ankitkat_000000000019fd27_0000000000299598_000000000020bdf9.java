import java.io.*;
import java.util.*;

public class Solution {
    
    
    public static int min(int b[], int c[])
    {
        int m=Integer.MAX_VALUE;
        int ind=0;
        for(int i=0;i<b.length;i++)
        {
            if(b[i]<=m && c[i]==0)
            {
                m=b[i];
                ind=i;
            }
            
        }
        return ind;
        
        
        
        
    }
    
    
    
    

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=Integer.parseInt(s);
        for(int i=0;i<n;i++)
        {
            String s1=sc.nextLine();
            int t=Integer.parseInt(s1);
            int a[]=new int[t];
            int b[]=new int[t];
            int c[]=new int[t];
            String res="";
            for(int j=0;j<t;j++)
            {
                String[] ss=sc.nextLine().split(" ");
                a[j]=Integer.parseInt(ss[0]);
                b[j]=Integer.parseInt(ss[1]);
                
            }
            int xc=0,xj=0;
            outer:
            for(int j=0;j<t;j++)
            {
                int index=Solution.min(b,c);
                if(j==0)
                {
                    c[index]=1;
                    xc=b[index];
                }
                else
                {
                    if(a[index]<xc && a[index]<xj)
                    {
                        res="IMPOSSIBLE";
                        break outer;
                    }
                    else if(a[index]==xc)
                    {
                        c[index]=1;
                        xc=b[index];
                    }
                    else if(a[index]==xj)
                    {
                        c[index]=2;
                        xj=b[index];
                    }
                    else
                    {
                        if(a[index]<xc)
                        {
                            c[index]=2;
                            xj=b[index];
                        }
                        else
                        {
                            c[index]=1;
                            xc=b[index];
                        }
                    }
                    
                    
                    
                    
                    
                    
                    
                    
                }
                
                
                
                
                
                
                
                
            }
            inner:
            for(int k=0;k<t;k++)
            {
                if(c[k]==0)
                {
                    res="IMPOSSIBLE";
                    break inner;
                }
                else if(c[k]==1)
                {
                    res=res+"C";
                }
                else
                {
                    res=res+"J";
                }
            }
            
            System.out.println("Case #"+(i+1)+": "+res);
            
            
        }
        
        
        
        
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}