import java.io.*;
import java.util.*;
import java.io.*;

class Solution{
	
	public static void main(String args[]) throws NumberFormatException, IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(br.readLine());
	for(int i=1;i<=t;i++){
		String s = br.readLine();
		int n = s.length();
		int brac=0;
		StringBuilder sb = new StringBuilder();
		for(int j=0;j<n;j++){
			int val = s.charAt(j)-48;
			if(val==brac){
				sb.append(s.charAt(j));
			} else if(val > brac){
				int diff = val-brac;
				sb.append(openBraces(diff)).append(s.charAt(j));
				brac = brac+diff;
			}
			else{
				int diff = brac-val;
				sb.append(closeBraces(diff)).append(s.charAt(j));
				brac=brac-diff;
			}
		}
		if(brac > 0){
			sb.append(closeBraces(brac));
		}
		System.out.println("Case #"+i+":"+ " "+sb.toString());
	}
	System.exit(0);
	}
	
	public static String openBraces(int n){
		return String.join("",Collections.nCopies(n,"("));
	}
	
	public static String closeBraces(int n){
		return String.join("",Collections.nCopies(n,")"));
	}
}