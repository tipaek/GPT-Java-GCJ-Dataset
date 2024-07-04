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
			
			
			int deep=0;
			for (int j = 0; j <s.length(); j++) {
				int actual=Integer.parseInt(s.charAt(j)+"");
				if(actual>deep) {
					while(deep!=actual) {
						result.append("(");
						deep++;
					}
					result.append(actual);
				}else if(actual==deep) {
					result.append(actual);
				}else {
					while(deep!=actual) {
						result.append(")");
						deep--;
					}
					result.append(actual);
				}
				
			}
			while(deep!=0) {
				result.append(")");
				deep--;
			}
			
			out.write("Case #"+(i+1)+": "+result.toString()+"\n");
			
		}

		out.close();
	}

}
