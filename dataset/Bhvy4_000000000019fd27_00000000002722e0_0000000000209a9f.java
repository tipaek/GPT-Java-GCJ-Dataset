import java.util.*;
public class Solution{
	public static String nesting(char[] arr){
		int n = arr.length;
		String ans = "";
		int prev = 0;
		for(int i=0; i<n; i++){
			int val = arr[i] -'0';
			if(i==0){
				for(int j=0 ; j<val; j++) ans+= "(";
			}
			else if(prev-val>0){
				int x = prev-val;
				for(int j=0; j<x; j++) ans+=")";
			}
			else{
				int x = val-prev;
				for(int j=0; j<x; j++) ans+="(";
			}
			ans+=arr[i];
			prev = val;
		}
		for(int j=0; j<prev; j++) ans+=")";
		return ans;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int s = 1;
		while(s<=t){
			String S = sc.next();
			char arr[] = S.toCharArray();
			String ans = nesting(arr);
			System.out.println("Case #"+s+": "+ans);
			s++;
		}
	}
}