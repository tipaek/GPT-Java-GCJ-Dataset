import java.util.Scanner;

public class Solution {
	static void solve(int t , long L , long R){
		int ci = 1;
		while(L >= ci || R >= ci){
			if(L >= R){
				L -= ci;
			}else{
				R -= ci;
			}
			ci++;
		}
		ci--;
		System.out.printf("Case #%d: %d %d %d\n" , t , ci , L , R);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cn = sc.nextInt();
		for(int t = 1 ; t <= cn ; ++t){
			long L = sc.nextLong();
			long R = sc.nextLong();
			solve(t, L , R);
		}
				
	}
}
