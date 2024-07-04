import java.util.Scanner;
import java.util.Arrays;
public class Solution {
    public static void main(String args[])
    {
    Scanner sc = new Scanner(System.in);
    int t=sc.nextInt();
    for(int z=0;z<t;z++)
    {
        int n=sc.nextInt();
        int a[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }
        
        int trace=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                trace=trace+a[i][j];
            }
        }
        
        int c[]=new int[n];
        int col=0;
        for(int j=0;j<n;j++)
        {
            for(int i=0;i<n;i++)
            {
                c[i]=a[i][j];
            }
            Arrays.sort(c);
        for(int i=1;i<n;i++)
        {
            if(c[i]==c[i-1])
            {
                col++;
                break;
            }
        }
        }
        
        int row=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                c[j]=a[i][j];
            }
            Arrays.sort(c);
            for(int j=1;j<n;j++)
            {
                if(c[j]==c[j-1])
                {
                    row++;
                    break;
                }
            }
        }
 
        int y=z+1;
        System.out.print("Case #"+y+": "+trace+" "+row+" "+col+"\n");
    }
    }
}
