import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tC; t++) {
			System.out.print("Case #" + t + ": ");
			
			int n = Integer.parseInt(br.readLine());
			StringBuilder str = new StringBuilder(br.readLine());
			int ind = str.indexOf("*");
			
			StringBuilder s = new StringBuilder(str.substring(0, ind));
			StringBuilder e = new StringBuilder(str.substring(ind+1));
			
			for(int i = 1; i < n; i++) {
				StringBuilder next = new StringBuilder(br.readLine());
				//System.out.println("NEXT: " + next);
				int index = next.indexOf("*");
				
				StringBuilder start = new StringBuilder(next.substring(0, index));
				StringBuilder end = new StringBuilder(next.substring(index+1));
				//System.out.println("00" + end + "00");
				if(start.length() > s.length() && start.indexOf(s.toString()) == 0 || s.length() == 0) {
					//System.out.println(start + " " + s);
					s = new StringBuilder(start);
				}
				else if(start.length() != 0 && s.indexOf(start.toString()) != 0) {
					//System.out.println("first " + start + " " + s);
					System.out.println("*");
					for(int j = i+1; j < n; j++) {
						br.readLine();
					}
					break;
				}
				
				if(end.length() > e.length()) {
					if(end.indexOf(e.toString()) == end.length()-e.length() || e.length() == 0) {
				
					//System.out.println(end + " " + e);
					e = new StringBuilder(end);
					}
				}
				else if(end.length() != 0 && (e.indexOf(end.toString()) != e.length()-end.length() || e.indexOf(end.toString()) == -1)) {
//					System.out.println(end.equals(""));
//					System.out.println(end);
//					System.out.println("second " + end + " " + e);
					System.out.println("*");
					for(int j = i+1; j < n; j++) {
						br.readLine();
					}
					break;
				}
				
				if(i == n-1) {
					System.out.println(s + "" + e);
				}
			}
			
		}
	}
}
