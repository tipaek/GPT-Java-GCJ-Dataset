import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++){
			String S = sc.next();
			int now = 0;
			StringBuffer bf = new StringBuffer();
			for(int j = 0; j < S.length(); j++){
				char ch = S.charAt(j);
				while((ch-'0') > now){
					bf.append("(");
					now++;
				}
				while((ch-'0') < now){
					bf.append(")");
					now--;
				}
				bf.append(ch);
			}
			while(now > 0){
				bf.append(")");
				now--;
			}
			System.out.print("Case #"+(i + 1)+": ");
			System.out.println(bf.toString());
		}
	}
}