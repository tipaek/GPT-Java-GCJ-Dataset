import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
 
public class Solution{
 
	public static void main(String args[]) throws Exception{
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		new Solution().solve(br,pw);
		br.close();
		pw.flush();
		pw.close();
		System.exit(0);
	}
 
	void solve(BufferedReader br,PrintWriter pw) throws Exception{
		
		int T = Integer.parseInt(br.readLine());	
		for(int i = 0;i < T;i++){
			String S = br.readLine();
			int prev = 0;
			String S1 = "";
			for(int j = 0;j < S.length();j++){
				int current = Integer.parseInt(S.charAt(j) + "");
				if(prev == 0 || current == 0){
					String temp = "";
					for(int k = 0;k < current;k++){
						temp += "(";
					} 
					temp += current;
					for(int k = 0;k < current;k++){
						temp += ")";
					}
					S1 += temp;
				}
				else{
					int count = 0;
					int k;
					for(k = S1.length() - 1;k >= 0;k--){
						if(count == current){
							break;
						}
						if(S1.charAt(k) != ')'){
							break;
						}
						count++;
					}
					//System.out.println(count+" "+current +" "+k);
					if(count == current){
						S1 = S1.substring(0,k+1) + current + S1.substring(k+1,S1.length());
					}
					else{
						int diff = current - count;
						String temp = "";
						for(int l = 0;l < diff;l++){
							temp += "(";
						} 
						temp += current;
						for(int l = 0;l < diff;l++){
							temp += ")";
						}
						S1 = S1.substring(0,k+1) + temp + S1.substring(k+1,S1.length());
					}
				}
				prev = current;
			}
			pw.println("Case #"+(i+1)+": "+S1);
		}
		
		
		

	}
}


