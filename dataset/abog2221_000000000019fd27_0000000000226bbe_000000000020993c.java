import java.io.*;
import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main (String[] args) throws IOException{
		  FastReader sc=new FastReader();  
		  PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		  int t=sc.nextInt();
		  for(int i=1;i<=t;i++) {
			  int n=sc.nextInt();
			  int[][] ok=new int[n][n];
			  for(int e=0;e<n;e++) {
				  for(int d=0;d<n;d++) {
					  ok[e][d]=sc.nextInt();
				  }
			  }
			  int sum=0;
			  for(int e=0;e<n;e++) {
				  sum+=ok[e][e];
			  }
			  int r=0,c=0;
			  for(int e=0;e<n;e++) {
				  Set<Integer> test=new HashSet<>();
				  for(int d=0;d<n;d++) {
					  test.add(ok[d][e]);
				  }
				  if(test.size()<n) {
					  c++;
				  }
			  }
			  
			  for(int e=0;e<n;e++) {
				  Set<Integer> test=new HashSet<>();
				  for(int d=0;d<n;d++) {
					  test.add(ok[e][d]);
				  }
				  if(test.size()<n) {
					  r++;
				  }
			  }
			  
			  out.println("Case #"+i+": "+sum+" "+r+" "+c);
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