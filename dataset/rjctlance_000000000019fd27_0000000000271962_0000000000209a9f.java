import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static String process(String S) {
		String r = "";
		int count = 0;
		boolean ok=false;
		
		for(int i=0;i<S.length(); i++) {
			int tmp = S.charAt(i) - 48;
			
			if(ok) {
				for(int j=count; j>0; j--) {
					r += ")";
					count--;
				}
			}
			
			if(count < tmp) {
				for(int j=count;j<tmp;j++) {
					r += "(";
					count++;
				}
			}
			else if(count > tmp) {
				for(int j=count; j>tmp; j--) {
					r += ")";
					count--;
				}
				
			}
			else if(count == tmp && count > 1) {
				for(int k=0;k<count; k++) {
					r+= ")";
				}
				for(int k=0;k<count; k++) {
					r+= "(";
				}
				ok = true;
			}
			
			
			r += ""+tmp;
		}
		for(int i=0; i<count; i++) {
			r += ")";
		}
		
		return r;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		String text = in.next();
		int N = Integer.parseInt(text);

		for (int i = 0; i < N; i++) {

			text = in.next();
			
			String outRes = process(text);
			System.out.println("Case #"+(i+1)+": " + outRes);

		}
		in.close();
	}
}
