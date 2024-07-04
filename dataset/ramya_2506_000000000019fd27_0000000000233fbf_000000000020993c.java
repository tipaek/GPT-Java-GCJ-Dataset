import java.io.*;
import java.util.*;
class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int[][]a=new int[i][i];
            for(int j=0;j<i;j++)
            {
                a[i][i]=sc.nextInt();
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}