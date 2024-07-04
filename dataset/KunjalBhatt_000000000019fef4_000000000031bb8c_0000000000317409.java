
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]){
		 
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	     int t = in.nextInt(); 
	     for (int i = 1; i <= t; ++i) {
	    	 int x = in.nextInt();
	    	 int y = in.nextInt();
	    	 
	    	 String path = in.next();
	    	 
	    	 System.out.println("Case #" + i + ": "+getMin(x, y, path));
	       }
	     in.close();
	}
	
	static String getMin(int x,int y,String path){
		String r = "IMPOSSIBLE";
		
		int minuteHave = path.length();
		char[] pathSteps = path.toCharArray();
		
		for(int i=0;i < minuteHave; i++){
			if(pathSteps[i] == 'N'){
				y++;
			}else{
				y--;
			}
			int pathl = Math.abs(x)+Math.abs(y); 
			if(pathl<=(i+1)){
				return String.valueOf((i+1));
			}
		}
		return r;
	}
}

