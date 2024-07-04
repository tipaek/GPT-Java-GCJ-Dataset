
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
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
    static int len(int x) {
    	return Integer.toString(x).length();
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Reader r=new Reader();
		int q=r.nextInt();
		for(int itr=1;itr<=q;++itr) {
			r.pr("Case #"+itr+": ");
			int u=r.nextInt();
			int a[]=new int[26];
			char ans[]=new char[10];
			Arrays.fill(a,Integer.MAX_VALUE);
			for(int i=0;i<10000;++i){
			    int m=r.nextInt();
			    char[] ch=r.next().toCharArray();
			    int n=ch.length;
			    String M[]=Integer.toString(m).split("");
			    int k=M.length;
			    if(k==n) {
			    	int p=ch[0]-65;
			    	int x=Integer.parseInt(M[0]);
			    	a[p]=Math.min(a[p],x);
			    	int prev=x;
			    	for(int j=1;j<n;++j) {
			    		p=ch[j]-65;
			    		x=Integer.parseInt(M[j]);
			    		if((j==1&&prev==1)||(prev==0))a[p]=Math.min(a[p],x);
			    		else a[p]=Math.min(a[p],9);
			    		prev=a[p];
			    	}
			    }
			    else {
			    	for(int j=0;j<n;++j) {
			    		int p=ch[j]-65;
			    		a[p]=Math.min(a[p],9);
			    	}
			    }
			}
			for(int i=0;i<26;++i){
			    if(a[i]!=Integer.MAX_VALUE){
			        ans[a[i]]=(char)(i+65);
			    }
			}
			for(char c:ans)r.pr(c+"");
			r.prln("");
		}
		r.close();
	}
}
