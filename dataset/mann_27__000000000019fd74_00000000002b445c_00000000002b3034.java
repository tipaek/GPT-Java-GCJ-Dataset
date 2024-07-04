import java.io.*;
import java.math.BigInteger; 
import java.util.*;

//Mann Shah [ DAIICT ].
//fast io

public class Solution {
	static int mod = (int) (1e9+7);
	static long N = (long)(2*1e5);
	static InputReader in;
    static PrintWriter out;
    static Debugger deb;
    
    public static int lower_bound(int[] a,int k) { // no. of elements less than k in array.
    		int first = 0,last = a.length,mid;
        while (first < last) {
            mid = first + ((last - first) >> 1); 
            if (a[mid] < k)  //lower bound. for upper use <= ( n - first)
                first = mid + 1; 
            else 
                last = mid;
        }
    		return first;
    }
    
    public static int gcd(int a, int b){ 
	    if (a == 0) 
	        return b;  
	    return gcd(b % a, a);  
    } 
    
    
	public static void main(String args[] ) throws NumberFormatException, IOException  {
			
		in = new InputReader(System.in);
	    out = new PrintWriter(System.out);
	    deb = new Debugger();
	    
	    
	    int T = in.nextInt();
	    int t=1;
	    while(T-->0) {
	    		int n = in.nextInt();
	    		String[] s = new String[n];
	    		int ml =0;
	    		for(int i=0;i<n;i++) {
	    			StringBuilder ss = new StringBuilder();
	    			s[i]= in.readString();
	    			ml = s[i].length() > ml ? s[i].length() : ml;
	    			ss.append(s[i]);
	    			s[i] = ss.reverse().toString();
	    		}
	    		
	    		
	    		StringBuilder sb = new StringBuilder();
	    		int f=0;
	    		for(int i=0;i<ml;i++) {
	    			char c = '.';
	    			for(int j=0;j<n;j++) {
	    				if(i >= s[j].length()) continue;
	    				if(s[j].charAt(i)=='*') {
	    					continue;
	    				}
	    				if(c=='.') {
	    					c=s[j].charAt(i);
	    				}
	    				else {
	    					if(s[j].charAt(i)!=c) {
	    						f=1;
	    					}
	    				}
	    			}
	    			if(c!='.' && f==0) {
	    				sb.append(c);
	    			}
	    		}
	    		out.println("Case #"+t+": "+ (f==1 ? "*" : sb.reverse().toString()));
	    		t++;
	    }
	    
	    out.close();
	}
		
/* TC space



 */
		
		static class InputReader
	    {
	        private final InputStream stream;
	        private final byte[] buf = new byte[8192];
	        private int curChar, snumChars;
	        private SpaceCharFilter filter;

	        public InputReader(InputStream stream)
	        {
	                this.stream = stream;
	        }

	        public int snext()
	        {
	                if (snumChars == -1)
	                        throw new InputMismatchException();
	                if (curChar >= snumChars)
	                {
	                        curChar = 0;
	                        try
	                        {
	                                snumChars = stream.read(buf);
	                        } catch (IOException e)
	                        {
	                                throw new InputMismatchException();
	                        }
	                        if (snumChars <= 0)
	                                return -1;
	                }
	                return buf[curChar++];
	        }

	        public int nextInt()
	        {
	                int c = snext();
	                while (isSpaceChar(c))
	                {
	                        c = snext();
	                }
	                int sgn = 1;
	                if (c == '-')
	                {
	                        sgn = -1;
	                        c = snext();
	                }
	                int res = 0;
	                do
	                {
	                        if (c < '0' || c > '9')
	                                throw new InputMismatchException();
	                        res *= 10;
	                        res += c - '0';
	                        c = snext();
	                } while (!isSpaceChar(c));
	                return res * sgn;
	        }

