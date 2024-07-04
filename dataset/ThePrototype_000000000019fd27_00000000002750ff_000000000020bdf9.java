import java.util.*;

public class Solution{
	public static void main(String[] args){
		int T;
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		for(int t=1; t<=T; ++t){
			int c_ST=-1,c_ET=-1,j_ST=-1,j_ET=-1;
			int N = in.nextInt();
			StringBuffer res = new StringBuffer();
			boolean im =false;
			for(int i = 0; i < N; ++i){
				int ST = in.nextInt();
				int ET = in.nextInt();
				if(im){
					continue;
				}
				else if(c_ST == -1){
					c_ST = ST;
					c_ET = ET;
					res.append('C');
				}
				else if(c_ST >= ET){
					c_ST = ST;
					res.append('C');
				}
				else if(c_ET <= ST){
					c_ET = ET;
					res.append('C');
				}
				else if(j_ST == -1){
					j_ST = ST;
					j_ET = ET;
					res.append('J');
				}
				else if(j_ST >= ET){
					j_ST = ST;
					res.append('J');
				}
				else if(j_ET <= ST){
					j_ET = ET;
					res.append('J');
				}
				else{
					res = new StringBuffer("IMPOSSIBLE");
					im = true;
				}
			}
			System.out.println("Case #" + t + ": " + res); 
		}
	
	}
}