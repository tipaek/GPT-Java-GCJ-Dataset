import java.util.*;

public class Solution{
    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for(int l = 1; l <= t; ++l){
			String s = sc.nextLine();
			int sz = s.length();
			int [] cur = new int [sz];
			int [] fwd = new int [sz];
			int [] bwd = new int [sz];
			for(int i = 0; i < sz; ++i){
				cur[i] = (int)(s.charAt(i) - '0');
			}
			for(int i = 0; i < sz; ++i){
				while(cur[i] != 0){
					cur[i]--;
					fwd[i]++;
					int j = i;
					while(j+1 < sz && cur[j+1] != 0)cur[++j]--;
					bwd[j]++;
				}
			}
			System.out.print("Case #" + l +": ");
			for(int i = 0; i < sz; ++i){
				while(fwd[i]-->0)System.out.print("(");
				System.out.print(s.charAt(i));
				while(bwd[i]-->0)System.out.print(")");
			}
			System.out.println();
		}
	}
}