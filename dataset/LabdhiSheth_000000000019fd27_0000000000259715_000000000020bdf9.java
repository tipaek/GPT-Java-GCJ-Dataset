
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
        
        for(int k = 0;k<t;k++)
        {
        	int n = sc.nextInt();
        	int arr[][] = new int[n][2];
        	int m[][] = new int[n][4];
        	
        	for(int i=0;i<n;i++)
        	{
        		arr[i][0] = sc.nextInt();
        		m[i][0] = arr[i][0];
        		arr[i][1] = sc.nextInt();
        		m[i][1] = arr[i][1];
        	}
        	
        	//sorting
        	for (int i = 0; i < n; i++)
                {
        			for (int j = i+1; j < n; j++)
        				{
        					if (m[i][0] > m[j][0])
        					{
                                int temp1 = m[i][0];
                                m[i][0] = m[j][0];
                                m[j][0] = temp1;
                                
                                int temp2 = m[i][1];
                                m[i][1] = m[j][1];
                                m[j][1] = temp2;
                            }
        				}  
                }
        	
        	int c1 = -1,c2 = -1;
        	int j1 = m[0][0];
        	int j2 = m[0][1];
        	
        	int j = 1,y=0,flag = 0;
        	
        	while(c1 == -1 && j<n)
        	{
        		if(j1 <= m[j][0])
        		{
        			j2 = m[j][1];
        			j1 = m[j][0];
        			m[j][2] = 1;
        		}
        		else
        		{
        			c1 = m[j][0];
        			c2 = m[j][1];
        			m[j][2] = 2;
        		}
        		j++;
        		y = j;
        	}
        	
        	for(j = y;j<n;j++)
        	{
        		if(j2 <= m[j][0])
        		{
        			j2 = m[j][1];
        			j1 = m[j][0];
        			m[j][2] = 1;
        		}
        		else if(c2 <= m[j][0])
        		{
        			c1 = m[j][0];
        			c2 = m[j][1];
        			m[j][2] = 2;
        		}else
        		{
        			flag = -1;
        		}
        	}
        	
        	String str = "";
        	
        	if(flag == -1)
        	{
        		str = "IMPOSSIBLE";
        	}
        	else
        	{
        		for(j = 0;j<n;j++)
        		{
        			for(int l = 0;l<n;l++)
        			{
        				if(arr[j][0] == m[l][0] && arr[j][1] == m[l][1] && m[l][3] == 0)
        				{
        					if(m[l][2] == 1)
        					{
        						str += 'C';
        					}
        					else
        					{
        						str += 'J';
        					}
        					m[l][3] = 1;
        					break;
        				}
        			}
        		}
        	}
        	
        	w.println("Case #"+(k+1)+": "+str);
        	
        }
        w.close();
    }
}