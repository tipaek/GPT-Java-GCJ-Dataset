import java.util.*;
import java.io.*;

public class Solution {
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
    static class Node {
    	int s,e,idx;
    	public Node(int st,int end,int i) {
    		s=st;e=end;idx=i;
    	}
    }
    static class Comp implements Comparator<Node> {
    	public int compare(Node a,Node b) {
    		int s1=a.s,e1=a.e,s2=b.s,e2=b.e;
    		if(s1==s2&&e1==e2)return Integer.compare(a.idx,b.idx);
    		if(s1>s2||(s1==s2&&e1>e2))return 1;
    		return -1;
    	}
    }
    public static void main(String[] args) throws java.lang.Exception {
        
    	Reader r=new Reader();
    	int t=r.nextInt();
    	for(int itr=1;itr<=t;++itr) {
    		r.pr("Case #"+itr+": ");
    		int n=r.nextInt();
    		ArrayList<Node> al=new ArrayList<>();
    		StringBuilder ans=new StringBuilder();
    		for(int i=0;i<n;++i) {
    			al.add(new Node(Integer.parseInt(r.next()),Integer.parseInt(r.next()),i));
    			ans.append('0');
    		}
    		Collections.sort(al,new Comp());
    		int js=-1,je=-1,cs=-1,ce=-1;
    		boolean imp=false;
    		for(Node x:al) {
    			int s=x.s,e=x.e;
    			if(ce<=s) {
    				ce=cs=-1;
    			}
    			if(je<=s) {
    				je=js=-1;
    			}
    			if(cs==-1) {
    				ans.setCharAt(x.idx,'C');
    				cs=s;ce=e;
    			}
    			else if(js==-1) {
    				ans.setCharAt(x.idx,'J');
    				js=s;je=e;
    			}
    			else {
    				imp=true;break;
    			}
    		}
    		if(imp) r.prln("IMPOSSIBLE");
    		else r.prln(ans.toString());
    	}
    	r.close();
    }
}
