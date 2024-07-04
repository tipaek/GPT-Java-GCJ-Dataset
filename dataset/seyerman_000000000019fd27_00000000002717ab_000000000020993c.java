import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		byte T = Byte.parseByte(line);
		
		int caseNumber = 1;
		while(T>0){
			line = br.readLine();
			byte N = Byte.parseByte(line);
			byte[][] m = new byte[N][N];
			int trace = 0;
			int repRows = 0;
			int repCols = 0;			
			for (byte i = 0; i < m.length; i++) {
				line = br.readLine();
				String[] parts = line.split(" ");
				byte[] repeated = new byte[101];
				boolean rep = false;
				for (byte j = 0; j < parts.length; j++) {
					byte elem = Byte.parseByte(parts[j]);
					m[i][j] = elem;
					if(i==j){
						trace += elem;
					}
					repeated[elem]++;
					if(repeated[elem]>1){
						rep = true;
					}
				}
				if(rep){
					repRows++;
				}
			}
			for (byte i = 0; i < m.length; i++) {
				byte[] repeated = new byte[101];
				boolean rep = false;
				for (byte j = 0; j < m.length; j++) {
					byte elem = m[j][i];
					repeated[elem]++;
					if(repeated[elem]>1){
						rep = true;
					}
				}
				if(rep){
					repCols++;
				}
			}
			
			bw.write("Case #"+caseNumber+": "+trace+" "+repRows+" "+repCols+"\n");
			
			T--;
			caseNumber++;
		}
		
		bw.close();
		br.close();
	}

}
