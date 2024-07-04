import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int arr[][];
        int n,f=0;
       int t=sc.nextInt();
        String ans="J";
        boolean c=false,ja=false;
        for(int i=0;i<t;i++)
        {
            ans="J";
            c=false;
            ja=false;
            n=sc.nextInt();
            arr=new int[n][2];
            f=0;
            for(int j=0;j<n;j++)
            {
                arr[j][0]=sc.nextInt();
                arr[j][1]=sc.nextInt();
            }
    
         for(int j=1;j<n;j++)
         {
             c=false;
             ja=false;
             for(int k=j-1;k>=0;k--)
             {
                 if((arr[j][0]<arr[k][1]&&arr[j][0]>arr[k][0]&&ans.charAt(k)=='C'&& c==false)||(arr[j][1]<arr[k][1]&&arr[j][1]>arr[k][0]&&ans.charAt(k)=='C'&& c==false))
                 {
                     c=true;
                 }
                 else if((arr[j][0]<arr[k][1]&&arr[j][0]>arr[k][0]&&ans.charAt(k)=='J' &&ja==false)||(arr[j][1]<arr[k][1]&&arr[j][1]>arr[k][0]&&ans.charAt(k)=='J' &&ja==false))
                 {
                     ja=true;
                 }
             }
             if(c==true&&ja==true)
             {
                 f=1;
                 System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
                 break;
             }
             else if(c==true&& ja==false)
             {
                 ans=ans+"J";
             }
             else if(ja==true&&c==false)
             {
                 ans=ans+"C";
             }
             else
             {
                 ans=ans+"J";
             }
         }
         if(f==0)
         {
             System.out.println("Case #"+(i+1)+": "+ans+"");
         }
         
         }
        
    }
}
                
        
        
    