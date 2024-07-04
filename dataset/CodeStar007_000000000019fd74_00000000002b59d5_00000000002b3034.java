
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
	
	static void solve(int N,String[] patterns,int case_num) {
		Arrays.sort(patterns);
		String S=patterns[0];
		for(int i=0;i<N;i++) {
			if(S.indexOf(patterns[i].substring(1))==-1) {
				System.out.println("Case #"+case_num+": "+"*");
				return;
			}
		}
		
		System.out.println("Case #"+case_num+": "+S);
	}

}
