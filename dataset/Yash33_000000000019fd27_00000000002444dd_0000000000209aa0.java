import java.io.*;
import java.util.*;
 
public class Solution implements Runnable {
   
    static boolean isValid(int a[][],int x,int row,int col,int k)
    {
        int sum = x;
         
        for(int i=0;i<a.length;i++)
        {
            if(a[i][col] ==x || a[row][i]==x)
                return false;
            sum += a[i][i];
        }
       
        if(row==col && row==a.length-1)
        {
            if(sum!=k)
                return false;
        }
        if(row==col && sum>k)
        return false;
 
        return true;
    }
   
    static boolean findAns(int a[][],int n,int k)
    {
        boolean finished = true;
        int row = -1, col = -1;
        for(int i=0;i<n;i++)
        {
                for(int j=0;j<n;j++)
                {
                    if(a[i][j]==0)
                    {
                        row = i;
                        col = j;
                        finished = false;
                        break;
                    }
                }
                if(!finished)
                break;
        }
        if(finished)
            return true;
       
        for(int i=1;i<=n;i++)
        {
            if(isValid(a,i,row,col,k))
            {
                a[row][col] = i;
                if(findAns(a,n,k))
                {
                    return true;
                }
                else
                {
                    a[row][col] = 0;
                }
            }
        }
        return false;
    }
   
    static void fillDiag(int a[][],int k)
    {
        for(int i=0;i<a.length;i++)
        {
            a[i][i]=a.length;
        }
       
        int sum = a.length*a.length;
       
        for(int i = a.length-1;i>=0;i--)
        {
            if(sum==k)
                break;
            int x = sum-k;
            x = Math.min(a[i][i]-1,x);
            a[i][i]-=x;
            sum-=x;
        }
    }
   
    static boolean solve(int testcase,int n,int k,int a[][])
    {
        
        if(findAns(a,n,k))
		return true;
		
        return false;  
    }
   static volatile boolean isDone;
    static void printArray(int a[][])
    {
        for(int i[]:a)
        {
            for(int j:i)
                System.out.print(j+" ");
            System.out.println();
        }
    }
   
    public void run() {
       
        InputReader sc = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
       
        int t = sc.nextInt();
   
        for(int i=1;i<=t;i++)
        {
			int n = sc.nextInt();
			int a[][] = new int[n][n];
			int k = sc.nextInt();
			
			if(k==(n+1) || k==(n*n-1))
			{
				System.out.println("Case #"+i+": IMPOSSIBLE");
				continue;
			}
			
			 isDone = false;
			
            if(findDiag(a,n,k,i))
            {
				System.out.println("Case #"+i+": POSSIBLE");
				printArray(a);
			}
            else
            {		
				System.out.println("Case #"+i+": IMPOSSIBLE");
			}        
        }
        out.close();
    }
    
    static boolean findDiag(int a[][],int n,int k,int testcase)
    {
        boolean finished = true;
        int row = -1, col = -1;
        for(int i=0;i<n;i++)
        {
		       if(a[i][i]==0)
               {
                   row = i;
                   col = i;
                   finished = false;
                   break;
               }
		}
        if(finished)
		{
			return solve(testcase,a.length,k,a);
		}
       
        for(int i=1;i<=n;i++)
        {
            if(isValidDiag(a,i,row,col,k,testcase))
            {
                a[row][col] = i;
                if(findDiag(a,n,k,testcase))
                {
                    return true;
                }
                else
                {
                    a[row][col] = 0;
                }
            }
        }
        return false;
    }
	
	static boolean isValidDiag(int a[][],int x,int row,int col,int k,int testcase)
	{
		int sum=x;
		for(int i=0;i<row;i++)
		{
			sum+=a[i][i];
		}
		if(sum>k)return false;
		if(row==a.length-1 && sum!=k)return false;
		
		return true;	
	}

    
   
//======================================================================    
   
    static class SortPair implements Comparator<Pair>
    {
        public int compare(Pair a, Pair b)
        {
            if(a.a != b.a)
                return a.a - b.a;
            return a.b - b.b;
        }
    }
   
    static class Pair
    {
        int a,b,in;
        Pair(int aa, int bb,int ii)
        {
            a = aa;
            b = bb;
            in=ii;
        }
        public String toString()
        {
            return "["+a+" "+b+"]";
        }
    }
 
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        public InputReader(InputStream stream) {
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
                while (!isSpaceChar(c)) {
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
       
        public String readString() {
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
     
        public String next() {
            return readString();
        }
       
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
 
    public static void main(String args[]) throws Exception {
        new Thread(null, new Solution(),"Main",1<<27).start();
    }
}
