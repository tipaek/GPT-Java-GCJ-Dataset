import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int pr=1;
        while(t-->0)
        {
            int n=sc.nextInt();
            HashSet<Integer> r[]=new HashSet[n];
            HashSet<Integer> c[]=new HashSet[n];
            for(int i=0;i<n;i++)
            {
                r[i]=new HashSet<>();
                c[i]=new HashSet<>();
            }
            int tr=0,nr=0,nc=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    int temp=sc.nextInt();
                    if(i==j)
                    {
                        tr+=temp;
                    }
                    r[i].add(temp);
                    c[j].add(temp);
                }
            }
            for(int i=0;i<n;i++)
            {
                if(r[i].size()!=n)
                {
                    nr++;
                }
                if(c[i].size()!=n)
                {
                    nc++;
                }
            }
            System.out.println("Case #"+pr+": "+tr+" "+nr+" "+nc);
            pr++;
        }
    }
}