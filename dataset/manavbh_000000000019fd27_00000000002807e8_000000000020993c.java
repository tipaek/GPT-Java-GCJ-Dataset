import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        int t,ans=0;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        while(t-->0)
        {
            int n,sum=0;
            n=sc.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                }
            }
            for(int i=0;i<n;i++)
                sum+=a[i][i];
            HashMap<Integer,Integer> map=new HashMap<>();
            int reprows=0,repcolumns=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(!map.containsKey(a[i][j]))
                        map.put(a[i][j],1);
                    else
                    {
                        reprows++;
                        map.clear();
                        break;
                    }
                }
                map.clear();
            }
            map.clear();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(!map.containsKey(a[j][i]))
                        map.put(a[j][i],1);
                    else
                    {
                        repcolumns++;
                        map.clear();
                        break;
                    }
                }
                map.clear();
            }
            ans++;
            System.out.println("Case #"+ans+": "+sum+" "+reprows+" "+repcolumns);
        }
    }
}
