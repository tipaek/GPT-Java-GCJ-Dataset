import java.util.*;
import java.io.*;
public class Solution {
	
	public static int findAns(int X , int Y, String path){
		int time = 0;
		char direction ;
		boolean flag = false;
		if(X == 0 && Y == 0 )
			return time;
		for(int i = 0 ;i < path.length();i++){
			time++;
			direction = path.charAt(i);
			if(Y == 0)
				flag = true;
			if(direction == 'N'){
				Y++;
			}else if(direction == 'S'){
				Y--;
			}else if(direction == 'E'){
				X++;
			}else{
				X--;
			}
			if(!flag){
				if(X > 0)
					X--;
				else if(X < 0){
					X++;
				}
				else{
					if(Y > 0)
						Y--;
					else if( Y < 0)
						Y++;
				}	
			}else{
				if(Y > 0)
					Y--;
				else if( Y < 0)
					Y++;
				else{
					if(X > 0)
						X--;
					else if(X < 0){
						X++;
					}
				}
			}
			
			if(X == 0 && Y == 0 )
				return time;
//			System.out.println(X+" "+Y);
		}
		return -1;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int t_i = 1 ;t_i <= t; t_i++){
			String strArr[] = br.readLine().split(" ");
			int X = Integer.parseInt(strArr[0]);
			int Y = Integer.parseInt(strArr[1]);
			String path = strArr[2];
			int ans = findAns(X,Y,path);
			if(ans == -1)
				System.out.println("Case #"+t_i+": IMPOSSIBLE");
			else
				System.out.println("Case #"+t_i+": "+ans);
		}

	}

}
