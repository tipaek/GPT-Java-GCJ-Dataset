
import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution{
    public static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        public FastReader(InputStream stream) {
            this.stream = stream;
        }
        public int read() {
            if (numChars==-1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }
                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
        public String nextLine() {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();
            while(isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }
        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c))
                {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
        public char nextChar() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char)c;
        }
        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));
            return res.toString();
        }
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
    static long gcd(long a, long b){
        if (a == 0)
            return b;  
        return gcd(b % a, a);  
    }
    static long lcm(long a, long b)  {
        return (a*b)/gcd(a, b);  
    }
    static long func(long a[],long size,int s){
        long max1=a[s];
        long maxc=a[s];
        for(int i=s+1;i<size;i++){
            maxc=Math.max(a[i],maxc+a[i]);
            max1=Math.max(maxc,max1);
        }
        return max1;
    }
    
    public static void main(String args[])
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader sc = new FastReader(inputStream);
        PrintWriter w = new PrintWriter(outputStream);
        
        int t = sc.nextInt();
        
        for(int k=0;k<t;k++)
        {
        	int n = sc.nextInt();
        	int a[][] = new int[n][n];
        	
        	for(int i =0;i<n;i++)
        	{
        		for(int j = 0;j<n;j++)
        		{
        			a[i][j] = sc.nextInt();
        		}
        	}
        	
        	int sum = 0;
        	for(int i =0;i<n;i++)
        	{
        		for(int j = 0;j<n;j++)
        		{
        			if(i == j)
        				sum += a[i][j];
        		}
        	}
        	
        	int count1 = 0;
        	int rows = a.length;
        	int col = a[0].length;
        	for(int i =0;i<rows;i++)
        	{
        		HashSet<Integer> set = new HashSet<Integer>();
        		for(int j =0;j<col;j++)
        		{
        			if(!set.contains(a[i][j]))
        				set.add(a[i][j]);
        		}
        		if(set.size() != n)
        			count1++;
        	}
        	
        	int count2 = 0;
        	for(int i =0;i<col;i++)
        	{
        		HashSet<Integer> set = new HashSet<Integer>();
        		for(int j =0;j<rows;j++)
        		{
        			set.add(a[j][i]);
        		}
        		if(set.size() != n)
        			count2++;
        	}
        	w.println("Case #"+(k+1)+": "+sum+" "+count1+" "+count2);
        	
        }
        w.close();
    }
}