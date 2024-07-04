import java.util.*;
import java.io.*;

public class Solution{
    static class Reader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
        BufferedWriter bw;
  
        public Reader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
        void pr(String s){
            try{
                bw.write(s);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        void prln(String s){
            try{
                bw.write(s+"\n");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        void close(){
            try{
                bw.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws java.lang.Exception {
        
    	Reader r=new Reader();
    	int t=r.nextInt();
    	for(int itr=1;itr<=t;++itr) {
    		String[] inp=r.next().split("");
    		r.pr("Case #"+itr+": ");
    		StringBuilder ans=new StringBuilder();
    		int op=0;
    		for(int i=0;i<inp.length;++i) {
    			int n=Integer.parseInt(inp[i]);
    			for(int j=0;j<n-op;++j)ans.append("(");
    			for(int j=0;j<op-n;++j)ans.append(")");
    			ans.append(inp[i]);
    			op=n;
    		}
    		for(int j=0;j<op;++j)ans.append(")");
    		r.prln(ans.toString());
    	}
    	r.close();
    }
}
