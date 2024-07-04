import java.io.*;
import jaav.util.HashSet;

public class a
{
    public static void main(String a[])throws IOException
    {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bf.readLine());
        for(int i=0;i<t;i++)
        {
            int n=Integer.parseInt(bf.readLine());
            int trace=0,rows=0,cols=0;
            int a[][]=new int[n][n];
           
            for(int j=0;j<n;j++)
            {
                String s[]=bf.readLIne().split(" ");
                for(int k=0;k<n;k++)
                a[j][k]=Integer.parseInt(s[k]);
            }
            //finding trace
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<n;k++)
                {
                    if(j==k)
                    trace+=a[j][k];
                }
            }
            //finding number of rows
            for(int j=0;j<n;j++)
            {
                HashSet<Integer> hs=new HashSet<>();
                for(int k=0;k<n;k++)
                {
                    hs.add(a[j][k]);
                }
                if(hs.size()!=n)
                ++rows;
            }
            //finding number of cols
            for(int j=0;j<n;j++)
            {
                HashSet<Integer> hs=new HashSet<>();
                for(int k=0;k<n;k++)
                {
                    hs.add(a[k][j]);
                }
                if(hs.size()!=n)
                ++cols;
            }
            System.out.println("Case #"+(i+1)+": "+trace+" "+rows+" "+cols);
        }
    }
}