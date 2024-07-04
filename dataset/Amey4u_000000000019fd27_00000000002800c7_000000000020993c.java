import java.util.*;

public class Solution {
//Solution
    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            int m=sc.nextInt();
            int arry[][]=new int[m][m];
            for(int j=0;j<m;j++)
            {
                for(int k=0;k<m;k++)
                {
                    arry[j][k]=sc.nextInt();
                }
            }
            int trace=0;
            int row=0;
            int colo=0;
            for(int j=0;j<m;j++)
            {
                for(int k=0;k<m;k++)
                {
                    int count=0;
                    for(int l=0;l<m;l++)
                    {
                        if(arry[j][l]==k+1)
                        {
                            count++;
                        }
                    }
                    if(count!=1)
                    {
                        row++;
                        break;
                    }
                }
            }
            for(int j=0;j<m;j++)
            {
                for(int k=0;k<m;k++)
                {
                    int count=0;
                    for(int l=0;l<m;l++)
                    {
                        if(arry[l][j]==k+1)
                        {
                            count++;
                        }
                    }
                    if(count!=1)
                    {
                        colo++;
                        break;
                    }
                }
            }
            for(int j=0;j<m;j++)
            {
                for(int k=0;k<m;k++)
                {
                    if(j==k)
                    {
                        trace=trace+arry[j][k];
                    }
                }
            }
            System.out.println("Case #"+i+": "+trace+" "+row+" "+colo);

        }



    }
}
