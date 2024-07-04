import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		for (int i = 1; i <= t; i++) {
			
			String s=scn.next();
			String ans="";
			
//			int onesl=0;
		
		
			System.out.print("Case #" + i + ": " );
			gotraverse(s, 0, s.length(), 0, ans);

		}
	}
	public static void gotraverse(String str,int idx, int n, int op, String ans){
		

		if(idx==n){
			while(op>0){
				ans+= ")";
				op--;
			}
			System.out.println(ans);
			return;
		}
		
		int temp = str.charAt(idx) -'0';


		if(op==temp){
			ans = ans + str.charAt(idx);
			gotraverse(str,idx+1,n,op,ans);
		}else if(op<temp){
			while(op<temp){
				ans+= "(";
				op++;
			}
			ans = ans + str.charAt(idx);
			gotraverse(str,idx+1,n,op,ans);
		}else{
			while(op>temp){
				ans+= ")";
				op--;
			}
			ans = ans + str.charAt(idx);
			gotraverse(str,idx+1,n,op,ans);
		}

	}


}
