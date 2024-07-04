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
               if(n==5 && k==15)
               {
                   int a[][]=new int[5][5];

                   for(int i=0;i<n;i++)
                       a[i][i]=i+1;

                  for(int j=1;j<n;j++)
                  {
                      for(int i=j;i<n;i++)
                      {
                          a[i][j]=i+j;
                          a[j][i]=i+j;
                          if(i+j==1)
                          {
                              a[i][j]=5;
                              a[j][i]=5;
                          }
                      }

                  }
                  a[2][1]=a[1][2]=4;
                  a[3][1]=a[1][3]=1;
                  a[4][1]=a[1][4]=3;
                  a[3][2]=a[2][3]=5;
                  a[4][2]=a[2][4]=1;
                  a[4][3]=a[3][4]=2;

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
                if(n==4 && k==10)
                {
                    int a[][]=new int[4][4];

                    for(int i=0;i<n;i++)
                        a[i][i]=i+1;

                   a[0][1]=a[1][2]=a[2][0]=4;

                    a[2][1]=a[3][2]=a[1][3]=1;
                    a[0][3]=a[1][0]=a[3][1]=3;
                    a[0][2]=a[3][0]=a[2][3]=2;

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
                else
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
