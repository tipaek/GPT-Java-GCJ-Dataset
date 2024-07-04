import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		String precompute[]={"-4,-4=IMPOSSIBLE", "-4,-3=SSW", "-4,-2=IMPOSSIBLE", "-4,-1=NSW", "-4,0=IMPOSSIBLE", "-4,1=SNW", "-4,2=IMPOSSIBLE", "-4,3=NNW", "-4,4=IMPOSSIBLE", "-3,-4=WWS", "-3,-3=IMPOSSIBLE", "-3,-2=ESW", "-3,-1=IMPOSSIBLE", "-3,0=WW", "-3,1=IMPOSSIBLE", "-3,2=ENW", "-3,3=IMPOSSIBLE", "-3,4=WWN", "-2,-4=IMPOSSIBLE", "-2,-3=NWS", "-2,-2=IMPOSSIBLE", "-2,-1=SW", "-2,0=IMPOSSIBLE", "-2,1=NW", "-2,2=IMPOSSIBLE", "-2,3=SWN", "-2,4=IMPOSSIBLE", "-1,-4=EWS", "-1,-3=IMPOSSIBLE", "-1,-2=WS", "-1,-1=IMPOSSIBLE", "-1,0=W", "-1,1=IMPOSSIBLE", "-1,2=WN", "-1,3=IMPOSSIBLE", "-1,4=EWN", "0,-4=IMPOSSIBLE", "0,-3=SS", "0,-2=IMPOSSIBLE", "0,-1=S", "0,1=N", "0,2=IMPOSSIBLE", "0,3=NN", "0,4=IMPOSSIBLE", "1,-4=WES", "1,-3=IMPOSSIBLE", "1,-2=ES", "1,-1=IMPOSSIBLE", "1,0=E", "1,1=IMPOSSIBLE", "1,2=EN", "1,3=IMPOSSIBLE", "1,4=WEN", "2,-4=IMPOSSIBLE", "2,-3=NES", "2,-2=IMPOSSIBLE", "2,-1=SE", "2,0=IMPOSSIBLE", "2,1=NE", "2,2=IMPOSSIBLE", "2,3=SEN", "2,4=IMPOSSIBLE", "3,-4=EES", "3,-3=IMPOSSIBLE", "3,-2=WSE", "3,-1=IMPOSSIBLE", "3,0=EE", "3,1=IMPOSSIBLE", "3,2=WNE", "3,3=IMPOSSIBLE", "3,4=EEN", "4,-4=IMPOSSIBLE", "4,-3=SSE", "4,-2=IMPOSSIBLE", "4,-1=NSE", "4,0=IMPOSSIBLE", "4,1=SNE", "4,2=IMPOSSIBLE", "4,3=NNE", "4,4=IMPOSSIBLE"};
		
		HashMap<String, String> ans = new HashMap<>();
		for(String line: precompute){
			String keyValue[]=line.split("=");
			ans.put(keyValue[0], keyValue[1]);
		}

		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		for(int t=1;t<=n;t++){
			int x=scanner.nextInt();
			int y=scanner.nextInt();
			System.out.println("Case #"+t+": "+ans.get(x+","+y));
		}
		scanner.close();
	}
}
