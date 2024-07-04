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
    static int isEmpty(int m[][], int i, int j, int n)
    {
    	for(i=0;i<n;i++)
    	{
    		for(j=0;j<n;j++)
    		{
    			if(m[i][j] == 0)
    			{	
    				return 1;
    			}
    		}
    	}
    	return 0;
    }

    static int uniqueRow(int m[][], int rows, int j, int n)
    {
    	rows--;
    	for(int i=0;i<n;i++)
    	{
    		if(m[rows][i] == j )
    		{
    			return 0;
    		}
    	}
    	return 1;
    }
    
    static int uniqueCol(int m[][], int cols , int j, int n)
    {
    	cols--;
    	for(int i=0;i<n;i++)
    	{
    		if(m[i][cols] == j )
    		{
    			return 0;
    		}
    	}
    	return 1;
    }
    
    static int sumK(int m[][], int n)
    {
    	int sum = 0;
    	for(int i=0; i<n; i++)
    	{
    		sum += m[i][i];
    	}
    	return sum;
    }
    
    static int generateMatrix(int m[][],int n,int k)
    {
    	int rows=5, cols=5;
    	
    	if(isEmpty(m,rows,cols,n) == 0)
    	{
    		return 1;
    	}
    	
    	for(int j =1;j<=n;j++)
    	{
    		if(uniqueRow(m,rows,j,n) * uniqueCol(m,cols,j,n) == 1)
    		{
    			m[rows][cols] = j;
    			
    			if(generateMatrix(m,n,k) == 1 && sumK(m,n) == k)
    			{
    				return 1;
    			}
    			m[rows][cols] = 0;
    		}
    	}
    	
    	return 0;
    }
    public static void main(String args[])
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader sc = new FastReader(inputStream);
        PrintWriter w = new PrintWriter(outputStream);
        
        int t = sc.nextInt();
        int grid[][][] = new int[44][5][5];
    	//Arrays.fill(grid , 0);
        
        for(int l = 0;l < t; l++)
        {
        	int n = sc.nextInt();
        	int k = sc.nextInt();
        	
        	if(generateMatrix(grid[l],n,k) == 1)
        	{
        		w.println("Case #"+(l+1)+": "+"POSSIBLE");
        		for(int i =0;i<n;i++)
        		{
        			for(int j =0;j<n;j++)
        			{
        				w.print(grid[l][i][j]+" ");
        			}
        			w.println();
        		}
        	}
        	else
        	{
        		w.println("Case #"+(l+1)+": "+"IMPOSSIBLE");
        	}
        }
        w.close();
    }
}