import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static String process(String S) {
		String r = "";
		int count = 0;
		
		for(int i=0;i<S.length(); i++) {
			int tmp = S.charAt(i) - 48;
			
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
