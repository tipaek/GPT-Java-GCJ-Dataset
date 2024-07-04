import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
 
public class Pattern{
 
	public static void main(String args[]) throws Exception{
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		new Pattern().solve(br,pw);
		br.close();
		pw.flush();
		pw.close();
		System.exit(0);
	}
 
	void solve(BufferedReader br,PrintWriter pw) throws Exception{
		
		int T = Integer.parseInt(br.readLine());	
		for(int i = 0;i < T;i++){
			int N = Integer.parseInt(br.readLine());	
			String P[] = new String[N];
			for(int j = 0;j < N;j++){
				P[j] = br.readLine();
			}
			String suffixes[] = new String[N];
			String prefixes[] = new String[N];
			for(int j = 0;j < N;j++){
				int index = P[j].lastIndexOf("*");
				suffixes[j] = P[j].substring(index+1);
				prefixes[j] = P[j].substring(0,index);
			}
			//System.out.println(Arrays.toString(suffixes));
			//System.out.println(Arrays.toString(prefixes));
			String result = "";
			for(int j = 0;j < N;j++){
				for(int k = 0;k < N-1;k++){
					if(suffixes[k+1].length() > suffixes[k].length()){
						String temp = suffixes[k+1];
						suffixes[k+1] = suffixes[j];
						suffixes[k] = temp;
					}
				}
			}
			//System.out.println(Arrays.toString(suffixes));
			boolean flag = true;
			for(int j = N-1;j >= 1;j--){
				
				if(suffixes[j-1].indexOf(suffixes[j]) == -1){
					flag = false;
				}
			}
			if(flag){
				result = suffixes[0];
			}
			else{
				result = "*";
			}
			pw.println("Case #"+(i+1)+": "+result);	
		}
		
		
		

	}
}
class Element{
	String suffix;
}


