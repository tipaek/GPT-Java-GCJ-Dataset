import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Solution {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static void solve() throws IOException{
		String line = br.readLine();
		byte N = Byte.parseByte(line);
		String[] strs = new String[N];
		String large = "";
		for (byte i = 0; i < N; i++) {
			strs[i] = br.readLine().substring(1);
			if(strs[i].length()>large.length()){
				large = strs[i];
			}
		}
		boolean possible = true;
		for (byte i = 0; i < strs.length && possible; i++) {
			//System.out.println("large:"+large+" vs strs["+i+"]:"+strs[i]);
			//System.out.println(large.contains(strs[i]));
			if(!large.contains(strs[i])){
				possible = false;
			}
		}
		
		if(possible){
			bw.write(large);
		}else{
			bw.write("*");
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		byte T = Byte.parseByte(line);
		
		int caseNumber = 1;
		while(T>0){			
			bw.write("Case #"+caseNumber+": ");
			
			solve();
			
			bw.write("\n");
			T--;
			caseNumber++;
		}
		
		bw.close();
		br.close();
	}

}
