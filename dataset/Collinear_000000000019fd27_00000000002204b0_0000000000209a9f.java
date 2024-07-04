import java.io.*;
import java.util.*;

public class Solution {
	
	public static String appendLeft(int x, String s){
		for(int i = 0; i<x; i++){
			s+="(";
		}
		
		return s;
		
	}
	
	public static String appendRight(int x, String s){
		for(int i = 0; i<x; i++){
			s+=")";
		}
		return s;
	}
	
	public static String parenth(String x){
		int[] A = new int[x.length()];
		String ans = "";
		for(int i = 0; i<x.length(); i++){
			A[i] = x.charAt(i)-48;
		}
		ans = appendLeft(A[0], ans);
		ans += x.charAt(0);;
		for(int i = 1; i<x.length(); i++){
			if(A[i] > A[i-1]){
				ans = appendLeft(A[i]-A[i-1], ans);
			}
			else if(A[i] < A[i-1]){
				ans = appendRight(A[i-1]-A[i], ans);
			}
			ans+=x.charAt(i);
		}
		ans = appendRight(A[x.length()-1], ans);
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException{
		
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for(int i = 0; i<cases; i++){
			String x = input.next();
			System.out.println("Case #" + (i+1) + ": " + parenth(x));
		}
		input.close();
		
	}
}
