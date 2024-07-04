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
				int u=ni();
				int q = 100*100;
				HashSet<Character> cc = new HashSet<>();
				HashMap<String,Long> hm = new HashMap<>();
				for(int i=0;i<q;++i){
					long n = nl();
					String x  = ns();
					char[] str = x.toCharArray();
					for(char c: str) cc.add(c);

					if(hm.containsKey(x)){
						hm.put(x,Math.min(hm.get(x),n));
					}
					else{
						hm.put(x,n);
					}

				}
				ArrayList<Character> curr = new ArrayList<>();
				for(char c: cc) curr.add(c);
				int[] pp = {0,1,2,3,4,5,6,7,8,9};
				//print("cur is "+curr);
				
				boolean got = true  ; 
				int[] per=new int[10];
				//pn("trying : "+Arrays.toString(pp));
				
				for(String x: hm.keySet()){
					char[] str =x.toCharArray();
					StringBuilder sb =new StringBuilder();
					for(char y: str){
						sb.append(curr.indexOf(y));
					}
					if(Long.parseLong(sb.toString()) > hm.get(x) ){
						got =false ;
					}
				}
				if(got){
					StringBuilder fa = new StringBuilder();
					for(char x: curr) fa.append(x);
					pn("Case #"+z+": "+fa);
					//pn("ans from first : ");
					
				}
				else{
					
				while(next_permutation(pp)){
					//print("trying : "+Arrays.toString(pp));
					got = true ;
					ArrayList<Character> use = new ArrayList<>(); 
					for(String x: hm.keySet()){
						char[] str =x.toCharArray();
						StringBuilder sb =new StringBuilder();
						 use = new ArrayList<>();
						for(int y : pp) use.add(curr.get(y));
						for(char y: str){
							sb.append(use.indexOf(y));
						}
						if(Long.parseLong(sb.toString()) > hm.get(x) ){
							got =false ;
						}


					}
					if(got){
						StringBuilder fa = new StringBuilder();
						for(char x: use ) fa.append(x);
						pn("Case #"+z+": "+fa);

						break ; 
						
					}



				}
				}	




		 }
	}
	boolean next_permutation(int[] p) {
		for (int a = p.length - 2; a >= 0; --a)
		  if (p[a] < p[a + 1])
			for (int b = p.length - 1;; --b)
			  if (p[b] > p[a]) {
				int t = p[a];
				p[a] = p[b];
				p[b] = t;
				for (++a, b = p.length - 1; a < b; ++a, --b) {
				  t = p[a];
				  p[a] = p[b];
				  p[b] = t;
				}
				return true;
			  }
		return false;
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