import java.util.*;
public class Solution {

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        for(int ii=0;ii<t;ii++)
        {
            int n=sc.nextInt();
          //  int f=1;
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                  //  if(a[i][j]>n || a[i][j]<=0)
                       // f=-1;
                }
            }
           // if(f)
            int r[]=new int[n+1];
            int c[]=new int[n+1];
            int rc=0;
            int cc=0;

            for(int i=0;i<n;i++)
            {
                int f=0;
                for(int j=0;j<n;j++)
                {
                    if(f==0 && r[a[i][j]]==1)
                    {
                        f=1;
                        rc+=1;
                        continue;
                    }
                    else
                    {
                        r[a[i][j]]=1;
                    }
                }
                Arrays.fill(r,0);
            }
            int sum=0;
            for(int j=0;j<n;j++)
            {
                int f=0;
                for(int i=0;i<n;i++)
                {
                    if(i==j) sum+=a[i][j];

                    if(f==0 && c[a[i][j]]==1)
                    {
                        cc+=1;
                        f=1;
                       continue;
                    }
                    else
                    {
                        c[a[i][j]]=1;
                    }


                }
                Arrays.fill(c,0);
            }
            System.out.println("Case #"+(ii+1)+": "+sum+" "+rc+" "+cc);
       //     System.out.println(sum+" "+rc+" "+cc);
        }

    }

}
