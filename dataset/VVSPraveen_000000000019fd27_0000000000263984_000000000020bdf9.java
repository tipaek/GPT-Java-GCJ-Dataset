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
            int a[][]=new int[n][2];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<2;k++)
                {
                    a[j][k]=sc.nextInt();       
                    
                }
            
            }
            
           
            if(a[0][0]<a[n-1][1] && a[0][1]>a[n-1][0])
            {
                System.out.println("Case #"+i+": "+"IMPOSSIBLE"); 
            }
            else
            {
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
            System.out.println("Case #"+i+": "+s);
            
            }
            
        }
        
    }
    
    
    
}