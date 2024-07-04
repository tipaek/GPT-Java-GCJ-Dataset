import java.io.*;
import java.util.*;
class FastReader
{
    BufferedReader br;
    StringTokenizer st;
    FastReader()
    {
        br=new BufferedReader(new InputStreamReader(System.in));
    }
    String next()throws IOException
    {
        while(st==null ||!st.hasMoreTokens())
        {
            st=new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
    int nextInt()throws IOException
    {
        return Integer.parseInt(next());
    }
}

class codechef
{
    public static void main(String args[])
    {
        try
        {
            FastReader fr=new FastReader();
            int t=fr.nextInt();
            for(int x=1;x<=t;x++)
            {
                int n=fr.nextInt();
                int m[][]=new int[n][n];
                int k=0;
                int ar[]=new int[n+1];
                int r=0;
                int c=0;
                for(int y=0;y<n;y++)
                {
                    for(int z=0;z<n;z++)
                    {
                        m[y][z]=fr.nextInt();
                        if(y==z)
                        {
                            k+=m[y][z];
                        }
                    }
                }
                for(int y=0;y<n;y++)
                {
                    Arrays.fill(ar,0);
                    for(int z=0;z<n;z++)
                    {
                        ar[m[y][z]]++;
                        if(ar[m[y][z]]>1)
                        {
                            r++;
                            break;
                        }
                    }
                }
                for(int z=0;z<n;z++)
                {
                    Arrays.fill(ar,0);
                    for(int y=0;y<n;y++)
                    {
                        ar[m[y][z]]++;
                        if(ar[m[y][z]]>1)
                        {
                            c++;
                            break;
                        }
                    }
                }
                System.out.println("Case #"+x+": "+k+" "+r+" "+c);
            }
        }
        catch(Exception e)
        {
            System.exit(0);
        }
    }
}