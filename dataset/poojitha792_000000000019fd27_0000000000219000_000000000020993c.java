import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        int t;
        int test=1;
        Scanner s=new Scanner(System.in);
        t=s.nextInt();
        while(t-->0)
        {
            int n=s.nextInt();
            int [][]a=new int[n][n];
            int i,j,sum=0;
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++){
                a[i][j]=s.nextInt();
                if(i==j)
                sum=sum+a[i][j];
                }
            }
            int r=0,c=0;
            HashSet<Integer> h = new HashSet<>();
            HashSet<Integer> h1 = new HashSet<>();
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                   h.add(a[i][j]);
                   h1.add(a[j][i]);
                }
                if(h.size()!=n)
                r++;
                if(h1.size()!=n)
                c++;
                h1.clear();
                h.clear();
            }
            System.out.println("Case #"+(test++)+": "+sum+" "+r+" "+c);
            
        }
        s.close();
    }
}