import java.util.Scanner;


public class Solution {


	public static int[] lps(String pattern) {
		
		int i =1;
		int j =0;
		int len = pattern.length();
		int[] arr = new int[len];
		while(i<len) {
			if(pattern.charAt(i)==pattern.charAt(j)) {
				arr[i] = j+1;
				i++;
				j++;
			}else {
				if(j==0) {
					i++;
				}else {
				j = arr[j-1];}
			}
		}
	return arr;
		
	}
	
	public static boolean findString(String text, String pattern) {
		// Write your code here

		int i =0;
		int j =0;
		int tLen = text.length();
		int pLen = pattern.length();
		
		int[] arr = lps(pattern);
		
		
		while(i<tLen&&j<pLen) {
			if(text.charAt(i)==pattern.charAt(j)) {
				i++;
				j++;
			}else {
				if(j!=0) {
					j = arr[j-1];
				}else {
					i++;
				}
			}
			
		}
		if(j==pLen) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
    
	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		int t = s.nextInt();
		int k = t;
		while(t>0) {
			int n= s.nextInt();
			String[] arr = new String[n];
			int j =0;
			int max = 0;
			for(int i =0;i<n;i++) {
				arr[i] = s.next();
				if(arr[i].length()>max) {
					max = arr[i].length();
					j = i;
				}
			}
			
			boolean flag = true;
			
			
			for(int i =0;i<n;i++) {
			
				if(!findString(arr[j].substring(1), arr[i].substring(1))) {
					
					System.out.println("Case #"+(k-t+1)+": *");
					
					flag = false;
					
					break;
				}
				
			}
			if(flag) {
				System.out.println("Case #"+(k-t+1)+": "+arr[j].substring(1));
			}
			
			
			
			t--;
		}
		s.close();
		
		
	}
}