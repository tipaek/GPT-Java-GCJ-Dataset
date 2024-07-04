import java.util.*;
import java.io.*;
public class Solution{
	
	public static int findAns(int X , int Y, String path){
		int time = 0;
		char direction ;
		if(X == 0 && Y == 0 )
			return time;
		for(int i = 0 ;i < path.length();i++){
			time++;
			direction = path.charAt(i);
			if(direction == 'N'){
				Y++;
			}else if(direction == 'S'){
				Y--;
			}else
				break;
			if(X !=0)
				X--;
			else{
				if(X == 0 && Y == 0 )
					return time;
				if(Y > 0)
					Y--;
				else
					Y++;
			}	
			if(X == 0 && Y == 0 )
				return time;
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
