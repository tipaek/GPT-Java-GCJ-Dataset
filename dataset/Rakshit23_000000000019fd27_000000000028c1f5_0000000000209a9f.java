import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t=0; t<T; t++){
			int prv = 0;
			String s = sc.nextLine();
			int df = 0;
			System.out.print("Case #"+t+": ");
			for(int i=0; i<s.length(); i++){
				int x = s.charAt(i) - '0';
				int d = x - prv;
				prv = x;
				if(d>0){
					while(d>0){
						System.out.print('(');
						d--;
					}
				} else{
					while(d<0){
						System.out.print(')');
						d++;
					}
				}
				System.out.print(x);
				df = x;
			}
			while(df>0){
				System.out.print(')');
				df--;
			}
			System.out.println();
		}
	}
}