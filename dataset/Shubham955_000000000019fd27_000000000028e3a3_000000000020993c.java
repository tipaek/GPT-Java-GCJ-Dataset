import java.util.Scanner;
class Demo
{
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        int h=1;
        while(h<=t)
        {
            int k=0,n=scan.nextInt();
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=scan.nextInt();
                    if(i==j)
                    {
                        k+=arr[i][j];
                    }
                }
            }
            int a2[]=new int[4];
            for(int i=0;i<n;i++)
            {
                a2[i]=0;
            }
            int r=0,c=0,m;
            for(int i=0;i<n-1;i++)
            {   m=i+1;
                for(int j=0;j<n-1;j++)
                {
                    if(arr[i][j]==arr[m][j] && (a2[i]==0 || a2[i+1]==0))
                    {
                    //c++;
                    a2[i]=1;
                       a2[i+1]=1;
                        if(m<n-1)
                        m++;
                        else
                        break;
                    j=-1;
                    
                    }
                    
                }
            }
            for(int i=0;i<n;i++)
            {
                if(a2[i]==1)
                    c++;
                a2[i]=0;
            }
            for(int j=0;j<n-1;j++)
            {m=j+1;
                for(int i=0;i<n-1;i++)
                {
                    if(arr[i][j]==arr[i][m] && (a2[i]==0 || a2[i+1]==0))
                    {
                    
                    a2[i]=1;
                       a2[i+1]=1;
                        if(m<n-1)
                        m++;
                        else
                        break;
                    i=-1;
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                if(a2[i]==1)
                    r++;
                a2[i]=0;
            }
            System.out.println("Case #"+h+": "+k+" "+r+" "+c);
            h++;
        }
    }
}