import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int i,j,trace=0,row=0,col=0,k,l,m,d,count=1;
        for(i=0;i<=t;i++)
        {
            trace=0;
            row=0;
            col=0;
            d = obj.nextInt();
            int a[][] = new int[d][d];
            for(i=0;i<d;i++)
            {
                for(j=0;j<d;j++)
                {
                    a[i][j] = obj.nextInt();
                }
            }
            for(i=0;i<d;i++)
            {
                for(j=0;j<d;j++)
                {
                    if(i==j)
                    {
                        trace=trace+a[i][j];
                    }
                }
            }
            for(i=0;i<d;i++)
            {
                row=0;
                m = d;
                for(j=0;j<d;j++)
                {
                    count=1;
                    for(k=j+1;k<m;k++)
                    {   
                        if(a[j][k]==a[i][j])
                        {
                            count++;
                            for(l=k;l<m-1;l++)
                            {
                                a[l]=a[l+1];
                            }
                            k--;
                            m--;
                        }
                    }
                    if(count>1)
                    {
                        row++;
                        break;
                    }
                    else
                    {
                        continue;
                    }
                }
            }
            for(j=0;j<d;j++)
            {
                col=0;
                m = d;
                for(i=0;i<d;i++)
                {
                    count=1;
                    for(k=i+1;k<m;k++)
                    {   
                        if(a[i][k]==a[j][i])
                        {
                            count++;
                            for(l=k;l<m-1;l++)
                            {
                                a[l]=a[l+1];
                            }
                            k--;
                            m--;
                        }
                    }
                    if(count>1)
                    {
                    	col++;
                        break;
                    }
                    else
                    {
                        continue;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+row+" "+" "+col);
        }
    }
}