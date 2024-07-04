import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class parenting
{
	public static void main(String args[]) throws IOException
	{
		InputStream inputStream=System.in;
		OutputStream outputStream=System.out;
		FastReader in=new FastReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		int t=in.nextInt();
		Parenting solver=new Parenting();
		for(int i=1;i<=t;i++)
			solver.solve(i,in,out);
		out.close();

	}

	static class Parenting
	{

		public void solve(int t,FastReader s,PrintWriter w)
		{

			int n=s.nextInt();
			int[] start=new int[n];
            int[] end=new int[n];
            int Js=0, Je=0, Cs=0, Ce=0;
            boolean jOn=false, sOn=false;
            String res="";
            // char c='';
            
            //ArrayList<Parenting> schedules = new ArrayList<>();

            //take soonest time (that is after the end)
            for(int i=0;i<n;i++)
            {
                start[i] = s.nextInt();
                end[i] = s.nextInt();
            }

            //give someone a job
            for(int i=0;i<n;i++)
            {
                if(i==0)
                {
                    res+="J";
                    Js = start[i];
                    Je = end[i];
                    jOn=true;
                }
                else
                {
                    //J is either busy or not busy
                    if(end[i-1]<start[i])
                    {
                        res+="J";
                        Js = start[i];
                        Je = end[i];
                    }
                    else if(end[i-1]>start[i])
                    {
                        res+="C";
                        Cs = start[i];
                        Ce = end[i];
                    }
                    else //both can't make it so it is impossible
                    {
                        System.out.println("impossible!");
                        return;
                    }
                }
            }
            System.out.println(res);
		}

	}

	static class FastReader {
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
}