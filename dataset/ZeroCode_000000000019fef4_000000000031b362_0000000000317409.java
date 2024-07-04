import java.util.*;
import java.io.*;

public class Solution {


	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			String path = in.nextLine().substring(1);

//			System.out.print(x + " " + y + " path-" +path) ;

			boolean pos = false;
			int ans = 1005;
			if((Math.abs(x)+Math.abs(y))==0){
				pos=true;
				ans=0;
			}

			int time = 1;
			for(Character dir : path.toCharArray()) {
//				System.out.println(dir);
				if(dir.equals('N')) y+=1;
				if(dir.equals('S')) y-=1;
				if(dir.equals('E')) x+=1;
				if(dir.equals('W')) x-=1;
//				System.out.println(x+y);
				if((Math.abs(x)+Math.abs(y))<=time) {
					pos = true;
					ans = ans>time? time:ans;
				}
				time+=1;
			}

			if(pos) {
				System.out.println("Case #" + i + ": " + ans);
			}
			else {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			}
		}
	}


}
