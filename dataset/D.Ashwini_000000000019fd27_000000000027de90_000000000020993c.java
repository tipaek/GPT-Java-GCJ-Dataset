import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int x=0;x<t;x++)
        {
            //HashSet<Integer> hs=new HashSet<Integer>();
            int trace=0,rows=0,cols=0;
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                }
            }
	    for(int i=0;i<n;i++)
             {
                 trace=trace+a[i][i];
             }
             for(int i=0;i<n;i++)
             {
                 HashSet<Integer> hs1=new HashSet<Integer>();
                 HashSet<Integer> hs=new HashSet<Integer>();
                 for(int j=0;j<n;j++)
                 {
                    int value=a[i][j];
                        hs.add(value);
                    int value1=a[j][i];
                        hs1.add(value1);
                    
                 }
                 if(hs.size()!=n)
                    rows++;
                 if(hs1.size()!=n)
                    cols++;
             }
             System.out.println("Case #"+(x+1)+": "+trace+" "+rows+" "+cols);
        }
    }
}
