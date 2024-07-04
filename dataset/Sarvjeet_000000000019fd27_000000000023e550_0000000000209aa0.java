import java.util.*;
public class Solution {



    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        for(int ii=0;ii<t;ii++)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();

            if(k%n!=0)
            {
                System.out.println("Case #"+(ii+1)+": IMPOSSIBLE");
            }
            else
            {
                int d=k/n;
                int a[][]=new int[n][n];

                for(int i=0;i<n;i++)
                    a[i][i]=d;


                for(int j=0;j<n;j++)
                {
                   int i=(j+1)%(n);
                   int no=n;
                   while(no>=1)
                   {
                       if(no==d) no--;

                           a[i][j]=no;

                       i=(i+1)%(n);
                       no--;
                   }
                }
                System.out.println("Case #"+(ii+1)+": POSSIBLE");
                for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        System.out.print(a[i][j]+" ");
                    }
                    System.out.println();
                }
            }

           //   System.out.println("Case #"+(ii+1)+": "+sb.toString());
        }

    }

}
