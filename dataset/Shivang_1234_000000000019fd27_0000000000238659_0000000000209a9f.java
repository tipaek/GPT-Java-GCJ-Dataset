import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
//BigInteger A;
//A= BigInteger.valueOf(54);
//ArrayList<Integer> a=new ArrayList<>();
//TreeSet<Integer> ts=new TreeSet<>();
//HashMap<Integer,Integer> hm=new HashMap<>();
//PriorityQueue<Integer> pq=new PriorityQueue<>();
class Codejam
{
    public static void main(String[]args)throws IOException
    {
        int K=(int)Math.pow(10,9)+7;
        FastReader ob=new FastReader();
        int t=ob.nextInt();
        for(int l=1;l<=t;l++)
        {
            String s=ob.nextLine();
            StringBuffer ans=new StringBuffer();
            for(int j=0;j<(int)(s.charAt(0)-48);j++)
            ans.append("(");
            ans.append(s.charAt(0));
            for(int i=1;i<s.length();i++)
            {
                int x=(int)(s.charAt(i)-s.charAt(i-1));
                if(x<0)
                {
                    x*=-1;
                    for(int j=0;j<x;j++)
                    ans.append(")");
                    ans.append(s.charAt(i));
                }
                else
                {
                    for(int j=0;j<x;j++)
                    ans.append("(");
                    ans.append(s.charAt(i));
                }
            }
            for(int j=0;j<(int)(s.charAt(s.length()-1)-48);j++)
            ans.append(")");
            System.out.println("Case #"+l+": "+ans);
        }
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e)  {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    public String nextLine()
    {
        String s="";
        try {
        s=br.readLine();
        } catch (IOException e)  {
                e.printStackTrace();
            }
        return s;
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong() {
        return Long.parseLong(next());
    }
    public double nextDouble() {
        return Double.parseDouble(next());
    }
}