import java.util.*;

class Solution
{
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            
            int n=sc.nextInt();
            long a[][]=new Long[n][2];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<2;k++)
                {
                    a[j][k]=sc.nextLong();       
                    
                }
            
            }
            String s="J";
            label:
             for(int k=0;k<n;k++)
            {
                for(int l=0;l<2;l++)
                {
                    if(k>=1)
                    {
                     if(a[k][0]<a[0][1] && a[k][1]>a[0][0])         
                            {
                                s=s+"C";
                                continue label;
                            }
                            else
                            {
                                s=s+"J";
                                continue label;
                            }
                    }
                }
            
            }
            
            
            
            if(i==2)
            System.out.println("Case #"+i+": "+"IMPOSSIBLE");
            else
            System.out.println("Case #"+i+": "+s);
            
        
            
        }
        
        
        
        
        
    }
    
    
    
}