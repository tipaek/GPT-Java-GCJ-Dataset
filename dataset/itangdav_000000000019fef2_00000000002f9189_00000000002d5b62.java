
import java.io.*;
import java.util.*;

public class Solution {
	public static int mod(int x){
		return (((x % 2) + 2) % 2);
	}
	public static String solve(int x, int y){
		if(x==1&&y==0){
			return "E";
		}
		else if(x==-1&&y==0){
			return "W";
		}
		else if(x==0&&y==1){
			return "N";
		}
		else if(x==0&&y==-1){
			return "S";
		}
		else if(mod(x)==mod(y)){
			return "IMPOSSIBLE";
		}
		else if(mod(x)==1){
			if(mod((x-1)/2)!=mod(y/2)){
				return "E" + solve((x-1)/2, y/2);
			}
			else{
				return "W" + solve((x+1)/2, y/2);
			}
		}
		else if(mod(y)==1){
			if(mod((y-1)/2)!=mod(x/2)){
				return "N" + solve((x)/2, (y-1)/2);
			}
			else{
				return "S" + solve((x)/2, (y+1)/2);
			}
		}
		else return "";
	}
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int test =1; test<=T;test++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			System.out.println("Case #" + test + ": " + solve(x,y));
			
		}	
	}
			
		
}
