/* package codechef; // don't place package name! */
package my;
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
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
    static int dist(int x,int y) {
    	return Math.abs(x)+Math.abs(y);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Reader r=new Reader();
		int q=r.nextInt();
		for(int itr=1;itr<=q;++itr) {
			String[] inp=r.nextLine().split(" ");
			int x=Integer.parseInt(inp[0]);
			int y=Integer.parseInt(inp[1]);
			char str[]=inp[2].toCharArray();
			int time=0;
			int ans=-1;
			for(char c:str) {
				switch(c) {
				case 'N':y++;break;
				case 'E':x++;break;
				case 'W':x--;break;
				case 'S':y--;
				}
				time++;
				if(dist(x,y)<=time) {
					ans=time;
					break;
				}
			}
			r.pr("Case #"+itr+": ");
			if(ans==-1)r.prln("IMPOSSIBLE");
			else r.prln(ans+"");
		}
		r.close();
	}
}
