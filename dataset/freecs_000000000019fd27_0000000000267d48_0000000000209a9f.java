import java.util.*;
import java.io.*;

public class Solution{
	
	public void solve(int test, Scanner sc){
		String str = sc.next();
		
		String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		int sum = 0;
		StringBuilder result = new StringBuilder();
		
		for(int i=0; i<str.length(); i++){
			int ch = (int)(str.charAt(i)-'0');
			
			while(sum < ch){
				result.append("(");
				sum++;
			}
			while(sum > ch){
				result.append(")");
				sum--;
			}
			if(sum == ch){
				result.append(nums[ch]);
			}
		}
		
		while(sum > 0){
			result.append(")");
			sum--;
		}
		
		String res = result.toString();
		
		System.out.println("Case #"+test+": "+res);
	}
	
	public Solution(){
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
        
        for(int t=1; t<=tests; t++){
			solve(t, sc);
        }
	}
	
	public static void main(String[] args){
		new Solution();
	}
}