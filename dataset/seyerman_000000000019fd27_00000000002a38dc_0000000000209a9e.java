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
		String[] parts = line.split(" ");
		byte T = Byte.parseByte(parts[0]);
		byte B = Byte.parseByte(parts[1]);
		
		String output = "";
		for (byte i = 1; i <= T; i++) {
			for (byte j = 1; j <= B; j++) {
				bw.write(j+"\n");
				bw.flush();
				line = br.readLine();
				output += line;
			}
			bw.write(output+"\n");
			bw.flush();
			line = br.readLine();
			if(line.equals("N")){
				break;
			}
		}
		bw.close();
		br.close();
	}

}
