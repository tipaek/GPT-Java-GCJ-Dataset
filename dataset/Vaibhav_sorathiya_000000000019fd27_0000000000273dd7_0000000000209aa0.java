import java.io.*;
import java.util.*;

class Solution {

    
    static boolean generateArray(int a[][],int n,int k)
    {
        boolean isOver = true;
        int row = -1, col = -1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i][j]==0)
                {
                    row = i;
                    col = j;
                    isOver = false;
                    break;
                }
            }
            if(!isOver)
                break;
        }
        if(isOver)
            return true;

        for(int i=1;i<=n;i++)
        {
            if(isValid(a,i,row,col,k))
            {
                a[row][col] = i;
                if(generateArray(a,n,k))
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

    

    static void printArray(int a[][],PrintWriter out)
    {
        for(int i[]:a)
        {
            for(int j:i)
                out.print(j+" ");
            out.println();
        }
    }
    static void handleInput(FastReader fd, PrintWriter out, int testcase)
    {
        int n = fd.nextInt();
        int a[][] = new int[n][n];

        int k = fd.nextInt();

        if(generateArray(a,n,k))
        {
            out.println("Case #"+testcase+": POSSIBLE");
            printArray(a,out);
        }
        else
        {
            out.println("Case #"+testcase+": IMPOSSIBLE");

        }

    }

    public static void main(String[] args) {
        FastReader fd = new FastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = fd.nextInt();

        for(int i=1;i<=t;i++)
        {
            handleInput(fd,out,i);
        }
        out.close();

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

   
}
