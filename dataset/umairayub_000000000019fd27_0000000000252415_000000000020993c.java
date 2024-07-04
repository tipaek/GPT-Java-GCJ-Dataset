import java.io.*;
import java.util.*;
class q1
{
    public static void main(String args[])
    {
        int cnt=1,t, n, rowcount=0, colcount=0, trace=0,flag1=0,flag2=0;
        Scanner sc  = new Scanner(System.in);
        t=sc.nextInt();
        while(t-->0)
        {
           
           
            n = sc.nextInt();
            int arr[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                    
                }
            }
            for(int i = 0 ; i<n; i++)
            {
                trace+=arr[i][i];
            }
            outerr: for(int i=0;i<n;i++)
            {
                valuer: for(int val=1;val<=n;val++)
                {
                    innerr: for(int j=0;j<n;j++)
                    {
                        if(arr[i][j]==val)
                        {
                            flag1++;
                        }
						
                    }
					if(flag1>1)
					{
						rowcount++;
						flag1=0;
						continue outerr;
					}
					flag1=0;
                }
                
            }
            outerc: for(int i=0;i<n;i++)
            {
                valuec: for(int val=1;val<=n;val++)
                {
                    innerc: for(int j=0;j<n;j++)
                    {
                        if(arr[j][i]==val)
                        {
                            flag1++;
                        }
                    }
					if(flag1>1)
					{
						colcount++;
						flag1=0;
						continue outerc;
					}
					flag1=0;
                }
                
            }
            System.out.print("Case #"+cnt+": "+trace+" "+rowcount+" "+colcount);
            cnt++;
            while(t!=0)
            {
                System.out.println();
			}
			rowcount=0;
			colcount=0;
			trace=0;
            
            
        }
    }
}
