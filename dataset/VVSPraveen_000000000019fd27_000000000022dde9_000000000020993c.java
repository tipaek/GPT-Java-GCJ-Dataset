import java.util.*;

class Vestigium
{
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
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
                    
                   for(int k=0;k<y;k++)
                   {
                       for(int l=0;l<k;l++)
                       {
                           if(a[k][p]==a[l][p])
                          {
                              c1++;
                              break;
                          }
                           
                       }
                   }
                }
            }
            
            
            
            
            
            
            
            System.out.println("Case #"+i+1+": "+sum+" "+r1+" "+c1);
            
            
            
            
            
        }
        
        
        
        
        
    }
    
    
}