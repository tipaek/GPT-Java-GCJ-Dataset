import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;


class Vestigium {
    public static void main(String[] args) {
        InputStream inputStream=System.in;
		OutputStream outputStream=System.out;
		FastReader in=new FastReader(inputStream);
        PrintWriter out=new PrintWriter(outputStream);
        
        int t=in.nextInt();

        for(int i=0;i<t;i++)
        {
            //size of latin matrix
            int n = in.nextInt();

            int row=0;
            int col=0;

            int trace=0;

            int[][] grid = new int[n][n];

            for(int j=0;j<n;j++) //col
            {
                //for finding dupliacte rows
                HashSet<Integer> hRow = new HashSet<Integer>(); 
                boolean foundRow = false;

                for(int k=0;k<n;k++) //row
                {
                    grid[j][k] = in.nextInt();

                    if(foundRow != true)                //if we haven't found a duplicate yet in this row
                        if(hRow.contains(grid[j][k]))   //if we haven't check if this is a duplicate
                            foundRow=true;              //make it trrue because we found one
                        else
                            hRow.add(grid[j][k]);
                    if(j==k)
                        trace+= grid[j][k];
                }
                if(foundRow)
                    row++;
            }

            //find duplicates in columns
            for(int j=0;j<n;j++)
            {
                HashSet<Integer> hCol = new HashSet<Integer>(); 
                boolean foundCol = false;

                for(int k=0;k<n;k++)
                {
                    if(!foundCol)
                        if(hCol.contains(grid[k][j]))
                            foundCol=true;
                        else
                            hCol.add(grid[k][j]);

                }
                if(foundCol)
                    col++;
            }

            System.out.println("Case #"+(i+1)+": "+trace+" "+row+" "+col);

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
