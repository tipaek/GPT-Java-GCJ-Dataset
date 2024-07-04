import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;
class Solution{
    static void merge2(int arr[],int arr1[],int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int [n1];
        int R[] = new int [n2];
        int L1[]=new int[n1];
        int R1[]=new int[n2];
        for (int i=0; i<n1; ++i)
        {
            L[i] = arr[l + i];
            L1[i]=arr1[l+i];
        }
        for (int j=0; j<n2; ++j)
        {
            R[j] = arr[m + 1+ j];
            R1[j]=arr1[m+1+j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                arr1[k]=L1[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                arr1[k]=R1[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            arr[k] = L[i];
            arr1[k]=L1[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            arr[k] = R[j];
            arr1[k]=R1[j];
            j++;
            k++;
        }
    }
    static void sort2(int arr[],int arr1[],int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            sort2(arr,arr1, l, m);
            sort2(arr ,arr1, m+1, r);
            merge2(arr,arr1,l, m, r);
        }
    }
    public static void task(InputReader in){
        //---------------------------------Solve here---------------------------------------------------------------------------------
        int t=in.nextInt();
        for(int test=1;test<=t;test++)
        {
            System.out.print("Case #"+test+": ");
            int n=in.nextInt();
            int s[]=new int[n];
            int e[]=new int[n];
            for(int i=0;i<n;i++)
            {
                s[i]=in.nextInt();
                e[i]=in.nextInt();
            }
            sort2(s,e,0,n-1);
            int answer[]=new int[n];
            answer[0]=1;
            int last1=e[0];
            int last2=0;
            boolean flag=false;
            for(int i=1;i<n;i++)
            {
                if(s[i]>=last1)
                {
                    answer[i]=1;
                    last1=e[i];
                }
                else if(s[i]>=last2)
                {
                    answer[i]=2;
                    last2=e[i];
                }
                else
                {
                    flag=true;
                    break;
                }
            }
            if(flag)
                System.out.println("IMPOSSIBLE");
            else
            {
                for(int i=0;i<n;i++)
                {
                    if(answer[i]==1)
                        System.out.print("J");
                    else if(answer[i]==2)
                        System.out.print("C");
                }
                System.out.println();
            }

        }
        
          
        //---------------------------------------------------------------------------------------------------------------------------- 
    }
    public static void main(String[] args)throws IOException {
        try{
            InputStream inputStream = System.in;
            InputReader in = new InputReader(inputStream);
            task(in);
            out.close();
        }
        catch(NumberFormatException e){
            System.out.println(e);
        }
    }
    public static class InputReader {
        /*
        String-nextString()
        int   -nextInt()
        double-nextDouble()
        long  -nextLong()
        char  -nextChar()
        line  -nextLine()
        */
		private InputStream stream;
		private byte[] buf = new byte[8192];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}
		public int nextInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		public String nextString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
		public double nextDouble() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, nextInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E') {
						return res * Math.pow(10, nextInt());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		public long nextLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
		public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }
        public char nextChar(){
            return nextString().charAt(0);
        }
		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
		public String next() {
			return nextString();
		}
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
		private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
	}
}