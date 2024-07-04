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
        
      
    int test=ni();
    for(int ii=0;ii<test;ii++)
    {
    	
    		int n=ni();
    		String s="";
    		int a[][]=new int[n][3];
    		int b[][]=new int[n][2];
    		for(int i=0;i<n;i++) {
    			a[i][0]=ni();
    			a[i][1]=ni();
    			b[i][0]=a[i][0];
    			b[i][1]=a[i][1];
    		}
    		int curr_max=0;
    		int curr_ma1=0;
    		int flag=0;
    		Arrays.sort(a, (a1, b1) -> Double.compare(a1[0], b1[0]));
    	for(int i=0;i<n;i++) {
    			if(a[i][0]>=curr_max) {
    			a[i][2]=1;
    			curr_max=a[i][1];
    			}
    			}
    		for(int i=0;i<n;i++) {
    			if(a[i][0]>=curr_ma1&&a[i][2]!=1) {
    			a[i][2]=-1;
    			curr_ma1=a[i][1];
    			}
    			}
    		
    		for(int i=0;i<n;i++) {
    			if(a[i][2]==0)flag=-1;
    		}
    		for(int i=0;i<n;i++) {
    			for(int j=0;j<n;j++) {
    				if((b[i][0]==a[j][0])&&(b[i][1]==a[j][1])&&(a[j][2]!=-2)) {
    					if(a[j][2]==1)s+='C';
    					else s+='J';
    					a[j][2]=-2;
    					break;
    				}
    			}
    		}
    			
    		if(flag==-1)s="IMPOSSIBLE";
    		 pn("Case #" + (ii+1) + ": " + s);
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

    
    
   