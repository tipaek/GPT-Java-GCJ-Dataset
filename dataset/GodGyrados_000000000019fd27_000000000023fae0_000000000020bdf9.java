
import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		MyScanner scan= new MyScanner();
		
		int t=scan.nextInt();
		for(int z=0;z<t;z++) {
			int n=scan.nextInt();
			String s="";
			E[] ele=new E[n];
			E[] J=new E[n];					
			E[] C=new E[n];	
			boolean flag=true;
			for(int i=0;i<n;i++) {
				ele[i]=new E(scan.nextInt(),scan.nextInt(),i,1);
			}
			Arrays.sort(ele,new Comparex());
			int cx=0,jx=-1;
			C[0]=new E(ele[0].x,ele[0].y,0,1);
			
			for(int i=1;i<n;i++) {
				if(ele[i].x>=C[cx].y) {
					cx+=1;
					C[cx]=new E(ele[i].x,ele[i].y,cx,1);
					continue;
				}
				else if(jx==-1 || ele[i].x>=J[jx].y) {
					jx+=1;
					J[jx]=new E(ele[i].x,ele[i].y,jx,0);
					ele[i].a=0;
					continue;
				}
				else {
					flag=false;
					break;
				}
			}
			Arrays.sort(ele,new Comparez());
			for(int i=0;i<n;i++) {
				if(ele[i].a==1) {
					s=s.concat("C");
				}
				else {
					s=s.concat("J");
				}
			}
			if(flag) {
				System.out.println("Case #"+(z+1)+": "+s);
			}
			else {
				System.out.println("Case #"+(z+1)+": IMPOSSIBLE");
			}
			
		}
		
		}
		
	
	public static class E {

		int x;
		int y;
		int z;
		int a;

		public E(int k, int f, int z, int a) {
			super();
			this.x = k;
			this.y = f;
			this.z=z;
			this.a=a;
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
	
	public static class Comparez implements Comparator<E> {

		@Override
		public int compare(E a, E b) {
			return a.z - b.z;

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
