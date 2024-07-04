import java.io.*;
import java.math.BigInteger; 
import java.util.*;
import java.math.*; 

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
	    int tt=1;
	    while(T-->0) {
	    		out.print("Case #"+tt+": ");
	    		StringBuilder sb = new StringBuilder();
	    		
	    		long x = in.nextLong();
	    		long y = in.nextLong();
	    		
	    		int ngx=0,ngy=0;
	    		if(x<0) {
	    			x = -x;
	    			ngx=1;
	    		}
	    		if(y<0) {
	    			y = -y;
	    			ngy=1;
	    		}

	    		int f=0;
	    		
	    		for(int i=0;i<=5;i++) {
	    			//out.println(x+" "+y);
	    			//out.println(((x>>i)&1) +" "+((y>>i)&1));
	    			if( ((x>>i)&1) == 1 && ((y>>i)&1)==0 ) {
	    				sb.append("E");
	    			}
	    			else if( ((x>>i)&1) == 0 && ((y>>i)&1)==1) {
	    				sb.append("N");
	    			}
	    			else if(((x>>i)&1) == 1 && ((y>>i)&1)==1) {
	    				if(sb.length()==0) {
	    					f=1;
	    					break;
	    				}
	    				if(sb.charAt(sb.length()-1)=='N'){
	    					sb.setCharAt(sb.length()-1, 'S');
	    					y+=(1<<i-1);
	    					sb.append("E");
	    				}
	    				else {
	    					sb.setCharAt(sb.length()-1, 'W');
	    					x+=(1<<i-1);
	    					sb.append("N");
	    				}
	    			}
	    			else {
	    				if(x > (1<<i) || y > (1<<i)) {
	    					f=1;
	    				}
	    				break;
	    			}
	    		}
	    		

	    		if(f==1) {
	    			out.println("IMPOSSIBLE");
	    		}
	    		else {
	    			if(ngx==1) {
	    				for(int i=0;i<sb.length();i++) {
	    					if(sb.charAt(i)=='E') sb.setCharAt(i, 'W');
	    					else if(sb.charAt(i)=='W') sb.setCharAt(i, 'E');
	    				}
	    			}
	    			if(ngy==1) {
	    				for(int i=0;i<sb.length();i++) {
	    					if(sb.charAt(i)=='N') sb.setCharAt(i, 'S');
	    					else if(sb.charAt(i)=='S') sb.setCharAt(i, 'N');
	    				}
	    			}
	    			out.println(sb.toString());
	    		}
	    		tt++;
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
    int x; 
    int y; 
  
    // Constructor 
    public Pair(int x, int y) 
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