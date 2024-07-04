
import java.util.Scanner;

public class Solution {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void solve(){
		String s=sc.next();
		char[] s1 =s.toCharArray();
		int dep=0;
		String ans = "";
		

		for(char c: s1){
			int newdep = c-'0';
			while(newdep>dep){
				++dep;
				ans+='(';
			}
			while(newdep<dep){
				--dep;
				ans+=')';
			}
			ans+=c;
		}
		while(dep>0){
			--dep;
			ans+=')';
		}
		//cout << ans << "\n";
		System.out.println(ans);
	}

	public static void main(String[] args) {
		
		int n = sc.nextInt();
		for(int i=1;i<=n;++i){
			System.out.print("Case #" + i + ": ");
			solve();
		}
	}
	
}