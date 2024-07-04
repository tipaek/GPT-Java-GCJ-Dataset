	import java.io.BufferedReader;
			import java.io.FileReader;
			import java.io.IOException;
			import java.io.InputStreamReader;
			import java.io.PrintWriter;
			import java.math.BigInteger;
			import java.util.*;
	 
				 public class Solution{
					    void pre() throws Exception{}
					    void solve(int TC) throws Exception{    
					    	
					    	int t=ni();
					    	for(int ii=0;ii<t;ii++){
					    int n=ni();
					   int a[][]=new int[n][n];
					   long sum=0;
					   int row=0,col=0;
					   for(int i=0;i<n;i++) {
						   int flag=0;
						   HashSet<Integer> h=new HashSet();
						   for(int j=0;j<n;j++) {
							   a[i][j]=ni();
							   if(i==j)sum+=a[i][j];
							   if(h.contains(a[i][j]))flag=1;
							   h.add(a[i][j]);
						   }
						   row+=flag;
					   }
					   for(int i=0;i<n;i++) {
						   int flag=0;
						   HashSet<Integer> h=new HashSet();
						   for(int j=0;j<n;j++) {
							  // a[j][i]=ni();
							   
							   if(h.contains(a[j][i]))flag=1;
							   h.add(a[j][i]);
						   }
						   
						   col+=flag;
					   }
					   pn("Case #" + (ii+1) + ": " + sum+" " + row + " " + col);
					   
					   
					    	}
					    }
					            
					    
	 
					    static boolean multipleTC = false, memory = false;
					    FastReader in;PrintWriter out;
					    void run() throws Exception{
					        in = new FastReader();
					        out = new PrintWriter(System.out);
					        int T = (multipleTC)?ni():1;
					        pre();for(int t = 1; t<= T; t++)solve(t);
					        out.flush();
					        out.close();
					    }
					    public static void main(String[] args) throws Exception{
					        if(memory)new Thread(null, new Runnable() {public void run(){try{new Solution().run();}catch(Exception e){e.printStackTrace();}}}, "1", 1 << 28).start();
					        else new Solution().run();
					    }
					    void p(Object o){out.print(o);}
					    void pn(Object o){out.println(o);}
					    void nd(Object o){out.println(o);}
					    void pni(Object o){out.println(o);out.flush();}
					    String n()throws Exception{return in.next();}
					    String nln()throws Exception{return in.nextLine();}
					    int ni()throws Exception{return Integer.parseInt(in.next());}
					    long nl()throws Exception{return Long.parseLong(in.next());}
					    double nd()throws Exception{return Double.parseDouble(in.next());}
					    
					    class FastReader{
					        BufferedReader br;
					        StringTokenizer st;
					        public FastReader(){
					            br = new BufferedReader(new InputStreamReader(System.in));
					        }
					
					        public FastReader(String s) throws Exception{
					            br = new BufferedReader(new FileReader(s));
					        }
					
					        String next() throws Exception{
					            while (st == null || !st.hasMoreElements()){
					                try{
					                    st = new StringTokenizer(br.readLine());
					                }catch (IOException  e){
					                    throw new Exception(e.toString());
					                }
					            }
					            return st.nextToken();
					        }
					
					        String nextLine() throws Exception{
					            String str = "";
					            try{   
						                str = br.readLine();
						            }catch (IOException e){
					                throw new Exception(e.toString());
					            }  
					            return str;
					        }
					    }
					}