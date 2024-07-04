
import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		MyScanner scan= new MyScanner();
		int t=Integer.parseInt(scan.nextLine());
		for(int z=0;z<t;z++) {
			StringBuffer s=new StringBuffer(scan.nextLine());
			s.insert(0, 0);
			s.append(0);
			TreeMap<Integer,Integer> L=new TreeMap<Integer,Integer>();
			TreeMap<Integer,Integer> R=new TreeMap<Integer,Integer>();
			for(int i=1;i<s.length()-1;i++) {
				int ni=Integer.parseInt(s.substring(i, i+1));
				if(ni==0) {
					continue;
				}
				
				//Left
				
				int j=i-1;
					
					int nj=Integer.parseInt(s.substring(j, j+1));
					if(nj<ni) {
						if(L.containsKey(j)) {
							L.put(j, L.get(j)+(ni-nj));
						}
						else {
							L.put(j, ni-nj);
						}
						
					}
					else if(nj==ni) {
					}
				
				//Right
				
				int k=i+1;
					
					int nk=Integer.parseInt(s.substring(k, k+1));
					if(nk<ni) {
						if(R.containsKey(k)) {
							R.put(j, R.get(k)+(ni-nk));
						}
						else {
							R.put(k, ni-nk);
						}
					}
					else if(nk==ni) {
					}
				
			}
			StringBuffer ans=new StringBuffer();
			int offset[]=new int[s.length()-1];
			int off=0;
			for (int i=1;i<s.length()-1;i++) {
				if(L.containsKey(i-1)) {
					for(int j=0;j<L.get(i-1);j++) {
						ans.append("(");
					}
					off+=L.get(i-1);
				}
				ans.append(s.substring(i,i+1));
				off++;
				offset[i]=off;
			}
			for (Map.Entry<Integer,Integer> en: R.descendingMap().entrySet()) {
					
				for(int j=0;j<en.getValue();j++) { 
						ans.insert(offset[en.getKey()-1], ")");
					}
			}
       
			System.out.println("Case #"+(z+1)+": "+ans);

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
