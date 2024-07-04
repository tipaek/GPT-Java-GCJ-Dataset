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
		
		for (byte i = 1; i <= T; i++) {
			line = br.readLine();
			short open = 0;
			bw.write("Case #"+i+": ");
			
			for (int j = 0; j < line.length(); j++) {
				char chdig = line.charAt(j);
				byte digit = Byte.parseByte(chdig+"");
				while(digit>open){
					bw.write("(");
					open++;
				}
				while(digit<open){
					bw.write(")");
					open--;
				}
				bw.write(chdig+"");
			}
			while(open>0){
				bw.write(")");
				open--;
			}
			bw.write("\n");			
		}
		
		bw.close();
		br.close();
	}

}
