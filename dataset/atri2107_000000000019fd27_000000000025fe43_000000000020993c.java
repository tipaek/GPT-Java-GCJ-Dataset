import java.util.*;
class abc
{
    public static void main(String[] args) {
        int t;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        for(int k=0;k<t;k++)
        {
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                }
            }
            int trace=0,row=0,col=0;
            HashSet<Integer> r;
            HashSet<Integer> c;
            for(int i=0;i<n;i++)
            {
                trace+=a[i][i];
            }
            for(int i=0;i<n;i++)
            {
                r=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    r.add(a[i][j]);
                }
                if(r.size()<n) row++;
            }
            for(int i=0;i<n;i++)
            {
                c=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    c.add(a[j][i]);
                }
                if(c.size()<n) col++;
            }
            System.out.println("Case #"+(k+1)+": "+trace+" "+row+" "+col);

        }
    }
}