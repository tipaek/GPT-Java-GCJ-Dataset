import java.util.*;
public class Solution{


	public static void main(String args[]){

		Scanner sca = new Scanner(System.in);
		int t = sca.nextInt();
		int kase = 1;
		while(t-- > 0){
			String s = sca.next();
			int n = s.length();
			StringBuilder ans = new StringBuilder();
			int i = 0;
			while(i < n){
				if(s.charAt(i) == '1'){
					ans.append('(');
					while(i < n && s.charAt(i) == '1'){
						ans.append('1');
						i = i + 1;
					}
					ans.append(')');
					if(i < n){
						ans.append('0');
					}
				}else{	
					ans.append('0');
				}
				i = i + 1;
			}

			System.out.println("Case #" +  (kase++) + ": " + ans.toString());
		}
	}

}