import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++){
			String s = br.readLine();
			String build = "";
			
			int j = 0;
			while (j<s.length()){
				int cur = Character.getNumericValue((s.charAt(j)));
				for (int k=0; k<cur; k++){
					build += "(";
				}
				build += cur;
				if (j<s.length()-1 && Character.getNumericValue(s.charAt(j))==Character.getNumericValue(s.charAt(j+1))){
					while (j<s.length()-1 && 
							Character.getNumericValue(s.charAt(j))==Character.getNumericValue(s.charAt(j+1))){
						build += cur;
						j++;			
					}
				}
				for (int k=0; k<cur; k++){
					build += ")";
				}
				j++;
			}
			System.out.println("Case #" + (i+1) + ": " + build);			
		}
		
		
		
//		out.close();
		br.close();
//		System.out.println("Took "+(double)(System.nanoTime() - startTime)/1000000000 + " ns");
	}
}
