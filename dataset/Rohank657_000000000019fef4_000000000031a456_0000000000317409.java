import java.io.*;
import java.util.*;
class Solution {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 1;i<=t;i++) {
			String[] data = br.readLine().split(" ");
			int x = Integer.parseInt(data[0]);
			int y = Integer.parseInt(data[1]);
			//int time = 0;
			boolean flag = false;
			String str = data[2];
			for(int j = 0;j<str.length();j++) {
				if(str.charAt(j)=='N') y++;
				else if(str.charAt(j)=='S') y--;
				else if(str.charAt(j)=='E') x++;
				else x--;
				
				if(Math.abs(x)+Math.abs(y)<=j+1) {
					int a = j+1; 
					System.out.println("Case #"+i+": "+a);
					flag = true;
					break;
				}
			}
			if(!flag) {
				System.out.println("Case #"+i+": IMPOSSIBLE");
			}
		}
	}
}
