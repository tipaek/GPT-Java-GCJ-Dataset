import java.util.*;
public class Latina
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int tcase=0,i,j,k,z,n,flag;
        tcase=sc.nextInt();
        int[] tsum=new int[tcase];
        int[] r=new int[tcase];
        int[] c=new int[tcase];
        for(k=0;k<tcase;k++)
        {
            n=sc.nextInt();
            int[][] m=new int[n][n];
            tsum[k]=0;
            r[k]=0;
            c[k]=0;
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    m[i][j]=sc.nextInt();
                }
            }
            
            for(j=0;j<n;j++)
                tsum[k]=tsum[k]+m[j][j];//trace done.

            for(z=0;z<n;z++)
            {
                flag=0;
                for(i=0;i<n;i++)
                {
                    for(j=0;j<n;j++)
                    {
                        if((i!=j)&&(m[z][j]==m[z][i]))  //0->z
                        {
                            r[k]=r[k]+1;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1)
                        break;
                }
            }


            for(z=0;z<n;z++)
            {
                flag=0;
                for(i=0;i<n;i++)
                {
                    for(j=0;j<n;j++)
                    {
                        if((i!=j)&&(m[j][z]==m[i][z]))  //0->z
                        {
                            c[k]=c[k]+1;
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1)
                        break;
                }
            }

        }// ----> increments to next test case^
        for(i=0;i<tcase;i++)
            System.out.println("Case #"+(i+1)+":"+tsum[i]+" "+r[i]+" "+c[i]);
    }
}