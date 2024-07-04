import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int testCases = scanner.nextInt();
		
		if(100 < testCases || testCases <1)
			extracted();
	
		String output[] = new String[testCases] ;
		
		for (int t = 0; t < testCases; t++) {
			String s = scanner.next();
			
			if(s.length()<1 || s.length()>100 )
				extracted();
			
			String[] l= s.split("");
			
			int[] it = new int[l.length];
			int j=0;
			for(String ch: l)
			{
				it[j++]=Integer.parseInt(ch);
			}

			
			String result ="";
			
			for(int i=0;i<l.length;i++) {
				
				for(j=it[i];j>0;j--) {
					result+="(";
				}
				result+=it[i];
				for(j=it[i];j>0;j--) {
					result+=")";
				}
				
			}
			
			
			output[t]= new String(result);
			
		}
		
		
		
		for (int i = 0; i < testCases; i++) {
			System.out.println("Case #" + (i) + ": " + output[i]);
		}
		
		
	}
	
	private static void extracted() throws Exception {
		throw new Exception();
	}

}
