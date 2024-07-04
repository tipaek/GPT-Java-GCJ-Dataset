import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();
        StringBuilder sb=new StringBuilder();
        int cases=1;
        while(t-->0)
        {
            int n=ob.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                a[i][j] = ob.nextInt();
            }
            int trace=0;
            for(int i=0;i<n;i++)
            trace+=a[i][i];
            int rows=0;
            int cols=0;
            for(int i=0;i<n;i++) // rows
            {
                Set<Integer> set1=new HashSet<Integer>();
                for(int j=0;j<n;j++)
                set1.add(a[i][j]);
                if(set1.size()!=n)
                rows++;
                
                Set<Integer> set2=new HashSet<Integer>();
                for(int j=0;j<n;j++)
                set2.add(a[j][i]);
                if(set2.size()!=n)
                cols++;
            }
            sb.append("Case #"+cases+": "+trace+" "+rows+" "+cols+"\n");
            cases++;
        }
        System.out.println(sb);
    }
}