import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
public class Solution
{
	public static void main(String args[]) throws IOException
	{
		InputStream inputStream=System.in;
		OutputStream outputStream=System.out;
		FastReader in=new FastReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		int t=in.nextInt();
		vestigium solver=new vestigium();
		for(int i=1;i<=t;i++)
			solver.solve(i,in,out);
		out.close();

	}

	static class vestigium
	{
		public void solve(int t,FastReader s,PrintWriter w)
		{
			String S=s.next();
			String res="";
			int pv=0;
			int fp=0,bp=0;
			for(int i=0;i<S.length();i++)
			{
				char c=S.charAt(i);
				int cv=Integer.parseInt(String.valueOf(c));
				if(res.length()==0)
				{
					for(int j=0;j<cv;j++)
					{
						res+="(";
						fp++;
					}
					res+=c;
				}
				else
				{
					if(cv>pv)
					{
						int d=cv-pv;
						for(int k=0;k<d;k++)
							res+="(";
						res+=c;
						fp+=d;
					}
					else if(cv<pv)
					{
						int d=pv-cv;
						for(int k=0;k<d;k++)
							res+=")";
						res+=c;
						bp+=d;
					}
					else
						res+=c;
				}

				pv=cv;
			}
			while(fp!=bp)
				{
					res+=")";
					bp++;
				}
			w.println("Case #"+t+": "+res);
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