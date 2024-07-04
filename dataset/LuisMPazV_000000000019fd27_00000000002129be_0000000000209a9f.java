import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		int numberOfCases=Integer.parseInt(in.readLine().trim());
		
		for (int i = 0; i < numberOfCases; i++) {
			
			String s=in.readLine();
			
			StringBuilder result=new StringBuilder();
			
			
			boolean open=false;
			for (int j = 0; j <s.length(); j++) {
				char actual=s.charAt(j);
				
				if(actual=='1') {
					if(!open) {
						result.append("(1");
						open=true;
					}else {
						result.append("1");
					}
				}else {
					if(!open) {
						result.append("0");
						
					}else {
						result.append(")0");
						open=false;
					}
				}
				
			}
			char last=s.charAt(s.length()-1);
			
			if(last=='1'&&open) {
				result.append(')');
			}
			
			out.write("Case #"+(i+1)+": "+result.toString()+"\n");
			
		}

		out.close();
	}

}
