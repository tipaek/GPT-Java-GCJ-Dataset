import java.util.*;

class Vestigium
{
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int q=0;q<t;q++)
        {
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            int sum=0;
            int r1=0,c1=0;
            for(int i=0;i<n;i++)
            {
                
                for(int j=0;j<n;j++)
                {
                    
                    a[i][j]=sc.nextInt();
                    if(i==j)
                    sum=sum+a[i][j];
                   for(int k=0;k<j;k++)
                   {
                       for(int l=0;l<k;l++)
                       {
                           if(a[i][k]==a[i][l])
                          {
                              r1++;
                              break;
                          }
                           
                       }
                   }
                }
            }
            
            for(int p=0;p<n;p++)
            {
                
                for(int y=0;y<n;y++)
                {
                    
                   for(int e=0;e<y;e++)
                   {
                       for(int r=0;r<e;r++)
                       {
                           if(a[e][p]==a[r][p])
                          {
                              c1++;
                              break;
                          }
                           
                       }
                   }
                }
            }
            
            
            
            
            
            
            
            System.out.println("Case #"+q+1+": "+sum+" "+r1+" "+c1);
            
            
            
            
            
        }
        
        
        
        
        
    }
    
    
}