import java.util.*;
class code
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int l=0;l<t;l++)
        {
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                }
            }
            int trace=0;
            for(int i=0;i<n;i++)
            trace=trace+a[i][i];
            
            int r=0;int c=0;int check=0;
            for(int i=0;i<n;i++)
            {
                check=0;
                for(int j=0;j<n;j++)
                {
                    for(int m=j+1;m<n;m++)
                    {
                        if(a[i][j]==a[i][m])
                        check=1;
                        
                        if(check==1)
                        break;
                    }
                    if(check==1)
                        break;
                }
                if (check==1)
                r++;
            }
            
          for(int i=0;i<n;i++)
            {
                check=0;
                for(int j=0;j<n;j++)
                {
                    for(int m=j+1;m<n;m++)
                    {
                        if(a[j][i]==a[m][i])
                        check=1;
                        
                        if(check==1)
                        break;
                    }
                    if(check==1)
                        break;
                }
                if (check==1)
                c++;
            }
            
            
            System.out.println("Case #"+l+": "+trace+" "+r+" "+c);
        }
    }
}