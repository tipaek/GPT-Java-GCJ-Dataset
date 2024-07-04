import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


class Vestigium {
    public static void main(String[] args) {
        InputStream inputStream=System.in;
		OutputStream outputStream=System.out;
		FastReader in=new FastReader(inputStream);
        PrintWriter out=new PrintWriter(outputStream);
        
        int t = in.nextInt();

        for(int l=0;l<t;l++)
        {
            //size of latin matrix
            int n = in.nextInt();

            int r=0;
            int c=0;

            int trace=0;

            int[][] grid = new int[n][n];


            ArrayList<ArrayList<Integer> > a1 = new ArrayList<ArrayList<Integer> >();

            // for(int j=0;j<n;j++) //row
            for(int i=0;i<n;i++)
                {
                    int flag1=0;
                    for(int j=0;j<n;j++)
                    {
                        a1.add(new ArrayList<Integer>());
                        int x = in.nextInt();
                            if(a1.get(i).contains(x)&&flag1!=1)
                            {
                                r++;
                                flag1=1;
                            }
                        a1.get(i).add(j,x);
                        if(i==j)
                            trace+=x;
                    }
    
                }
                //works
                for(int i=0;i<n;i++)
                {
                    ArrayList<Integer> temp=new ArrayList<Integer>(n);
                    for(int j=0;j<n;j++)
                    {
                        int x=a1.get(j).get(i);
                        if(temp.contains(x))
                        {
                            c++;
                            break;
                        }
                        else
                            temp.add(x);
                    }
                }
                out.println("Case #"+l+": "+trace+" "+r+" "+c);
            }
    }
}

 class FastReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private FastReader.SpaceCharFilter filter;

    public FastReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();

        if (curChar >= numChars) {

            curChar = 0;

            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }

            if (numChars <= 0)
                return -1;
        }

        return buf[curChar++];
    }

    public int nextInt() {

        int c = read();

        while (isSpaceChar(c))
            c = read();

        int sgn = 1;

        if (c == '-') {
            sgn = -1;
            c = read();
        }

        int res = 0;

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
