import java.util.*;
class Vestigium 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int b[][]=new int[t][3];
        int l=0;
        if((t>=1)&&(t<=100))
        {    
            int sum=0,row=0,col=0;
            int n=sc.nextInt();
            if((n>=2)&&(n<=100))
            {
                int a[][]=new int[n][n];
                
                for(int i=0;i<n;i++)
                {
                     for(int j=0;j<n;j++)
                      {
                             a[i][j]=sc.nextInt();
                             if ((a[i][j]<1)||(a[i][j]>n))
                             System.exit(0);
                             if(i==j)
                             sum+=a[i][j];
                             
                       }
                }
                for(int i=0;i<n;i++)
                {    int p=1;
                     for(int j=0;j<n-1; )
                      {   
                          if(a[i][j]==a[i][p])
                          {
                              row++;
                              break;
                          }
                          else
                          {
                              p++;
                          }
                          if (p==4)
                          {
                              j++;
                              p=j+1;
                          }
                      }
                } 
                for(int i=0;i<n;i++)
                {    int q=1;
                     for(int j=0;j<n-1; )
                      {   
                          if(a[j][i]==a[q][i])
                          {
                              col++;
                              break;
                          }
                          else
                          {
                              q++;
                          }
                          if (q==4)
                          {
                              j++;
                              q=j+1;
                          }
                      }
                }
                
                b[l][0]=sum;
                b[l][1]=row;
                b[l][2]=col;
                
                   
                
        
              
            
                
            }
            else
            {
                System.exit(0);
            }
        }
        for(int i=0;i<t;i++)
        {
            System.out.println("Case #"+(i+1)+": "+b[i][0]+""+b[i][1]+""+b[i][2]);
        }
    }
}