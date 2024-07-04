import java.io.*;
import java.util.*;
import java.lang.*;

class Solution{
    public static void main(String natgs[])
    {
        Scanner cs=new Scanner(System.in);
        int a,b,i,j,n;
        int[] arr=new arr[20];
        n=cs.nextInt();
        for(i=0;i<n;i++)
        {
            arr[i]=cs.nextInt();
            String s=String.valueOf(arr[i]);
            char[] str=s.toCharArray();
            
            for(j=0;j<s.length();j++)
            {
                if(str[j]=='1')
                {
                    System.out.print("("+str[j]+")");
                }
                else
                {
                    System.out.print(str[j]);
                }
            }
        }
        
    }
}