import java.io.ByteArrayInputStream;
			import java.io.IOException;
			import java.io.InputStream;
			import java.io.PrintWriter;
			import java.util.*;
			import java.io.*;
			public class Solution {
			InputStream is;
				PrintWriter out;
				String INPUT = ""; 
			//classin Declaration
			

			static class pair implements Comparable<pair>{
				int x,y;
				
				pair (int i,int j)
				{ x=i; y=j; 
					
				}
				public int compareTo(pair p){
					if(this.x!=p.x) { return this.x-p.x;}
					else { return this.y-p.y;}
				}
				public int hashCode() { return (x+" "+y).hashCode();}
				public String toString(){ return x+" "+y;} 
				public boolean equals(Object o){ 
					pair x = (pair) o ;
					return (x.x==this.x&&x.y==this.y);}
			}
	
		
void solve() throws Exception{
	int t=ni();
	for(int z=1;z<=t;++z){
		
		int n=ni();
		int[][] arr= new int[n][n];
		for(int i=0;i<n;++i) arr[i]=na(n);

		int rowcnt= 0;
		for(int i=0;i<n;++i){
			boolean[] row= new boolean[n];
			for(int j=0;j<n;++j){
				if(row[arr[i][j]-1]){
					rowcnt++;
					break;

				}
				else{
					row[arr[i][j]-1]=true;
				}
			}
		}
		
		int colcnt= 0;
		for(int j=0;j<n;++j){
			boolean[] col= new boolean[n];
			for(int i=0;i<n;++i){
				if(col[arr[i][j]-1]){
					colcnt++;
					break;

				}
				else{
					col[arr[i][j]-1]=true;
				}
			}
		}
		int trace =0;
		for(int i=0;i<n;++i){
			trace+=arr[i][i];
		}
		
		pn("Case #"+z+": "+trace+" "+rowcnt+" "+colcnt);


	}
	
}


 int gcd(int a, int b) 
{ 
    if (b == 0) 
    	return a; 
    return gcd(b, a % b);  
}
	void run() throws Exception
			{
					is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
			 out = new PrintWriter(System.out);
					
					long s = System.currentTimeMillis();
					solve();
					out.flush();
					if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
			}
				
				
		public static void main(String[] args) throws Exception { new Solution().run(); }
				
			//output methods
			private void pn(Object o)
			{
				out.println(o);
			}
			private void p(Object o)
			{
				out.print(o);
			}
 
 
 
			//input methods
					private byte[] inbuf = new byte[1024];
				public int lenbuf = 0, ptrbuf = 0;
				
 
				private int readByte()
				{
					if(lenbuf == -1)throw new InputMismatchException();
					if(ptrbuf >= lenbuf){
						ptrbuf = 0;
						try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
						if(lenbuf <= 0)return -1;
					}
					return inbuf[ptrbuf++];
				}
				
				
				
				
				private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
				private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
				
				private double nd() { return Double.parseDouble(ns()); }
				private char nc() { return (char)skip(); }
				
				private String ns()
				{
					int b = skip();
					StringBuilder sb = new StringBuilder();
					while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
						sb.appendCodePoint(b);
						b = readByte();
					}
					return sb.toString();
				}
				
				private char[] ns(int n)
				{
					char[] buf = new char[n];
					int b = skip(), p = 0;
					while(p < n && !(isSpaceChar(b))){
						buf[p++] = (char)b;
						b = readByte();
					}
					return n == p ? buf : Arrays.copyOf(buf, p);
				}
					
				private char[][] nm(int n, int m)
				{
					char[][] map = new char[n][];
					for(int i = 0;i < n;i++)map[i] = ns(m);
					return map;
				}
				
				private int[] na(int n)
				{
					int[] a = new int[n];
					for(int i = 0;i < n;i++)a[i] = ni();
					return a;
				}
				
				private int ni()
				{
					int num = 0, b;
					boolean minus = false;
					while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
					if(b == '-'){
						minus = true;
						b = readByte();
					}
					
					while(true){
						if(b >= '0' && b <= '9'){
							num = num * 10 + (b - '0');
						}else{
							return minus ? -num : num;
						}
						b = readByte();
					}
				}
				
				private long nl()
				{
					long num = 0;
					int b;
					boolean minus = false;
					while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
					if(b == '-'){
						minus = true;
						b = readByte();
					}
					
					while(true){
						if(b >= '0' && b <= '9'){
							num = num * 10 + (b - '0');
						}else{
							return minus ? -num : num;
						}
						b = readByte();
					}
				}
				
				private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }
			}