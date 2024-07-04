import java.util.*;
import java.math.*;

public class Solution
{
	public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    for(int a=0;a<t;a++)
    {
        
        int n=sc.nextInt();
        int arr[][]=new int[n][n];
        int dia=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
            }
            dia=dia+arr[i][i];
        }
        int c=0,r=0;
        for(int i=0;i<n;i++)
        {   int flag1=0;
        int flag2=0;
            for(int j=0;j<n-1;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    if(arr[i][j]==arr[i][k] && flag1==0)
                    {
                        c++;
                        flag1=1;
                        //k=n;
                        //j=n;
                    }
                    if(arr[j][i]==arr[k][i] && flag2==0)
                    {
                        r++;
                        flag2=1;
                    }
                }
            }
        }
        
        System.out.println("Case #"+(a+1)+": "+dia+" "+c+" "+r);
    
    }

}
}