
import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int test =1; test<=T;test++){
			st = new StringTokenizer(br.readLine());
			String ans = "";
			int depth = 0;
			String S = st.nextToken() + "0";
			
			for(int i=0;i<S.length();i++){
				int next = Integer.parseInt(S.substring(i,i+1));
				if(next<=depth){
					
					for(int j=0;j<depth-next;j++){
						ans += ")";
					}
					ans +=Integer.toString(next);
					depth=next;
				}
				else{
					for(int j=0;j<next-depth;j++){
						ans+="(";
					}

						ans += Integer.toString(next);
						depth=next;
				}
			}
			
			
			
			System.out.println("Case #" + test + ": "+ ans.substring(0, ans.length()-1));
		}
	}
}
