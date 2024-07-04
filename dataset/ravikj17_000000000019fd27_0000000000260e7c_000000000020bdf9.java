import java.util.*;
public class Solution
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int cs=1;
        while(t-->0)
        {
            ArrayList<Integer> l1=new ArrayList<Integer>();
            ArrayList<Integer> l2=new ArrayList<Integer>();
            int n = sc.nextInt();
            int s[] = new int[n];
            int e[] = new int[n];
            for(int i=0;i<n;i++)
            {
                s[i]=sc.nextInt();
                e[i]=sc.nextInt();
            }
            String s1="C";
            l1.add(0);
            outer:for(int i=1;i<n;i++)
            {
                if(i==1)
                {
                    s1=s1+"J";
                    l2.add(i);
                    continue;
                }
                for(int j=0;j<l1.size();j++)
                {
                    if(s[i]>= e[l1.get(j)]||e[i]<=s[l1.get(j)])
                    {
                        s1=s1+"C";
                        l1.add(i);
                        continue outer;
                    }
                }
                for(int j=0;j<l2.size();j++)
                {
                    if(s[i]>=e[l2.get(j)]||e[i]<=s[l2.get(j)])
                    {
                        s1=s1+"J";
                        l2.add(i);
                        continue outer;
                    }
                }
            }
            if(n!=s1.length())
                s1="IMPOSSIBLE";
            System.out.println("Case #" + cs + ": " + s1);
            cs++;
        }
    }
}
