import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int asdfasdf=1; asdfasdf<T+1; asdfasdf++) {
			String s = br.readLine();
			StringBuilder sb = new StringBuilder(s);
			int sbposition = 0;
			int prevman=0;
			System.out.print("Case #"+asdfasdf+": ");
			for (int i=0; i<s.length(); i++) {
				int currman = Integer.parseInt(s.charAt(i)+"");
				//System.out.println("AAA"+currman+" "+prevman+"AA");
				int bobbyjoe = currman-prevman;
				if (bobbyjoe>0) {
					for (int joe=0; joe<bobbyjoe; joe++) {
						System.out.print("(");
					}
				}
				if (bobbyjoe<0) {
					for (int joe=0; joe<-bobbyjoe; joe++) {
						System.out.print(")");
					}
				}
				System.out.print(currman);
				prevman=currman;
			}
			for (int i=0; i<prevman; i++)System.out.print(")");
			System.out.println();
		}
	}
}
