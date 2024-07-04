import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		InputReader sc = new InputReader(System.in);
		int t = sc.nextInt();
		int c = 1;
		StringBuilder res = new StringBuilder();
		while (t-- > 0) {
			String str = sc.next();
			str = "0"+str+"0";
			StringBuilder sb = new StringBuilder();
			int n = str.length();
			for (int i = 1 ; i < n ; i++) {
				int x = str.charAt(i) - str.charAt(i-1);
				if (x > 0) {
					while (x > 0) {
						sb.append("(");
						x -= 1;
					}
				}else if (x < 0) {
					while (x < 0) {
						sb.append(")");
						x += 1;
					}
				}
				if (x == 0 && i != n-1) {
					sb.append(str.charAt(i));
				}
			}
			res.append("Case #"+c+": "+sb.toString()+"\n");
			c+=1;
		}
		System.out.println(res.toString());
	}
	static class InputReader{
		BufferedReader br;
		StringTokenizer st;
        
        public InputReader(InputStream in){
        	try {
        		br = new BufferedReader(new
        				InputStreamReader(in)); 
        	}catch (Exception e) {
        		System.out.println(e.toString());
        	}
        }
        
        String next(){
        	while (st == null || !st.hasMoreElements()){
        		try{
        			st = new StringTokenizer(br.readLine()); 
                }catch (IOException  e){
                	e.printStackTrace(); 
                }
            }
            return st.nextToken(); 
        }
        
        int nextInt(){
        	return Integer.parseInt(next()); 
        }
        
        long nextLong(){
        	return Long.parseLong(next()); 
        }
        
        double nextDouble(){
        	return Double.parseDouble(next()); 
        }
        
        String nextLine(){
        	String str = "";
        	try{
        		str = br.readLine();
        	}catch (IOException e){
        		e.printStackTrace(); 
            }
            return str; 
        }
    }
}
