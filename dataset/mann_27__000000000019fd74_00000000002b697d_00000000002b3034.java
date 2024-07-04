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
	    		StringBuilder[] s1 = new StringBuilder[n];
	    		StringBuilder[] s2 = new StringBuilder[n];
	    		int ml1=0,ml2 =0;
	    		for(int i=0;i<n;i++) {
	    			String s= in.readString();
	    			int star=0;
	    			s1[i] = new StringBuilder();
	    			s2[i] = new StringBuilder();
	    			for(int j=0;j<s.length();j++) {
	    				if(star==0) {
	    					if(s.charAt(j)=='*') {
	    						star=1;
	    						continue;
	    					}
	    					s1[i].append(s.charAt(j));
	    				}
	    				else {
	    					s2[i].append(s.charAt(j));
	    				}
	    			}
	    			s2[i] = s2[i].reverse();
	    			s2[i].append('*');
	    			s1[i].append('*');
	    			ml1 = s1[i].length() > ml1 ? s1[i].length() : ml1;
	    			ml2 = s2[i].length() > ml2 ? s2[i].length() : ml2;
	    		}
	    		
	    		StringBuilder sb1 = new StringBuilder();
	    		int ff=0;
	    		for(int i=0;i<ml1;i++) {
	    			char c = '.';
	    			for(int j=0;j<n;j++) {
	    				if(i >= s1[j].length()) continue;
	    				if(s1[j].charAt(i)=='*') {
	    					continue;
	    				}
	    				if(c=='.') {
	    					c=s1[j].charAt(i);
	    				}
	    				else {
	    					if(s1[j].charAt(i)!=c) {
	    						ff=1;
	    					}
	    				}
	    			}
	    			if(c!='.' && ff==0) {
	    				sb1.append(c);
	    			}
	    		}
	    		
	    		StringBuilder sb2 = new StringBuilder();
	    		int f=0;
	    		for(int i=0;i<ml2;i++) {
	    			char c = '.';
	    			for(int j=0;j<n;j++) {
	    				if(i >= s2[j].length()) continue;
	    				if(s2[j].charAt(i)=='*') {
	    					continue;
	    				}
	    				if(c=='.') {
	    					c=s2[j].charAt(i);
	    				}
	    				else {
	    					if(s2[j].charAt(i)!=c) {
	    						f=1;
	    					}
	    				}
	    			}
	    			if(c!='.' && f==0) {
	    				sb2.append(c);
	    			}
	    		}
	    		String ss1 = sb1.toString();
	    		String ss2 = sb2.reverse().toString();
	    		if(ss1.equals(ss2)) {
	    			out.println("Case #"+t+": "+ (f==1 ? "*" : ss1));
	    		}
	    		else {
	    			out.println("Case #"+t+": "+ (f==1 ? "*" : ss1+ss2));
	    		}
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
