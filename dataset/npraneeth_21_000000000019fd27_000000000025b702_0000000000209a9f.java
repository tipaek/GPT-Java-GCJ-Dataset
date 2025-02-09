import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int noOfCases = Integer.valueOf(br.readLine());
			
			for(int i = 0 ; i < noOfCases ; i++) {
				
				String input = br.readLine();
				StringBuffer output = new StringBuffer();
				
				for(int j = 0 ; j < input.length(); j++) {
					
					if(input.charAt(j) == '1') {
						output.append('(');
						while(input.charAt(j) == '1') {
							output.append(input.charAt(j));
						}
						output.append(')');
					} else {
						output.append(input.charAt(j));
					}
					
				}
				
				System.out.println("Case #" + (i+1) + ": " + output.toString());
			}
			
		} catch(Exception ex) {
			
		}
		
	}

}
