import java.util.Scanner;

class Solution {

    public static void main(String args[])
    {

        int T,i,j,k,N[],mat[][],sum[],row[],col[],temp=0,tr=0,tc=0;
        Scanner sc=new Scanner(System.in);

        do {
            T=sc.nextInt();
        }while (T<1 || T>100);

        N=new int[T];
        sum=new int[T];
        row=new int[T];
        col=new int[T];

        for (i=0;i<T;i++)
        {
            sum[i]=0;
            row[i]=0;
            col[i]=0;
            do {
                N[i]=sc.nextInt();
            }while (N[i]<2 || N[i]>100);

            mat=new int[N[i]][N[i]];

            for (j=0;j<N[i];j++)
            {
                for (k=0;k<N[i];k++)
                {
                    do {
                        mat[j][k]=sc.nextInt();
                    }while (mat[j][k]<1 || mat[j][k]>N[i]);
					
                    if (k==j)
                    {
                        sum[i]+=mat[j][k];
                    }
                }
            }
            for(int m=0;m<N[i];m++)
            {
                tr=row[i];
                tc=col[i];
                for (j=0;j<N[i];j++)
                {
                    temp=mat[m][j];
                    for (k=j+1;k<N[i];k++)
                    {
                        if (temp==mat[m][k])
                        {
                            row[i]++;
                            break;
                        }
                    }
                    if(row[i]==(tr+1))
					{
                        break;
					}
                }

                for (j=0;j<N[i];j++)
                {
                    temp=mat[j][m];
                    for (k=j+1;k<N[i];k++)
                    {
                        if (temp==mat[k][m])
                        {
                            col[i]++;
                            break;
                        }
                    }
                    if(col[i]==(tc+1))
					{
                        break;
					}
                }
            }

        }

        for (i=0;i<T;i++)
        {
            System.out.println("Case #"+(i+1)+": "+sum[i]+" "+row[i]+" "+col[i]);
        }

    }

}
