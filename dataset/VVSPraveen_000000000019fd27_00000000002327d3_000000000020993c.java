import java.util.*;

class Vestigium
{
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int q=1;q<=t;q++)
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
                   
                }
            }
            
            label:
            for(int k=0;k<n;k++)
                   {
                       for(int h=0;h<=9;h++)
                       {
                           int d=0;
                           for(int l=0;l<n;l++)
                       {
                           
                           if(h==a[k][l])
                          {
                              d++;
                              
                          }
                           
                       }
                       if(d>=2)
                       {
                           r1++;
                           continue label;
                       }
                       }
                   }
            
           label1:
            for(int p=0;p<n;p++)
                   {
                       for(int s=0;s<=9;s++)
                       {
                           int c=0;
                           for(int g=0;g<n;g++)
                       {
                           
                           if(s==a[g][p])
                          {
                              c++;
                          }
                           
                       }
                       if(c>=2)
                       {
                           c1++;
                           continue label1;
                       }
                       }
                   }
            
            
            
            
            
            
            
            System.out.println("Case #"+q+": "+sum+" "+r1+" "+c1);
            
            
            
            
            
        }
        
        
        
        
        
    }
    
    
}