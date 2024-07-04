import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCount = Integer.parseInt(br.readLine());
				
		for(int i=1;i<=testCount;i++){
			String inputStr = br.readLine();
			String buildString = "";
			for(String s: inputStr.split("")){
				int val = Integer.parseInt(s);
				String part = s;
				for(int j=0;j<val;j++){
					part = "(" + part + ")";
				}
				buildString+= part;
			}
			while(buildString.contains(")(")){
				buildString = buildString.replace(")(","");
			}
			System.out.println("Case #"+i+": "+buildString);
		}
	}
}