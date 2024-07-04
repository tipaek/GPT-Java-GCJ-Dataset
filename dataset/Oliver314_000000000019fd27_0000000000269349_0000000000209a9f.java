import java.util.ArrayList;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++){
			char[] s = sc.next().toCharArray();
			StringBuilder sb = new StringBuilder();
			int last = 0;
			for(char c: s){
				if(c == '0'){
					if(last == 1){
						sb.append(')');
					}
					sb.append('0');
					last = 0;
				}else{
					if(last == 0){
						sb.append('(');
					}
					sb.append('1');
					last = 1;
				}
			}
			if(last == 1){
				sb.append(')');
			}
				
			System.out.println("Case #"+i+ ": "+sb.toString());
		}
			
	}

}
