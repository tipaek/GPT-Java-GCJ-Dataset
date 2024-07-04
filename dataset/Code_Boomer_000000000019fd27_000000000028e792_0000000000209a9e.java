import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution {

	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String d = br.readLine();
			ArrayList<Integer> temp = new ArrayList<>();
			int count = 1;
			for(int j=0;j<B;j++) {
				if(count%10==1) {
					j--;
				}
				else {
					bw.write(j+"");
					bw.flush();
					temp.add(Integer.parseInt(br.readLine()));
				}
				count++;
			}
			String r = "";
			for(int j=0;j<temp.size();j++) {
				r+=temp.get(j);
			}
			bw.write(r);
			bw.flush();
			String check = br.readLine();
			if(check.equals("N"))
				break;
		}
	}
}

