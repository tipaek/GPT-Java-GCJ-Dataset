import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

/* Name of the class has to be "Main" only if the class is public*/
public class Solution
{
    static class FastReader {
        
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
        
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    
    static class Node {
        
        long pp;
        long a, b;
        
        Node(long x, long y) {
            a = x;
            b = y;
            pp = a * b;
        }
    }
    static class Comp implements Comparator<Node> {
        
        public int compare(Node o1, Node o2) {
            if (o1.pp > o2.pp) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    static int gcd(int x, int y)
    {
        if(y==0) return x;
        else return gcd(y,x%y);
    } 
    static class Pair
    {
        int start,end;
        Pair(int start, int end)
        {
            this.start=start; this.end=end;
        }
    }
    static class SortbyStart implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.start-b.start;
        }
    }
    
    public static void main(String[] args) {
        FastReader sc=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        //your code starts here
        int t=sc.nextInt();
        for(int q=1;q<=t;q++)
        {
            int n=sc.nextInt();
            Pair a[]=new Pair[n];
            for(int i=0;i<n;i++)
            {
                a[i]=new Pair(sc.nextInt(),sc.nextInt());
            }
            Arrays.sort(a, new SortbyStart());
            StringBuffer ans=new StringBuffer(); 
            int c1,c2,j1,j2; c1=c2=j1=j2=0; 
            for(int i=0;i<n;i++)
            {
                if(c2<=a[i].start) 
                {
                    c1=a[i].start;
                    c2=a[i].end;
                    ans.append("C");
                }
                else if(j2<=a[i].start) 
                {
                    j1=a[i].start;
                    j2=a[i].end;
                    ans.append("J");
                }
                else 
                {
                    ans=new StringBuffer("IMPOSSIBLE");
                    break;
                }
            }
            out.println("Case #"+q+": "+ans.toString());
        }

        out.close();
    }
}
