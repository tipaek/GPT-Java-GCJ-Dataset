import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());	
		int k = tc;
		while (tc-->0){
			String input = br.readLine();
			String ans = ""; 
			
			int curr = Integer.parseInt(input.substring(0, 1));
			for (int i=0; i<curr; i++)	ans+="(";

			ans += input.substring(0, 1);
			for (int i=0; i<input.length()-1; i++){
				// if next > curr
				curr = Integer.parseInt(input.substring(i, i+1));
				int next = Integer.parseInt(input.substring(i+1, i+2));

				if (curr < next)
					for (int x=0; x<next-curr; x++)	ans += "(";

				// if next smol -> curr-next * ")"
				else if (curr > next)
					for (int x=0; x<curr-next; x++)	ans+=")";

				ans+=input.substring(i+1, i+2);
			}
			
			curr = Integer.parseInt(input.substring(input.length()-1));
			for (int i=0; i<curr; i++)	ans+=")";
			
			sb.append("Case #" + (k - tc) + ": " + ans + "\n");
		}
		System.out.print(sb);
	}
}