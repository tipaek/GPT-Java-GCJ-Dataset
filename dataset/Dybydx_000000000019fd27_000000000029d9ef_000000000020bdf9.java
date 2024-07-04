import java.util.*;
public class Solution
{
    public static void main (String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int x=1;
        while(t-->0)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[n];
            int J[]=new int[1440];
            int C[]=new int[1440];
            String ans="";
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                b[i]=sc.nextInt();
            }

            for(int i=0;i<n;i++)
            {
                if(check(J,a[i],b[i]))
                {
                    ans=ans+'J';
                    put(J,a[i],b[i]);
                }
                else if(check(C,a[i],b[i]))
                {
                    ans=ans+'C';
                    put(C,a[i],b[i]);
                }
                else
                {
                    ans="IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #"+x+": "+ans);
            x++;
        }

    }
    static boolean check(int arr[],int start,int end)
    {
        for(int i=start;i<end;i++)
        {
            if(arr[i]==1)
            {
                return false;
            }
        }
        return true;
    }
    static void put(int arr[],int start,int end)
    {
        for(int i=start;i<end;i++)
        {
            arr[i]=1;
        }
    }
}