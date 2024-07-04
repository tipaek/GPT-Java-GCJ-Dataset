import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args)throws IOException{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t=in.nextInt();
		for(int i=1;i<=t;i++) {
			String c=in.next();
			System.out.println("Case #"+i+": "+answer(c));
		}
		in.close();
		
	}
	static String answer(String c) {
		String result="";
		int previous=0;
		for(int i=0;i<c.length();i++) {
			if(Integer.parseInt(c.substring(i,i+1))>previous) {
				for(int j=0;j<Integer.parseInt(c.substring(i,i+1))-previous;j++) {
					result+="(";
				}
			}
			if(Integer.parseInt(c.substring(i,i+1))<previous) {
				for(int j=0;j<previous-Integer.parseInt(c.substring(i,i+1));j++) {
					result+=")";
				}
			}
			result+=c.substring(i,i+1);
			previous=Integer.parseInt(c.substring(i,i+1));
		}
		for(int i=0;i<previous;i++) {
			result+=")";
		}
		return result;
	}
}
