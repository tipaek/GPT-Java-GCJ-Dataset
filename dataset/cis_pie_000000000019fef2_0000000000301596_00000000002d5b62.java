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
				//class  Declaration
				
				static class pair implements Comparable<pair>{
					int x;
					int y;
					
					
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
			
			Integer x= ni();
			Integer y= ni();
			boolean xneg  = false ; 
			boolean yneg = false ; 
			if(x<0) {xneg = true ; x=-x; }
			if(y<0) {yneg = true ; y=-y; }

			int limit  = (1<<16) - 1 ; 
			StringBuilder fa= new StringBuilder("IMPOSSIBLE");
			
			for(int i=1;i<=390624;++i){

				String num = Integer.toString(i,5);
				if(num.contains("0")) continue ;
				else{
					char[] str = num.toCharArray();
					//print(Arrays.toString(str));
					StringBuilder sb  = new StringBuilder();
					int gx =0 , gy = 0 ;
					for(int j=0;j<str.length;++j){
						if(str[j]=='1'){
							gx+=  (1<<j);
							sb.append("E");
						}
						if(str[j]=='2'){
							gx -=  (1<<j);
							sb.append("W");
						}
						if(str[j]=='3'){
							gy +=  (1<<j);
							sb.append("N");
						}
						if(str[j]=='4'){
							gy -=  (1<<j);
							sb.append("S");
						}
						
					}
					if(x==gx && y==gy){
						if(fa.toString().equals("IMPOSSIBLE")){
							fa = sb ;  
						}
						else{
							if(fa.length()>sb.length()){
								fa= sb ;
							}
						}
					}


				}
			}

			
			

			boolean possible = !fa.toString().equals("IMPOSSIBLE");
			//pn("Orig "+fa);
			//pn(xneg+" "+yneg+" "+possible);
			if(possible){
				char[] str = fa.toString().toCharArray();
				
				if(xneg){
					for(int i=0;i<str.length;++i){
						if(str[i]=='E') str[i]='W';
						else
						if(str[i]=='W') str[i]='E';
					}
				}
				if(yneg){
					for(int i=0;i<str.length;++i){
						if(str[i]=='N') str[i]='S';
						else
						if(str[i]=='S') str[i]='N';
					}
				}

				fa= new StringBuilder(new String(str));



			}





			pn("Case #"+z+": "+fa);
		}
	}
	
	void print(Object o){
		System.out.println(o);
		System.out.flush();
	}

	int gcd(int a, int b) 
	{ 
		if (b == 0) 
			return a; 
		return gcd(b, a % b);  
	}
	void run() throws Exception{
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
					void watch(Object ... a) throws Exception{
						int i=1;
						pn("watch starts :");
						for(Object o : a ) {
							//print(o);
							boolean notfound = true;
							if(o.getClass().isArray()){
								
								String type = o.getClass().getName().toString();
								print("type is "+type);
								switch (type) {
									case "[I":{
										int[] test = (int[])o ;
										pn(i+" "+Arrays.toString(test));
										break;
									}
									case "[[I":{
										int[][] obj = (int[][])o;
										
										pn(i+" "+Arrays.deepToString(obj));
										break;
									}
									case "[J" : {
										
										long[] obj  = (long[])o ;
										pn(i+" "+Arrays.toString(obj));
										break;
									}
									case "[[J": {
										
										long[][] obj = (long[][])o;
										pn(i+" "+Arrays.deepToString(obj));
										break;
									}
									case "[D" :{
										
										double[] obj= (double[])o;
										pn(i+" "+Arrays.toString(obj));
										break;
									}
									case "[[D" :{
										
										double[][] obj = (double[][])o;
										pn(i+" "+Arrays.deepToString(obj));
										break;
									}
									case "[Ljava.lang.String": {
										
										String[] obj = (String[])o ;
										pn(i+" "+Arrays.toString(obj));
										break;
									}
									case "[[Ljava.lang.String": {
										
										String[][] obj = (String[][])o ;
										pn(i+" "+Arrays.deepToString(obj));
										break ; 
									}
									case "[C" :{
										char[] obj = (char[])o ;
										pn(i+" "+Arrays.toString(obj));
										break;
									}
									case "[[C" :{
										
										char[][] obj = (char[][])o;
										pn(i+" "+Arrays.deepToString(obj));
										break;
									}
				
										
								
									default:{
										pn(i+" type not identified");
										break;
									}
								}
								notfound = false;
								
							}
							if(o.getClass() == ArrayList.class){
								pn(i+" al: "+o);
								notfound = false;
							}
							if(o.getClass() == HashSet.class){
								pn(i+" hs: "+o);
								notfound = false;
							}
							if(o.getClass() == TreeSet.class){
								pn(i+" ts: "+o);
								notfound = false;
							}
							if(o.getClass() == TreeMap.class){
								pn(i+" tm: "+o);
								notfound = false;
							}
							if(o.getClass() == HashMap.class){
								pn(i+" hm: "+o);
								notfound = false;
							}
							if(o.getClass() == LinkedList.class){
								pn(i+" ll: "+o);
								notfound = false;
							}
							if(o.getClass() == PriorityQueue.class){
								pn(i+" pq : "+o);
								notfound = false;
							}
							if(o.getClass() == pair.class){
								pn(i+" pq : "+o);
								notfound = false;
							}
							
							if(notfound){
								pn(i+" unknown: "+o);
							}
							i++;
						}
						pn("watch ends ");
					}
				
				}