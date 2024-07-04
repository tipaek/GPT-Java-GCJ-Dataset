 import java.util.*;
    import java.io.*;
public class Solution{

     public static void main(String []args){
         Scanner y = new Scanner(System.in);
        int t=y.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=y.nextInt();
            int d=y.nextInt();
            long cut[]=new long[n];
            for(int j=0;j<n;j++)
            {
                cut[j]=y.nextLong();
            }
            Arrays.sort(cut);
            if(n>=d)
            {
                int flag=0;
                for(int j=0;j<n;j++)
                {
                    int temp=1;
                    
                    for(int k=j+1;k<n;k++)
                    {
                        if(cut[j]==cut[k])
                        {
                            temp++;
                        }
                    }
                    if(temp==d)
                    {
                     System.out.println("Case #"+(i+1)+": 0");  
                     j=n+1;
                     flag=1;
                    }
                }
                if(flag!=1)
                {
                    System.out.println("Case #"+(i+1)+": "+(d-1));
                }
                
                
            }
            else
            {
                long tem=0,c=0;
                for(int j=0;j<n&& tem!=d-1;j++)
                {
                    tem=1;
                    
                    for(int k=j+1;k<n;k++)
                    {
                        if(cut[k]%cut[j]==0)
                        {
                            tem=cut[k]/cut[j];
                            c++;
                        }
                    }
                }
                if(c!=0){
                    System.out.println("Case #"+(i+1)+": "+c);
                }
                else
                {
                    System.out.println("Case #"+(i+1)+": "+(d-1));
                }
            }
            
            
        }
     }
}