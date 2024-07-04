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
		int N = Integer.parseInt(line);
		bw.write("\n1 1");
		
		if(N>1){
			int x = (int)((-1 + Math.sqrt(1+8*N))/(double)2);
			//bw.write("\nx="+x+"\n");
			if((x*(x+1))/2==N){
				x--;
			}
			
			for (int i = 2; i <= x+1; i++) {
				bw.write("\n"+i+" 2");
			}
			
			int Naprox = (x*(x+1))/2+1;
			for (int i = x+1; Naprox<N; i++) {
				Naprox++;
				bw.write("\n"+i+" 1");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		byte T = Byte.parseByte(line);
		
		int caseNumber = 1;
		while(T>0){
			
			bw.write("Case #"+caseNumber+":");
			
			solve();
			
			bw.write("\n");
			T--;
			caseNumber++;
		}
		
		bw.close();
		br.close();
	}

}
