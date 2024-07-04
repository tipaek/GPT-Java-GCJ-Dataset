
import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		MyScanner scan= new MyScanner();
		int t=scan.nextInt();
		for(int z=0;z<t;z++) {
			int n=scan.nextInt();
			HashSet<Integer> row[]=new HashSet[n];
			HashSet<Integer> col[]=new HashSet[n];
			long sum=0;
			for(int i=0;i<n;i++) {
				row[i]=new HashSet<Integer>();
				for(int j=0;j<n;j++) {
					if(i==0) {
						col[j]=new HashSet<Integer>();
					}
					int ij= scan.nextInt();
					row[i].add(ij);
					col[j].add(ij);
					if(i==j) {
						sum+=ij;
					}
				}
			}
			int rows=0;
			int cols=0;
			for(int i=0;i<n;i++) {
				if(row[i].size()!=n){
					rows++;
				}
				if(col[i].size()!=n){
					cols++;
				}
			}
			System.out.println("Case #"+(z+1)+": "+(sum)+" "+(rows)+" "+(cols));

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
