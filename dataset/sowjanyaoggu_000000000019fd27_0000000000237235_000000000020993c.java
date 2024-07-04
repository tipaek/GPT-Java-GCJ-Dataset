import java.util.*;
class Main
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++)
        {
            int tr=s.nextInt();
            int[][] a=new int[tr][tr];
            int c=0,d=0,sum=0;
            for(int j=0;j<tr;j++)
            {
                for(int k=0;k<tr;k++)
                {
                    a[j][k]=s.nextInt();
                    if(a[j][k]==a[j][k+1])
                    {
                        c++;
                        break;
                    }
                    else k++;
                    if(a[j][k]==a[j+1][k])
                    {
                        d++;
                        break;
                    }
                    else j++;
                    if(i==j)
                     sum=sum+a[i][j];
                }
            }
            System.out.println("case #"+i+": "+sum+" "+c+" "+d);
        }
    }
}