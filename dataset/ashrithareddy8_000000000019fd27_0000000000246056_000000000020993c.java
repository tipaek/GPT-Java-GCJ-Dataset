import java.util.Scanner;
class Main
{
    public static void main(String args[])
    {
        int n,m,i,j,k,count=0,d=0;
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        int sum[]=new int[n];
        int r[]=new int[n];
        int c[]=new int[n];
        for(i=0;i<n;i++)
        {
            m=s.nextInt();
            int a[][]=new int[m][m];
            
            for(j=0;j<m;j++)
            {
                for(k=0;k<m;k++)
                {
                    a[j][k]=s.nextInt();
                }
            }
            j=0;
            k=0;
            
            while(j<m)
            {
                    sum[i]=sum[i]+a[j][k];
                    j++;
                    k++;
                
            }
            
            for(j=0;j<m;j++)
            {
                count=0;
                d=0;
                for(k=0;k<m;k++)
                {
                    if(count>0 && d>0)
                    break;
                    for(int l=k+1;l<m;l++)
                    {
                        if(a[j][k]==a[j][l])
                        {
                            count++;
                            
                
                        }
                        if(a[k][j]==a[l][j])
                        {
                            d++;
                            
                            
                        }
                    }
                }
                if(count>0)r[i]++;
                if(d>0)c[i]++;
            }
            
        }  
        for(i=0;i<n;i++)
        System.out.println("Case #"+(i+1)+": "+sum[i]+" "+r[i]+" "+c[i]);
    }
}