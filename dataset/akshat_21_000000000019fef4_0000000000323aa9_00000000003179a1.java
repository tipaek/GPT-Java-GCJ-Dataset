import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
public class Solution{
	
	public static void main(String[] args) throws Exception{
		Reader.init(System.in);
		PrintWriter out=new PrintWriter(System.out);
		Integer t=Reader.nextInt();
		int pos=1;
		while(t>0) {
			t--;
			long u=Reader.nextLong();
			TreeSet<Integer>[] dp=new TreeSet[26];
			for(int i=0;i<26;i++) {
				dp[i]=new TreeSet<Integer>();
			}
		    for(int i=0;i<26;i++){
		      for(int j=0;j<=9;j++){
		        dp[i].add(j);
		      }
		    }
		    for(int i=0;i<10000;i++) {
		    	long num=Reader.nextLong();
		    	if(num==-1) {
		    		num=(long)Math.pow(10, u)-1;
		    	}
		    	String s=Reader.next();
		    	int length=s.length();
		        long help=Math.min(num,(long)Math.pow(10,length)-1);
		        String temp=Long.toString(help);
		        for(int j=temp.length()-1;j>0;j--) {
		        	int max=temp.charAt(j)-'0';
		        	for(int k=j-1;k>=0;k--) {
		        		int tt=temp.charAt(k)-'0';
		        		if( k>0 && tt>=1) {
		        			max=9;
		        			break;
		        		}
		        		else if(k==0 && tt>1) {
		        			max=9;
		        			break;
		        		}
		        	}
		        	for(int k=max+1;k<=9;k++) {
		        		dp[s.charAt(j)-'A'].remove(k);
		        	}
		        }
		        int max=temp.charAt(0)-'0';
//		        System.out.println(temp.charAt(0));
		        dp[s.charAt(0)-'A'].remove(0);
		        for(int k=max+1;k<=9;k++) {
	        		dp[s.charAt(0)-'A'].remove(k);
	        	}
		    }
		    
		 char[] ans=new char[10];
//		 for(int kk=0;kk<10;kk++)
		 for(int i=0;i<26;) {
			 if(dp[i].size()==1) {
				 ans[dp[i].first()]=(char)('A'+i);
				 int ttt=dp[i].first();
				 for(int j=0;j<26;j++) {
					 dp[j].remove(ttt);
				 }
				 i=0;
			 }
			 else{
			     i++;
			 }
		 }
//		 for(int i=0;i<10;i++) {
//		    	for(int j:dp[i]) {
//		    		System.out.print(j+" ");
//		    	}
//		    	System.out.println();
//		    }
		 out.print("Case #"+pos+": ");
		 for(int i=0;i<10;i++) {
				out.print(ans[i]);
			}
		 out.println();
		 pos++;
		}
		
		out.close();
		
	}
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
//    / call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
   
    static String nextLine() throws IOException{
        return reader.readLine();
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
