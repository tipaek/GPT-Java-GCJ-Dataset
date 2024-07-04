import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
 class Solution
{
	public static void main(String args[]) throws IOException
	{
		InputStream inputStream=System.in;
		OutputStream outputStream=System.out;
		FastReader in=new FastReader(inputStream);
		PrintWriter out=new PrintWriter(outputStream);
		int t=in.nextInt();
		Depth solver=new Depth();
		for(int i=1;i<=t;i++)
			solver.solve(i,in,out);
		out.close();

	}

	static class Depth
	{
		public void solve(int t,FastReader s,PrintWriter w)
		{
            //test case
            String S=s.next();
            
            //output
            String res="";
            
            int pv=0;
            int fp=0,bp=0;
            
			for(int i=0;i<S.length();i++)
			{
                char c=S.charAt(i);
                
                //characetr value
                int cv=Integer.parseInt(String.valueOf(c));
                
                //first case
				if(res.length()==0)
				{
                    //add paranthesis for first char value
					for(int j=0;j<cv;j++)
					{
                        res+="(";
                        //increase front paranthesis count
						fp++;
                    }
                    //add char too string
					res+=c;
				}
				else
				{   
                    //if current is greater than previous add diff more (
					if(cv>pv)
					{
						int d=cv-pv;
						for(int k=0;k<d;k++)
                            res+="(";

                        //add current number to string and
                        res+=c;
                        
                        //record how many more front paranthesis we added
						fp+=d;
                    }
                    
                    //previous value is higher than the current value so close off parns for last number
					else if(cv<pv)
					{
						int d=pv-cv;
						for(int k=0;k<d;k++)
                            res+=")";
                        //add number
                        res+=c;

                        //increase back parn count
						bp+=d;
					}
                    else
						res+=c;
				}

                //assign previous value
				pv=cv;
            }
            
            //add back parns until it is even with front parn
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