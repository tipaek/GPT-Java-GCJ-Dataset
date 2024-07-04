import java.util.*;
import java.io.*;
public class Main {
    public static void main ( String args[] ) {
      FastReader sc = new FastReader();
      PrintWriter out = new PrintWriter (System.out); 
      int t = sc.nextInt(); 
      while (t-->0) {
    	  int x = 1 ; 
    	  int n = sc.nextInt(); 
    	  int [][]a = new int [n][n]; 
    	  for (int i = 0 ; i < n ; i++) {
    		  for (int j = 0 ; j < n ; j++) {
    			  a[i][j]= sc.nextInt(); 
    		  }
    	  }
    	  int trace  = 0 ; 
    	  for (int i = 0 ; i < n ; i++)
    		  trace+= a[i][i];
    	  int row = 0 ; 
    	  int col = 0 ; 
    	  for (int i = 0 ; i < n ; i++) {
    		  HashSet h = new HashSet<Integer>(); 
    		  HashSet h2 = new HashSet<Integer>(); 
    		  for (int j = 0 ; j < n ; j++) {
    			  h.add(a[i][j]);
    			  h2.add(a[j][i]); 
    		  }
    		  if (h.size()!= n )
    			  row++; 
    		  if (h2.size()!=n)
    			  col++;
    	  }
    	  x++; 
    	  System.out.println("Case"+" "+"#"+x+":" +" " +  trace+" "+row+" "+col);
    	  
    		  
      }
      }
     
    public static void swap(char []a ,int i , int j ) {
    	char temp = a[i]; 
    	a[i]= a[j]; 
    	a[j]= temp ; 
    	
    }
    static class FastReader 
	{ 
		BufferedReader br; 
		StringTokenizer st; 
		
		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 
		
		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException  e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 
		
		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 
		
		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 
		
		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 
		
		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return str; 
		}
}
}
class Pair {
	int x ; 
	int y ; 
	public Pair(int x ,int y){
		this.x = x;
		this.y=y;}
}
 class Pair1 implements Comparable{
	int x ; 
	int y ; 
	public Pair1(int x ,int y){
		this.x = x;
		this.y=y;}
	public int compareTo(Object o) {
		Pair1 a = (Pair1) o ; 
		
		return (a.y-this.y);
	}
		
	}
 class Pair2 implements Comparable{
	int x ; 
	int y ; 
	public Pair2(int x ,int y){
		this.x = x;
		this.y=y;}
	public int compareTo(Object o) {
		Pair2 a = (Pair2) o ; 
		
		return (this.y-a.y);
	}
		
	}