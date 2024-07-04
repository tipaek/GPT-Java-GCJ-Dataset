
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
			String S = patterns[i];
			for (int j = i + 1; j < N; j++) {
				if (S.indexOf(patterns[j].substring(1)) == -1) {
					flag=false;
				}else {
					flag=true;
				}
			}
			if(flag==true) {
				System.out.println("Case #" + case_num + ": " +S);
				return;
			}
		}

		System.out.println("Case #" + case_num + ": " +"*");
	}

}
