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
			int ce=0,je=0,cs=0,js=0,flag=0;
			String res="";
			for(int i=0;i<n;i++)
			{
				start[i]=s.nextInt();
				end[i]=s.nextInt();
			}
			for(int i=0;i<n;i++)
			{
				if(i==0) 
				{	
					res+="J";
					je=end[0];
					js=start[0];	
				}
				else
				{
					char ch=res.charAt(i-1);
					if(start[i]>end[i-1])
					{
						if(ch=='C')
						{
							res+='C';
							ce=end[i];
							cs=start[i];
						}
						else
						{
							res+='J';
							je=end[i];
							js=start[i];
						}
					}
					else if(start[i]==end[i-1])
					{
						if(ch=='C')
						{
							res+='C';
							ce=end[i];
						}
						else
						{
							res+='J';
							je=end[i];
						}
					}
					else
					{
						if(start[i]<end[i-1]&&start[i]>=start[i-1])
						{
							if(ch=='C')
							{
								if(je<=start[i]||js>=end[i])
								{
									res+="J";
									js=start[i];
									je=end[i];
								}
								else
								{
									flag=1;
									break;
								}
							}
							else
							{
								if(ce<=start[i]||cs>=end[i])
								{
									res+="C";
									cs=start[i];
									ce=end[i];
								}
								else
								{
									flag=1;
									break;
								}
							}
						}
						else if(start[i]<start[i-1])
						{
							if(end[i]<=end[i-1])
							{
								if(ch=='C'&&(js>=end[i]||je<=start[i]))
								{
									res+='J';
									js=start[i];
									je=end[i];
								}
								else
								{
									if(cs>=end[i]||ce<=start[i])
									{
										res+='C';
										cs=start[i];
										ce=end[i];
									}
									else
									{
										flag=1;
										break;
									}
								}
							}
							else
							{
								if(ch=='C')
								{
									if(js>=end[i]||je<=start[i])
									{
										res+='J';
										js=start[i];
										je=end[i];
									}
									else
									{
										flag=1;
										break;
									}
								}
								else
								{
									if(cs>=end[i]||ce<=start[i])
									{
										res+='J';
										cs=start[i];
										ce=end[i];
									}
									else
									{
										flag=1;
										break;
									}
								}
							}
						}
					}
				}
			}
			if(flag==1)
				w.println("Case #"+t+": IMPOSSIBLE");
			else
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