
import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		MyScanner scan= new MyScanner();
		
		int t=scan.nextInt();
		for(int z=0;z<t;z++) {
			int n=scan.nextInt();
			String s="C";
			E[] ele=new E[n];
			E[] J=new E[n];					
			E[] C=new E[n];					
			for(int i=0;i<n;i++) {
				ele[i]=new E(scan.nextInt(),scan.nextInt());
			}
			Arrays.sort(ele,new Comparex());
			int cx=0,jx=-1;
			C[0]=new E(ele[0].x,ele[0].y);
			
			for(int i=1;i<n;i++) {
				if(ele[i].x>=C[cx].y) {
					cx+=1;
					C[cx]=new E(ele[i].x,ele[i].y);
					s=s.concat("C");
					continue;
				}
				else if(jx==-1 || ele[i].x>=J[jx].y) {
					jx+=1;
					J[jx]=new E(ele[i].x,ele[i].y);
					s=s.concat("J");
					continue;
				}
				else {
					s="IMPOSSIBLE";
					break;
				}
				
			}
			
			System.out.println("Case #"+(z+1)+": "+s);
		}
		
		}
		
	
	public static class E {

		int x;
		int y;

		public E(int k, int f) {
			super();
			this.x = k;
			this.y = f;
		}

		public E(int k) {
			super();
			this.x = k;
		}

	}

	public static class Comparex implements Comparator<E> {

		@Override
		public int compare(E a, E b) {
			return a.x - b.x;

		}

	}
	public static class Comparey implements Comparator<E> {

		@Override
		public int compare(E a, E b) {
			return a.y - b.y;

		}

	}
	
	public static class GCD {
		public int gcd(int A, int B) {
		    if(B==0)
		        return A;
		    else
		        return gcd(B, A % B);
		}
	}
	

public static class BinomialCoefficient {
	// Program to calculate C(n ,k) or nCk in java 
	
	    // Returns value of Binomial Coefficient C(n, k) 
	    static int binomialCoeff(int n, int k) 
	    { 
	        int res = 1; 
	      
	 
	        if ( k > n - k ) 
	            k = n - k; 
	      
	      
	        for (int i = 0; i < k; ++i) 
	        { 
	        res *= (n - i); 
	        res /= (i + 1); 
	        } 
	      
	        return res; 
	    } 
	      
 
	
}

public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
       br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine(){
        String str = "";
	  try {
	     str = br.readLine();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return str;
    }
    
}
}
