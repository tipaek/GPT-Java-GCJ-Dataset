
import java.util.Scanner;


public class Solution {
	
	
	public static void solve(String str, int k) {
		
		String ans = "";
		int i =0;
		while(i<str.length()) {
			
			int curr = str.charAt(i)-'0';
			if(curr==0) {
				ans+="0";
				i++;
			}else {
				int curr2 = curr;
				while(curr2>0) {
					int len =ans.length();
					if(len==0) {
						break;
					}
					if(ans.charAt(len-1)!=')') {
						break;
					}
					ans = ans.substring(0, len-1);
					curr2--;
				}
				
				while(curr2>0) {
					ans+='(';
					curr2--;
				}
				
				ans+=curr;
				while(curr>0) {
					ans+=')';
					curr--;
				}
				
				i++;
			}
			
			
			
		}
		
		
		
		System.out.println("Case #"+ k +": "+ans);
		
	}
	
    
	public static void main(String[] args) {
	
	Scanner s = new Scanner(System.in);
	int  t= s.nextInt();
	int k = t;
	while(t>0) {
		String str = s.next();
		
		solve(str, k-t+1);
		
		t--;
	}
	s.close();
	
	
	}

}