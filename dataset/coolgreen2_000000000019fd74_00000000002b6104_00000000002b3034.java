import java.util.*;
import java.io.*;


public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int cases = 1; cases <= T; cases++) {
			System.out.print("Case #" + cases + ": " );
			int N = Integer.parseInt(br.readLine());
			String[] answers = new String[N];
			String start = "";
			String end = "";
			boolean printed = false;
			cycle: for (int i = 0; i < N; i++) {
				String s = br.readLine();
				if (!printed) {
					String start_string = s.substring(0, s.indexOf('*'));
					for (int h = 0; h < Math.min(start_string.length(), start.length()); h++) {
						if (start_string.charAt(h) != start.charAt(h)) {
							System.out.println("*");
							printed = true;
							continue cycle;
						}
					}
					if (start_string.length() > start.length())
						start = start_string;
					String end_string = s.substring(s.lastIndexOf('*')+1);
					for (int h = 0; h < Math.min(end_string.length(), end.length()); h++ ) {
						if (end.charAt(end.length()-h-1) != end_string.charAt(end_string.length()-1-h)) {
							System.out.println("*");
							printed = true;
							continue cycle;
						}
					}
					if (end_string.length() > end.length())
						end = end_string;
					answers[i] = s.replaceAll("\\*", "");
				}
			}
			if (!printed) {
				System.out.print(start);
				for (int i = 0; i < answers.length; i++) 
					System.out.print(answers[i]);
				System.out.println(end);		
			}
			
			
			
		}
		
		
		
	}



}