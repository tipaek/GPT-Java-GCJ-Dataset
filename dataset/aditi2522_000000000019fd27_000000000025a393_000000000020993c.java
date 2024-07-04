import java.util.*;
class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int t1=1;t1<=t;t1++)
        {
            int n=sc.nextInt();
            int[][] a=new int[n][n];
            int r=0;
            int c=0;
            int trace=0;
            int ans=-1;
            for(int i=0;i<n;i++)
            {
                
                HashSet<Integer> h=new HashSet<Integer>();
                for(int j=0;j<n;j++)
                {
                    
                    a[i][j]=sc.nextInt();
                    if(h.contains(a[i][j])!=true)
                    h.add(a[i][j]);
                    else if(ans!=i)
                    {
                    r++;
                    ans=i;
                    }
                    
                    if(i==j)
                    trace+=a[i][j];
                }
            }
            ans=-1;
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> h=new HashSet<Integer>();
                for(int j=0;j<n;j++)
                {
                    if(h.contains(a[j][i])!=true)
                    h.add(a[j][i]);
                    else if(ans!=i)
                    {
                    c++;
                    ans=i;
                    break;
                    }
                    
                }
            }
            System.out.println("Case #"+t1+": "+trace+" "+r+" "+c);
        }
    }
}