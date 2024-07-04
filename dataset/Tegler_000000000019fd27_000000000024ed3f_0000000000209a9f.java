import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(scan.readLine());
		
		for(int casen = 1; casen <= t;casen++){
			String[] inp = scan.readLine().split("");
			int[] list = new int[inp.length];
			
			for(int i = 0; i < inp.length;i++){
				list[i] = Integer.parseInt(inp[i]);
			}
			
			int[] par = new int[inp.length+1];
			int curr = 0;
			
			for(int i = 0; i <inp.length;i++){
				par[i] = list[i] - curr;
				curr = list[i];
			}
			par[par.length-1] = -curr;
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i <inp.length;i++){
				if(par[i] > 0 ){
					for(int ii = 0; ii< par[i];ii++){
						sb.append("(");
					}
					
				} else {
					for(int ii = 0; ii< -par[i];ii++){
						sb.append(")");
					}
				}
				sb.append(list[i]);
			}
			if(par[par.length-1] > 0 ){
				for(int ii = 0; ii< par[par.length-1];ii++){
					sb.append("(");
				}
				
			} else {
				for(int ii = 0; ii< -par[par.length-1];ii++){
					sb.append(")");
				}
			}
			System.out.println("Case #" + casen + ": " + sb);	
		}
		

	}

}
