import java.util.*;
import java.io.*;
class Vest
{
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        int t=sc.nextInt();
        int i;
        for(i=0;i<t;i++)
        {
            int n=sc.nextInt();
            int Arr[][]=new int[n][n];
            int j,k;
            for(j=0;j<n;j++)
            {
                for(k=0;k<n;k++)
                Arr[j][k]=sc.nextInt();
            }
            int trace=0;
            for(j=0;j<n;j++)
            trace=trace+Arr[j][j];
            int m,flag=0,row=0,column=0;
            for(m=0;m<n;m++)
            {
                flag=0;
            for(j=0;j<n-1;j++)
            {
                for(k=j+1;k<n;k++)
                {
                  if(Arr[m][k]==Arr[m][j])
                  {
                    flag=1;
                    break;
                  }
                }
                if(flag==1)
                {
                    row++;
                    break;
                }
            }
            }
            for(m=0;m<n;m++)
            {
                flag=0;
            for(j=0;j<n-1;j++)
            {
                for(k=j+1;k<n;k++)
                {
                  if(Arr[k][m]==Arr[j][m])
                  {
                    flag=1;
                    break;
                  }
                }
                if(flag==1)
                {
                    column++;
                    break;
                }
            }
            }
            System.out.print("Case #");
            System.out.print(i+1);
            System.out.print(": "+trace+" "+row+" "+column);
        }
    }
}
