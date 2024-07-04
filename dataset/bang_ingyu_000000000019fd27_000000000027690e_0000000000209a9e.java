import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    
    public static int stoi(String s){
        return Integer.parseInt(s);
    }
    
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());


		int T = stoi(st.nextToken());
		int B = stoi(st.nextToken());
		int attempt = 1;

		if(B == 10){
			for(int i = 1; i <= T; i++){
				StringBuilder sb = new StringBuilder();
				while(attempt <= 10){
					bw.write("1\n");
					bw.flush();
					String s = br.readLine();
					attempt++;
				}
				for(int j = 1; j <= 10; j++){
					bw.write(j+"\n");
					bw.flush();
					sb.append(stoi(br.readLine()));
				}
				sb.append("\n");
				bw.write(sb.toString());
				bw.flush();
				attempt = 1;

				if(br.readLine().equals("N")){
					break;
				}
			}
		} else {
			for(int i = 1; i <= T; i++){
				StringBuilder sb = new StringBuilder();
				while(attempt <= 150){
					bw.write("1\n");
					bw.flush();
					String s = br.readLine();
					attempt++;
				}
				for(int j = 1; j <= B; j++){
					sb.append(0);
				}
				bw.write(sb.toString());
				bw.flush();
				attempt = 1;

				if(br.readLine().equals("N")){
					break;
				}
			}
		}

		bw.close();
    }
}