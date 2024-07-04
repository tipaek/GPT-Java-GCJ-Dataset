import java.util.*;
import java.io.*;
class Solution{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
		int h=1;

        while(t>0)
        {
            int sum=0;
            int a[][]=new int[10][10];
            int N=sc.nextInt();
            for( int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {

                    a[i][j]=sc.nextInt();

                }
            }
            int sum1=0,sum2=0;

               for( int k=0;k<N;k++)
            { int flag=0, flag1=0;

                for(int l=0;l<N;l++)
                {
                    if(a[k][l]<=N)
                    {
                        if(k==l)
                        sum+=a[k][l];
                        for(int g=l+1;g<N;g++)
                        {
                            if(a[k][l]==a[k][g])
                            {
                            flag=1;

                            }
                             if(a[l][k]==a[g][k])
							 {
							    flag1=1;

                            }
                        }

                    }

                }
                sum1=sum1+flag;
                sum2=sum2+flag1;
            }


            System.out.println("Case #"+h+": "+sum+" "+sum1+" "+sum2);
             h++;
            t--;

        }
    }
}


      
             
      