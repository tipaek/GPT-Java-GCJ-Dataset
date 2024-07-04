import java.util.*;
import java.lang.*;

class Main
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int r=0;r<t;r++)
        {
            int s=in.nextInt();
            int[][] a=new int[s][s];
            for(int i=0;i<s;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=in.nextInt();
                }
            }
            int sum=0;
            for(int i1=0;i1<s;i1++)
            {
                for(int j1=0;j1<s;j1++)
                {
                    if(i1=j1)
                    sum=sum+a[i1][j1];
                }
            }
            System.out.print(sum+" ");
            int count=0;
            for(int i2=0;i2<s;i2++)
            {
                for(int j2=0;j2<s-1;j2++)
                {
                    if(a[i2][j2]==a[i2][j2+1])
                    {
                        count=count+1;
                        break;
                    }
                }
            }
            System.out.print(count+" ");
            int count1=0;
            for(int i3=0;i3<s-1;i3++)
            {
                for(int j3=0;j3<s;j3++)
                {
                    if(a[i3][j3]==a[i3+1][j3])
                    {
                        count1=count1+1;
                        break;
                    }
                }
            }
            System.out.print(count1);
        }
    }
}