	        public long nextLong()
	        {
	                int c = snext();
	                while (isSpaceChar(c))
	                {
	                        c = snext();
	                }
	                int sgn = 1;
	                if (c == '-')
	                {
	                        sgn = -1;
	                        c = snext();
	                }
	                long res = 0;
	                do
	                {
	                        if (c < '0' || c > '9')
	                                throw new InputMismatchException();
	                        res *= 10;
	                        res += c - '0';
	                        c = snext();
	                } while (!isSpaceChar(c));
	                return res * sgn;
	        }

	        public int[] nextIntArray(int n)
	        {
	                int a[] = new int[n];
	                for (int i = 0; i < n; i++)
	                {
	                        a[i] = nextInt();
	                }
	                return a;
	        }

	        public long[] nextLongArray(int n)
	        {
	                long a[] = new long[n];
	                for (int i = 0; i < n; i++)
	                {
	                        a[i] = nextLong();
	                }
	                return a;
	        }
	        
	        public ArrayList<Integer> nextArrayList(int n){
	        			ArrayList<Integer> x = new ArrayList<Integer>();
	        			for(int i=0;i<n;i++) {
	        				int v = in.nextInt();
	        				x.add(v);
	        			}
	        			return x;
	        }

	        public String readString()
	        {
	                int c = snext();
	                while (isSpaceChar(c))
	                {
	                        c = snext();
	                }
	                StringBuilder res = new StringBuilder();
	                do
	                {
	                        res.appendCodePoint(c);
	                        c = snext();
	                } while (!isSpaceChar(c));
	                return res.toString();
	        }

	        public String nextLine()
	        {
	                int c = snext();
	                while (isSpaceChar(c))
	                        c = snext();
	                StringBuilder res = new StringBuilder();
	                do
	                {
	                        res.appendCodePoint(c);
	                        c = snext();
	                } while (!isEndOfLine(c));
	                return res.toString();
	        }

	        public boolean isSpaceChar(int c)
	        {
	                if (filter != null)
	                        return filter.isSpaceChar(c);
	                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	        }

	        private boolean isEndOfLine(int c)
	        {
	                return c == '\n' || c == '\r' || c == -1;
	        }

	        public interface SpaceCharFilter
	        {
	                public boolean isSpaceChar(int ch);
	        }

	    }
		
		static class Debugger{
			public void n(int x) {
				out.println(x);
			}
			
			public void a(int[] a) {
		        StringBuilder sb = new StringBuilder();
		        for(int i=0;i<a.length;i++) {
		        		sb.append(a[i]+" ");
		        }
		        out.println(sb.toString());
			}
		}
		
}


class Pairx {
	Pair a;
	int b;
	public Pairx(Pair a,int b) {
		this.a =a;
		this.b =b;
	}
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Pairx)) return false;
	    Pairx p = (Pairx) o;
	    return  b == p.b;
	}
	public int compareTo(Pairx that) {
		return (int)(this.a.x - that.a.x);
	}
}


//Pair arr[] = new Pair[n]; 
//arr[0] = new Pair(10, 20); 
 class Pair { 
    long x; 
    long y; 
  
    // Constructor 
    public Pair(long x, long y) 
    { 
        this.x = x; 
        this.y = y; 
    } 
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Pair)) return false;
	    Pair p = (Pair) o;
	    return x == p.x && y == p.y;
	}
} 
// class Compare { 
//	  //void return by default.
//    static Pair[] compare(Pair arr[], int n) 
//    { 
 
 		// (p1,p2) -> p1.x-p2.x Using lembda function...
 
//        // Comparator to sort the pair according to first element.
//        Arrays.sort(arr, new Comparator<Pair>() { 
//            @Override public int compare(Pair p1, Pair p2) 
//            { 
//                return p1.x - p2.x; 
//            } 
//        }); 
//        
//        return arr;
//    } 
//} 




class couple implements Comparable<couple>
{ int x,y;
  public couple(int m,int f) {
 	 x=m;
 	 y=f;
  }
	public int compareTo(couple o) {
		
		 
		return x-o.x;
	}  
}
