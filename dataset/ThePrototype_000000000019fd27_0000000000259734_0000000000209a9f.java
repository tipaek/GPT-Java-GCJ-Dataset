import java.util.*;

public class Solution{
	public static void main(String[] args){
		int T;
		Scanner in = new Scanner(System.in);
		T=in.nextInt();
		in.nextLine();
		for(int t = 1; t <= T; ++t){
			String s = in.nextLine();
			StringBuffer res = new StringBuffer();
			int openParam=0;
			for( int i = 0; i < s.length(); ++i){
			 	int chr = (int)s.charAt(i) - '0';
				if(chr > openParam){
					while(chr != openParam){
						res.append('(');
						++openParam;
					}
				}
				else if(chr < openParam){
					while(chr != openParam){
						res.append(')');
						--openParam;
					}
				}
				res.append(chr);
			}
			while(openParam>0){
				res.append(')');
				--openParam;
			}
			String result = new String(res);
			System.out.println("Case #"+ (t) + ": " + result);
		}
	}
}