import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static int size = 2000000001;
	static int fixup = 2;
	static int moves = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int search = 10;
		int space = size/(search+2);
		game: for (int t = 1; t <= T; t++) {
			moves = 0;
			int x=0,y=0;
			search: for(int a=0;a<search;a++){
				y = (a+1)*space;
				for(int b=0;b<search;b++){
					x = (b+1)*space;
					moves++;
					System.out.println(offset(x)+" "+offset(y));
					System.out.flush();
					String response = sc.next();
					if(response.equals("CENTER")) continue game;
					if(response.equals("HIT")) break search;
				}
			}
//			int down = 0;
			int down = findDown(x,y,sc);
			if(down==Integer.MAX_VALUE)continue;
			int up = findUp(x,y,sc);
			if(up==Integer.MAX_VALUE)continue;
			int left = findLeft(x,y,sc);
			if(left==Integer.MAX_VALUE)continue;
			int right = findRight(x,y,sc);
			if(right==Integer.MAX_VALUE)continue;
			int cx = (left+right)/2;
			int cy = (up+down)/2;
			
			for(int a=-fixup;a<=fixup;a++){
				for(int b=-fixup;b<=fixup;b++){
					moves++;
					System.out.println(offset(cx+a)+" "+offset(cy+b));
					System.out.flush();
					String response = sc.next();
					if(response.equals("CENTER")) continue game;
				}
			}
			System.exit(1);
		}
	}

	private static int findDown(int x, int y, Scanner sc) {
		int low = 0;
		long high = y;
		long mid =(int) 42;
		int ans = -1;
		while(low<=high){
			mid = (low+high)/2;
			moves++;
			System.out.println(offset(x)+" "+offset((int)mid));
			System.out.flush();
			String response = sc.next();
			if(response.equals("CENTER")) return Integer.MAX_VALUE;
			if(response.equals("HIT")){
				ans =(int) mid;
				high = (int)mid-1;
			}
			else {
				low = (int)mid+1;			
			}
		}		
		return ans;
	}
	
	private static int findUp(int x, int y, Scanner sc) {
		int low = y;
		long high = size;
		long mid = 42;
		int ans = -1;
		while(low<=high){
			mid = (low+high)/2;
			System.out.println(offset(x)+" "+offset((int)mid));
			System.out.flush();
			String response = sc.next();
			if(response.equals("CENTER")) return Integer.MAX_VALUE;
			if(response.equals("HIT")){
				ans = (int)mid;
				low = (int)mid+1;			
			}
			else {
				high = (int)mid-1;
			}
		}
		
		return ans;
	}
	
	private static int findLeft(int x, int y, Scanner sc) {
		int low = 0;
		long high = x;
		long mid = 42;
		int ans = -1;
		while(low<=high){
			mid = (low+high)/2;
			System.out.println(offset((int)mid)+" "+offset(y));
			System.out.flush();
			String response = sc.next();
			if(response.equals("CENTER")) return Integer.MAX_VALUE;
			if(response.equals("HIT")){
				ans = (int)mid;
				high = (int)mid-1;
			}
			else {
				low =(int) mid+1;			
			}
		}
		
		return ans;
	}
	
	private static int findRight(int x, int y, Scanner sc) {
		int low = x;
		long high = size;
		long mid = 42;
		int ans = -1;
		while(low<=high){
			mid = (low+high)/2;
			System.out.println(offset((int)mid)+" "+offset(y));
			System.out.flush();
			String response = sc.next();
			if(response.equals("CENTER")) return Integer.MAX_VALUE;
			if(response.equals("HIT")){
				ans =(int)mid;
				low = (int)mid+1;			
			}
			else {
				high =(int) mid-1;
			}
		}
		
		return ans;
	}
	

	private static int offset(int x) {
		return x - 1000000000;
	}
}
