import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String[] args)throws IOException
	{
		Scanner sc=new Scanner(System.in);
// 		Scanner sc=new Scanner(new File("inp.txt"));
		
		int p,t,i,n,d,ans;
        long slices[];

		p=t=sc.nextInt();

		while(t-->0)
		{
            n=sc.nextInt();
            d=sc.nextInt();
            
            slices=new long[n];
            for(i=0;i<n;i++)
                slices[i]=sc.nextLong();

            Arrays.sort(slices);
            
            if(d==2)
            {
                ans=1;
                for(i=1;i<n;i++)
                {
                    if(slices[i]==slices[i-1])
                    {
                        ans=0;
                        break;
                    }
                }
            }
            else if(d==3)
            {
                ans=2;
                for(i=2;i<n;i++)
                {
                    if(slices[i]==slices[i-1]&&slices[i]==slices[i-2])
                    {
                        ans=0;
                        break;
                    }
                }

                if(ans==2)
                {
                    for(i=1;i<n;i++)
                    {
                        if(slices[i]==slices[i-1]&&i<n-1)
                        {
                            ans=1;
                            break;
                        }
                    }
                    if(ans==2)
                    {
                        for(i=1;i<n;i++)
                        {
                            if(slices[i]%2==1)
                                continue;
                            if(binSearch(slices,slices[i]/2))
                            {
                                ans=1;
                                break;
                            }
                        }
                    }
                }
            }
            else
                ans=1;
            
            System.out.println("Case #"+(p-t)+": "+ans);
		}
	}
    public static boolean binSearch(long a[],long x)//to search for a number
    {
        int u=a.length-1,l=0,mid;
        while(l<=u)
        {
            mid=(l+u)/2;
            if(a[mid]==x)
                return true;
            if(a[mid]>x)
                u=mid-1;
            else
                l=mid+1;
        }
        return false;
    }
}