import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++)
        {
            String s=sc.nextLine();
            int len=s.length();
            String res="";
            int x=0;
            for(int j=0;j<=len-1;j++)
            {
                char a=s.charAt(j);
                int c=a-'0';
                int temp=c-x;
                if(temp>0)
                {
                    for(int m=0;m<temp;m++)
                    {
                        res=res+"(";
                    }
                    x+=temp;
                }
                else if(temp<0)
                {
                    temp=Math.abs(temp);
                    for(int m=0;m<temp;m++)
                    {
                        res=res+")";
                    }
                    x-=temp;
                }
                else
                {
                    
                }
                
                res=res+a;
            }
            
            for(int k=0;k<x;k++)
            {
                res=res+")";
            }
            
            
            
            System.out.println("Case #"+(i+1)+": "+res);
            
            
        }
        
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}