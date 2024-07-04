import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int t = in.nextInt();
		String res = "";
		 for (int i = 1; i <= t; i++) {
			 
			 String no = in.next();
	         char[] chars = no.toCharArray();
	         
	         String finalRes = "";
	         for(int j=0;j<chars.length;j++) {
	        	 
	        	 int c = getValue(chars, j);
	        	 int p = getValue(chars, j-1);
	        	 int n = getValue(chars, j+1);
	        	 
	        	 int open = getOpen(c, p);
	        	 int close = getClose(c, n);
	        	 
	        	 String openB = getOpenBraces(open);
	        	 String CloseB = getCloseBraces(close);
	        	 
	        	 finalRes = finalRes + openB + chars[j] + CloseB;
	         }
	         res = res + finalRes+"\n";
	     }
		 System.out.println(res);
	}
	
	static String getOpenBraces(int count) {
		
		String s = "";
		for(int i=0;i<count;i++) {
			s = s +"(";
		}
		
		return s;
	}
	
	static String getCloseBraces(int count) {
		
		String s = "";
		for(int i=0;i<count;i++) {
			s = s +")";
		}
		
		return s;
	}
	
	static int getOpen(int c,int p) {
		int open = c-p;
		if(open >0 && open<=c) {
			return open;
		}
		return 0;
	}
	static int getClose(int c,int n) {
		int close = c-n;
		if(close >0 && close<=c) {
			return close;
		}
		return 0;
	}
	
	static int getValue(char[] chars,int index) {
		if(index < 0) {
			return 0;
		}
		else if(index >= chars.length) {
			return 0;
		}
		else {
			int value = Integer.parseInt(chars[index]+"");
			return value;
		}
	}
}