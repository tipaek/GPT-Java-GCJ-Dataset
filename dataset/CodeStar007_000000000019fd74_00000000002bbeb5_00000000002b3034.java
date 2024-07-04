
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner S=new Scanner(System.in);
		int T=S.nextInt();
		int case_num=1;
		while(T>0) {
			int N=S.nextInt();
			String[] patterns=new String[N];
			for(int i=0;i<patterns.length;i++) {
				patterns[i]=S.next();
			}
			solve(N,patterns,case_num);
			T--;
			case_num++;
		}
	}
	
	static void solve(int N, String[] patterns, int case_num) {
		Arrays.sort(patterns);
		boolean flag=true;
		String ans="";
		for (int i = 0; i < N; i++) {
			flag=false;
			StringBuilder sb=new StringBuilder();
			sb.append(patterns[i].substring(1));
			String check=sb.reverse().toString();
			for (int j = 0; j < N; j++) {
				String check2=new StringBuilder().append(patterns[j].substring(1)).reverse().toString();
				if (!check.startsWith(check2)) {
					flag=false;
					break;
				}else {
					flag=true;
				}
			}
			if(flag==true) {
				System.out.println("Case #" + case_num + ": " +patterns[i].substring(1));
				return;
			}
		}

		System.out.println("Case #" + case_num + ": " +"*");
	}
}
