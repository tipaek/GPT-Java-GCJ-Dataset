import java.io.*;
import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main (String[] args) throws IOException{
		  FastReader sc=new FastReader();  
		  PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		  int t=sc.nextInt();
		  for(int z=1;z<=t;z++) {
			  String str=sc.next();
			  String res="";
			  int len=str.length();
			  int[] val=new int[len];
			  for(int i=0;i<len;i++) {
				  val[i]=str.charAt(i)-48;
			  }
			  for(int i=0;i<val[0];i++) {
				  res+="(";
			  }
			  res+=val[0];
			  //out.println(res);
			  for(int i=1;i<str.length();i++) {  
				  int diff=val[i-1]-val[i];
				  if(diff>0) {
					  for(int e=0;e<diff;e++) {
						 res+=")";}
					  }
					 
					 else {
						 for(int e=0;e>diff;e--) {res+="(";}
					 }
				  
				  res+=val[i];
				  //out.println(res);
			  }
			  
			  for(int i=0;i<val[val.length-1];i++) {
				  res+=")";
			  }
			  
			  out.println("Case #"+z+": "+res);
		  }
			  
		  out.close();
	}
	
	
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
            public FastReader(String s) throws FileNotFoundException {
                br = new BufferedReader(new FileReader(new File(s)));
            }

            String next() {
                while (st == null || !st.hasMoreElements()) {
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }

            int nextInt() {
                return Integer.parseInt(next());
            }

            long nextLong() {
                return Long.parseLong(next());
            }

            double nextDouble() {
                return Double.parseDouble(next());
            }

            String nextLine() {
                String str = "";
                try {
                    str = br.readLine();
                } catch (IOException e) { e.printStackTrace();
                }return str;
        }
    }
}
