import java.util.*;
class test
{
    public static void main(String args[])
    {
        int k,n,i,j,trace[],o=0,row[],col[];
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        trace=new int[t];
        row=new int[t];
        col=new int[t];
        for(k=0;k<t;k++)
        {
            trace[k]=0;
            row[k]=0;
            col[k]=0;
        }
        for(k=0;k<t;k++)
        {
        n=sc.nextInt();
        int a[][]=new int[n][n];
            
        
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                a[i][j]=sc.nextInt();
            
            
            System.out.print(" ");
            }
            
            System.out.println();
        
            
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(i==j)
                trace[k]+=a[i][j];
            }
        }
        
        for(i=0;i<n;i++)
        {
            for(o=0;0<(n-1);o++)
            {
            for(j=1;j<n;j++)
            {
                
                if(a[i][o]==a[i][j])
                {
                    row[k]++;
                break;
                }
               
            }
                if(a[i][o]==a[i][j])
                {
                   
                break;
                }
            
            
            }
        }
        for(i=0;i<n;i++)
        {
            for(o=0;0<(n-1);o++)
            {
            for(j=1;j<n;j++)
            {
                
                if(a[o][i]==a[j][i])
                {
                    col[k]++;
                break;
                }
               
            }
                if(a[o][i]==a[j][i])
                {
                   
                break;
                }
            
            
            }
        }
        
        
        }
        for(k=0;k<t;k++)
        {
        System.out.println("Case #"+(k+1)+": "+trace[k]+" "+row[k]+" "+col[k]);
        }
            
        }
}