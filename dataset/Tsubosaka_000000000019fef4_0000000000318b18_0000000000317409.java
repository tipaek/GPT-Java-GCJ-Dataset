import java.util.Scanner;

public class Solution {
	static int solve(int X  , int Y , String M){
		for(int i = 0 ; i < M.length() ; ++i){
			char c = M.charAt(i);
			if(c == 'N'){
				Y++;
			}
			if(c == 'S'){
				Y--;
			}
			if(c == 'W'){
				X--;
			}
			if(c == 'E'){
				X++;
			}
			int dist = Math.abs(X) + Math.abs(Y);
			if((i + 1) >= dist){
				return i + 1;
			}
//			System.out.println(i+" "+X+" "+Y+" "+dist);
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int cn = 1 ; cn <= T ; ++cn){
			int X = sc.nextInt();
			int Y = sc.nextInt();
			String M = sc.next();
			int result = solve(X , Y , M);
			if(result < 0){
				System.out.printf("Case #%d: IMPOSSIBLE\n" , cn , result);				
			}else{
				System.out.printf("Case #%d: %d\n" , cn , result);
			}
		}
	}	
}
