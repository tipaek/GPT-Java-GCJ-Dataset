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
    
    public static void main(String[] args) {
        FastReader sc=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        //your code starts here
        int t=sc.nextInt();
        for(int q=1;q<=t;q++)
        {
            int n=sc.nextInt();
            int mat[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                mat[i][j]=sc.nextInt();
            }
            // to find trace
            long tr=0l;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(i==j) tr+=mat[i][j];
                }
            }
            // to find repeating element count
            int r=0,c=0;
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> hrow=new HashSet<>();
                HashSet<Integer> hcol=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    hrow.add(mat[i][j]);
                    hcol.add(mat[j][i]);
                }

                if(hrow.size()!=n) ++r;
                if(hcol.size()!=n) ++c;
                hrow.clear();
                hcol.clear();

            }
            // printing output
            out.println("Case #"+q+": "+tr+" "+r+" "+c);
        }

        out.close();
    }
}
