import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String args[]) {
      FastReader sc = new FastReader();
      int t = sc.nextInt();
      int test=0;
      while(t-->0){
          test++;
          String s = sc.nextLine();
          int n = s.length();
          Stack<Character> st = new Stack<>();
          char c = s.charAt(n-1);
          int num = (int)c-48;
          for(int i=0;i<num;i++){
              st.push(')');
          }
          st.push(c);
          for(int i=n-2;i>=0;i--){
              int n1 = (int)s.charAt(i)-48;
              int n2 = (int)s.charAt(i+1)-48;
              if(n1<n2){
                  int diff = n2-n1;
                  for(int j=0;j<diff;j++){
                      st.push('(');
                  }
              }
              else{
                  int diff = n1-n2;
                  for(int j=0;j<diff;j++){
                      st.push(')');
                  }
              }
              st.push(s.charAt(i));
          }
          num = (int)s.charAt(0)-48;
          for(int i=0;i<num;i++){
              st.push('(');
          }
          StringBuilder sb = new StringBuilder();
          while(!st.isEmpty()){
              sb.append(st.pop());
          }
          String ans = sb.toString();
          System.out.println("Case #"+test+": "+ans);
      }
    }
}


class FastReader 
	{ 
		BufferedReader br; 
		StringTokenizer st; 
 
		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 
 
		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException e) 
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
	}

	 	 