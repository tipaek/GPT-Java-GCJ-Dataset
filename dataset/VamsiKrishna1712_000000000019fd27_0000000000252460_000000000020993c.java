import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> row=new ArrayList<Integer>();
        ArrayList<Integer> col=new ArrayList<Integer>();
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            row.clear();
            col.clear();
            int n=sc.nextInt();
            int[][] a=new int[n][n];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    a[j][k]=sc.nextInt();
                }
            }
            int trace=0;
            for(int j=0;j<n;j++)
            {
                for(int k=j;k<n;k++)
                {
                    trace=trace+a[j][k];
                    break;
                }
            }
            int cnt=0;
            int rcount=0;
            for(int j=0;j<n;j++)
            {
                row.clear();
                for(int k=0;k<n;k++)
                {
                    row.add(a[j][k]);
                }
                cnt=duplicates(row);
                rcount=rcount+cnt;
            }
            int l=0;
            int m=0;
            int cnt1=0;
            int ccount=0;
            for(int j=0;j<n;j++)
            {
                m=0;
                col.clear();
                while(m<n)
                {
                    col.add(a[m][l]);
                    m++;
                }
                l++;
                cnt1=duplicates(col);
                ccount=ccount+cnt1;
            }
            System.out.println("Case #"+(i+1)+": "+ trace+" "+rcount+" "+ccount);
        }
    }
    public static int duplicates(ArrayList<Integer> a)
    {
        //System.out.println(a);
        int c=0;
        for(int i=0;i<a.size();i++)
        {
            for(int j=i+1;j<a.size();j++)
            {
                if(a.get(i)==a.get(j))
                {
                    c=1;
                }
            }
            if(c==1)
            {
                break;
            }
        }
        //System.out.println(c);
        return c;
    }
}
