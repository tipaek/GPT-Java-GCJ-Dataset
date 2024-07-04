import java.io.*;
import java.util.*;


class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int tn = 1;
		
		while(t > 0){
			String[] ip = br.readLine().split(" ");
			int X = Integer.parseInt(ip[0]);
			int Y = Integer.parseInt(ip[1]);
			String path = ip[2];
			int tlen = path.length();
			
//			int myx = 0, myy = 0;
			
			int min_meet_time = 100000;
			
			if(X==0 && Y==0)
				min_meet_time = 0;
			
			int ctx = X, cty = Y;
			for(int i=1;i<=tlen && min_meet_time>0; i++){
				
				if(path.charAt(i-1)=='S'){
					ctx = ctx;
					cty = cty-1;
				}
				else if(path.charAt(i-1)=='N'){
					ctx = ctx;
					cty = cty+1;
				}
				else if(path.charAt(i-1)=='E'){
					ctx = ctx+1;
					cty = cty;
				}
				else {
					ctx = ctx-1;
					cty = cty;
				}
				
				int myTime = Math.abs(ctx-0) + Math.abs(cty-0);
				
				if(myTime <= i){
					int meet_time = Math.max(myTime, i);
					min_meet_time = Math.min(meet_time, min_meet_time);
				}

			}
			
			if(min_meet_time == 100000)
				System.out.println("Case #"+tn+": "+"IMPOSSIBLE");
			else
				System.out.println("Case #"+tn+": "+min_meet_time);
			
			
			
			t--;
			tn++;
		}
		
		
	}

}
