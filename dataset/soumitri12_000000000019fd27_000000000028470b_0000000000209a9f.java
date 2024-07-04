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
    static String nesting(int x, int flag)
    {
        String res="";
        if(flag==1) // opening brackets
        for(int i=0;i<x;i++) res+="(";
        else for(int i=0;i<x;i++) res+=")";
        return res;
    }
    
    public static void main(String[] args) {
        FastReader sc=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        //your code starts here
        int t=sc.nextInt();
        for(int q=1;q<=t;q++)
        {
            String str=sc.next(); int n=str.length();
            char[] s=str.toCharArray();
            StringBuffer sb=new StringBuffer();
            int nest=0;
            for(int i=0;i<s.length;i++)
            {
                int num=s[i]-48;
                if(num==nest) sb.append(s[i]);
                else if(num>nest) // open nesting
                {
                    int x=num-nest;
                    String open=nesting(x,1);
                    sb.append(open).append(s[i]);
                    nest+=x;
                }
                else // close nesting
                {
                    int x=nest-num;
                    String close=nesting(x,0);
                    sb.append(close).append(s[i]);
                    nest-=x;
                }
            }
            if(nest>0) sb.append(nesting(nest,0));
            
            out.println("Case #"+q+": "+sb.toString());
        }

        out.close();
    }
}
