import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Solution{
	public static String addPar(int x, boolean open){
		String ret = "";
		if(open) {
			for(int i =0; i < x; i++){
				ret += "(";
			}
		}
		else{
			for(int i =0; i < x; i++){
				ret += ")";
			}
		}
		
		return ret;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		int keis = Integer.valueOf(br.readLine().trim());
		for(int kei =0 ;kei < keis; kei++){
			String str = br.readLine().trim();
			int len = str.length();
			
			String ans = "";
			int prev = str.charAt(0) - '0';
			ans += addPar(prev, true);
			ans += ""+(prev);
			
			for(int i = 1; i < len; i++){
				int cur = str.charAt(i) - '0';
				int diff = prev - cur;
				if(diff > 0){
					ans += addPar(diff, false);
				}
				else if(diff < 0){
					ans += addPar(-diff, true);
				}
				
				prev = cur;
				ans += ""+(prev);
			}
			
			ans += addPar(prev, false);
			out.println("Case #"+(kei+1)+": "+ans);
		}
	}
}