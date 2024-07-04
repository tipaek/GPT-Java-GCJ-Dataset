 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i=1;i<=t;++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			String path = in.next();
			int sol = findSol(x,y,path);
			if(sol<=0) {
				System.out.println("Case #"+i+": "+"IMPOSSIBLE");
			}else {
				System.out.println("Case #"+i+": "+sol);
			}
			
		}
	}
	
	public static int findSol(int x, int y, String path) {
		//System.out.println(path);
		for(int i = 0; i<path.length();++i) {
			switch(path.charAt(i)) {
				case 'N':{
					y++;
					break;
				}
				case 'S':{
					y--;
					break;
				}
				case 'W':{
					x--;
					break;
				}
				case'E':{
					x++;
					break;
				}
			}
			//System.out.println(x+" "+y);
			if(Math.abs(x)+Math.abs(y)<=i+1) {
				return i +1;
			}
		}
		return -1;
	}
}